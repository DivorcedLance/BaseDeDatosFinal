package Controlador;

import Modelo.DAO.PartidaDAO;
import static Vistas.V_Login.varCodCiaGlobalDeLogin;
import Modelo.Message.Mensaje1;
import Modelo.Message.Mensaje2;
import Utils.Excel;
import Modelo.DAO.Partida_MezclaDAO;
import Modelo.Partida;
import Modelo.Partida_Mezcla;
import Modelo.Auxiliares.PartidaAux;
import Vistas.V_Partida_Mezcla;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class C_Partida_Mezcla implements ItemListener,ActionListener, KeyListener, MouseListener{
    Partida_MezclaDAO pmDAO = new Partida_MezclaDAO();
    V_Partida_Mezcla vpm = new V_Partida_Mezcla();
    DefaultTableModel modelPartidaMezclaI = new DefaultTableModel();
    DefaultTableModel modelPartidaMezclaE = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> sorterI;
    TableRowSorter<DefaultTableModel> sorterE;
    int ordenI,ordenE;
    
    public C_Partida_Mezcla(V_Partida_Mezcla vpm){
        this.vpm=vpm;
        this.vpm.btt_Actualizar_I.addActionListener(this);
        this.vpm.btt_Registrar_I.addActionListener(this);
        this.vpm.btt_Eliminar_I.addActionListener(this);
        this.vpm.tablaPartida_Mezcla_I.addMouseListener(this);
        this.vpm.padCodPartida_I.addItemListener(this);
        
        this.vpm.btt_Actualizar_E.addActionListener(this);
        this.vpm.btt_Registrar_E.addActionListener(this);
        this.vpm.btt_Eliminar_E.addActionListener(this);
        this.vpm.tablaPartida_Mezcla_E.addMouseListener(this);
        this.vpm.padCodPartida_E.addItemListener(this);
        
        this.vpm.actualizaTabla.addActionListener(this);
        this.vpm.nuevo.addActionListener(this);

        this.vpm.btnExcelE.addActionListener(this);
        this.vpm.btnExcelI.addActionListener(this);
        init();
    }
    
    public void init(){
        initTablaPartidaMezcla_I();
        initTablaPartidaMezcla_E();
        vpm.init();
        initListarPartidas();
    }
    
     public void initListarPartidas(){
        vpm.codPartida_I.removeAllItems();
        vpm.padCodPartida_I.removeAllItems();
        PartidaAux pa = new PartidaAux(0, "I", "");
        vpm.padCodPartida_I.addItem(pa);
        List<Partida> listaParI = new PartidaDAO().listarPorCodCia(varCodCiaGlobalDeLogin,"I");
        for (int i = 0; i < listaParI.size(); i++) {
            Partida p = listaParI.get(i);
            pa = new PartidaAux(p.getCodPartida(), p.getIngEgr(), p.getDesPartida(), p.gettUniMed(), p.geteUniMed());
            vpm.codPartida_I.addItem(pa);
            vpm.padCodPartida_I.addItem(pa);
        }

        vpm.codPartida_E.removeAllItems();
        vpm.padCodPartida_E.removeAllItems();
        pa = new PartidaAux(0, "E", "");
        vpm.padCodPartida_E.addItem(pa);
        List<Partida> listaParE = new PartidaDAO().listarPorCodCia(varCodCiaGlobalDeLogin,"E");
        for (int i = 0; i < listaParE.size(); i++) {
            Partida p = listaParE.get(i);
            pa = new PartidaAux(p.getCodPartida(), p.getIngEgr(), p.getDesPartida(), p.gettUniMed(), p.geteUniMed());
            vpm.codPartida_E.addItem(pa);
            vpm.padCodPartida_E.addItem(pa);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         System.out.println("DENTRO DE ACTION PARTIDA_MEZCLA");
         if(e.getSource()==vpm.btt_Registrar_I){
            registrarDatos("I");
            actualizarTabla();
        }
        if(e.getSource()==vpm.btt_Actualizar_I){
            actualizarDatos("I");
            actualizarTabla();
        }
        if(e.getSource()==vpm.btt_Eliminar_I){
            eliminarDatos("I");
            actualizarTabla();
        }
        if(e.getSource()==vpm.btt_Registrar_E){
            registrarDatos("E");
            actualizarTabla();
        }
        if(e.getSource()==vpm.btt_Actualizar_E){
            actualizarDatos("E");
            actualizarTabla();
        }
        if(e.getSource()==vpm.btt_Eliminar_E){
            eliminarDatos("E");
            actualizarTabla();
        }
        if(e.getSource()==vpm.actualizaTabla){
            actualizarTabla();
        }
        if(e.getSource()==vpm.btnExcelI || e.getSource()==vpm.btnExcelE){
            Excel excel = new Excel();
            // 
            List<String> headers = Arrays.asList("Código Mezcla", "Hija", "Padre", "Nivel", "Orden", "Tabs", "Elementos", "Costo Unitario");
            excel.exportTablesToExcel(Arrays.asList(vpm.tablaPartida_Mezcla_I, vpm.tablaPartida_Mezcla_E), Arrays.asList(headers, headers), Arrays.asList("TablaPartidaMezclaI", "TablaPartidaMezclaE"), "TablaPartidaMezcla");
        }
        if(e.getSource()==vpm.nuevo){
            vaciarCampos();
            actualizarTabla();
        }
    }
    
    public void actualizarTabla(){
        limpiarTabla(modelPartidaMezclaI);
        limpiarTabla(modelPartidaMezclaE);
        initTablaPartidaMezcla_I();
        initTablaPartidaMezcla_E();
        //initListarPartidas(); //Para una mejor frescura visual.
        //Me da un error 
        System.out.println("Refrescando tabla automaticamente.");
    }

    public void initTablaPartidaMezcla_I(){
        System.out.println("DENTRO DE INITTABLAPARTIDAMEZCLA_I");
        @SuppressWarnings("rawtypes")
        List listaI = new Partida_MezclaDAO().getv_partidas_mezcla(varCodCiaGlobalDeLogin,"I");
        @SuppressWarnings("unchecked")
        List<Partida_Mezcla> listaPpm = (List<Partida_Mezcla>) listaI.get(0);
        @SuppressWarnings("unchecked")
        List<PartidaAux> listaPartida = (List<PartidaAux>) listaI.get(1);
        @SuppressWarnings("unchecked")
        List<PartidaAux> listaPartidaPadre = (List<PartidaAux>) listaI.get(2);

        modelPartidaMezclaI = (DefaultTableModel)vpm.tablaPartida_Mezcla_I.getModel();

        Object[] o=new Object[8];
        sorterI = new TableRowSorter<>(modelPartidaMezclaI);
        vpm.tablaPartida_Mezcla_I.setRowSorter(sorterI);
        limpiarTabla(modelPartidaMezclaI);
        for(int i=0;i<listaPpm.size();i++){
            o[0]=listaPpm.get(i); // corr
            o[1]=listaPartida.get(i); // Partida
            o[2]=listaPartidaPadre.get(i); // PartidaPadre
            o[3]=listaPpm.get(i).getNivel(); // Nivel
            o[4]=listaPpm.get(i).getOrden(); // Orden
            o[5]=((PartidaAux)listaPartida.get(i)).gettUniMedDes(); // tUnitMed
            o[6]=((PartidaAux)listaPartida.get(i)).geteUniMedDes(); // eUnitMed
            o[7]=listaPpm.get(i).getCostoUnit(); // CostoUnit
            modelPartidaMezclaI.addRow(o); // Agregar a la tabla
        }
        vpm.tablaPartida_Mezcla_I.setModel(modelPartidaMezclaI);


    }
    
    public void initTablaPartidaMezcla_E(){
        @SuppressWarnings("rawtypes")
        List listaE = new Partida_MezclaDAO().getv_partidas_mezcla(varCodCiaGlobalDeLogin,"E");
        @SuppressWarnings("unchecked")
        List<Partida_Mezcla> listaPpm = (List<Partida_Mezcla>) listaE.get(0);
        @SuppressWarnings("unchecked")
        List<PartidaAux> listaPartida = (List<PartidaAux>) listaE.get(1);
        @SuppressWarnings("unchecked")
        List<PartidaAux> listaPartidaPadre = (List<PartidaAux>) listaE.get(2);

        modelPartidaMezclaE = (DefaultTableModel)vpm.tablaPartida_Mezcla_E.getModel();

        Object[] o=new Object[8];
        sorterE = new TableRowSorter<>(modelPartidaMezclaE);
        vpm.tablaPartida_Mezcla_E.setRowSorter(sorterE);
        limpiarTabla(modelPartidaMezclaE);
        for(int i=0;i<listaPpm.size();i++){
            o[0]=listaPpm.get(i); // corr
            o[1]=listaPartida.get(i); // Partida
            o[2]=listaPartidaPadre.get(i); // PartidaPadre
            o[3]=listaPpm.get(i).getNivel(); // Nivel
            o[4]=listaPpm.get(i).getOrden(); // Orden
            o[5]=((PartidaAux)listaPartida.get(i)).gettUniMedDes(); // tUnitMed
            o[6]=((PartidaAux)listaPartida.get(i)).geteUniMedDes(); // eUnitMed
            o[7]=listaPpm.get(i).getCostoUnit(); // CostoUnit
            modelPartidaMezclaE.addRow(o); // Agregar a la tabla
        }
        vpm.tablaPartida_Mezcla_E.setModel(modelPartidaMezclaE);
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
       if(e.getSource()==vpm.tablaPartida_Mezcla_I){
            fila = vpm.tablaPartida_Mezcla_I.getSelectedRow();;

            vpm.codPartida_I.setSelectedItem((PartidaAux)vpm.tablaPartida_Mezcla_I.getValueAt(fila,1));
            vpm.padCodPartida_I.setSelectedItem((PartidaAux)vpm.tablaPartida_Mezcla_I.getValueAt(fila,2)); 

            vpm.nivel_I.setValue(((Partida_Mezcla)vpm.tablaPartida_Mezcla_I.getValueAt(fila,0)).getNivel());
            vpm.orden_I.setValue(((Partida_Mezcla)vpm.tablaPartida_Mezcla_I.getValueAt(fila,0)).getOrden());
            vpm.costoUnit_I.setValue(((Partida_Mezcla)vpm.tablaPartida_Mezcla_I.getValueAt(fila,0)).getCostoUnit());
            
        }
       
       if(e.getSource()==vpm.tablaPartida_Mezcla_E){
            fila = vpm.tablaPartida_Mezcla_E.getSelectedRow();;

            vpm.codPartida_E.setSelectedItem((PartidaAux)vpm.tablaPartida_Mezcla_E.getValueAt(fila,1));
            vpm.padCodPartida_E.setSelectedItem((PartidaAux)vpm.tablaPartida_Mezcla_E.getValueAt(fila,2)); 

            vpm.nivel_E.setValue(((Partida_Mezcla)vpm.tablaPartida_Mezcla_E.getValueAt(fila,0)).getNivel());
            vpm.orden_E.setValue(((Partida_Mezcla)vpm.tablaPartida_Mezcla_E.getValueAt(fila,0)).getOrden());
            vpm.costoUnit_E.setValue(((Partida_Mezcla)vpm.tablaPartida_Mezcla_E.getValueAt(fila,0)).getCostoUnit());
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
        Partida_Mezcla pm = new Partida_Mezcla();
        if(tip == "I"){
            pm.setCodCia(varCodCiaGlobalDeLogin);
            pm.setIngEgr(tip);
            pm.setCodPartida(((PartidaAux)vpm.codPartida_I.getSelectedItem()).getCodPartida());
            pm.setPadCodPartida(((PartidaAux)vpm.padCodPartida_I.getSelectedItem()).getCodPartida());
            pm.setNivel(Integer.parseInt(vpm.nivel_I.getValue().toString()));
            pm.setOrden(Integer.parseInt(vpm.orden_I.getValue().toString()));
            pm.setCostoUnit(Float.parseFloat(vpm.costoUnit_I.getValue().toString()));

            pm.settUnitMed(((PartidaAux)vpm.codPartida_I.getSelectedItem()).gettUniMed());
            pm.seteUnitMed(((PartidaAux)vpm.codPartida_I.getSelectedItem()).geteUniMed());

            pm.setVigente('1');
        }
        else{
            pm.setCodCia(varCodCiaGlobalDeLogin);
            pm.setIngEgr(tip);
            pm.setCodPartida(((PartidaAux)vpm.codPartida_E.getSelectedItem()).getCodPartida());
            pm.setPadCodPartida(((PartidaAux)vpm.padCodPartida_E.getSelectedItem()).getCodPartida());
            pm.setNivel(Integer.parseInt(vpm.nivel_E.getValue().toString()));
            pm.setOrden(Integer.parseInt(vpm.orden_E.getValue().toString()));
            pm.setCostoUnit(Float.parseFloat(vpm.costoUnit_E.getValue().toString()));

            pm.settUnitMed(((PartidaAux)vpm.codPartida_E.getSelectedItem()).gettUniMed());
            pm.seteUnitMed(((PartidaAux)vpm.codPartida_E.getSelectedItem()).geteUniMed());

            pm.setVigente('1');
        }
        if(pmDAO.add(pm)==1){
            showMessage2("Partida_Mezcla registrada correctamente");
            vaciarCampos();
        }else{
            showMessage1("Error al registrar el Partida_Mezcla ");
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
        int fila,cod,cor,pad;
        Partida_Mezcla pm = new Partida_Mezcla();
        if(tip == "I"){
            fila = vpm.tablaPartida_Mezcla_I.getSelectedRow();
            if(fila!=-1){
                System.out.println("Hay filas seleccionadas.");
                cor = ((Partida_Mezcla)vpm.tablaPartida_Mezcla_I.getValueAt(fila,0)).getCorr();
                cod = ((PartidaAux)vpm.tablaPartida_Mezcla_I.getValueAt(fila,1)).getCodPartida();
                pad = ((PartidaAux)vpm.tablaPartida_Mezcla_I.getValueAt(fila,2)).getCodPartida();
                pm.setCodCia(varCodCiaGlobalDeLogin);
                pm.setIngEgr(tip);
                pm.setCodPartida(cod);
                pm.setCorr(cor);
                pm.setNivel(Integer.parseInt(vpm.nivel_I.getValue().toString()));
                pm.setOrden(Integer.parseInt(vpm.orden_I.getValue().toString()));
                pm.setCostoUnit(Float.parseFloat(vpm.costoUnit_I.getValue().toString()));
                pm.setVigente('1');
                if(pmDAO.busOrden(varCodCiaGlobalDeLogin,tip,pad,pm.getNivel(),pm.getOrden())==true){
                    Partida_Mezcla pmI =new Partida_MezclaDAO().listarOrden(varCodCiaGlobalDeLogin,"I",pad,pm.getNivel(),pm.getOrden());
                    pmI.setOrden(ordenI);
                    pmDAO.actualizar(pmI);
                }
                if(pmDAO.actualizar(pm)==1){
                    showMessage2("Partida_Mezcla actualizada correctamente");
                    vaciarCampos();
                }else{
                    showMessage1("Error al actualizar Partida_Mezcla");
                }
            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
        else{
            fila = vpm.tablaPartida_Mezcla_E.getSelectedRow();
            if(fila!=-1){
                System.out.println("Hay filas seleccionadas.");
                cor = ((Partida_Mezcla)vpm.tablaPartida_Mezcla_E.getValueAt(fila,0)).getCorr();
                cod = ((PartidaAux)vpm.tablaPartida_Mezcla_E.getValueAt(fila,1)).getCodPartida();
                pad = ((PartidaAux)vpm.tablaPartida_Mezcla_E.getValueAt(fila,2)).getCodPartida();
                pm.setCodCia(varCodCiaGlobalDeLogin);
                pm.setIngEgr(tip);
                pm.setCodPartida(cod);
                pm.setCorr(cor);
                pm.setNivel(Integer.parseInt(vpm.nivel_E.getValue().toString()));
                pm.setOrden(Integer.parseInt(vpm.orden_E.getValue().toString()));
                pm.setCostoUnit(Float.parseFloat(vpm.costoUnit_E.getValue().toString()));
                pm.setVigente('1');
                if(pmDAO.busOrden(varCodCiaGlobalDeLogin,tip,pad,pm.getNivel(),pm.getOrden())==true){
                    Partida_Mezcla pmE =new Partida_MezclaDAO().listarOrden(varCodCiaGlobalDeLogin,"E",pad,pm.getNivel(),pm.getOrden());
                    pmE.setOrden(ordenE);
                    pmDAO.actualizar(pmE);
                }
                if(pmDAO.actualizar(pm)==1){
                    showMessage2("Partida_Mezcla actualizada correctamente");
                    vaciarCampos();
                }else{
                    showMessage1("Error al actualizar Partida_Mezcla");
                }
            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
    }
    
    public void eliminarDatos(String tip){
        int fila,cod,cor;
        if(tip=="I"){
            fila = vpm.tablaPartida_Mezcla_I.getSelectedRow();
            System.out.println("La fila es"+fila);
            if(fila!=-1){
                System.out.println("Hay filas seleccionadas.");
                cor = ((Partida_Mezcla)vpm.tablaPartida_Mezcla_I.getValueAt(fila,0)).getCorr();
                cod = ((PartidaAux)vpm.tablaPartida_Mezcla_I.getValueAt(fila,1)).getCodPartida();
                new Partida_MezclaDAO().eliminarDatos(varCodCiaGlobalDeLogin,cod,tip,cor);
            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
        else{
            fila = vpm.tablaPartida_Mezcla_E.getSelectedRow();
            System.out.println("La fila es"+fila);
            if(fila!=-1){
                System.out.println("Hay filas seleccionadas.");
                cor = ((Partida_Mezcla)vpm.tablaPartida_Mezcla_E.getValueAt(fila,0)).getCorr();
                cod = ((PartidaAux)vpm.tablaPartida_Mezcla_E.getValueAt(fila,1)).getCodPartida();
                new Partida_MezclaDAO().eliminarDatos(varCodCiaGlobalDeLogin,cod,tip,cor);
            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
    }
    
    public void vaciarCampos(){
        initListarPartidas();
        vpm.nivel_E.setValue(0);
        vpm.nivel_I.setValue(0);
        vpm.orden_E.setValue(0);
        vpm.orden_I.setValue(0);
        vpm.costoUnit_E.setValue(0);
        vpm.costoUnit_I.setValue(0);

        if (vpm.codPartida_I.getItemCount() > 0) {
            vpm.codPartida_I.setSelectedIndex(0);
        }
        if (vpm.codPartida_E.getItemCount() > 0) {
            vpm.codPartida_E.setSelectedIndex(0);
        }
        
        vpm.nivel_I.setModel(new SpinnerNumberModel(1,1,99,1));
        vpm.orden_I.setModel(new SpinnerNumberModel(1,1,99,1));
        vpm.costoUnit_I.setModel(new SpinnerNumberModel(0,0,999999999,1000));
        
        vpm.nivel_E.setModel(new SpinnerNumberModel(0,0,99,1));
        vpm.orden_E.setModel(new SpinnerNumberModel(0,0,99,1));
        vpm.costoUnit_E.setModel(new SpinnerNumberModel(0,0,999999999,1000));
        
        codPAD = ((PartidaAux)vpm.padCodPartida_I.getSelectedItem()).getCodPartida();
            if(codPAD==0){
                vpm.nivel_I.setValue(1);
                vpm.orden_I.setValue(new Partida_MezclaDAO().asignarOrden("I",1,varCodCiaGlobalDeLogin));
                vpm.nivel_I.setEnabled(false);
                vpm.orden_I.setEnabled(false);
            }
        codPAD = ((PartidaAux)vpm.padCodPartida_E.getSelectedItem()).getCodPartida();
            if(codPAD==0){
                vpm.nivel_E.setValue(1);
                vpm.orden_E.setValue(new Partida_MezclaDAO().asignarOrden("E",1,varCodCiaGlobalDeLogin));
                vpm.nivel_E.setEnabled(false);
                vpm.orden_E.setEnabled(false);
            }
    }
    
    int codPAD;
    @Override
    public void itemStateChanged(ItemEvent e) {
       if(e.getSource()==vpm.padCodPartida_I && vpm.padCodPartida_I.getSelectedItem() != null){
            codPAD = ((PartidaAux)vpm.padCodPartida_I.getSelectedItem()).getCodPartida();
            if(codPAD==0){
                vpm.nivel_I.setValue(1);
                vpm.orden_I.setValue(new Partida_MezclaDAO().asignarOrden("I",1,varCodCiaGlobalDeLogin));
                vpm.nivel_I.setEnabled(false);
                vpm.orden_I.setEnabled(false);
            }
            else{
                vpm.nivel_I.setValue(new Partida_MezclaDAO().asignarNivelNoNULL("I", codPAD,varCodCiaGlobalDeLogin));
                vpm.orden_I.setValue(new Partida_MezclaDAO().asignarOrdenNoNULL("I", codPAD,varCodCiaGlobalDeLogin));
                vpm.nivel_I.setEnabled(false);
                vpm.orden_I.setEnabled(false);
            }
        }
        
       if(e.getSource()==vpm.padCodPartida_E && vpm.padCodPartida_E.getSelectedItem() != null){
            codPAD = ((PartidaAux)vpm.padCodPartida_E.getSelectedItem()).getCodPartida();
            if(codPAD==0){
                vpm.nivel_E.setValue(1);
                vpm.orden_E.setValue(new Partida_MezclaDAO().asignarOrden("E",1,varCodCiaGlobalDeLogin));
                vpm.nivel_E.setEnabled(false);
                vpm.orden_E.setEnabled(false);
            }
            else{
                vpm.nivel_E.setValue(new Partida_MezclaDAO().asignarNivelNoNULL("E", codPAD,varCodCiaGlobalDeLogin));
                vpm.orden_E.setValue(new Partida_MezclaDAO().asignarOrdenNoNULL("E", codPAD,varCodCiaGlobalDeLogin));
                vpm.nivel_E.setEnabled(false);
                vpm.orden_E.setEnabled(false);
            }
        }
    }
}