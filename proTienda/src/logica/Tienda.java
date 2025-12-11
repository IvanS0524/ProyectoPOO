/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Clase principal que representa el sistema de la tienda.
 * Gestiona todas las entidades productos, clientes, proveedores, transacciones
 * Implementa lógica de carritos de compra/venta y persistencia mediante Serializable.
 */
package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tienda implements Serializable {
    private List<Producto> productos;
    private List<Cliente> clientes;
    private List<Proveedor> proveedores;
    private List<Transaccion> transacciones;
    
    private List<DetalleCompra> carritoTemporalCompra = new ArrayList<>();
    private Proveedor proveedorEnCarrito = null;
    private List<DetalleVenta> carritoTemporalVenta = new ArrayList<>();
    private Cliente clienteEnCarrito = null;

    /**
     * Constructor que inicializa el sistema de la tienda.
     * Crea las listas vacías para todos los elementos del sistema.
     */
    public Tienda() {
        this.productos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        this.transacciones = new ArrayList<>();
    }

    /**
     * Obtiene la lista completa de productos en el inventario.
     * @return Lista de productos registrados
     */
    public List<Producto> getProductos() {
        return productos;
    }
    /**
     * Obtiene la lista completa de clientes registrados.
     * @return Lista de clientes
     */
    public List<Cliente> getClientes() {
        return clientes;
    }
    /**
     * Obtiene la lista completa de proveedores registrados.
     * @return Lista de proveedores
     */
    public List<Proveedor> getProveedores() {
        return proveedores;
    }
    /**
     * Obtiene la lista completa del historial de transacciones.
     * @return Lista de transacciones compras y ventas
     */
    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    /**
     * Agrega un producto al inventario.
     * @param p El producto a agregar
     */
    public void addProducto(Producto p) {
        productos.add(p);
    }
    /**
     * Agrega un cliente al sistema.
     * @param c El cliente a agregar
     */
    public void addCliente(Cliente c) {
        clientes.add(c);
    }
    /**
     * Agrega un proveedor al sistema.
     * @param p El proveedor a agregar
     */
    public void addProveedor(Proveedor p) {
        proveedores.add(p);
    }
    /**
     * Agrega una transacción al historial.
     * @param t La transacción a agregar
     */
    public void addTransaccion(Transaccion t) {
        transacciones.add(t);
    }
    
    /**
     * Elimina un producto del inventario.
     * @param p El producto a eliminar
     */
    public void eliminarProducto(Producto p) {
        productos.remove(p);
    }
    /**
     * Elimina un cliente del sistema.
     * @param c El cliente a eliminar
     */
    public void eliminarCliente(Cliente c) {
        clientes.remove(c);
    }
    /**
     * Elimina un proveedor del sistema.
     * @param p El proveedor a eliminar
     */
    public void eliminarProveedor(Proveedor p) {
        proveedores.remove(p);
    }

    /**
     * Busca y retorna un producto por su ID.
     * @param id El identificador del producto a buscar
     * @return El producto encontrado, o null si no existe
     */
    public Producto getProductoPorId(int id){
        for (Producto p : productos) {
            if (p != null && p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    /**
     * Busca y retorna un cliente por su ID.
     * @param id El identificador del cliente a buscar
     * @return El cliente encontrado, o null si no existe
     */
    public Cliente getClientePorId(int id){
        for (Cliente c : clientes) {
            if (c != null && c.getId() == id) {
                return c;
            }
        }
        return null;
    }
    /**
     * Busca y retorna un proveedor por su ID.
     * @param id El identificador del proveedor a buscar
     * @return El proveedor encontrado, o null si no existe
     */
    public Proveedor getProveedorPorId(int id){
        for (Proveedor p : proveedores) {
            if (p != null && p.getId() == id) {
                return p;
            }
        }
        return null;
    }  
    /**
     * Elimina un cliente del sistema usando su ID.
     * @param id El identificador del cliente a eliminar
     * @return true si se eliminó exitosamente, false si no se encontró
     */
    public boolean eliminarCliente(int id) {
        Cliente clienteBorrar = getClientePorId(id);
        
        if (clienteBorrar != null) {
            clientes.remove(clienteBorrar);
            return true; 
        }
        return false; 
    }
    /**
     * Elimina un proveedor del sistema usando su ID.
     * @param id El identificador del proveedor a eliminar
     * @return true si se eliminó exitosamente, false si no se encontró
     */
    public boolean eliminarProveedor(int id) {
        Proveedor proveedorBorrar = getProveedorPorId(id);
        
        if (proveedorBorrar != null) {
            proveedores.remove(proveedorBorrar);
            return true;
        }
        return false;
    }
    /**
     * Registra un nuevo cliente en el sistema.
     * Valida que no exista otro cliente con el mismo ID.
     * @param id Identificador único del cliente
     * @param nombre Nombre del cliente
     * @param telefono Número telefónico del cliente
     * @throws IllegalArgumentException Si ya existe un cliente con ese ID
     */
    public void registrarCliente(int id, String nombre, String telefono) {
        if (getClientePorId(id) != null) {
            throw new IllegalArgumentException("Ya existe un cliente con el ID " + id);
        }

        Cliente nuevo = new Cliente(nombre, id, telefono);
        addCliente(nuevo);
    }
    /**
     * Registra un nuevo proveedor en el sistema.
     * Valida que no exista otro proveedor con el mismo ID.
     * @param id Identificador único del proveedor
     * @param nombre Nombre del proveedor
     * @param email Correo electrónico del proveedor
     * @throws IllegalArgumentException Si ya existe un proveedor con ese ID
     */
    public void registrarProveedor(int id, String nombre, String email) {
        if (getProveedorPorId(id) != null) {
            throw new IllegalArgumentException("Ya existe un proveedor con el ID " + id);
        }

        Proveedor nuevo = new Proveedor(nombre, id, email);
        addProveedor(nuevo);
    } 

    /**
     * Registra una compra de producto a un proveedor.
     * Incrementa el stock del producto automáticamente.
     * @param proveedor El proveedor al que se le compra
     * @param producto El producto a comprar
     * @param cantidad La cantidad a comprar
     * @return La transacción de compra creada
     */
    public TCompra registrarCompra(Proveedor proveedor, Producto producto, int cantidad) {
        TCompra nuevaCompra = new TCompra(proveedor);

        DetalleCompra detalle = new DetalleCompra(producto, cantidad, proveedor);
        nuevaCompra.agregarDetalle(detalle);

        nuevaCompra.calcularTotal();
        nuevaCompra.procesarStock();

        this.addTransaccion(nuevaCompra);
        return nuevaCompra;
    }    
    /**
     * Registra una venta de producto a un cliente.
     * Valida stock disponible y lo decrementa automáticamente.
     * @param cliente El cliente que realiza la compra
     * @param producto El producto a vender
     * @param cantidad La cantidad a vender
     * @return La transacción de venta creada
     * @throws IllegalArgumentException Si no hay stock suficiente
     */
    public TVenta registrarVenta(Cliente cliente, Producto producto, int cantidad) {
        if (producto.getStock() < cantidad) {
            throw new IllegalArgumentException("Stock insuficiente. Disponible: " + producto.getStock());
        }
        TVenta nuevaVenta = new TVenta(cliente);

        DetalleVenta detalle = new DetalleVenta(producto, cantidad, cliente);
        nuevaVenta.agregarDetalle(detalle);

        nuevaVenta.calcularTotal();
        nuevaVenta.procesarStock();

        this.addTransaccion(nuevaVenta);

        return nuevaVenta;
    }   
    /**
     * Procesa una transacción completa (compra o venta).
     * Calcula el total, procesa el stock y la agrega al historial.
     * @param t La transacción a procesar
     */
    public void procesarTransaccion(Transaccion t) {
        t.calcularTotal();
        t.procesarStock();
        this.addTransaccion(t);
    }
    
    //LOGICA CARRITO COMPRA
    /**
     * Agrega un producto al carrito temporal de compras.
     * Valida que todos los productos sean del mismo proveedor.
     * @param p El producto a agregar
     * @param cantidad La cantidad del producto
     * @param proveedor El proveedor del producto
     * @throws IllegalArgumentException Si se intenta mezclar proveedores diferentes
     */
    public void agregarAlCarritoCompra(Producto p, int cantidad, Proveedor proveedor) {
        if (proveedorEnCarrito != null && !proveedorEnCarrito.getId().equals(proveedor.getId())) {
            throw new IllegalArgumentException("No puede mezclar proveedores. Termine la compra actual o limpie el carrito.");
        }
        if (proveedorEnCarrito == null) proveedorEnCarrito = proveedor;

        DetalleCompra detalle = new DetalleCompra(p, cantidad, proveedorEnCarrito);
        carritoTemporalCompra.add(detalle);
    }

    /**
     * Confirma y procesa todos los productos del carrito de compras.
     * Crea la transacción, actualiza stock y limpia el carrito.
     * @return La transacción de compra procesada
     * @throws IllegalStateException Si el carrito está vacío
     */
    public TCompra confirmarCarritoCompra() {
        if (carritoTemporalCompra.isEmpty()) throw new IllegalStateException("El carrito está vacío.");

        TCompra compra = new TCompra(proveedorEnCarrito);
        for (DetalleCompra d : carritoTemporalCompra) compra.agregarDetalle(d);
        
        procesarTransaccion(compra);
        limpiarCarritoCompra();
        return compra;
    }

    /**
     * Limpia completamente el carrito de compras.
     * Elimina todos los detalles y resetea el proveedor asociado.
     */
    public void limpiarCarritoCompra() {
        carritoTemporalCompra.clear();
        proveedorEnCarrito = null;
    }
    
    /**
     * Obtiene la cantidad de items en el carrito de compras.
     * @return Número de productos diferentes en el carrito
     */
    public int getItemsCarritoCompra() { return carritoTemporalCompra.size(); }

    //LÓGICA DEL CARRITO DE VENTAS
    /**
     * Agrega un producto al carrito temporal de ventas.
     * Valida que todos los productos sean para el mismo cliente.
     * Valida que haya stock suficiente considerando lo que ya está en el carrito.
     * @param p El producto a agregar
     * @param cantidad La cantidad del producto
     * @param cliente El cliente que realiza la compra
     * @throws IllegalArgumentException Si se mezclan clientes o no hay stock suficiente
     */
    public void agregarAlCarritoVenta(Producto p, int cantidad, Cliente cliente) {
        if (clienteEnCarrito != null && !clienteEnCarrito.getId().equals(cliente.getId())) {
            throw new IllegalArgumentException("No puede mezclar clientes. Termine la venta actual o limpie el carrito.");
        }
        int cantidadEnCarrito = 0;
        for (DetalleVenta d : carritoTemporalVenta) {
            if (d.getProducto().getId().equals(p.getId())) {
                cantidadEnCarrito += d.getCantidad();
            }
        }
     
        if (p.getStock() < (cantidad + cantidadEnCarrito)) {
            throw new IllegalArgumentException("Stock insuficiente. Disponible: " + p.getStock() + 
                                               ". (En carrito: " + cantidadEnCarrito + ")");
        }

        if (clienteEnCarrito == null) clienteEnCarrito = cliente;
        DetalleVenta detalle = new DetalleVenta(p, cantidad, clienteEnCarrito);
        carritoTemporalVenta.add(detalle);
    }
    /**
     * Confirma y procesa todos los productos del carrito de ventas.
     * Crea la transacción, actualiza stock y limpia el carrito.
     * @return La transacción de venta procesada
     * @throws IllegalStateException Si el carrito está vacío
     */
    public TVenta confirmarCarritoVenta() {
        if (carritoTemporalVenta.isEmpty()) throw new IllegalStateException("El carrito está vacío.");

        TVenta venta = new TVenta(clienteEnCarrito);
        for (DetalleVenta d : carritoTemporalVenta) venta.agregarDetalle(d);
        
        procesarTransaccion(venta);
        limpiarCarritoVenta();
        return venta;
    }
    /**
     * Limpia completamente el carrito de ventas.
     * Elimina todos los detalles y resetea el cliente asociado.
     */
    public void limpiarCarritoVenta() {
        carritoTemporalVenta.clear();
        clienteEnCarrito = null;
    }
    /**
     * Obtiene la cantidad de items en el carrito de ventas.
     * @return Número de productos diferentes en el carrito
     */
    public int getItemsCarritoVenta() { return carritoTemporalVenta.size(); }
}
