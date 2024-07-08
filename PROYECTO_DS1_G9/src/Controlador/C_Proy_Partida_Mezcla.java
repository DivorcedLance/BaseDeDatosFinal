package Controlador;

import Modelo.DAO.Proy_PartidaDAO;
import Modelo.DAO.Proy_Partida_MezclaDAO;
import Modelo.DAO.ProyectoDAO;
import Modelo.Message.Mensaje1;
import Modelo.Message.Mensaje2;
import Utils.Excel;
import Modelo.Proy_Partida_Mezcla;
import Modelo.Proyecto;
import Modelo.Auxiliares.PartidaAux;
import Modelo.Auxiliares.ProyectoAux;
import Vistas.V_GeneratorTree;
import static Vistas.V_Login.varCodCiaGlobalDeLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Vistas.V_Proy_Partida_Mezcla;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class C_Proy_Partida_Mezcla implements ItemListener,ActionListener, KeyListener, MouseListener{
    
    Proy_Partida_MezclaDAO ppmDAO = new Proy_Partida_MezclaDAO();
    V_Proy_Partida_Mezcla vppm = new V_Proy_Partida_Mezcla();
    DefaultTableModel modelProyPartidaMezclaI = new DefaultTableModel();
    DefaultTableModel modelProyPartidaMezclaE = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> sorterI;
    TableRowSorter<DefaultTableModel> sorterE;
    
    public C_Proy_Partida_Mezcla(V_Proy_Partida_Mezcla vppm){
        this.vppm=vppm;
        this.vppm.btt_Actualizar_I.addActionListener(this);
        this.vppm.btt_Registrar_I.addActionListener(this);
        this.vppm.btt_Eliminar_I.addActionListener(this);
        this.vppm.tablaProy_Partida_Mezcla_I.addMouseListener(this);
        this.vppm.padCodPartida_I.addItemListener(this);
        this.vppm.proyecto_I.addItemListener(this);
        
        this.vppm.btt_Actualizar_E.addActionListener(this);
        this.vppm.btt_Registrar_E.addActionListener(this);
        this.vppm.btt_Eliminar_E.addActionListener(this);
        this.vppm.tablaProy_Partida_Mezcla_E.addMouseListener(this);
        this.vppm.padCodPartida_E.addItemListener(this);
        this.vppm.proyecto_E.addItemListener(this);
        
        this.vppm.actualizaTablaIng.addActionListener(this);
        this.vppm.generaArbolIng.addActionListener(this);
        this.vppm.actualizaTablaEgr.addActionListener(this);
        this.vppm.generaArbolEgr.addActionListener(this);
        this.vppm.nuevoIng.addActionListener(this);
        this.vppm.nuevoEgr.addActionListener(this);

        this.vppm.btnExcelI.addActionListener(this);
        this.vppm.btnExcelE.addActionListener(this);
        init();
    }
    
    public void init(){
        initTablaProyPartidaMezcla_I();
        initTablaProyPartidaMezcla_E();
        vppm.init();
        initListarProyectos_I();
        initListarProyectos_E();
    }
    
    public void initListarProyectos_I(){
        vppm.proyecto_I.removeAllItems();
        List<Proyecto> listaPI = new ProyectoDAO().listarPorCodCia(varCodCiaGlobalDeLogin);
        System.out.println("Tamaño de listaPI: "+listaPI.size());
        for(int i=0;i<listaPI.size();i++){
            ProyectoAux pya = new ProyectoAux(listaPI.get(i).getCodPyto(),listaPI.get(i).getNomPyto());
            vppm.proyecto_I.addItem(pya);
            System.out.println("   Proyecto: "+pya.getNomPyto());
        }
    }
    
    public void initListarProyectos_E(){
        vppm.proyecto_E.removeAllItems();
        List<Proyecto> listaPE = new ProyectoDAO().listarPorCodCia(varCodCiaGlobalDeLogin);
        for(int i=0;i<listaPE.size();i++){
            ProyectoAux pya = new ProyectoAux(listaPE.get(i).getCodPyto(),listaPE.get(i).getNomPyto());
            vppm.proyecto_E.addItem(pya);
        }
    }
    
    public void initListarPartidas(int pyto){
        vppm.padCodPartida_I.removeAllItems();

        List<PartidaAux> listaParI = new Proy_PartidaDAO().getv_datos_partidas_padre(varCodCiaGlobalDeLogin, "I");
        for (int i = 0; i < listaParI.size(); i++) {
            vppm.padCodPartida_I.addItem(listaParI.get(i));
        }

        vppm.padCodPartida_E.removeAllItems();

        List<PartidaAux> listaParE = new Proy_PartidaDAO().getv_datos_partidas_padre(varCodCiaGlobalDeLogin, "E");
        for (int i = 0; i < listaParE.size(); i++) {
            vppm.padCodPartida_E.addItem(listaParE.get(i));
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("DENTRO DE ACTION PARTIDA_MEZCLA");
        if(e.getSource()==vppm.btt_Registrar_I){
            registrarDatos("I");
            actualizarTabla();
        }
        if(e.getSource()==vppm.btt_Actualizar_I){
            actualizarDatos("I");
            actualizarTabla();
        }
        if(e.getSource()==vppm.btt_Eliminar_I){
            eliminarDatos("I");
            actualizarTabla();
        }
        if(e.getSource()==vppm.btt_Registrar_E){
            registrarDatos("E");
            actualizarTabla();
        }
        if(e.getSource()==vppm.btt_Actualizar_E){
            actualizarDatos("E");
            actualizarTabla();
        }
        if(e.getSource()==vppm.btt_Eliminar_E){
            eliminarDatos("E");
            actualizarTabla();
        }
        if(e.getSource()==vppm.actualizaTablaIng){
            actualizarTabla();
        }
        if(e.getSource()==vppm.generaArbolIng){
            System.out.println("2");
            generaArbolIngreso();
        }
        if(e.getSource()==vppm.actualizaTablaEgr){
            actualizarTabla();
        }
        if(e.getSource()==vppm.generaArbolEgr){
            System.out.println("4");
            generaArbolEgreso();
        }
        if (e.getSource() == vppm.btnExcelI || e.getSource() == vppm.btnExcelE) {
            Excel excel = new Excel();
            // 
            List<String> headers = Arrays.asList("Proyecto", "Código Mezcla", "Hija", "Padre", "Nivel", "Orden", "Tabs", "Elementos", "Costo Unitario", "Cantidad", "Costo Total");
            excel.exportTablesToExcel(Arrays.asList(vppm.tablaProy_Partida_Mezcla_I, vppm.tablaProy_Partida_Mezcla_E), Arrays.asList(headers, headers), Arrays.asList("TablaProyPartidaMezclaI", "TablaProyPartidaMezclaE"), "TablaProyPartidaMezcla");            
        }
        if(e.getSource()==vppm.nuevoEgr){
            vaciarCampos();
            actualizarTabla();
        }
        if(e.getSource()==vppm.nuevoIng){
            vaciarCampos();
            actualizarTabla();
        }
    }
    
    public void actualizarTabla(){
        limpiarTabla(modelProyPartidaMezclaI);
        limpiarTabla(modelProyPartidaMezclaE);
        initTablaProyPartidaMezcla_I();
        initTablaProyPartidaMezcla_E();
        System.out.println("Refrescando tabla automaticamente.");
    }

    public void initTablaProyPartidaMezcla_I(){
        @SuppressWarnings("rawtypes")
        List listaI = new Proy_Partida_MezclaDAO().getv_proy_partida_mezcla(varCodCiaGlobalDeLogin,"I");
        @SuppressWarnings("unchecked")
        List<Proy_Partida_Mezcla> listaPpm = (List<Proy_Partida_Mezcla>) listaI.get(0);
        @SuppressWarnings("unchecked")
        List<ProyectoAux> listaProyecto = (List<ProyectoAux>) listaI.get(1);
        @SuppressWarnings("unchecked")
        List<PartidaAux> listaPartida = (List<PartidaAux>) listaI.get(2);
        @SuppressWarnings("unchecked")
        List<PartidaAux> listaPartidaPadre = (List<PartidaAux>) listaI.get(3);

        modelProyPartidaMezclaI = (DefaultTableModel)vppm.tablaProy_Partida_Mezcla_I.getModel();

        Object[] o=new Object[11];
        sorterI = new TableRowSorter<>(modelProyPartidaMezclaI);
        vppm.tablaProy_Partida_Mezcla_I.setRowSorter(sorterI);
        limpiarTabla(modelProyPartidaMezclaI);
        for(int i=0;i<listaPpm.size();i++){
            o[0]=listaProyecto.get(i); // Proyecto
            o[1]=listaPpm.get(i); // Corr
            o[2]=listaPartida.get(i); // Partida
            o[3]=listaPartidaPadre.get(i); // PartidaPadre
            o[4]=listaPpm.get(i).getNivel(); // Nivel
            o[5]=listaPpm.get(i).getOrden(); // Orden
            o[6]=listaPartida.get(i).gettUniMedDes(); // tUnitMed
            o[7]=listaPartida.get(i).geteUniMedDes(); // eUnitMed
            o[8]=listaPpm.get(i).getCostoUnit(); // CostoUnit
            o[9]=listaPpm.get(i).getCant(); // Cantidad
            o[10]=listaPpm.get(i).getCostoTot(); // CostoTotal
            modelProyPartidaMezclaI.addRow(o);
        }
        vppm.tablaProy_Partida_Mezcla_I.setModel(modelProyPartidaMezclaI);
    }
    
    public void initTablaProyPartidaMezcla_E(){
        @SuppressWarnings("rawtypes")
        List listaE = new Proy_Partida_MezclaDAO().getv_proy_partida_mezcla(varCodCiaGlobalDeLogin,"E");
        @SuppressWarnings("unchecked")
        List<Proy_Partida_Mezcla> listaPpm = (List<Proy_Partida_Mezcla>) listaE.get(0);
        @SuppressWarnings("unchecked")
        List<ProyectoAux> listaProyecto = (List<ProyectoAux>) listaE.get(1);
        @SuppressWarnings("unchecked")
        List<PartidaAux> listaPartida = (List<PartidaAux>) listaE.get(2);
        @SuppressWarnings("unchecked")
        List<PartidaAux> listaPartidaPadre = (List<PartidaAux>) listaE.get(3);
        
        System.out.println("Tamaño de listaPpmE: "+listaPpm.size());
        
        modelProyPartidaMezclaE = (DefaultTableModel)vppm.tablaProy_Partida_Mezcla_E.getModel();
        Object[] o=new Object[12];
        sorterE = new TableRowSorter<>(modelProyPartidaMezclaE);
        vppm.tablaProy_Partida_Mezcla_E.setRowSorter(sorterE);
        limpiarTabla(modelProyPartidaMezclaE);
        for(int i=0;i<listaPpm.size();i++){
            o[0]=listaProyecto.get(i); // Proyecto
            o[1]=listaPpm.get(i); // Corr
            o[2]=listaPartida.get(i); // Partida
            o[3]=listaPartidaPadre.get(i); // PartidaPadre
            o[4]=listaPpm.get(i).getNivel(); // Nivel
            o[5]=listaPpm.get(i).getOrden(); // Orden
            o[6]=listaPartida.get(i).gettUniMedDes(); // tUnitMed
            o[7]=listaPartida.get(i).geteUniMedDes(); // eUnitMed
            o[8]=listaPpm.get(i).getCostoUnit(); // CostoUnit
            o[9]=listaPpm.get(i).getCant(); // Cantidad
            o[10]=listaPpm.get(i).getCostoTot(); // CostoTotal
            modelProyPartidaMezclaE.addRow(o);
        }
        vppm.tablaProy_Partida_Mezcla_E.setModel(modelProyPartidaMezclaE);
    }
    
    public void generaArbolIngreso(){
        int filaSelecIng, pyto;
        filaSelecIng = vppm.tablaProy_Partida_Mezcla_I.getSelectedRow();
        pyto = Integer.parseInt(vppm.tablaProy_Partida_Mezcla_I.getValueAt(filaSelecIng,0).toString()); //codPyto
        //codPartida = Integer.parseInt(vppm.tablaProy_Partida_Mezcla_I.getValueAt(filaSelecIng,3).toString());//codPartida
        V_GeneratorTree tg1=new V_GeneratorTree(varCodCiaGlobalDeLogin,pyto,"I");
        tg1.setVisible(true);
        System.out.println("LA FILA DE INGRESO ES: "+filaSelecIng);
    }
    
    public void generaArbolEgreso(){
        int filaSelecEgr, pyto;
        filaSelecEgr = vppm.tablaProy_Partida_Mezcla_E.getSelectedRow();
        pyto = Integer.parseInt(vppm.tablaProy_Partida_Mezcla_E.getValueAt(filaSelecEgr,0).toString()); //codPyto
        //codPartida = Integer.parseInt(vppm.tablaProy_Partida_Mezcla_E.getValueAt(filaSelecEgr,3).toString());//codPartida
        V_GeneratorTree tg2=new V_GeneratorTree(varCodCiaGlobalDeLogin,pyto,"E");
        tg2.setVisible(true);
        System.out.println("LA FILA DE Egreso ES: "+filaSelecEgr);
    }
    
    public void limpiarTabla(DefaultTableModel model){
        for(int i = 0; i < model.getRowCount();i++){
            model.removeRow(i);
            i=i-1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        return;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        return;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       int fila;
       if(e.getSource()==vppm.tablaProy_Partida_Mezcla_I){
            fila = vppm.tablaProy_Partida_Mezcla_I.getSelectedRow();
            vppm.padCodPartida_I.setSelectedItem((PartidaAux)(vppm.tablaProy_Partida_Mezcla_I.getValueAt(fila,3)));
            vppm.proyecto_I.setSelectedItem((ProyectoAux)vppm.tablaProy_Partida_Mezcla_I.getValueAt(fila,0));
            vppm.cantidad_I.setValue(((Proy_Partida_Mezcla)vppm.tablaProy_Partida_Mezcla_I.getValueAt(fila,1)).getCant());
        }
       
       if(e.getSource()==vppm.tablaProy_Partida_Mezcla_E){
            fila = vppm.tablaProy_Partida_Mezcla_E.getSelectedRow();
            vppm.padCodPartida_E.setSelectedItem((PartidaAux)vppm.tablaProy_Partida_Mezcla_E.getValueAt(fila,3));
            vppm.proyecto_E.setSelectedItem((ProyectoAux)vppm.tablaProy_Partida_Mezcla_E.getValueAt(fila,0));
            vppm.cantidad_E.setValue(((Proy_Partida_Mezcla)vppm.tablaProy_Partida_Mezcla_E.getValueAt(fila,1)).getCant());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        return;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         return;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        return;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        return;
    }
    
    public void registrarDatos(String tip){
        Proy_Partida_Mezcla pm = new Proy_Partida_Mezcla();
        pm.setCodCia(varCodCiaGlobalDeLogin);
        pm.setIngEgr(tip);
        pm.setNroVersion(1);
        if (tip == "I") {
            pm.setCodPyto(((ProyectoAux)vppm.proyecto_I.getSelectedItem()).getCodPyto());
            pm.setPadCodPartida(((PartidaAux)vppm.padCodPartida_I.getSelectedItem()).getCodPartida());
            pm.setCant(Integer.parseInt(vppm.cantidad_I.getValue().toString()));
        }
        else{
            pm.setCodPyto(((ProyectoAux)vppm.proyecto_E.getSelectedItem()).getCodPyto());
            pm.setPadCodPartida(((PartidaAux)vppm.padCodPartida_E.getSelectedItem()).getCodPartida());
            pm.setCant(Integer.parseInt(vppm.cantidad_E.getValue().toString()));
        }
        if(ppmDAO.add(pm)==1){
            showMessage2("Proy_Partida_Mezcla registrado correctamente");
            vaciarCampos();
        }else{
            showMessage1("Error al registrar el Proy_Partida_Mezcla");
        }
    }
    
    private boolean showMessage1(String message){
        Mensaje1 obj = new Mensaje1(Frame.getFrames()[1],true);
        obj.showMessage(message);
        return obj.isAceptar();
    }
    
    private boolean showMessage2(String message) {
        Mensaje2 obj = new Mensaje2(Frame.getFrames()[1], true);
        obj.showMessage(message);
        return obj.isAceptar();
    }
    
    public void actualizarDatos(String tip){
        int fila;
        Proy_Partida_Mezcla pm = new Proy_Partida_Mezcla();
        if(tip == "I"){
            fila = vppm.tablaProy_Partida_Mezcla_I.getSelectedRow();
            if(fila!=-1){
                pm.setNivel(((Integer)vppm.tablaProy_Partida_Mezcla_I.getValueAt(fila,4)));
                pm.setOrden(((Integer)vppm.tablaProy_Partida_Mezcla_I.getValueAt(fila,5)));
                pm.setCostoUnit(((Float)vppm.tablaProy_Partida_Mezcla_I.getValueAt(fila,8)));
                pm.setCorr(((Proy_Partida_Mezcla)vppm.tablaProy_Partida_Mezcla_I.getValueAt(fila,1)).getCorr());
                pm.setCodPyto(((ProyectoAux)vppm.tablaProy_Partida_Mezcla_I.getValueAt(fila,0)).getCodPyto());
                pm.setCodPartida(((PartidaAux)vppm.tablaProy_Partida_Mezcla_I.getValueAt(fila,2)).getCodPartida());
                pm.setCant((Integer)vppm.cantidad_I.getValue());

            
            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
        else{
            fila = vppm.tablaProy_Partida_Mezcla_E.getSelectedRow();
            if(fila!=-1){

                pm.setNivel(((Integer)vppm.tablaProy_Partida_Mezcla_E.getValueAt(fila,4)));
                pm.setOrden(((Integer)vppm.tablaProy_Partida_Mezcla_E.getValueAt(fila,5)));
                pm.setCostoUnit(((Float)vppm.tablaProy_Partida_Mezcla_E.getValueAt(fila,8)));
                pm.setCorr(((Proy_Partida_Mezcla)vppm.tablaProy_Partida_Mezcla_E.getValueAt(fila,1)).getCorr());
                pm.setCodPyto(((ProyectoAux)vppm.tablaProy_Partida_Mezcla_E.getValueAt(fila,0)).getCodPyto());
                pm.setCodPartida(((PartidaAux)vppm.tablaProy_Partida_Mezcla_E.getValueAt(fila,2)).getCodPartida());
                pm.setCant((Integer)vppm.cantidad_E.getValue());

            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
        pm.setCodCia(varCodCiaGlobalDeLogin);
        pm.setIngEgr(tip);
        pm.setNroVersion(1);
        pm.setCostoTot(pm.getCant()*pm.getCostoUnit());

        if(ppmDAO.actualizar(pm)==1){
            showMessage2("Proy_Partida_Mezcla registrado correctamente");
            vaciarCampos();
        }else{
            showMessage1("Proy_Partida_Mezcla al registrar Elementos");
        }
    }
    
    public void eliminarDatos(String tip){
        int fila,cod,cor,pyto,ver;
        if(tip=="I"){
            fila = vppm.tablaProy_Partida_Mezcla_I.getSelectedRow();
            System.out.println("La fila es"+fila);
            if(fila!=-1){
                cod = ((PartidaAux)vppm.tablaProy_Partida_Mezcla_I.getValueAt(fila,2)).getCodPartida();
                cor = ((Proy_Partida_Mezcla)vppm.tablaProy_Partida_Mezcla_I.getValueAt(fila,1)).getCorr();
                pyto = ((ProyectoAux)vppm.tablaProy_Partida_Mezcla_I.getValueAt(fila,0)).getCodPyto();
                ver = 1;
                new Proy_Partida_MezclaDAO().eliminarDatos(varCodCiaGlobalDeLogin,cod,tip,cor,pyto,ver);
            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
        else{
            fila = vppm.tablaProy_Partida_Mezcla_E.getSelectedRow();
            System.out.println("La fila es"+fila);
            if(fila!=-1){
                cod = ((PartidaAux)vppm.tablaProy_Partida_Mezcla_E.getValueAt(fila,2)).getCodPartida();
                cor = ((Proy_Partida_Mezcla)vppm.tablaProy_Partida_Mezcla_E.getValueAt(fila,1)).getCorr();
                pyto = ((ProyectoAux)vppm.tablaProy_Partida_Mezcla_E.getValueAt(fila,0)).getCodPyto();
                ver = 1;
                new Proy_Partida_MezclaDAO().eliminarDatos(varCodCiaGlobalDeLogin,cod,tip,cor,pyto,ver);
            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
    }
    
    public void vaciarCampos(){
        vppm.cantidad_E.setValue(1);
        vppm.cantidad_I.setValue(1);
        
        vppm.cantidad_I.setModel(new SpinnerNumberModel(1,1,999,1));
        vppm.cantidad_E.setModel(new SpinnerNumberModel(1,1,999,1));
    }
    
    int pyto;
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==vppm.proyecto_I){
            if(vppm.proyecto_I.getSelectedIndex()!=-1){
                initListarPartidas(((ProyectoAux)vppm.proyecto_I.getSelectedItem()).getCodPyto());
            } else{
                vppm.proyecto_I.setSelectedItem(-1);
            }
        }
        
         if(e.getSource()==vppm.proyecto_E){
            if(vppm.proyecto_E.getSelectedIndex()!=-1){
                initListarPartidas(((ProyectoAux)vppm.proyecto_E.getSelectedItem()).getCodPyto());
            } else{
                vppm.proyecto_E.setSelectedItem(-1);
            }
        }
    }
    
}
