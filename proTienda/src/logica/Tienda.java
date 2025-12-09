package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tienda implements Serializable {
    private List<Producto> productos;
    private List<Cliente> clientes;
    private List<Proveedor> proveedores;
    private List<Transaccion> transacciones;

    public Tienda() {
        this.productos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        this.transacciones = new ArrayList<>();
    }

    public List<Producto> getProductos() {
        return productos;
    }
    public List<Cliente> getClientes() {
        return clientes;
    }
    public List<Proveedor> getProveedores() {
        return proveedores;
    }
    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void addProducto(Producto p) {
        productos.add(p);
    }
    public void addCliente(Cliente c) {
        clientes.add(c);
    }
    public void addProveedor(Proveedor p) {
        proveedores.add(p);
    }
    public void addTransaccion(Transaccion t) {
        transacciones.add(t);
    }
    
    public void eliminarProducto(Producto p) {
        productos.remove(p);
    }
    public void eliminarCliente(Cliente c) {
        clientes.remove(c);
    }
    public void eliminarProveedor(Proveedor p) {
        proveedores.remove(p);
    }

    public Producto getProductoPorId(int id){
        for (Producto p : productos) {
            if (p != null && p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public Cliente getClientePorId(int id){
        for (Cliente c : clientes) {
            if (c != null && c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public Proveedor getProveedorPorId(int id){
        for (Proveedor p : proveedores) {
            if (p != null && p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public boolean eliminarCliente(int id) {
        // Buscamos al cliente primero
        Cliente clienteAborrar = getClientePorId(id);
        
        // Si existe, lo borramos de la lista
        if (clienteAborrar != null) {
            clientes.remove(clienteAborrar);
            return true; // Se eliminó con éxito
        }
        return false; // No se encontró ese ID
    }

    public boolean eliminarProveedor(int id) {
        Proveedor proveedorAborrar = getProveedorPorId(id);
        
        if (proveedorAborrar != null) {
            proveedores.remove(proveedorAborrar);
            return true;
        }
        return false;
    }

}
