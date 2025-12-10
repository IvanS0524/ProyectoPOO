/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Clase que representa un detalle específico de compra.
 * Extiende Detalle y asocia el producto con el proveedor.
 * Calcula subtotal usando precio de compra.
 */
package logica;

public class DetalleCompra extends Detalle{
    private Proveedor proveedor;
    
    /**
     * Constructor que crea un detalle de compra.
     * @param producto El producto que se está comprando
     * @param cantidad La cantidad que se compra
     * @param proveedor El proveedor del que se compra
     */
    public DetalleCompra(Producto producto, int cantidad, Proveedor proveedor) {
        super(producto, cantidad);
        this.proveedor = proveedor;
    }
    
    /**
     * Obtiene el proveedor asociado a esta compra.
     * @return El proveedor del detalle de compra
     */
    public Proveedor getProveedor(){
        return proveedor;
    }

    /**
     * Calcula el subtotal de la compra.
     * Usa el precio de compra del producto.
     * @return El subtotal precio de compra × cantidad
     */
    @Override
    public double calcularSubtotal() {
        return producto.getPrecioCompra() * cantidad;
    }
}
