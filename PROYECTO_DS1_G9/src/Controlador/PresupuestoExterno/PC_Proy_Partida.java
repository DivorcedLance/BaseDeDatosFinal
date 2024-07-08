package Controlador.PresupuestoExterno;

import Modelo.DAO.ProyectoDAO;
import Modelo.DAO.PresupuestoExterno.*;
import Modelo.Message.Mensaje1;
import Modelo.Message.Mensaje2;
import Vistas.PresupuestoExterno.PV_Proy_Partida;
import Modelo.Partida;
import Modelo.Proy_Partida;
import Modelo.Proyecto;
import Modelo.Auxiliares.PartidaAux;
import Modelo.Auxiliares.ProyectoAux;

import static Vistas.V_Login.varCodCiaGlobalDeLogin;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PC_Proy_Partida implements ActionListener, KeyListener, MouseListener{
    
    PProy_PartidaDAO ppDAO = new PProy_PartidaDAO();
    PV_Proy_Partida vpp = new PV_Proy_Partida();
    DefaultTableModel modelProy_PartidaI = new DefaultTableModel();
    DefaultTableModel modelProy_PartidaE = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> sorterI;
    TableRowSorter<DefaultTableModel> sorterE;
    
    public PC_Proy_Partida(PV_Proy_Partida vpp){
        this.vpp=vpp;
        this.vpp.btt_Registrar_I.addActionListener(this);
        this.vpp.btt_Eliminar_I.addActionListener(this);
        this.vpp.tablaProy_Partida_I.addMouseListener(this);
        this.vpp.btt_Registrar_E.addActionListener(this);
        this.vpp.btt_Eliminar_E.addActionListener(this);
        this.vpp.tablaProy_Partida_E.addMouseListener(this);
        this.vpp.actualizaTabla.addActionListener(this);
        this.vpp.nuevo.addActionListener(this);
        init();
    }
    
    public void init(){
        initTablaProy_Partida_I();
        initTablaProy_Partida_E();
        vpp.init();
        initListarPartidas();
        initListarProyectos();
    }
    
    public void initListarProyectos(){
        vpp.codPyto_I.removeAllItems();
        List<Proyecto> lista = new ProyectoDAO().listarPorCodCia(varCodCiaGlobalDeLogin);
        for(int i=0;i<lista.size();i++){
            Proyecto p = lista.get(i);
            ProyectoAux pa = new ProyectoAux(p.getCodPyto(),p.getNomPyto());
            vpp.codPyto_I.addItem(pa);
            vpp.codPyto_E.addItem(pa);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("DENTRO DE ACTION PARTIDA");
        if(e.getSource()==vpp.btt_Registrar_I){
            registrarDatos("I");
            actualizarTabla();
        }
        if(e.getSource()==vpp.btt_Eliminar_I){
            eliminarDatos("I");
            actualizarTabla();
        }
        if(e.getSource()==vpp.btt_Registrar_E){
            registrarDatos("E");
            actualizarTabla();
        }
        if(e.getSource()==vpp.btt_Eliminar_E){
            eliminarDatos("E");
            actualizarTabla();
        }
        if(e.getSource()==vpp.actualizaTabla){
            actualizarTabla();
        }
        if(e.getSource()==vpp.nuevo){
            actualizarTabla();
        }
    }
    
    public void initListarPartidas(){
        vpp.codPartida_I.removeAllItems();
        List<Partida> listaParI = new PPartidaDAO().listarPorCodCia(varCodCiaGlobalDeLogin,"I");
        for(int i=0;i<listaParI.size();i++){
            Partida p = listaParI.get(i);
            PartidaAux pa = new PartidaAux(p.getCodPartida(),p.getIngEgr(), p.getDesPartida());
            pa.setCodPartidas(p.getCodPartidas());
            vpp.codPartida_I.addItem(pa);
        }

        vpp.codPartida_E.removeAllItems();
        List<Partida> listaParE = new PPartidaDAO().listarPorCodCia(varCodCiaGlobalDeLogin,"E");
        for(int i=0;i<listaParE.size();i++){
            Partida p = listaParE.get(i);
            PartidaAux pa = new PartidaAux(p.getCodPartida(),p.getIngEgr(), p.getDesPartida());
            pa.setCodPartidas(p.getCodPartidas());
            vpp.codPartida_E.addItem(pa);
        }
    }
    
    public void actualizarTabla(){
        limpiarTabla(modelProy_PartidaI);
        limpiarTabla(modelProy_PartidaE);
        initTablaProy_Partida_I();
        initTablaProy_Partida_E();
        System.out.println("Refrescando tabla automaticamente.");
    }
    
    public void initTablaProy_Partida_I(){
        @SuppressWarnings("rawtypes")
        List listaI = new PProy_PartidaDAO().getv_proy_partida(varCodCiaGlobalDeLogin, "I");
        @SuppressWarnings("unchecked")
        List<Proy_Partida> listaProyPartidas = (List<Proy_Partida>) listaI.get(0);
        @SuppressWarnings("unchecked")
        List<ProyectoAux> listaProyectos = (List<ProyectoAux>) listaI.get(1);
        @SuppressWarnings("unchecked")
        List<PartidaAux> listaPartidas = (List<PartidaAux>) listaI.get(2);

        modelProy_PartidaI = (DefaultTableModel)vpp.tablaProy_Partida_I.getModel();
        Object[] o=new Object[2];
        sorterI = new TableRowSorter<>(modelProy_PartidaI);
        vpp.tablaProy_Partida_I.setRowSorter(sorterI);
        limpiarTabla(modelProy_PartidaI);

        System.out.println("Tamaño de listaProyPartidas: "+listaProyPartidas.size());

        for(int i=0;i<listaProyPartidas.size();i++){
            o[0]=listaProyectos.get(i);
            o[1]=listaPartidas.get(i);

            System.out.println("Proyecto: "+listaProyectos.get(i).getNomPyto());

            modelProy_PartidaI.addRow(o);

        }
        vpp.tablaProy_Partida_I.setModel(modelProy_PartidaI);
    }
    
    public void initTablaProy_Partida_E(){
            @SuppressWarnings("rawtypes")
            List listaE = new PProy_PartidaDAO().getv_proy_partida(varCodCiaGlobalDeLogin, "E");
            @SuppressWarnings("unchecked")
            List<Proy_Partida> listaProyPartidas = (List<Proy_Partida>) listaE.get(0);
            @SuppressWarnings("unchecked")
            List<ProyectoAux> listaProyectos = (List<ProyectoAux>) listaE.get(1);
            @SuppressWarnings("unchecked")
            List<PartidaAux> listaPartidas = (List<PartidaAux>) listaE.get(2);
    
            modelProy_PartidaE = (DefaultTableModel)vpp.tablaProy_Partida_E.getModel();
            Object[] o=new Object[2];
            sorterE = new TableRowSorter<>(modelProy_PartidaE);
            vpp.tablaProy_Partida_E.setRowSorter(sorterE);
            limpiarTabla(modelProy_PartidaE);
            for(int i=0;i<listaProyPartidas.size();i++){
                o[0]=listaProyectos.get(i);
                o[1]=listaPartidas.get(i);
    
                modelProy_PartidaE.addRow(o);
    
            }
            vpp.tablaProy_Partida_E.setModel(modelProy_PartidaE);
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
        if(e.getSource()==vpp.tablaProy_Partida_I){
            fila = vpp.tablaProy_Partida_I.getSelectedRow();
            vpp.codPyto_I.setSelectedItem((ProyectoAux)vpp.tablaProy_Partida_I.getValueAt(fila,0));
            vpp.codPartida_I.setSelectedItem((PartidaAux)vpp.tablaProy_Partida_I.getValueAt(fila,1));
        }
        
        if(e.getSource()==vpp.tablaProy_Partida_E){
            fila = vpp.tablaProy_Partida_E.getSelectedRow();
            vpp.codPyto_E.setSelectedItem((ProyectoAux)vpp.tablaProy_Partida_E.getValueAt(fila,0));
            vpp.codPartida_E.setSelectedItem((PartidaAux)vpp.tablaProy_Partida_E.getValueAt(fila,1));
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
        Proy_Partida pm = new Proy_Partida();
        if(tip == "I"){
            pm.setCodCia(varCodCiaGlobalDeLogin);
            pm.setIngEgr(tip);
            pm.setCodPyto(((ProyectoAux)vpp.codPyto_I.getSelectedItem()).getCodPyto());
            pm.setCodPartida(((PartidaAux)vpp.codPartida_I.getSelectedItem()).getCodPartida());
            pm.setNroVersion(1);
            pm.setTabEstado("-1");
            pm.setCodEstado("1");
            pm.setCodPartidas(((PartidaAux)vpp.codPartida_I.getSelectedItem()).getCodPartidas());
            pm.setVigente('1');
        } else{
            pm.setCodCia(varCodCiaGlobalDeLogin);
            pm.setIngEgr(tip);
            pm.setCodPyto(((ProyectoAux)vpp.codPyto_E.getSelectedItem()).getCodPyto());
            pm.setCodPartida(((PartidaAux)vpp.codPartida_E.getSelectedItem()).getCodPartida());
            pm.setNroVersion(1);
            pm.setTabEstado("-1");
            pm.setCodEstado("1");
            pm.setCodPartidas(((PartidaAux)vpp.codPartida_E.getSelectedItem()).getCodPartidas());
            pm.setVigente('1');
        }
        if(ppDAO.add(pm)==1){
            showMessage2("Proy_Partida registrado correctamente");
        }else{
            showMessage1("Error al registrar Proy_Partida");
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
        int fila,pyto,cod;
        Proy_Partida pm = new Proy_Partida();
        if(tip == "I"){
            fila = vpp.tablaProy_Partida_I.getSelectedRow();
            if(fila!=-1){
                System.out.println("Hay filas seleccionadas.");
                pyto = ((ProyectoAux)vpp.tablaProy_Partida_I.getValueAt(fila,0)).getCodPyto();
                cod = ((PartidaAux)vpp.tablaProy_Partida_I.getValueAt(fila,1)).getCodPartida();
                pm.setCodCia(varCodCiaGlobalDeLogin);
                pm.setIngEgr(tip);
                pm.setCodPartida(cod);
                pm.setCodPyto(pyto);
                pm.setNroVersion(1);
                if(ppDAO.actualizar(pm)==1){
                    showMessage2("Proy_Partida registrado correctamente");
                }else{
                    showMessage1("Error al registrar Proy_Partida");
                }
            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
        else{
            fila = vpp.tablaProy_Partida_E.getSelectedRow();
            if(fila!=-1){
                System.out.println("Hay filas seleccionadas.");
                pyto = ((ProyectoAux)vpp.tablaProy_Partida_E.getValueAt(fila,0)).getCodPyto();
                cod = ((PartidaAux)vpp.tablaProy_Partida_E.getValueAt(fila,1)).getCodPartida();
                pm.setCodCia(varCodCiaGlobalDeLogin);
                pm.setIngEgr(tip);
                pm.setCodPartida(cod);
                pm.setCodPyto(pyto);
                pm.setNroVersion(1);
                if(ppDAO.actualizar(pm)==1){
                    showMessage2("Proy_Partida registrado correctamente");
                }else{
                    showMessage1("Error al registrar Proy_Partida");
                }
            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
    }
    
    public void eliminarDatos(String tip){
        int fila,cod,pyto;
        if(tip=="I"){
            fila = vpp.tablaProy_Partida_I.getSelectedRow();
            System.out.println("La fila es"+fila);
            if(fila!=-1){
                System.out.println("Hay filas seleccionadas.");
                pyto = ((ProyectoAux)vpp.tablaProy_Partida_I.getValueAt(fila,0)).getCodPyto();
                cod = ((PartidaAux)vpp.tablaProy_Partida_I.getValueAt(fila,1)).getCodPartida();
                ppDAO.eliminarDatos(varCodCiaGlobalDeLogin,cod,tip,pyto,1);
            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
        else{
            fila = vpp.tablaProy_Partida_E.getSelectedRow();
            System.out.println("La fila es"+fila);
            if(fila!=-1){
                System.out.println("Hay filas seleccionadas.");
                pyto = ((ProyectoAux)vpp.tablaProy_Partida_E.getValueAt(fila,0)).getCodPyto();
                cod = ((PartidaAux)vpp.tablaProy_Partida_E.getValueAt(fila,1)).getCodPartida();
                ppDAO.eliminarDatos(varCodCiaGlobalDeLogin,cod,tip,pyto,1);
            }else{
                showMessage1("Debe seleccionar una fila");
            }
        }
    }
}