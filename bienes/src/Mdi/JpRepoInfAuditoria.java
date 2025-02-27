/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mdi;

import Negocio.Auditoria;
import Negocio.Bien;
import Negocio.Usuario;
import Persistencia.AuditoriaJpaController;
import Persistencia.BienJpaController;
import Persistencia.UsuarioJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class JpRepoInfAuditoria extends javax.swing.JPanel {

    /**
     * Creates new form JpRepoInfAuditoria
     */
    MainMdi parent;
    AuditoriaJpaController dao = new AuditoriaJpaController();
    List<Auditoria> registros = new ArrayList();
    DefaultTableModel modelo = new DefaultTableModel();
    Integer tipoBusqueda = 1;
    
    private Usuario user;
    public JpRepoInfAuditoria() {
        initComponents();
        this.colocarEncabezadoGrid();
    }
    
    public final void colocarEncabezadoGrid(){
        String[] columnNames = {"Fecha",
                                "Bien",
                                "Operacion",
                                "Usuario"};
        this.modelo.setColumnIdentifiers(columnNames);
        this.tblRegistros.setModel(this.modelo);
    }
    
    public void registrosPorBien(Bien unBien){
        this.registros = dao.findAuditoriaByBien(unBien);
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
    
    public void registrosPorUsuario(Usuario usuario){
        this.registros = dao.findAuditoriaByUsuario(usuario);
    }
    public void registros(){
        this.registros = dao.findAuditoriaEntities();
    }
    
    public void buscarPorBien(){
        this.registrosPorBien(this.obtenerBien());
        if(this.registros.isEmpty()){
            showNoResults("Registros");
        }else{
            cargarGrid();
        }
    }
    
    public void buscarPorUsuario(){
        this.registrosPorUsuario(this.obtenerUsuario());
                if(this.registros.isEmpty()){
            showNoResults("Registros");
        }else{
            cargarGrid();
        }
    }
    
    public Bien obtenerBien(){
        Bien salida = null;
        BienJpaController daoBien = new BienJpaController();
        Integer nro = Integer.parseInt(this.txtBusqueda.getText());
        //List<Bien> bienes = daoBien.findBienByNroInventario(nro);
        List<Bien> bienes = daoBien.findBienByNroInventario(nro);
        
        if(bienes.size() > 0){
            salida = bienes.get(0);
        }
        return salida;
    }
    
    public Usuario obtenerUsuario(){
        UsuarioJpaController daoUser = new UsuarioJpaController();
        String userName = this.txtBusqueda.getText();
        Usuario salida  = daoUser.findUsuarioByUserName(userName);
        return salida;        
    }
    
    private void showNoResults(String campo) {
        JOptionPane.showMessageDialog(this,
            "No se encontraron bienes activos con ese " + campo,        
            "Algo salió mal",                        
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void buscarRegistros(){
        this.registros();
        
        if(this.registros.isEmpty()){
            showNoResults("Registros");
        }else{
            cargarGrid();
        }
    }
    
     public final void cargarGrid(){
       // Inventario inv = new Inventario();
        int cantregistros = this.registros.size();
        int COLS = 4;
        Object[][] data = new Object[cantregistros][COLS];
        int rowIndex = 0;
        
        for (Auditoria auditoria : this.registros) {
            data[rowIndex][0] = auditoria.getFecha();
            data[rowIndex][1] = auditoria.getBien();
            data[rowIndex][2] = auditoria.getOperacion();
            data[rowIndex][3] = auditoria.getUsuario();  
                    
            modelo.addRow(data[rowIndex]);
            rowIndex = rowIndex + 1;
        }
        this.tblRegistros.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opciones = new javax.swing.ButtonGroup();
        txtBusqueda = new javax.swing.JTextField();
        btnBien = new javax.swing.JRadioButton();
        btnUser = new javax.swing.JRadioButton();
        btnTodo = new javax.swing.JRadioButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();

        opciones.add(btnBien);
        btnBien.setText("Bien");
        btnBien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBienActionPerformed(evt);
            }
        });

        opciones.add(btnUser);
        btnUser.setText("Usuario");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        opciones.add(btnTodo);
        btnTodo.setSelected(true);
        btnTodo.setText("Todo");
        btnTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodoActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Bien", "Operacion", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRegistros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                        .addComponent(btnBuscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBien)
                    .addComponent(btnUser)
                    .addComponent(btnTodo)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBienActionPerformed
        // TODO add your handling code here:
        this.tipoBusqueda = 2;
    }//GEN-LAST:event_btnBienActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        switch(this.tipoBusqueda){
            case 1:
                this.buscarRegistros();
                break;
            case 2:
                this.buscarPorBien();
                break;
            case 3:
                this.buscarPorUsuario();
                break;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
        this.tipoBusqueda = 3;
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodoActionPerformed
        // TODO add your handling code here:
        this.tipoBusqueda = 1;
    }//GEN-LAST:event_btnTodoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnBien;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JRadioButton btnTodo;
    private javax.swing.JRadioButton btnUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup opciones;
    private javax.swing.JTable tblRegistros;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
