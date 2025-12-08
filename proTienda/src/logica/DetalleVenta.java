/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author ivans
 */
public class DetalleVenta extends Detalle{
    private Cliente cliente;
    
    public DetalleVenta(Producto producto, int cantidad, Cliente cliente) {
        super(producto, cantidad);
        this.cliente = cliente;
    }

    @Override
    public double calcularSubtotal() {
        return producto.getPrecioVenta() * cantidad;
    }
}
