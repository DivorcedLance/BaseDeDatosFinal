package Vistas;

import Modelo.DAO.ClienteDAO;
import Modelo.DAO.CompPagoCabDAO;
import Modelo.DAO.VtaComp_PagoCabDAO;
import Modelo.ModeloTarjeta;
import Modelo.ItemChart.ModelChart;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class V_Inicio extends javax.swing.JPanel {

    public V_Inicio() {
        initComponents();
        setOpaque(false);
        init();
    }
    
    public void init(){
        initGraficoBarras();
        chart.start();
        initTarjetaDatos();
    }
    
    public void initGraficoBarras(){
        chart.addLegend("Nuevos Usuarios", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Ventas", new Color(54, 4, 143), new Color(104, 49, 200));
        chart.addLegend("Ganancias", new Color(5, 125, 0), new Color(95, 209, 69));
        chart.addLegend("Compras", new Color(186, 37, 37), new Color(241, 100, 120));
        chart.addData(new ModelChart("January", new double[]{100, 200, 80, 89}));
        chart.addData(new ModelChart("February", new double[]{100, 250, 90, 150}));
        chart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        chart.addData(new ModelChart("April", new double[]{280, 150, 750, 700}));
    }
    
    public void initTarjetaDatos(){
        Icon icon1 = new ImageIcon(getClass().getResource("/image/clienteT.png"));
        tarjeta1.setDatos(new ModeloTarjeta("Clientes", new ClienteDAO().contarClientes(), icon1));
        Icon icon2 = new ImageIcon(getClass().getResource("/image/ventaT.png"));
        tarjeta2.setDatos(new ModeloTarjeta("Ventas", new VtaComp_PagoCabDAO().contarVentas(), icon2));
        Icon icon3 = new ImageIcon(getClass().getResource("/image/productoT.png"));
        tarjeta3.setDatos(new ModeloTarjeta("Compras", new CompPagoCabDAO().contarCompras(), icon3));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tarjeta1 = new Modelo.Design.Tarjeta();
        tarjeta2 = new Modelo.Design.Tarjeta();
        tarjeta3 = new Modelo.Design.Tarjeta();
        panelShadow1 = new Modelo.Design.PanelShadow();
        chart = new Modelo.ItemChart.Chart();

        tarjeta1.setBackground(new java.awt.Color(60, 66, 102));
        tarjeta1.setColorGradient(new java.awt.Color(118, 120, 128));

        tarjeta2.setBackground(new java.awt.Color(60, 66, 102));
        tarjeta2.setColorGradient(new java.awt.Color(118, 120, 128));

        tarjeta3.setBackground(new java.awt.Color(60, 66, 102));
        tarjeta3.setColorGradient(new java.awt.Color(118, 120, 128));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tarjeta1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tarjeta2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tarjeta3, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tarjeta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tarjeta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tarjeta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Modelo.ItemChart.Chart chart;
    private Modelo.Design.PanelShadow panelShadow1;
    private Modelo.Design.Tarjeta tarjeta1;
    private Modelo.Design.Tarjeta tarjeta2;
    private Modelo.Design.Tarjeta tarjeta3;
    // End of variables declaration//GEN-END:variables
}
