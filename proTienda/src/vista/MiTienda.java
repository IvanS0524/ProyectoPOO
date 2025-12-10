/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Interfaz gráfica principal del sistema construida con Swing.
 * Gestiona todas las operaciones de CRUD para productos, clientes, proveedores y transacciones.
 * Realiza guardado automático de datos en archivo binario y carga inicial de datos persistentes.
 */
package vista;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.*;
import persistencia.Archivo;

public class MiTienda extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MiTienda.class.getName());

    /**
     * Constructor que inicializa la interfaz gráfica.
     * Carga datos previos del archivo de persistencia.
     * Actualiza todas las tablas con los datos cargados.
     */    
    public MiTienda() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        try{
            tienda = (Tienda) archivo.cargarDesdeArchivo(); 
            JOptionPane.showMessageDialog(rootPane, "Archivo cargado correctamente");
            actualizarTablas();
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(rootPane, "Error: Clase no encontrada: " + e.getMessage());
        } catch (IOException ex){
            JOptionPane.showMessageDialog(rootPane, "Error al cargar archivo: " + ex.getMessage());
        }

    }
   
    Tienda tienda = new Tienda();
    Archivo archivo = new Archivo("tienda.bin");
    private Transaccion ultimaTransaccion = null;
    
    /**
     * Guarda automáticamente el estado actual de la tienda en archivo binario.
     * Se llama después de operaciones críticas como agregar, eliminar, transaccione.
     */
    private void guardarAutomaticamente() {
        try {
            archivo.guardarEnArchivo(tienda);
        } catch (IOException ex) {
            System.err.println("Error al guardar automáticamente: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Error: Clase no encontrada al guardar: " + ex.getMessage());
        }
    }
    
    /**
     * Actualiza todas las tablas de la interfaz con datos actualizados.
     * Llamada después de cambios significativos.
     */
    private void actualizarTablas(){
        actualizarTablaInventario();
        actualizarTablaClientes();
        actualizarTablaProveedores();
        actualizarTablaTransacciones();
    }
    
    /**
     * Actualiza la tabla de inventario de productos.
     * Muestra ID, nombre, stock, y precio de venta.
     */
    private void actualizarTablaInventario() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        
        modelo.setRowCount(0);
        
        if (tienda.getProductos() != null) {
            for (Producto p : tienda.getProductos()) {
            modelo.addRow(new Object[] {
                p.getId(),
                p.getNombre(),
                p.getStock(),
                p.getPrecioVenta()
                });
            }
        }
    }
    
    
    /**
     * Actualiza la tabla de clientes registrados.
     * Muestra ID, nombre y teléfono de cada cliente.
     */
    private void actualizarTablaClientes() {
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setRowCount(0);
        
        if (tienda.getClientes() != null) {
            for (Cliente c : tienda.getClientes()) {
                modelo.addRow(new Object[] {
                    c.getId(),
                    c.getNombre(),
                    c.getTelefono()
                });
            }
        }
    }

    /**
     * Actualiza la tabla de proveedores registrados.
     * Muestra ID, nombre y email de cada proveedor.
     */
    private void actualizarTablaProveedores() {
        DefaultTableModel modelo = (DefaultTableModel) tblProveedores.getModel();
        modelo.setRowCount(0);
        
        if (tienda.getProveedores() != null) {
            for (Proveedor p : tienda.getProveedores()) {
                modelo.addRow(new Object[] {
                    p.getId(),
                    p.getNombre(),
                    p.getEmail()
                });
            }
        }
    }

    /**
     * Actualiza la tabla de historial de transacciones.
     * Muestra fecha, productos, total y tipo de transacción (compra/venta).
     */
    private void actualizarTablaTransacciones() {
        DefaultTableModel modelo = (DefaultTableModel) tblTransaccion.getModel();
        modelo.setRowCount(0);
        
        if (tienda.getTransacciones() != null) {
            for (Transaccion t : tienda.getTransacciones()) {
                modelo.addRow(new Object[] {
                    t.getFecha().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), // Convertir fecha a String
                    t.getResumenProductos(),             
                    t.getTotal(),
                    t.getClass().getSimpleName()
                });
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnRealizarVenta = new javax.swing.JButton();
        btnComprobanteVenta = new javax.swing.JButton();
        jTFCantidadProducto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTFIdCliente = new javax.swing.JTextField();
        btnLimpiarV = new javax.swing.JButton();
        jTFIdProducto = new javax.swing.JTextField();
        btnAgregarCarritoVenta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCompra = new javax.swing.JButton();
        jTFNombre = new javax.swing.JTextField();
        jTFId = new javax.swing.JTextField();
        jTFCantidad = new javax.swing.JTextField();
        jTFPrecioCompra = new javax.swing.JTextField();
        jTFPrecioVenta = new javax.swing.JTextField();
        btnComprobanteCompra = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTFIdProveedor = new javax.swing.JTextField();
        btnLimpiarC = new javax.swing.JButton();
        btnAgregarCarritoCompra = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnAñadirCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();
        btnEliminarProveedor = new javax.swing.JButton();
        btnAñadirProveedor = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTransaccion = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de gestion deTienda ");

        jLabel8.setText("ID Producto");

        jLabel9.setText("Cantidad");

        btnRealizarVenta.setText("Realizar venta");
        btnRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVentaActionPerformed(evt);
            }
        });

        btnComprobanteVenta.setText("Imprimir comprobante");
        btnComprobanteVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobanteVentaActionPerformed(evt);
            }
        });

        jLabel11.setText("ID cliente");

        btnLimpiarV.setText("Limpiar");
        btnLimpiarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarVActionPerformed(evt);
            }
        });

        btnAgregarCarritoVenta.setText("Agregar al carrito");
        btnAgregarCarritoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarritoVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregarCarritoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRealizarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnComprobanteVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiarV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jTFIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnRealizarVenta)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnComprobanteVenta)
                        .addGap(27, 27, 27)
                        .addComponent(btnLimpiarV)))
                .addGap(4, 4, 4)
                .addComponent(btnAgregarCarritoVenta)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ventas", jPanel1);

        jLabel1.setText("Nom Producto");

        jLabel3.setText("ID Producto");

        jLabel4.setText("Cantidad");

        jLabel5.setText("Precio de venta");

        jLabel6.setText("Precio de compra");

        btnCompra.setText("Realizar Compra");
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        btnComprobanteCompra.setText("Imprimir Comprobante");
        btnComprobanteCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobanteCompraActionPerformed(evt);
            }
        });

        jLabel12.setText("ID proveedor");

        btnLimpiarC.setText("Limpiar");
        btnLimpiarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCActionPerformed(evt);
            }
        });

        btnAgregarCarritoCompra.setText("Agregar al carrito");
        btnAgregarCarritoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarritoCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTFId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                            .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregarCarritoCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(btnLimpiarC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTFCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFPrecioVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFIdProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCompra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnComprobanteCompra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTFIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTFCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTFPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCompra)
                            .addComponent(btnAgregarCarritoCompra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnComprobanteCompra)
                            .addComponent(btnLimpiarC))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Compras", jPanel2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Producto", "Stock", "Precio (Unidad)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inventario", jPanel3);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblClientes);

        btnAñadirCliente.setText("Añadir");
        btnAñadirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAñadirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAñadirCliente)
                    .addComponent(btnEliminarCliente))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes", jPanel4);

        tblProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProveedores);

        btnEliminarProveedor.setText("Eliminar");
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });

        btnAñadirProveedor.setText("Añadir");
        btnAñadirProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnAñadirProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarProveedor)
                    .addComponent(btnAñadirProveedor))
                .addGap(0, 28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proveedores", jPanel6);

        tblTransaccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Producto", "Total", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblTransaccion);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transaccion", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnComprobanteCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobanteCompraActionPerformed
        // TODO add your handling code here:}
        imprimirComprobante();
    }//GEN-LAST:event_btnComprobanteCompraActionPerformed
    
    /**
     * Genera e imprime el comprobante de la última transacción realizada.
     * Muestra el contenido completo del comprobante en una ventana de diálogo.
     * Valida que exista una transacción previa; si no, muestra un mensaje de advertencia.
     */
    private void imprimirComprobante() {
        if (ultimaTransaccion == null) {
            JOptionPane.showMessageDialog(rootPane, "No hay transacción para imprimir.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        String comprobante = ultimaTransaccion.generarComprobante();
    
        JOptionPane.showMessageDialog(rootPane, comprobante, "Comprobante", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Gestiona la creación o actualización de un producto.
     * Si el producto ya existe, solicita confirmación para actualizar precios y stock.
     * Si es nuevo, lo registra automáticamente en la tienda.
     * 
     * @param id Identificador único del producto
     * @param nombre Nombre descriptivo del producto
     * @param cantidad Cantidad a agregar al stock en compra
     * @param pCompra Precio de costo del producto
     * @param pVenta Precio de venta del producto
     * @return El objeto Producto gestionado ya sea nuevo o actualizado
     * @throws IllegalArgumentException Si el usuario cancela la actualización de producto existente
     */
    private Producto gestionarProducto(int id, String nombre, int cantidad, double pCompra, double pVenta) {
        Producto prod = tienda.getProductoPorId(id);

        if (prod != null) {
            String msg = "El producto '" + prod.getNombre() + "' (ID: " + id + ") ya existe.\n\n" +
                         "--- CAMBIOS DETECTADOS ---\n" +
                         "Stock Actual: " + prod.getStock() + "  >>>  Nuevo Stock: " + (prod.getStock() + cantidad) + "\n" +
                         "Precio Compra: $" + prod.getPrecioCompra() + "  >>>  Nuevo: $" + pCompra + "\n" +
                         "Precio Venta: $" + prod.getPrecioVenta() + "  >>>  Nuevo: $" + pVenta + "\n\n" +
                         "¿Deseas agregar el stock y ACTUALIZAR los precios/nombre?";

            int opcion = JOptionPane.showConfirmDialog(rootPane, msg, "Producto Existente", 
                                                       JOptionPane.YES_NO_OPTION, 
                                                       JOptionPane.QUESTION_MESSAGE);

            if (opcion == JOptionPane.YES_OPTION) {
                // Sobreescribimos los datos viejos con los nuevos
                prod.setNombre(nombre);           
                prod.setPrecioCompra(pCompra);    
                prod.setPrecioVenta(pVenta);      
                return prod; // Retornamos el objeto existente actualizado
            } else {
                // Si dice que no, cancelamos 
                throw new IllegalArgumentException("Operación cancelada. No se modificó el producto.");
            }

        } else {
            Producto nuevo = new Producto(nombre, id, 0, pCompra, pVenta); 
            tienda.addProducto(nuevo);

            JOptionPane.showMessageDialog(rootPane, "Producto nuevo registrado en el sistema.");
            return nuevo; 
        }
    }
    
    /**
     * Manejador del evento para el botón Realizar Compra
     * Confirma la transacción de compra actual, procesa el carrito y genera el comprobante.
     * Actualiza automáticamente el inventario, persiste datos y limpia la interfaz.
     * Valida que el carrito de compra no esté vacío antes de procesar.
     * 
     * @param evt Evento del botón
     */
    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        // TODO add your handling code here:
        try {
            TCompra compraFinal = tienda.confirmarCarritoCompra(); // ¡Una sola línea lógica!

            ultimaTransaccion = compraFinal;
            actualizarTablas();
            guardarAutomaticamente();
            JOptionPane.showMessageDialog(rootPane, compraFinal.generarComprobante(), "Exito", JOptionPane.INFORMATION_MESSAGE);

            btnLimpiarCActionPerformed(null); // Reset visual

        } catch (IllegalStateException e) { // Captura carrito vacío
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCompraActionPerformed

    /**
     * Maneja el evento para el botón Realizar Venta
     * Confirma la transacción de venta actual, valida stock disponible y procesa el carrito
     * Actualiza el inventario 
     * Genera comprobante de venta y limpia la interfaz automáticamente
     * 
     * @param evt Evento del botón
     */
    private void btnRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVentaActionPerformed
        // TODO add your handling code here:
        try {
            TVenta ventaFinal = tienda.confirmarCarritoVenta();

            ultimaTransaccion = ventaFinal;
            actualizarTablas();    
            guardarAutomaticamente();  
            JOptionPane.showMessageDialog(rootPane, ventaFinal.generarComprobante(), "Venta Exitosa", JOptionPane.INFORMATION_MESSAGE);

            btnLimpiarVActionPerformed(null);

        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error crítico: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRealizarVentaActionPerformed

    /**
     * Maneja el evento Añadir Proveedor
     * Solicita al usuario los datos del nuevo proveedor (ID, nombre, email)
     * Valida que el email sea válido formato correct y que el ID sea único
     * Registra el proveedor en la tienda, actualiza la tabla y guarda los cambios.
     * 
     * @param evt Evento del botón
     */
    private void btnAñadirProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirProveedorActionPerformed
        // TODO add your handling code here:
        try {
            String idStr = JOptionPane.showInputDialog(this, "Ingrese el ID del Proveedor:");
            if (idStr == null || idStr.trim().isEmpty()) return;
            int id = Integer.parseInt(idStr);

            String nombre = JOptionPane.showInputDialog(this, "Ingrese el Nombre del Proveedor:");
            if (nombre == null || nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre es obligatorio.");
                return;
            }

            String email = JOptionPane.showInputDialog(this, "Ingrese el Email del Proveedor:");
            if (email == null) return;

            tienda.registrarProveedor(id, nombre, email);

            actualizarTablaProveedores();
            guardarAutomaticamente();
            JOptionPane.showMessageDialog(this, "Proveedor agregado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }     
    }//GEN-LAST:event_btnAñadirProveedorActionPerformed

    /**
     * Maneja el evento para el botón Eliminar Proveedor
     * Solicita el ID del proveedor a eliminar y pide confirmación del usuario.
     * Busca el proveedor en la tienda y lo elimina si existe.
     * Actualiza la tabla de proveedores y guarda los cambios.
     * 
     * @param evt Evento del botón
     */
    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
        // TODO add your handling code here:
        try {
            String idStr = JOptionPane.showInputDialog(this, "Ingrese el ID del Proveedor a eliminar:");
            if (idStr == null || idStr.trim().isEmpty()) return;

            int idProv = Integer.parseInt(idStr);
            int confirmacion = JOptionPane.showConfirmDialog(this, 
                    "¿Seguro que deseas eliminar al proveedor " + idProv + "?",
                    "Confirmar Eliminación", 
                    JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                boolean eliminado = tienda.eliminarProveedor(idProv);
                if (eliminado) {
                    guardarAutomaticamente(); //Guardar en archivo
                    actualizarTablaProveedores(); //  Actualizar tabla proveedores
                    JOptionPane.showMessageDialog(this, "Proveedor eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún proveedor con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    /**
     * Maneja el evento para el botón Añadir Cliente
     * Solicita al usuario los datos del nuevo cliente como ID, nombre, teléfono
     * Valida que el ID sea único
     * Registra el cliente en la tienda, actualiza la tabla y guarda los cambios.
     * 
     * @param evt Evento del botón
     */
    private void btnAñadirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirClienteActionPerformed
        // TODO add your handling code here:
        try {
            String idStr = JOptionPane.showInputDialog(this, "Ingrese el ID del Usuario:");
            if (idStr == null || idStr.trim().isEmpty()) return;
            int id = Integer.parseInt(idStr);

            String nombre = JOptionPane.showInputDialog(this, "Ingrese el Nombre del Usuario:");
            if (nombre == null || nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre es obligatorio.");
                return;
            }

            String tel = JOptionPane.showInputDialog(this, "Ingrese el teléfono del Usuario:");
            if (tel == null) return;

            tienda.registrarCliente(id, nombre, tel);
            actualizarTablaClientes();
            guardarAutomaticamente();
            JOptionPane.showMessageDialog(this, "Cliente agregado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAñadirClienteActionPerformed

    /**
     * Maneja del evento para el botón Limpiar del carrito de ventas
     * Valida si hay productos en el carrito antes de limpiar
     * Si hay items, pide confirmación al usuario antes de cancelar la venta
     * Limpia tanto la lógica del carrito como los campos de entrada en la igu 
     * 
     * @param evt Evento del botón
     */
    private void btnLimpiarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarVActionPerformed
        // TODO add your handling code here:
        if (tienda.getItemsCarritoVenta() > 0) {
            int opt = JOptionPane.showConfirmDialog(rootPane, 
                "Hay productos en el carrito de ventas. ¿Seguro desea cancelar la venta y limpiar todo?", 
                "Cancelar Venta", 
                JOptionPane.YES_NO_OPTION);

            if (opt != JOptionPane.YES_OPTION) {
                return;
            }
        }
        tienda.limpiarCarritoVenta();

        jTFIdCliente.setText("");
        jTFIdProducto.setText("");
        jTFCantidadProducto.setText("");
        jTFIdCliente.setEditable(true);
    }//GEN-LAST:event_btnLimpiarVActionPerformed

    /**
     * Maneja el evento para el botón Imprimir Comprobante de venta.
     * Llamada cuando el usuario solicita imprimir el comprobante de la última venta realizada.
     * Valida que exista una transacción previa antes de intentar imprimir.
     * 
     * @param evt Evento del botón
     */
    private void btnComprobanteVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobanteVentaActionPerformed
        // TODO add your handling code here:
        imprimirComprobante();
    }//GEN-LAST:event_btnComprobanteVentaActionPerformed

    /**
     * Maneja el evento para el botón Eliminar Cliente
     * Solicita el ID del cliente a eliminar y pide confirmación del usuario.
     * Busca el cliente en la tienda y lo elimina si existe.
     * Actualiza la tabla de clientes y guardae los cambios en el archivo.
     * 
     * @param evt Evento del botón
     */
    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        // TODO add your handling code here:
        try {
            String idStr = JOptionPane.showInputDialog(this, "Ingrese el ID del Cliente a eliminar:");
            if (idStr == null || idStr.trim().isEmpty()) {
                return; 
            }

            int idCliente = Integer.parseInt(idStr);
            int confirmacion = JOptionPane.showConfirmDialog(this, 
                    "¿Seguro que deseas eliminar al cliente con ID " + idCliente + "?",
                    "Confirmar Eliminación", 
                    JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                boolean eliminado = tienda.eliminarCliente(idCliente);
                if (eliminado) {
                    guardarAutomaticamente();
                    actualizarTablaClientes();
                    JOptionPane.showMessageDialog(this, "Cliente eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún cliente con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    /**
     * Maneja el evento para el botón Agregar al Carrito de compra.
     * Valida todos los campos proveedor existente, producto, cantidad y precios.
     * Gestiona la creación o actualización de productos según sea necesario.
     * Agrega el producto al carrito de compra con la cantidad especificada.
     * limpia campos de entrada
     * 
     * @param evt Evento del botón
     */
    private void btnAgregarCarritoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarritoCompraActionPerformed
        // TODO add your handling code here:
        try {
            if (jTFIdProveedor.getText().isEmpty()) { JOptionPane.showMessageDialog(rootPane, "Ingrese ID proveedor"); return; }

            int idProv = Integer.parseInt(jTFIdProveedor.getText());
            Proveedor proveedor = tienda.getProveedorPorId(idProv);
            if (proveedor == null) { JOptionPane.showMessageDialog(rootPane, "Proveedor no existe"); return; }

            int idProd = Integer.parseInt(jTFId.getText());
            int cant = Integer.parseInt(jTFCantidad.getText());
            double pCompra = Double.parseDouble(jTFPrecioCompra.getText());
            double pVenta = Double.parseDouble(jTFPrecioVenta.getText());
            String nombre = jTFNombre.getText();

            Producto producto = gestionarProducto(idProd, nombre, cant, pCompra, pVenta);
            if (producto == null) return;

            tienda.agregarAlCarritoCompra(producto, cant, proveedor);

            JOptionPane.showMessageDialog(rootPane, "Agregado. Items: " + tienda.getItemsCarritoCompra());

            jTFIdProveedor.setEditable(false);
            jTFId.setText(""); 
            jTFNombre.setText(""); 
            jTFCantidad.setText(""); 
            jTFPrecioCompra.setText(""); 
            jTFPrecioVenta.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Datos numéricos inválidos");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarCarritoCompraActionPerformed

    /**
     * Maneja el evento para el botón Limpiar del carrito de compras.
     * Valida si hay productos en el carrito antes de limpiar.
     * Si hay items, pide confirmación al usuario antes de cancelar la compra.
     * Limpia tanto la lógica del carrito como los campos de entrada en la ifu.
     * Restaura la edición del campo de proveedor.
     * 
     * @param evt Evento del botón
     */
    private void btnLimpiarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCActionPerformed
        // TODO add your handling code here:
        if (tienda.getItemsCarritoCompra() > 0) { // Preguntamos a la tienda
            int cf = JOptionPane.showConfirmDialog(rootPane, "¿Limpiar carrito?", "Confirma", JOptionPane.YES_NO_OPTION);
            if (cf != JOptionPane.YES_OPTION) return;
        }
        tienda.limpiarCarritoCompra(); 
       
        jTFIdProveedor.setEditable(true);
        jTFIdProveedor.setText("");
        jTFNombre.setText(""); 
        jTFId.setText(""); 
        jTFCantidad.setText(""); 
        jTFPrecioCompra.setText("");
        jTFPrecioVenta.setText("");
    }//GEN-LAST:event_btnLimpiarCActionPerformed

    /**
     * Maneja del evento para el botón Agregar al Carrito de venta.
     * Valida todos los campos cliente existente, producto existente y cantidad válida.
     * Verifica que el producto tenga stock suficiente para la venta.
     * Valida que todas las ventas en el carrito sean del mismo cliente.
     * Agrega el producto al carrito de venta con la cantidad especificada.
     * deshabilita campo de cliente, limpia campos de entrada
     * 
     * @param evt Evento del botón
     */
    private void btnAgregarCarritoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarritoVentaActionPerformed
        // TODO add your handling code here:
        try {
            if (jTFIdCliente.getText().isEmpty()) { JOptionPane.showMessageDialog(rootPane, "ID Cliente requerido"); return; }

            int idCliente = Integer.parseInt(jTFIdCliente.getText());
            Cliente cliente = tienda.getClientePorId(idCliente);
            if (cliente == null) { JOptionPane.showMessageDialog(rootPane, "Cliente no existe"); return; }

            if (jTFIdProducto.getText().isEmpty() || jTFCantidadProducto.getText().isEmpty()) {
                 JOptionPane.showMessageDialog(rootPane, "Datos incompletos"); return;
            }
            int idProd = Integer.parseInt(jTFIdProducto.getText());
            int cant = Integer.parseInt(jTFCantidadProducto.getText());
            Producto producto = tienda.getProductoPorId(idProd);
            if (producto == null) { JOptionPane.showMessageDialog(rootPane, "Producto no existe"); return; }

            tienda.agregarAlCarritoVenta(producto, cant, cliente);

            JOptionPane.showMessageDialog(rootPane, "Agregado. Items: " + tienda.getItemsCarritoVenta());

            jTFIdCliente.setEditable(false);
            jTFIdProducto.setText(""); jTFCantidadProducto.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Verifique números");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Atención", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarCarritoVentaActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MiTienda().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCarritoCompra;
    private javax.swing.JButton btnAgregarCarritoVenta;
    private javax.swing.JButton btnAñadirCliente;
    private javax.swing.JButton btnAñadirProveedor;
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnComprobanteCompra;
    private javax.swing.JButton btnComprobanteVenta;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnLimpiarC;
    private javax.swing.JButton btnLimpiarV;
    private javax.swing.JButton btnRealizarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTFCantidad;
    private javax.swing.JTextField jTFCantidadProducto;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFIdCliente;
    private javax.swing.JTextField jTFIdProducto;
    private javax.swing.JTextField jTFIdProveedor;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFPrecioCompra;
    private javax.swing.JTextField jTFPrecioVenta;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblProveedores;
    private javax.swing.JTable tblTransaccion;
    // End of variables declaration//GEN-END:variables
}
