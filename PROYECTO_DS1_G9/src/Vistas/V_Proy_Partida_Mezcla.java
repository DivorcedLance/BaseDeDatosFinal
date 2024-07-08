package Vistas;

import javax.swing.SpinnerNumberModel;

import Modelo.Auxiliares.PartidaAux;
import Modelo.Auxiliares.ProyectoAux;

public class V_Proy_Partida_Mezcla extends javax.swing.JPanel {

    public V_Proy_Partida_Mezcla() {
        initComponents();
        setOpaque(false);
    }
    
    public void init(){
        tablaProy_Partida_Mezcla_E.fixTable(jScrollPane1);
        tablaProy_Partida_Mezcla_I.fixTable(jScrollPane2);
        
        cantidad_I.setModel(new SpinnerNumberModel(1,1,999,1));
        
        cantidad_E.setModel(new SpinnerNumberModel(1,1,999,1));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenuIng = new javax.swing.JPopupMenu();
        actualizaTablaIng = new javax.swing.JMenuItem();
        generaArbolIng = new javax.swing.JMenuItem();
        nuevoIng = new javax.swing.JMenuItem();
        popupMenuEgr = new javax.swing.JPopupMenu();
        actualizaTablaEgr = new javax.swing.JMenuItem();
        generaArbolEgr = new javax.swing.JMenuItem();
        nuevoEgr = new javax.swing.JMenuItem();
        materialTabbed1 = new Modelo.Design.MaterialTabbed();
        jPanel1 = new javax.swing.JPanel();
        panelBackground3 = new Modelo.Design.PanelBackground();
        jLabel2 = new javax.swing.JLabel();
        panelShadow5 = new Modelo.Design.PanelShadow();
        padCodPartida_I = new Modelo.Design.Combobox();
        proyecto_I = new Modelo.Design.Combobox();
        jLabel4 = new javax.swing.JLabel();
        cantidad_I = new javax.swing.JSpinner();
        btt_Actualizar_I = new Modelo.Design.Button();
        panelShadow3 = new Modelo.Design.PanelShadow();
        btt_Registrar_I = new Modelo.Design.Button();
        btt_Eliminar_I = new Modelo.Design.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProy_Partida_Mezcla_I = new Modelo.DesignTable.Tabla();
        btnExcelI = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panelBackground2 = new Modelo.Design.PanelBackground();
        jLabel1 = new javax.swing.JLabel();
        panelShadow4 = new Modelo.Design.PanelShadow();
        proyecto_E = new Modelo.Design.Combobox();
        padCodPartida_E = new Modelo.Design.Combobox();
        jLabel9 = new javax.swing.JLabel();
        cantidad_E = new javax.swing.JSpinner();
        btt_Actualizar_E = new Modelo.Design.Button();
        panelShadow2 = new Modelo.Design.PanelShadow();
        btt_Registrar_E = new Modelo.Design.Button();
        btt_Eliminar_E = new Modelo.Design.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProy_Partida_Mezcla_E = new Modelo.DesignTable.Tabla();
        btnExcelE = new javax.swing.JButton();

        actualizaTablaIng.setText("Actualizar Tabla");
        popupMenuIng.add(actualizaTablaIng);

        generaArbolIng.setText("Generar árbol");
        popupMenuIng.add(generaArbolIng);

        nuevoIng.setText("Nuevo");
        popupMenuIng.add(nuevoIng);

        actualizaTablaEgr.setText("Actualizar Tabla");
        popupMenuEgr.add(actualizaTablaEgr);

        generaArbolEgr.setText("Generar árbol");
        generaArbolEgr.setToolTipText("");
        popupMenuEgr.add(generaArbolEgr);

        nuevoEgr.setText("Nuevo");
        popupMenuEgr.add(nuevoEgr);

        materialTabbed1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setOpaque(false);

        panelBackground3.setBackground(new java.awt.Color(54, 87, 185));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATOS DE SOBRE LOS PROYECTOS ASOCIADOS A LAS MEZCLAS DE LAS PARTIDAS INGRESO");

        javax.swing.GroupLayout panelBackground3Layout = new javax.swing.GroupLayout(panelBackground3);
        panelBackground3.setLayout(panelBackground3Layout);
        panelBackground3Layout.setHorizontalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBackground3Layout.setVerticalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        padCodPartida_I.setLabeText("Partida Padre: ");

        proyecto_I.setLabeText("Proyecto:");

        jLabel4.setText("Cantidad");

        btt_Actualizar_I.setBackground(new java.awt.Color(240, 240, 240));
        btt_Actualizar_I.setText("Actualizar");

        javax.swing.GroupLayout panelShadow5Layout = new javax.swing.GroupLayout(panelShadow5);
        panelShadow5.setLayout(panelShadow5Layout);
        panelShadow5Layout.setHorizontalGroup(
            panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(proyecto_I, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(padCodPartida_I, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cantidad_I, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btt_Actualizar_I, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        panelShadow5Layout.setVerticalGroup(
            panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cantidad_I, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btt_Actualizar_I, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(proyecto_I, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(padCodPartida_I, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        btt_Registrar_I.setBackground(new java.awt.Color(240, 240, 240));
        btt_Registrar_I.setText("Registrar");

        btt_Eliminar_I.setBackground(new java.awt.Color(240, 240, 240));
        btt_Eliminar_I.setText("Eliminar");

        tablaProy_Partida_Mezcla_I.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Proyecto", "Código Mezcla", "Hija", "Padre", "Nivel", "Orden", "Tabs", "Elementos", "Costo Unitario", "Cantidad", "Costo Total"
            }
        ));
        tablaProy_Partida_Mezcla_I.setComponentPopupMenu(popupMenuIng);
        jScrollPane2.setViewportView(tablaProy_Partida_Mezcla_I);

        btnExcelI.setText("Excel");

        javax.swing.GroupLayout panelShadow3Layout = new javax.swing.GroupLayout(panelShadow3);
        panelShadow3.setLayout(panelShadow3Layout);
        panelShadow3Layout.setHorizontalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addComponent(btnExcelI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btt_Registrar_I, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btt_Eliminar_I, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        panelShadow3Layout.setVerticalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btt_Registrar_I, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btt_Eliminar_I, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnExcelI)))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelShadow5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBackground3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelShadow3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBackground3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        materialTabbed1.addTab("INGRESO", jPanel1);

        jPanel2.setOpaque(false);

        panelBackground2.setBackground(new java.awt.Color(54, 87, 185));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATOS DE SOBRE LOS PROYECTOS ASOCIADOS A LAS MEZCLAS DE LAS PARTIDAS EGRESO");

        javax.swing.GroupLayout panelBackground2Layout = new javax.swing.GroupLayout(panelBackground2);
        panelBackground2.setLayout(panelBackground2Layout);
        panelBackground2Layout.setHorizontalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBackground2Layout.setVerticalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        proyecto_E.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ingreso", "Egreso" }));
        proyecto_E.setSelectedIndex(-1);
        proyecto_E.setLabeText("Proyecto:");

        padCodPartida_E.setLabeText("Partida Padre: ");

        jLabel9.setText("Cantidad");

        btt_Actualizar_E.setBackground(new java.awt.Color(240, 240, 240));
        btt_Actualizar_E.setText("Actualizar");

        javax.swing.GroupLayout panelShadow4Layout = new javax.swing.GroupLayout(panelShadow4);
        panelShadow4.setLayout(panelShadow4Layout);
        panelShadow4Layout.setHorizontalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(proyecto_E, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(padCodPartida_E, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 325, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(cantidad_E, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btt_Actualizar_E, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        panelShadow4Layout.setVerticalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proyecto_E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(padCodPartida_E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cantidad_E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btt_Actualizar_E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        btt_Registrar_E.setBackground(new java.awt.Color(240, 240, 240));
        btt_Registrar_E.setText("Registrar");

        btt_Eliminar_E.setBackground(new java.awt.Color(240, 240, 240));
        btt_Eliminar_E.setText("Eliminar");

        tablaProy_Partida_Mezcla_E.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Proyecto", "Código Mezcla", "Hija", "Padre", "Nivel", "Orden", "Tabs", "Elementos", "Costo Unitario", "Cantidad", "Costo Total"
            }
        ));
        tablaProy_Partida_Mezcla_E.setComponentPopupMenu(popupMenuEgr);
        jScrollPane1.setViewportView(tablaProy_Partida_Mezcla_E);

        btnExcelE.setText("Excel");

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addComponent(btnExcelE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btt_Registrar_E, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btt_Eliminar_E, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btt_Registrar_E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btt_Eliminar_E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnExcelE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBackground2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelShadow4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBackground2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        materialTabbed1.addTab("EGRESO", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1016, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem actualizaTablaEgr;
    public javax.swing.JMenuItem actualizaTablaIng;
    public javax.swing.JButton btnExcelE;
    public javax.swing.JButton btnExcelI;
    public Modelo.Design.Button btt_Actualizar_E;
    public Modelo.Design.Button btt_Actualizar_I;
    public Modelo.Design.Button btt_Eliminar_E;
    public Modelo.Design.Button btt_Eliminar_I;
    public Modelo.Design.Button btt_Registrar_E;
    public Modelo.Design.Button btt_Registrar_I;
    public javax.swing.JSpinner cantidad_E;
    public javax.swing.JSpinner cantidad_I;
    public javax.swing.JMenuItem generaArbolEgr;
    public javax.swing.JMenuItem generaArbolIng;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Modelo.Design.MaterialTabbed materialTabbed1;
    public javax.swing.JMenuItem nuevoEgr;
    public javax.swing.JMenuItem nuevoIng;
    public Modelo.Design.Combobox padCodPartida_E;
    public Modelo.Design.Combobox padCodPartida_I;
    private Modelo.Design.PanelBackground panelBackground2;
    private Modelo.Design.PanelBackground panelBackground3;
    private Modelo.Design.PanelShadow panelShadow2;
    private Modelo.Design.PanelShadow panelShadow3;
    private Modelo.Design.PanelShadow panelShadow4;
    private Modelo.Design.PanelShadow panelShadow5;
    public javax.swing.JPopupMenu popupMenuEgr;
    public javax.swing.JPopupMenu popupMenuIng;
    public Modelo.Design.Combobox proyecto_E;
    public Modelo.Design.Combobox proyecto_I;
    public Modelo.DesignTable.Tabla tablaProy_Partida_Mezcla_E;
    public Modelo.DesignTable.Tabla tablaProy_Partida_Mezcla_I;
    // End of variables declaration//GEN-END:variables
}
