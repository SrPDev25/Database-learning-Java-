/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import dataBaseControl.Conexion;
import dataBaseControl.OperacionesDAO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Producto;

/**
 *
 * @author dam
 */
public class PanelProductoConsulta extends javax.swing.JPanel {
    
    Conexion bd;
    OperacionesDAO operaciones;
    DefaultTableModel modeloTabla;
    DefaultComboBoxModel modeloCombo;
    
    public PanelProductoConsulta(Conexion bd) {
        initComponents();
        this.bd = bd;
        
        operaciones = new OperacionesDAO(bd);
        modeloTabla = new DefaultTableModel();
        modeloCombo = new DefaultComboBoxModel();
        tblProductos.setModel(modeloTabla);
        comboCategorias.setModel(modeloCombo);
        modeloTabla.setColumnIdentifiers(new String[]{"Codigo", "Denominacion", "Categoria"});
        cargarCategorias();
        tblProductos.getTableHeader().setReorderingAllowed(false);
    }
    
    private void cargarCategorias() {
        ArrayList<Categoria> categorias = operaciones.getCategorias();
        modeloCombo.addElement("Todas las categorias");
        modeloCombo.addAll(categorias);
    }
    
    private void cargarProductos() {
        ArrayList<Producto> categorias = operaciones.getProductos();
        
        for (Producto i : categorias) {
            Vector v = new Vector();
            v.add(i.getCodigo());
            v.add(i.getDenominacion());
            v.add(i.getCodigo_categoria());
            modeloTabla.addRow(v);
        }
        
    }
    
    private void cargarProductos(int categoria) {
        ArrayList<Producto> categorias = operaciones.getProductos(categoria);
        
        for (Producto i : categorias) {
            Vector v = new Vector();
            v.add(i.getCodigo());
            v.add(i.getDenominacion());
            v.add(i.getCodigo_categoria());
            modeloTabla.addRow(v);
        }
        
    }
    
    private void cleanTable(){
        while(tblProductos.getRowCount()!=0){
            modeloTabla.removeRow(0);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        comboCategorias = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel1.setText("Consulta");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProductos.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblProductos);

        comboCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriasActionPerformed
        cleanTable();
        int pos=comboCategorias.getSelectedIndex();
        
        if (pos!=0) {
            Categoria categoria=(Categoria)modeloCombo.getElementAt(pos);
            cargarProductos(categoria.getCodigo());
        }else{
            cargarProductos();
        }
    }//GEN-LAST:event_comboCategoriasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}
