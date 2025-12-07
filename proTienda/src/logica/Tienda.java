package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tienda implements Serializable {
    private List<Producto> productos;
    private List<Cliente> clientes;
    private List<Proveedor> proveedores;

    public Tienda() {
        this.productos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.proveedores = new ArrayList<>();
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

    public void addProducto(Producto p) {
        productos.add(p);
    }
    public void addCliente(Cliente c) {
        clientes.add(c);
    }
    public void addProveedor(Proveedor p) {
        proveedores.add(p);
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



}
