/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author ivans
 */
public class DetalleCompra extends Detalle{
    private Proveedor provedor;
    
    public DetalleCompra(Producto producto, int cantidad, Proveedor provedor) {
        super(producto, cantidad);
        this.provedor = provedor;
    }

    @Override
    public double calcularSubtotal() {
        return producto.getPrecioCompra() * cantidad;
    }
}
