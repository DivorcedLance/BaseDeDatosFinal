package Modelo.DAO.PresupuestoExterno;

import Modelo.Conexion.ConectarOracle;
import Modelo.Interface.CRUD;
import Modelo.Partida_Mezcla;
import Modelo.Proy_Partida_Mezcla;
import Modelo.Auxiliares.PartidaAux;
import Modelo.Auxiliares.ProyectoAux;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PPartida_MezclaDAO implements CRUD<Partida_Mezcla>{
    
    //ConectarOracle conexion=new ConectarOracle();
    ConectarOracle conexion=ConectarOracle.getInstance();
    Connection con;
    Statement ps;
    PreparedStatement pst;
    ResultSet rs;
    CallableStatement myCall;

    @Override
    public List<Partida_Mezcla> listar() {
        List<Partida_Mezcla> lista = new ArrayList<>();
        String sql="SELECT * FROM P_PARTIDA_MEZCLA order by CODCIA";
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                Partida_Mezcla pm = new Partida_Mezcla();
                pm.setCodCia(rs.getInt(1));
                pm.setIngEgr(rs.getString(2));
                pm.setCodPartida(rs.getInt(3));
                pm.setCorr(rs.getInt(4));
                pm.setPadCodPartida(rs.getInt(5));
                pm.settUnitMed(rs.getString(6));
                pm.seteUnitMed(rs.getString(7));
                pm.setCostoUnit(rs.getFloat(8));
                pm.setNivel(rs.getInt(9));
                pm.setOrden(rs.getInt(10));
                pm.setVigente(rs.getString(11).charAt(0));
                lista.add(pm);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        System.out.println("terminando la lsita");
        return lista;
    }

    @Override
    public int add(Partida_Mezcla p) {
        System.out.println("{call P_INSERTAR_PARTIDA_MEZCLA(?,?,?,?,?,?,?,?,?,?)}");
        try{
           con=conexion.conectar();
           myCall = con.prepareCall("{call P_INSERTAR_PARTIDA_MEZCLA(?,?,?,?,?,?,?,?,?,?)}");
           myCall.setInt(1, p.getCodCia());
           myCall.setString(2, p.getIngEgr());
           myCall.setInt(3, p.getCodPartida());
           myCall.setInt(4, p.getPadCodPartida());
           myCall.setString(5, p.gettUnitMed());
           myCall.setString(6, p.geteUnitMed());
           myCall.setFloat(7, p.getCostoUnit());
           myCall.setInt(8, p.getNivel());
           myCall.setInt(9, p.getOrden());
           myCall.setString(10, String.valueOf(p.getVigente()));
           myCall.execute();
           myCall.close();
           con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Excepcion.\n"+ex.toString());
            System.out.println(ex.toString());
            return 0;
        }
       return 1;
    }

    @Override
    public int actualizar(Partida_Mezcla p) {
        String sql1= "update P_PARTIDA_MEZCLA set CostoUnit=?,Nivel=?,Orden=?,Vigente=? where CODCIA=? AND INGEGR=? AND CODPARTIDA=? AND CORR=?";
        System.out.println(sql1);
        try{
           con=conexion.conectar();
           pst=con.prepareStatement(sql1);
           pst.setFloat(1, p.getCostoUnit());
           pst.setInt(2, p.getNivel());
           pst.setInt(3, p.getOrden());
           pst.setString(4, String.valueOf(p.getVigente()));
           pst.setInt(5, p.getCodCia());
           pst.setString(6, p.getIngEgr());
           pst.setInt(7, p.getCodPartida());
           pst.setInt(8, p.getCorr());
           pst.execute();
           pst.close();
           con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Excepcion.\n"+ex.toString());
            System.out.println(ex.toString());
            return 0;
        }
        return 1;
    }
    
    public boolean busOrden(int cia,String tip,int id,int nivel,int orden){
        boolean band = false;
        String sql;
        if(id==0){
            sql="SELECT * from P_PARTIDA_MEZCLA WHERE CODCIA="+cia+" "
                + "AND INGEGR='"+tip+"' AND PADCODPARTIDA IS NULL "
                + "AND NIVEL="+nivel+" AND ORDEN="+orden;
        }
        else{
            sql="SELECT * from P_PARTIDA_MEZCLA WHERE CODCIA="+cia+" "
                + "AND INGEGR='"+tip+"' AND PADCODPARTIDA="+id+" "
                + "AND NIVEL="+nivel+" AND ORDEN="+orden;
        }
        System.out.println(sql);
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            if(rs.next()){
                band = true;
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        System.out.println(band);
        return band;
    }


    public void eliminarDatos(int cia,int id,String tipo,int cor) {
       String sql1="DELETE from P_PARTIDA_MEZCLA where CODCIA="+cia+" AND CODPARTIDA="+id+" AND INGEGR='"+tipo+"' AND CORR="+cor;
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql1);
            rs=ps.executeQuery(sql1);
            rs.close();
            ps.close();
            con.close();
            JOptionPane.showMessageDialog(null, "P_Partida_Mezcla eliminado con exito.");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Excepcion.\n"+e.toString());
            System.out.println(e.toString());
        }
    }
    
    public Partida_Mezcla listarId(int cia,String tipo,int par,int id){
        Partida_Mezcla pm = new Partida_Mezcla();
        String sql="SELECT CORR,CODPARTIDA,PADCODPARTIDA,NIVEL,ORDEN,TUNIMED,EUNIMED,"
                + "COSTOUNIT,VIGENTE FROM P_PARTIDA_MEZCLA WHERE CODCIA="+cia+" AND INGEGR='"+tipo+"' AND CODPARTIDA="+par+" AND CORR="+id;
        try{
            con = conexion.conectar();
            ps=con.createStatement();
            rs = ps.executeQuery(sql);
            if(rs.next()){
                pm.setCorr(rs.getInt(1));
                pm.setCodPartida(rs.getInt(2));
                pm.setPadCodPartida(rs.getInt(3));
                pm.setNivel(rs.getInt(4));
                pm.setOrden(rs.getInt(5));
                pm.settUnitMed(rs.getString(6));
                pm.seteUnitMed(rs.getString(7));
                pm.setCostoUnit(rs.getFloat(8));
                pm.setVigente(rs.getString(9).charAt(0));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Excepcion.\n"+e.toString());
            System.out.println(e.toString());
        }
        return pm;
    }    
    
    public Partida_Mezcla listarOrden(int cia,String tipo,int par,int nivel,int orden){
        Partida_Mezcla pm = new Partida_Mezcla();
        String sql;
        if(par==0){
            sql="SELECT CORR,CODPARTIDA,PADCODPARTIDA,NIVEL,ORDEN,CODCIA,INGEGR,"
                + "COSTOUNIT,VIGENTE FROM P_PARTIDA_MEZCLA WHERE CODCIA="+cia+" AND "
                    + "INGEGR='"+tipo+"' AND PADCODPARTIDA IS NULL AND NIVEL="+nivel+" "
                    + "AND ORDEN="+orden;
        }
        else{
            sql="SELECT CORR,CODPARTIDA,PADCODPARTIDA,NIVEL,ORDEN,CODCIA,INGEGR,"
                + "COSTOUNIT,VIGENTE FROM P_PARTIDA_MEZCLA WHERE CODCIA="+cia+" AND "
                    + "INGEGR='"+tipo+"' AND PADCODPARTIDA="+par+" AND NIVEL="+nivel+" "
                    + "AND ORDEN="+orden;
        }
        
        System.out.println(sql);
        try{
            con = conexion.conectar();
            ps= con.createStatement();
            rs = ps.executeQuery(sql);
            if(rs.next()){
                pm.setCorr(rs.getInt(1));
                pm.setCodPartida(rs.getInt(2));
                pm.setPadCodPartida(rs.getInt(3));
                pm.setNivel(rs.getInt(4));
                pm.setOrden(rs.getInt(5));
                pm.setCodCia(rs.getInt(6));
                pm.setIngEgr(rs.getString(7));
                pm.setCostoUnit(rs.getFloat(8));
                pm.setVigente(rs.getString(9).charAt(0));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Excepcion.\n"+e.toString());
            System.out.println(e.toString());
        }
        return pm;
    } 
    
    public List<Partida_Mezcla> listarPorCodCia(int id,String tip){
        List<Partida_Mezcla> lista = new ArrayList<>();
        String sql="SELECT "
                + "m.corr,m.codpartida,m.padcodpartida,m.nivel,m.orden,m.tunimed,m.eunimed,m.costounit,m.vigente "
                + "FROM P_PARTIDA_MEZCLA m WHERE m.codcia="+id+" AND m.ingegr='"+tip+"' order by m.corr";
        System.out.println(sql);
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                Partida_Mezcla pm = new Partida_Mezcla();
                pm.setCorr(rs.getInt(1));
                pm.setCodPartida(rs.getInt(2));
                pm.setPadCodPartida(rs.getInt(3));
                pm.setNivel(rs.getInt(4));
                pm.setOrden(rs.getInt(5));
                pm.settUnitMed(rs.getString(6));
                pm.seteUnitMed(rs.getString(7));
                pm.setCostoUnit(rs.getFloat(8));
                pm.setVigente(rs.getString(9).charAt(0));
                lista.add(pm);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Excepcion.\n"+e.toString());
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public List<Partida_Mezcla> listarCodPartida_Mezcla(int id,String tip){
        List<Partida_Mezcla> lista = new ArrayList<>();
        String sql="SELECT "
                + "codpartida"
                + " FROM P_PARTIDA_MEZCLA WHERE codcia="+id+" AND ingegr='"+tip+"' order by codpartida";
        System.out.println(sql);
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                Partida_Mezcla pm = new Partida_Mezcla();
                pm.setCodPartida(rs.getInt(1));
                lista.add(pm);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Excepcion.\n"+e.toString());
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public List<Partida_Mezcla> listarMezclas(int id,String tip){
        List<Partida_Mezcla> lista = new ArrayList<>();
        String sql="SELECT DISTINCT PADCODPARTIDA FROM P_PARTIDA_MEZCLA "
                + "WHERE CODCIA="+id+" AND INGEGR='"+tip+"' AND PADCODPARTIDA <> 0 ORDER BY PADCODPARTIDA";
        System.out.println(sql);
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                Partida_Mezcla pm = new Partida_Mezcla();
                pm.setPadCodPartida(rs.getInt(1));
                lista.add(pm);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Excepcion.\n"+e.toString());
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public List<Partida_Mezcla> listarMezclasPadre(int id,String tip){
        List<Partida_Mezcla> lista = new ArrayList<>();
        String sql="SELECT DISTINCT CODPARTIDA FROM P_PARTIDA_MEZCLA "
                + "WHERE CODCIA="+id+" AND INGEGR='"+tip+"' AND PADCODPARTIDA=0";
        System.out.println(sql);
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                Partida_Mezcla pm = new Partida_Mezcla();
                pm.setCodPartida(rs.getInt(1));
                lista.add(pm);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Excepcion.\n"+e.toString());
            System.out.println(e.toString());
        }
        return lista;
    }
    
    @Override
    public void eliminar(int id) {
        return;
    }
    
    public int asignarOrden(String tip,int nivel,int cia){
        int orden=0;
        String sql="SELECT * FROM (SELECT ORDEN FROM P_PARTIDA_MEZCLA WHERE INGEGR='"+tip+"' AND NIVEL="+nivel+" AND CODCIA="+cia+" ORDER BY orden DESC) WHERE ROWNUM=1";
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            if(rs.next()){
                orden = rs.getInt(1);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return orden+1;
    }
    
    public int asignarOrdenNoNULL(String tip,int cod,int cia){
        int orden=0;
        String sql="SELECT * FROM (SELECT ORDEN FROM P_PARTIDA_MEZCLA WHERE INGEGR='"+tip+"' AND PADCODPARTIDA="+cod+" AND CODCIA="+cia+" ORDER BY orden DESC) WHERE ROWNUM=1";
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            if(rs.next()){
                orden = rs.getInt(1);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return orden+1;
    }
    
    public int asignarNivelNoNULL(String tip,int cod,int cia){
        int nivel=0;
        String sql="SELECT * FROM (SELECT NIVEL FROM P_PARTIDA_MEZCLA WHERE INGEGR='"+tip+"' AND CODPARTIDA="+cod+" AND CODCIA="+cia+" ORDER BY ORDEN DESC) WHERE ROWNUM=1";
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            if(rs.next()){
                nivel = rs.getInt(1);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return nivel+1;
    }

    public List getv_partidas_mezcla(int codCia, String ingEgr) {
        List lista = new ArrayList<>();
        List<Partida_Mezcla> listaPm = new ArrayList<>();
        List<PartidaAux> listaPartida = new ArrayList<>();
        List<PartidaAux> listaPartidaPadre = new ArrayList<>();

        String sql = "{call p_getv_partidas_mezcla(?, ?, ?)}";
    
        try (Connection con = conexion.conectar();
             CallableStatement cs = con.prepareCall(sql)) {
    
            cs.setInt(1, codCia);
            cs.setString(2, ingEgr);
            cs.registerOutParameter(3, java.sql.Types.REF_CURSOR);
    
            cs.execute();
    
            try (ResultSet rs = (ResultSet) cs.getObject(3)) {
                while (rs.next()) {
                    Partida_Mezcla pm = new Partida_Mezcla();
                    PartidaAux pa = new PartidaAux(); // PartidaAux
                    PartidaAux pap = new PartidaAux(); // PartidaAux Padre

                    pm.setCorr(rs.getInt("CORR"));

                    pm.setCodPartida(rs.getInt("CODPARTIDA"));
                    pa.setCodPartida(rs.getInt("CODPARTIDA"));
                    pa.setDesPartida(rs.getString("DESPARTIDA"));

                    pm.setPadCodPartida(rs.getInt("PADCODPARTIDA"));
                    pap.setCodPartida(rs.getInt("PADCODPARTIDA"));
                    pap.setDesPartida(rs.getString("DESCPADCODPARTIDA"));
                    if (rs.getInt("PADCODPARTIDA") == 0) {
                        pap.setDesPartida("");
                    } else {
                        pap.setDesPartida(rs.getString("DESCPADCODPARTIDA"));
                    }

                    pm.setNivel(rs.getInt("NIVEL"));
                    pm.setOrden(rs.getInt("ORDEN"));

                    pm.settUnitMed(rs.getString("TUNIMED"));
                    pa.settUniMed(rs.getString("TUNIMED"));
                    pap.settUniMed(rs.getString("TUNIMED"));
                    pa.settUniMedDes(rs.getString("DENTAB"));
                    pap.settUniMedDes(rs.getString("DENTAB"));

                    pm.seteUnitMed(rs.getString("EUNIMED"));
                    pa.seteUniMed(rs.getString("EUNIMED"));
                    pap.seteUniMed(rs.getString("EUNIMED"));
                    pa.seteUniMedDes(rs.getString("DENELE"));
                    pap.seteUniMedDes(rs.getString("DENELE"));

                    pm.setCostoUnit(rs.getFloat("COSTOUNIT"));

                    pm.setCodCia(codCia);

                    pm.setIngEgr(ingEgr);
                    pa.setIngEgr(ingEgr);
                    pap.setIngEgr(ingEgr);

                    pm.setVigente('1');

                    listaPm.add(pm);
                    listaPartida.add(pa);
                    listaPartidaPadre.add(pap);
                }
                
                lista.add(listaPm);
                lista.add(listaPartida);
                lista.add(listaPartidaPadre);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        System.out.println("Terminando la lista");
        return lista;
    }

    public List<PartidaAux> getv_datos_partidas_padre(int codCia, String ingEgr) {
        List<PartidaAux> lista = new ArrayList<>();

        String sql = "{call p_getv_datos_partidas_padre(?, ?, ?)}";

        try (Connection con = conexion.conectar();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, codCia);
            cs.setString(2, ingEgr);
            cs.registerOutParameter(3, java.sql.Types.REF_CURSOR);

            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(3)) {
                while (rs.next()) {
                    PartidaAux pa = new PartidaAux();

                    pa.setCodPartida(rs.getInt("CODPARTIDA"));
                    pa.setDesPartida(rs.getString("DESPARTIDA"));
                    pa.setIngEgr(ingEgr);

                    lista.add(pa);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return lista;

    }

}