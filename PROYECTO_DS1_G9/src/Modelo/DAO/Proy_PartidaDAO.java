package Modelo.DAO;

import Modelo.Conexion.ConectarOracle;
import Modelo.Interface.CRUD;
import Modelo.Proy_Partida;
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

public class Proy_PartidaDAO implements CRUD<Proy_Partida> {

    // ConectarOracle conexion=new ConectarOracle();
    ConectarOracle conexion = ConectarOracle.getInstance();
    Connection con;
    Statement ps;
    PreparedStatement pst;
    ResultSet rs;
    CallableStatement myCall;

    @Override
    public List<Proy_Partida> listar() {
        List<Proy_Partida> lista = new ArrayList<>();
        String sql = "SELECT * FROM PROY_PARTIDA order by CODCIA";
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Proy_Partida pm = new Proy_Partida();
                pm.setCodCia(rs.getInt(1));
                pm.setCodPyto(rs.getInt(2));
                pm.setNroVersion(rs.getInt(3));
                pm.setIngEgr(rs.getString(4));
                pm.setCodPartida(rs.getInt(5));
                pm.setCodPartidas(rs.getString(6));
                pm.setFlgCC(rs.getString(7));
                pm.setNivel(rs.getInt(8));
                pm.setuUniMed(rs.getString(9));
                pm.setTabEstado(rs.getString(10));
                pm.setCodEstado(rs.getString(11));
                pm.setVigente(rs.getString(12).charAt(0));
                lista.add(pm);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        System.out.println("terminando la lista");
        return lista;
    }

    @Override
    public int add(Proy_Partida p) {
        System.out.println("{call INSERTAR_PROY_PARTIDA(?,?,?,?,?,?,?,?,?)}");
        System.out.println("Pyto" + p.getCodPyto() + " NroVersion" + p.getNroVersion() + " CodCia" + p.getCodCia()
                + " IngEgr" + p.getIngEgr() + " CodPartida" + p.getCodPartida() + " CodPartidas" + p.getCodPartidas()
                + " TabEstado" + p.getTabEstado() + " CodEstado" + p.getCodEstado() + " Vigente" + p.getVigente());
        try {
            con = conexion.conectar();
            myCall = con.prepareCall("{call INSERTAR_PROY_PARTIDA(?,?,?,?,?,?,?,?,?)}");
            myCall.setInt(1, p.getCodPyto());
            myCall.setInt(2, p.getNroVersion());
            myCall.setInt(3, p.getCodCia());
            myCall.setString(4, p.getIngEgr());
            myCall.setInt(5, p.getCodPartida());
            myCall.setString(6, p.getCodPartidas());
            myCall.setString(7, p.getTabEstado());
            myCall.setString(8, p.getCodEstado());
            myCall.setString(9, String.valueOf(p.getVigente()));


            myCall.execute();
            myCall.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Excepcion.\n" + ex.toString());
            System.out.println(ex.toString());
            return 0;
        }
        return 1;
    }

    @Override
    public int actualizar(Proy_Partida p) {
        String sql1 = "update PROY_PARTIDA set NROVERSION=? where CODCIA=? AND CODPYTO=? AND INGEGR=? and CODPARTIDA=?";
        System.out.println(sql1);
        try {
            con = conexion.conectar();
            pst = con.prepareStatement(sql1);
            myCall.setInt(1, p.getNroVersion());
            myCall.setInt(2, p.getCodCia());
            myCall.setInt(3, p.getCodPyto());
            myCall.setString(4, p.getIngEgr());
            myCall.setInt(5, p.getCodPartida());
            pst.execute();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Excepcion.\n" + ex.toString());
            System.out.println(ex.toString());
            return 0;
        }
        return 1;
    }

    @Override
    public void eliminar(int id) {
        return;
    }

    public void eliminarDatos(int cia, int cod, String tip, int pyto, int ver) {
        String sql1 = "DELETE from PROY_PARTIDA where CODCIA=" + cia + " AND CODPARTIDA=" + cod + " AND INGEGR='" + tip
                + "' AND CODPYTO=" + pyto + " AND NROVERSION=" + ver;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery(sql1);
            rs.close();
            ps.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Proy_Partida eliminado con exito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Excepcion.\n" + e.toString());
            System.out.println(e.toString());
        }
    }

    public Proy_Partida listarId(int cia, int pyto, int ver, int cod, String tip) {
        Proy_Partida pm = new Proy_Partida();
        String sql = "SELECT CODPYTO,NROVERSION,CODPARTIDA,CODESTADO,VIGENTE FROM PROY_PARTIDA WHERE CODCIA=" + cia
                + " AND"
                + " CODPYTO=" + pyto + " AND NROVERSION=" + ver + " AND CODPARTIDA=" + cod + " AND INGEGR='" + tip
                + "'";
        try {
            con = conexion.conectar();
            ps = con.createStatement();
            rs = ps.executeQuery(sql);
            if (rs.next()) {
                pm.setCodPyto(rs.getInt(1));
                pm.setNroVersion(rs.getInt(2));
                pm.setCodPartida(rs.getInt(3));
                pm.setCodEstado(rs.getString(4));
                pm.setVigente(rs.getString(5).charAt(0));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Excepcion.\n" + e.toString());
            System.out.println(e.toString());
        }
        return pm;
    }

    public List<Proy_Partida> listarPorCodCia(int id, String tip) {
        List<Proy_Partida> lista = new ArrayList<>();
        String sql = "SELECT "
                + "CodPyto,NroVersion,CodPartida,CodEstado,Vigente "
                + "FROM PROY_PARTIDA WHERE CODCIA=" + id + " AND INGEGR='" + tip + "' order by CODPYTO";
        System.out.println(sql);
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Proy_Partida pm = new Proy_Partida();
                pm.setCodPyto(rs.getInt(1));
                pm.setNroVersion(rs.getInt(2));
                pm.setCodPartida(rs.getInt(3));
                pm.setCodEstado(rs.getString(4));
                pm.setVigente(rs.getString(5).charAt(0));
                lista.add(pm);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Excepcion.\n" + e.toString());
            System.out.println(e.toString());
        }
        return lista;
    }

    public List<Proy_Partida> listarPorCodCiav2(int id, String tip, int pyto) {
        List<Proy_Partida> lista = new ArrayList<>();
        String sql = "SELECT "
                + "CodPyto,NroVersion,CodPartida,CodEstado,Vigente "
                + "FROM PROY_PARTIDA WHERE CODCIA=" + id + " AND INGEGR='" + tip + "' AND CODPYTO=" + pyto
                + " order by CODPYTO";
        System.out.println(sql);
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Proy_Partida pm = new Proy_Partida();
                pm.setCodPyto(rs.getInt(1));
                pm.setNroVersion(rs.getInt(2));
                pm.setCodPartida(rs.getInt(3));
                pm.setCodEstado(rs.getString(4));
                pm.setVigente(rs.getString(5).charAt(0));
                lista.add(pm);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Excepcion.\n" + e.toString());
            System.out.println(e.toString());
        }
        return lista;
    }

    public List<Proy_Partida> listarPorCodCia(int id, String tip, int pyto) {
        List<Proy_Partida> lista = new ArrayList<>();
        String sql = "SELECT "
                + "CodPyto,NroVersion,CodPartida,CodEstado,Vigente "
                + "FROM PROY_PARTIDA WHERE CODCIA=" + id + " AND INGEGR='" + tip + "' AND CODPYTO=" + pyto
                + " order by CODPYTO";
        System.out.println(sql);
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Proy_Partida pm = new Proy_Partida();
                pm.setCodPyto(rs.getInt(1));
                pm.setNroVersion(rs.getInt(2));
                pm.setCodPartida(rs.getInt(3));
                pm.setCodEstado(rs.getString(4));
                pm.setVigente(rs.getString(5).charAt(0));
                lista.add(pm);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Excepcion.\n" + e.toString());
            System.out.println(e.toString());
        }
        return lista;
    }

    public List<Proy_Partida> listarPorCodPyto(int id) {
        List<Proy_Partida> lista = new ArrayList<>();
        String sql = "SELECT "
                + "CodPartida "
                + "FROM PROY_PARTIDA WHERE CODPYTO=" + id + " order by CODPARTIDA";
        System.out.println(sql);
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Proy_Partida pm = new Proy_Partida();
                pm.setCodPartida(rs.getInt(1));
                lista.add(pm);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Excepcion.\n" + e.toString());
            System.out.println(e.toString());
        }
        return lista;
    }

    public Proy_Partida listarId(String id) {
        Proy_Partida pyPart = new Proy_Partida();
        String sql = "SELECT DESPARTIDA,CODPARTIDA FROM PROY_PARTIDA WHERE CODPARTIDA=" + id + " order by CODPARTIDA";
        try {
            con = conexion.conectar();
            ps = con.createStatement();
            rs = ps.executeQuery(sql);
            if (rs.next()) {
                // pyPart.setDesPartida(rs.getString(1));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Excepcion.\n" + e.toString());
            System.out.println(e.toString());
        }
        return pyPart;
    }

    public List<PartidaAux> getv_datos_partidas_padre(int codCia, String ingEgr) {
        List<PartidaAux> listaPartidasPadre = new ArrayList<>();

        String sql = "{call getv_datos_partidas_padre(?, ?, ?)}";
        try (Connection con = conexion.conectar();
             CallableStatement cs = con.prepareCall(sql)) {
    
            cs.setInt(1, codCia);
            cs.setString(2, ingEgr);
            cs.registerOutParameter(3, java.sql.Types.REF_CURSOR);
    
            cs.execute();
    
            try (ResultSet rs = (ResultSet) cs.getObject(3)) {
                while (rs.next()) {
                    PartidaAux partidaPadre = new PartidaAux(); // PartidaAux

                    partidaPadre.setCodPartida(rs.getInt("PADCODPARTIDA"));

                    if (partidaPadre.getCodPartida() == 0) {
                        partidaPadre.setDesPartida(rs.getString("DESPARTIDA"));
                        partidaPadre.setIngEgr(ingEgr);
                        
                        listaPartidasPadre.add(partidaPadre);
                    } else {
                        partidaPadre.setDesPartida(rs.getString("DESPARTIDA"));
                        partidaPadre.setIngEgr(rs.getString("INGEGR"));
                        
                        listaPartidasPadre.add(partidaPadre);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return listaPartidasPadre;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List getv_proy_partida(int codCia, String ingEgr) {
        List lista = new ArrayList<>();
        List<Proy_Partida> listaProyPartida = new ArrayList<>();
        List<ProyectoAux> listaProyectos = new ArrayList<>();
        List<PartidaAux> listaPartidas = new ArrayList<>();

        String sql = "{call getv_proy_partida(?, ?, ?)}";
        try (Connection con = conexion.conectar();
             CallableStatement cs = con.prepareCall(sql)) {
    
            cs.setInt(1, codCia);
            cs.setString(2, ingEgr);
            cs.registerOutParameter(3, java.sql.Types.REF_CURSOR);
    
            cs.execute();
    
            try (ResultSet rs = (ResultSet) cs.getObject(3)) {
                while (rs.next()) {
                    Proy_Partida proyPartida = new Proy_Partida(); // Proy_Partida
                    ProyectoAux pya = new ProyectoAux(); // ProyectoAux
                    PartidaAux pa = new PartidaAux(); // PartidaAux

                    proyPartida.setCodPyto(rs.getInt("CODPYTO"));
                    proyPartida.setCodPartida(rs.getInt("CODPARTIDA"));
                    proyPartida.setCodPartidas(rs.getString("CODPARTIDAS"));
                    proyPartida.setNroVersion(1);
                    proyPartida.setVigente('1');
                    proyPartida.setCodCia(codCia);
                    proyPartida.setIngEgr(ingEgr);

                    pya.setCodPyto(rs.getInt("CODPYTO"));
                    pya.setNomPyto(rs.getString("NOMBPYTO"));

                    pa.setCodPartida(rs.getInt("CODPARTIDA"));
                    pa.setDesPartida(rs.getString("DESPARTIDA"));
                    pa.setCodPartidas(rs.getString("CODPARTIDAS"));
                    pa.setIngEgr(ingEgr);

                    listaProyPartida.add(proyPartida);
                    listaProyectos.add(pya);
                    listaPartidas.add(pa);
                }
            }
        
        lista.add(listaProyPartida);
        lista.add(listaProyectos);
        lista.add(listaPartidas);
        
        
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return lista;
    }


}