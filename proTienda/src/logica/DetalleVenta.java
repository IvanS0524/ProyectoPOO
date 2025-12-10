/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Clase que representa un detalle específico de venta.
 * Extiende Detalle y asocia el producto con el cliente.
 * Calcula subtotal usando precio de venta.
 */
package logica;

public class DetalleVenta extends Detalle{
    private Cliente cliente;
    
    /**
     * Constructor que crea un detalle de venta.
     * @param producto El producto que se está vendiendo
     * @param cantidad La cantidad que se vende
     * @param cliente El cliente que realiza la compra
     */
    public DetalleVenta(Producto producto, int cantidad, Cliente cliente) {
        super(producto, cantidad);
        this.cliente = cliente;
    }

    /**
     * Calcula el subtotal de la venta.
     * Usa el precio de venta del producto.
     * @return El subtotal precio de venta × cantidad
     */
    @Override
    public double calcularSubtotal() {
        return producto.getPrecioVenta() * cantidad;
    }
}
