package Presentacion;

import Negocio.Bien;
import Negocio.Usuario;
import Persistencia.BienJpaController;
import Persistencia.UsuarioJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import Utilidades.FechaHora;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class FrmBien extends javax.swing.JDialog {

    private final DefaultListModel modeloBienes = new DefaultListModel();
    private boolean nuevoBien;
    private Bien unBien;
    private final CtrlVista logica = new CtrlVista();
    private java.awt.Frame miparent;
    private BienJpaController dao = new BienJpaController();
    private Usuario user;
    
    public FrmBien(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        miparent = parent;
        fillBienesList();
        this.activarComponentes(false);
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public void inicializarUsuario(Usuario user){
        this.setUser(user);
    }
    
    
    
    private void fillBienesList() {
        modeloBienes.clear();
        List<Bien> bienes = dao.findBienEntities();
        for (Bien bien:bienes) {
            modeloBienes.addElement(bien);
        }
    }
    
    public void activarComponentes(boolean var ){
      this.activarBotonesRecorrida();  
      this.btnNuevo.setEnabled(true);
      this.btnSalir.setEnabled(true);
    }

    public final void habilitarTextos(boolean habilitar){
        this.txtCodigo.setEnabled(habilitar);
        this.txtDescripcion.setEnabled(habilitar);
        this.txtNroExpediente.setEnabled(habilitar);
        this.txtNroActa.setEnabled(habilitar);
        this.txtFechaAlta.setEnabled(habilitar);
        this.txtNrodeInventario.setEnabled(habilitar);
        this.txtResolucion.setEnabled(habilitar);
        this.txtValor.setEnabled(habilitar);        
    }
    public final void limpiarComponentes(){
        this.txtCodigo.setText(null);
        this.txtDescripcion.setText(null);
        this.txtNroExpediente.setText(null);
        this.txtNroActa.setText(null);
        this.txtFechaAlta.setText(null);
        this.txtNrodeInventario.setText(null);
        this.txtResolucion.setText(null);
        this.txtValor.setText(null);
        this.txtResolucionBaja.setText(null);
        this.txtFechaBaja.setText(null);
       
    }
    public final void activarBM(boolean activar){
        this.btnEliminar.setEnabled(activar);
        this.btbModificar.setEnabled(activar);      
        this.btnCancelar.setEnabled(activar);
        this.btnEliminar.setEnabled(activar);
        this.btnGuardar.setEnabled(activar);
        this.btnNuevo.setEnabled(!activar);
        this.btnSalir.setEnabled(!activar);
               
        this.activarBotonesRecorrida();
    }
    
    public final void activarBotonesRecorrida(){
        boolean var = false;
        if(this.modeloBienes.size() > 0){
            var = true;
        }     
    }
    
    public boolean camposRequeridos(){
        boolean salida = true;
        //if()
        
        
        return salida;
    }
    
    public final void seleccionarBien(){              
        this.completarTextos();        
    }
    public final void completarTextos(){
        if(this.unBien.getCodigo() != null){
            this.txtCodigo.setText(this.unBien.getCodigo());
        }
        
        if(this.unBien.getDescripcion() != null){
            this.txtDescripcion.setText(this.unBien.getDescripcion());
        }
        
        FechaHora fecha = new FechaHora();
        
        if(this.unBien.getNroActa() != null){
            this.txtNroActa.setText(this.unBien.getNroActa());
        }
        
        if(this.unBien.getNroExpedienteAlta() != null){
            this.txtNroExpediente.setText(this.unBien.getNroExpedienteAlta());
        }
        
        if(this.unBien.getFechaAlta() != null){
            this.txtFechaAlta.setText(fecha.DateToString(this.unBien.getFechaAlta()));
        }
        
        if(this.unBien.getNroInventario() != null){
            this.txtNrodeInventario.setText(this.unBien.getNroInventario().toString());
        }
        
        if(this.unBien.getResolucionAlta() != null){
            this.txtResolucion.setText(this.unBien.getResolucionAlta());
        }
        
        if(this.unBien.getValor() != null){
            this.txtValor.setText(this.unBien.getValor().toString());
        }
        /*BAJA*/
        if(this.unBien.getResolucionBaja() != null){
            this.txtResolucionBaja.setText(this.unBien.getResolucionBaja());
        }
        
        if(this.unBien.getFechaBaja() != null){
            this.txtFechaBaja.setText(fecha.DateToString(this.unBien.getFechaBaja()));
        }
        /**/
        
    }
    public final void activarBotonesSeleccion(){
            this.activarBM(true);
            this.btbModificar.setEnabled(true);
            this.btnCancelar.setEnabled(true);
            this.btnEliminar.setEnabled(true);
            this.btnGuardar.setEnabled(false);
            this.btnNuevo.setEnabled(false);
            this.btnSalir.setEnabled(true);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSubResponsable = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btbModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtResolucionBaja = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtFechaBaja = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNrodeInventario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNroActa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtResolucion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNroExpediente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtFechaAlta = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bienes");
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Responsable"));

        jLabel10.setText("Responsable");

        jLabel11.setText("Área");

        jLabel1.setText("Sub Responsable");

        txtSubResponsable.setName("txtSubResponsable"); // NOI18N

        txtArea.setName("txtArea"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtArea, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSubResponsable, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(1, 1, 1))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNuevo.setText("Nuevo");
        btnNuevo.setName("btnNuevo"); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btbModificar.setText("Modificar");
        btbModificar.setEnabled(false);
        btbModificar.setName("btnModificar"); // NOI18N
        btbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Baja");
        btnEliminar.setEnabled(false);
        btnEliminar.setName("btnEliminar"); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setEnabled(false);
        btnGuardar.setLabel("Guardar");
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.setName("btnSalir"); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jButton1.setText("Imprimir Etiqueta");
        jButton1.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btbModificar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Baja"));

        jLabel13.setText("Resolucion");

        txtResolucionBaja.setEnabled(false);

        jLabel12.setText("Fecha");

        txtFechaBaja.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtResolucionBaja, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(txtFechaBaja))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResolucionBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nro de Inventario");

        txtNrodeInventario.setName("txtNrodeInventario"); // NOI18N
        txtNrodeInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNrodeInventarioActionPerformed(evt);
            }
        });
        txtNrodeInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNrodeInventarioKeyPressed(evt);
            }
        });

        jLabel7.setText("Nro de Acta");

        txtNroActa.setEnabled(false);
        txtNroActa.setName("txtNroActa"); // NOI18N

        jLabel9.setText("Resolucion");

        txtResolucion.setEnabled(false);
        txtResolucion.setName("txtResolucion"); // NOI18N

        jLabel3.setText("Nomenclador");

        txtCodigo.setEnabled(false);
        txtCodigo.setName("txtCodigo"); // NOI18N

        jLabel6.setText("Valor");

        txtValor.setEnabled(false);
        txtValor.setName("txtValor"); // NOI18N

        jLabel5.setText("Fecha de Alta");

        jLabel8.setText("Nro de Expediente ");

        txtNroExpediente.setEnabled(false);
        txtNroExpediente.setName("txtNroExpediente"); // NOI18N

        txtDescripcion.setColumns(15);
        txtDescripcion.setRows(5);
        txtDescripcion.setEnabled(false);
        txtDescripcion.setName("txtDescripcion"); // NOI18N
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel4.setText("Descripcion");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        try {
            txtFechaAlta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaAlta.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNrodeInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtResolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNroActa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtFechaAlta, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNroExpediente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNrodeInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNroActa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNroExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
                if(this.btnGuardar.isEnabled()){
            int respuesta = JOptionPane.showConfirmDialog(null, "Está editando un Bien.\n¿Desea salir de todos modos?", "Confirmación", JOptionPane.YES_NO_OPTION);
            switch(respuesta) {
                case JOptionPane.YES_OPTION:
                    //--- Operaciones en caso afirmativo
                    this.dispose();
                    break;
            }            
        }else{
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if(this.btnGuardar.isEnabled()){
            int respuesta = JOptionPane.showConfirmDialog(null, "Está editando un Bien.\n¿Desea salir de todos modos?", "Confirmación", JOptionPane.YES_NO_OPTION);
            switch(respuesta) {
                case JOptionPane.YES_OPTION:
                    //--- Operaciones en caso afirmativo
                    this.dispose();
                    break;
            }            
        }else{
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.habilitarTextos(true);
        this.btbModificar.setEnabled(false);
        this.btnCancelar.setEnabled(true);
        this.btnEliminar.setEnabled(false);
        this.btnGuardar.setEnabled(true);
        this.btnNuevo.setEnabled(false);
        this.btnSalir.setEnabled(true);
        this.nuevoBien=true;
        this.limpiarComponentes();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        FrmBajaBien ventana = new FrmBajaBien(this.miparent  ,rootPaneCheckingEnabled);
        ventana.setBien(unBien);
        ventana.setUser(this.user);
        ventana.inicializar();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void modificarBien() {
       if(this.camposRequeridos()){
            try{
            Bien newBien = this.getBienFromForm();
            this.dao.update(newBien, this.unBien.getId(),this.getUser());
            fillBienesList();
            this.habilitarTextos(false);
            this.limpiarComponentes();        
            this.prepararBotones();  
            }
            catch (NonexistentEntityException e){
              JOptionPane.showMessageDialog(null, "No se puede guardar la infomación.\nDebe completar los datos requeridos.");  
            }
       } 
    }
    
    private void prepararBotones() {
        this.deshabilitarBotones();
        this.habilitarBotones();
    }
    
    private void habilitarBotones() {
        this.btnNuevo.setEnabled(true);
        this.btnSalir.setEnabled(true);
    }
    
    private void deshabilitarBotones() {
        this.btbModificar.setEnabled(false);
        this.btnCancelar.setEnabled(false);                    
        this.btnEliminar.setEnabled(false);
        this.btnGuardar.setEnabled(false);
    }

    private Bien getBienFromForm() {
        FechaHora fecha = new FechaHora();
        String code = txtCodigo.getText();
        Integer stockNumber = Integer.parseInt(txtNrodeInventario.getText()); 
        String description = txtDescripcion.getText(); 
        Date fechaAlta = fecha.StringToDate(txtFechaAlta.getText());
        String nroActa = txtNroActa.getText();
        BigDecimal valor = new BigDecimal(txtValor.getText());                    
        String nroExpedienteAlta = txtNroExpediente.getText();
        String resolucionAlta = txtResolucion.getText();
        
        return new Bien(code, stockNumber, description, fechaAlta, nroActa, valor, nroExpedienteAlta, resolucionAlta );
        
        
    }
    
    public void buscar(){
        // TODO add your handling code here:
        
        List<Bien> lista = this.dao.findBienByNroInventario(Integer.parseInt(this.txtNrodeInventario.getText()));
        this.limpiarComponentes();
        if(lista.size() > 0){
            this.unBien = lista.get(0);
            this.btbModificar.setEnabled(true);
            this.btnEliminar.setEnabled(true);
            //this.b
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro ningun bien con el nro ingresado.");
        }
        this.completarTextos();
    }
    
    private void crearBien() {
        if(this.camposRequeridos()){
            Bien bn = getBienFromForm();
            dao.create(bn,this.getUser());
            //logica.crearBien(unCodigo,unNroInventario,unaDescripcion,unaFechaAlta,unNroActa,unValor,unNroExpedienteAlta,unaResolucionAlta); 
            this.fillBienesList();
            habilitarTextos(false);
            limpiarComponentes();                   
            deshabilitarBotones();
            habilitarBotones();                 
         }else{
            JOptionPane.showMessageDialog(null, "No se puede guardar la infomación.\nDebe completar los datos requeridos.");
       }
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(nuevoBien){
            crearBien();
        }else{
            modificarBien();
        }
        this.txtNrodeInventario.setEnabled(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void lstBienesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstBienesMouseClicked
        if(!this.modeloBienes.isEmpty()){
            this.seleccionarBien();
            this.activarBotonesSeleccion();
        }
    }//GEN-LAST:event_lstBienesMouseClicked

    private void btbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbModificarActionPerformed
        this.nuevoBien = false;
        this.txtCodigo.setEnabled(true);
        this.txtDescripcion.setEnabled(true);
        this.txtNroExpediente.setEnabled(true);
        this.txtNroActa.setEnabled(true);
        this.txtFechaAlta.setEnabled(true);
        this.txtNrodeInventario.setEnabled(true);
        this.txtValor.setEnabled(true);
        this.txtResolucion.setEnabled(true);
        this.btbModificar.setEnabled(false);
        this.btnCancelar.setEnabled(true);
        this.btnEliminar.setEnabled(false);
        this.btnGuardar.setEnabled(true);
        this.btnNuevo.setEnabled(false);
        this.btnSalir.setEnabled(true);
    }//GEN-LAST:event_btbModificarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.buscar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNrodeInventarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNrodeInventarioKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode() == 10){
             this.buscar();
         }
    }//GEN-LAST:event_txtNrodeInventarioKeyPressed

    private void txtNrodeInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNrodeInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNrodeInventarioActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmBien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmBien dialog = new FrmBien(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbModificar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JFormattedTextField txtFechaAlta;
    private javax.swing.JTextField txtFechaBaja;
    private javax.swing.JTextField txtNroActa;
    private javax.swing.JTextField txtNroExpediente;
    private javax.swing.JTextField txtNrodeInventario;
    private javax.swing.JTextField txtResolucion;
    private javax.swing.JTextField txtResolucionBaja;
    private javax.swing.JTextField txtSubResponsable;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}