package Controlador.PresupuestoExterno;

import Modelo.DAO.ElementosDAO;
import Modelo.DAO.TabsDAO;
import Modelo.DAO.PresupuestoExterno.PPartidaDAO;
import Modelo.Elementos;
import Modelo.Message.Mensaje1;
import Modelo.Message.Mensaje2;
import Modelo.Partida;
import Modelo.Tabs;
import static Vistas.V_Login.varCodCiaGlobalDeLogin;
import Vistas.PresupuestoExterno.PV_Partida;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AbstractDocument;

import Controlador.LimitDocumentFilter;

public class PC_Partida implements ItemListener,ActionListener, KeyListener, MouseListener{
    
    PPartidaDAO pDAO = new PPartidaDAO();
    PV_Partida vp = new PV_Partida();
    DefaultTableModel modelPartidaI = new DefaultTableModel();
    DefaultTableModel modelPartidaE = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> sorterI;
    TableRowSorter<DefaultTableModel> sorterE;
    int id=-1;
    
    public PC_Partida(PV_Partida vp){
        this.vp=vp;
        this.vp.btt_Actualizar_I.addActionListener(this);
        this.vp.btt_Registrar_I.addActionListener(this);
        this.vp.btt_Eliminar_I.addActionListener(this);
        this.vp.tablaPartida_I.addMouseListener(this);
        this.vp.tUniMed_I.addItemListener(this);
        this.vp.btt_Actualizar_E.addActionListener(this);
        this.vp.btt_Registrar_E.addActionListener(this);
        this.vp.btt_Eliminar_E.addActionListener(this);
        this.vp.tablaPartida_E.addMouseListener(this);
        this.vp.tUniMed_E.addItemListener(this);
        this.vp.actualizaTabla.addActionListener(this);
        this.vp.nuevo.addActionListener(this);
        init();
    }
    
    public void init(){
        initTablaPartida_I();
        initTablaPartida_E();
        vp.init();
        initListarTabs();
        ((AbstractDocument)vp.desPartida_I.getDocument()).setDocumentFilter(new LimitDocumentFilter(30,0));
        ((AbstractDocument)vp.desPartida_E.getDocument()).setDocumentFilter(new LimitDocumentFilter(30,0));
    }
    
     public void initListarTabs(){
        System.out.println("Tabs");
        vp.tUniMed_I.removeAllItems();
        vp.tUniMed_E.removeAllItems();
        List<Tabs> listaTab = new TabsDAO().listar();
        for(int i=0;i<listaTab.size();i++){
            vp.tUniMed_I.addItem(listaTab.get(i));
            vp.tUniMed_E.addItem(listaTab.get(i));
        }
    }
    
     public void initListarElementos(int cod, String tip){
        List<Elementos> listaEle = new ElementosDAO().listarTabs(cod);
        if (tip.equals("I")) {
            vp.eUniMed_I.removeAllItems();
            for (int i = 0; i < listaEle.size(); i++) {
                vp.eUniMed_I.addItem(listaEle.get(i));
            }
        } else {
            vp.eUniMed_E.removeAllItems();
            for (int i = 0; i < listaEle.size(); i++) {
                vp.eUniMed_E.addItem(listaEle.get(i));
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("DENTRO DE ACTION PARTIDA");
        if(e.getSource()==vp.btt_Registrar_I){
            registrarDatos("I");
            actualizarTabla();
        }
        if(e.getSource()==vp.btt_Actualizar_I){
            actualizarDatos("I");
            actualizarTabla();
        }
        if(e.getSource()==vp.btt_Eliminar_I){
            eliminarDatos("I");
            actualizarTabla();
        }
        if(e.getSource()==vp.btt_Registrar_E){
            registrarDatos("E");
            actualizarTabla();
        }
        if(e.getSource()==vp.btt_Actualizar_E){
            actualizarDatos("E");
            actualizarTabla();
        }
        if(e.getSource()==vp.btt_Eliminar_E){
            eliminarDatos("E");
            actualizarTabla();
        }
        if(e.getSource()==vp.actualizaTabla){
            actualizarTabla();
        }
        if(e.getSource()==vp.nuevo){
            vaciarCampos();
            actualizarTabla();
        }
    }
    
    public void actualizarTabla(){
        limpiarTabla(modelPartidaI);
        limpiarTabla(modelPartidaE);
        initTablaPartida_I();
        initTablaPartida_E();
        System.out.println("Refrescando tabla automaticamente.");
    }
    
    public void initTablaPartida_I(){
        List<Partida> listaI = pDAO.listarPorCodCia(varCodCiaGlobalDeLogin,"I");
        modelPartidaI = (DefaultTableModel)vp.tablaPartida_I.getModel();
        Object[] o=new Object[5];
        sorterI = new TableRowSorter<>(modelPartidaI);
        vp.tablaPartida_I.setRowSorter(sorterI);
        limpiarTabla(modelPartidaI);
        List<Tabs> tabsList = new TabsDAO().listar();
        List<Elementos> elementosList = new ElementosDAO().listar();
        for(int i=0;i<listaI.size();i++){
            o[0]=listaI.get(i).getCodPartida();
            o[1]=listaI.get(i).getCodPartidas();
            o[2]=listaI.get(i).getDesPartida();
            for(int j=0;j<tabsList.size();j++){
                if(tabsList.get(j).getCodTab().equals(listaI.get(i).gettUniMed())){
                    o[3]=tabsList.get(j);
                }
            }
            for(int j=0;j<elementosList.size();j++){
                if(elementosList.get(j).getCodElemento().equals(listaI.get(i).geteUniMed()) && elementosList.get(j).getCodTab().equals(listaI.get(i).gettUniMed()))
                {
                    o[4]=elementosList.get(j);
                }
            }
            modelPartidaI.addRow(o);
        }
        vp.tablaPartida_I.setModel(modelPartidaI);
    }
    

    //HashMap<String, List<E>> map = new HashMap<>();

    public void initTablaPartida_E(){
        List<Partida> listaE = pDAO.listarPorCodCia(varCodCiaGlobalDeLogin,"E");
        modelPartidaE = (DefaultTableModel)vp.tablaPartida_E.getModel();
        Object[] o=new Object[5];
        sorterE = new TableRowSorter<>(modelPartidaE);
        vp.tablaPartida_E.setRowSorter(sorterE);
        limpiarTabla(modelPartidaE);
        List<Tabs> tabsList = new TabsDAO().listar();
        List<Elementos> elementosList = new ElementosDAO().listar();

        for(int i=0;i<listaE.size();i++){
            o[0]=listaE.get(i).getCodPartida();
            o[1]=listaE.get(i).getCodPartidas();
            o[2]=listaE.get(i).getDesPartida();
            for(int j=0;j<tabsList.size();j++){
                if(tabsList.get(j).getCodTab().equals(listaE.get(i).gettUniMed())){
                    o[3]=tabsList.get(j);
                }
            }
            for(int j=0;j<elementosList.size();j++){
                if(elementosList.get(j).getCodElemento().equals(listaE.get(i).geteUniMed()) && elementosList.get(j).getCodTab().equals(listaE.get(i).gettUniMed())) {
                    o[4]=elementosList.get(j);
                }
            }
            modelPartidaE.addRow(o);
        }
        vp.tablaPartida_E.setModel(modelPartidaE);
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
        int fila,cod;
        if(e.getSource()==vp.tablaPartida_I){
            fila = vp.tablaPartida_I.getSelectedRow();
            cod = Integer.parseInt(vp.tablaPartida_I.getValueAt(fila,0).toString());
            System.out.println("PartidaMezcla = "+cod);
            Partida pI = new PPartidaDAO().listarId(varCodCiaGlobalDeLogin,cod,"I");
            vp.desPartida_I.setText(pI.getDesPartida());
            vp.tUniMed_I.setSelectedItem(vp.tablaPartida_I.getValueAt(fila,3));
            vp.eUniMed_I.setSelectedItem(vp.tablaPartida_I.getValueAt(fila,4));
        }
        
        if(e.getSource()==vp.tablaPartida_E){
            fila = vp.tablaPartida_E.getSelectedRow();
            cod = Integer.parseInt(vp.tablaPartida_E.getValueAt(fila,0).toString());
            System.out.println("PartidaMezcla = "+cod);
            Partida pE = new PPartidaDAO().listarId(varCodCiaGlobalDeLogin,cod,"E");
            vp.desPartida_E.setText(pE.getDesPartida());
            vp.tUniMed_E.setSelectedItem(vp.tablaPartida_E.getValueAt(fila,3));
            vp.eUniMed_E.setSelectedItem(vp.tablaPartida_E.getValueAt(fila,4));
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
        Partida pm = new Partida();
        if(tip == "I"){
            pm.setCodCia(varCodCiaGlobalDeLogin);
            pm.setIngEgr(tip);
            pm.settUniMed(((Tabs)vp.tUniMed_I.getSelectedItem()).getCodTab());
            pm.seteUniMed(((Elementos)vp.eUniMed_I.getSelectedItem()).getCodElemento());
            pm.setDesPartida(vp.desPartida_I.getText());
            pm.setVigente('1');
        }
        else{
            pm.setCodCia(varCodCiaGlobalDeLogin);
            pm.setIngEgr(tip);
            pm.settUniMed(((Tabs)vp.tUniMed_E.getSelectedItem()).getCodTab());
            pm.seteUniMed(((Elementos)vp.eUniMed_E.getSelectedItem()).getCodElemento());
            pm.setDesPartida(vp.desPartida_E.getText());
            pm.setVigente('1');
        }
        if(pDAO.add(pm)==1){
            showMessage2("Partida registrada correctamente");
            vaciarCampos();
        }else{
            showMessage1("Error al registrar Partida");
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
        int fila,cod;
        Partida pm = new Partida();
        if(tip == "I"){
            fila = vp.tablaPartida_I.getSelectedRow();
            if(fila!=-1){
                System.out.println("Hay filas seleccionadas.");
                cod = Integer.parseInt(vp.tablaPartida_I.getValueAt(fila,0).toString());
                pm.setCodCia(varCodCiaGlobalDeLogin);
                pm.setIngEgr(tip);
                pm.setCodPartida(cod);
                pm.setDesPartida(vp.desPartida_I.getText());
                pm.settUniMed(((Tabs)vp.tUniMed_I.getSelectedItem()).getCodTab());
                pm.seteUniMed(((Elementos)vp.eUniMed_I.getSelectedItem()).getCodElemento());
                pm.setVigente('1');
                if(pDAO.actualizar(pm)==1){
                    showMessage2("Partida registrado correctamente");
                    vaciarCampos();
                }else{
                    showMessage1("Error al registrar Partida");
                }
            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
        else{
            fila = vp.tablaPartida_E.getSelectedRow();
            if(fila!=-1){
                System.out.println("Hay filas seleccionadas.");
                cod = Integer.parseInt(vp.tablaPartida_E.getValueAt(fila,0).toString());
                pm.setCodCia(varCodCiaGlobalDeLogin);
                pm.setIngEgr(tip);
                pm.setCodPartida(cod);
                pm.setDesPartida(vp.desPartida_E.getText());
                pm.settUniMed(((Tabs)vp.tUniMed_E.getSelectedItem()).getCodTab());
                pm.seteUniMed(((Elementos)vp.eUniMed_E.getSelectedItem()).getCodElemento());
                pm.setVigente('1');
                if(pDAO.actualizar(pm)==1){
                    showMessage2("Partida registrado correctamente");
                    vaciarCampos();
                }else{
                    showMessage1("Error al registrar Partida");
                }
            }else{
                showMessage1("Debe seleccionar una fila");
            } 
        }
   } 
    
    public void eliminarDatos(String tip){
        int fila,cod;
        if(tip=="I"){
            fila = vp.tablaPartida_I.getSelectedRow();
            System.out.println("La fila es"+fila);
            if(fila!=-1){
                System.out.println("Hay filas seleccionadas.");
                cod = Integer.parseInt(vp.tablaPartida_I.getValueAt(fila,0).toString());
                new PPartidaDAO().eliminarDatos(varCodCiaGlobalDeLogin,cod,tip);
            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
        else{
            fila = vp.tablaPartida_E.getSelectedRow();
            System.out.println("La fila es"+fila);
            if(fila!=-1){
                System.out.println("Hay filas seleccionadas.");
                cod = Integer.parseInt(vp.tablaPartida_E.getValueAt(fila,0).toString());
                new PPartidaDAO().eliminarDatos(varCodCiaGlobalDeLogin,cod,tip);
            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
    }
    
    public void vaciarCampos(){
        vp.desPartida_E.setText("");
        vp.desPartida_I.setText("");
    }
    
    int codT;
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==vp.tUniMed_I){
            Tabs t = (Tabs)vp.tUniMed_I.getSelectedItem();
            codT = Integer.parseInt(t.getCodTab());
            initListarElementos(codT, "I");
        }
        
        if(e.getSource()==vp.tUniMed_E){
            Tabs t = (Tabs)vp.tUniMed_E.getSelectedItem();
            codT = Integer.parseInt(t.getCodTab());
            initListarElementos(codT, "E");
        }
    }
}