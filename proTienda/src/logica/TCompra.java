/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Clase que representa una transacción de compra a proveedores.
 * Implementa procesamiento de stock y generación de comprobante.
 * Asocia la compra con un proveedor específico.
 * Se aplica el concepto de herencia multiple mediante la implementación de ITransaccion y la herencia de Transaccion
 */
package logica;

import Interfaz.ITransaccion;

public class TCompra extends Transaccion implements ITransaccion{
    private Proveedor proveedor;

    /**
     * Constructor que crea una transacción de compra asociada a un proveedor.
     * @param proveedor El proveedor al que se le realiza la compra
     */
    public TCompra(Proveedor proveedor) {
        super();
        this.proveedor = proveedor;
    }

    /**
     * Obtiene el proveedor asociado a esta compra.
     * @return El proveedor de la compra
     */
    public Proveedor getProveedor() {
        return proveedor;
    } 
        
    /**
     * Procesa el stock incrementando la cantidad de cada producto.
     * Recorre todos los detalles y aumenta el stock de cada producto según la cantidad comprada.
     */
    @Override
    public void procesarStock() {
        for (Detalle detalle : this.detalles) {
            detalle.getProducto().setStock(detalle.getProducto().getStock() + detalle.getCantidad());
        }
    }

    /**
     * Genera un comprobante detallado de la compra.
     * Incluye ID, fecha, proveedor, detalles de productos y total.
     * @return String formateado con el comprobante de compra
     */
    @Override
    public String generarComprobante() {
        StringBuilder comprobante = new StringBuilder();
        comprobante.append("=== COMPROBANTE DE COMPRA ===\n");
        comprobante.append("ID Transacción: ").append(this.id).append("\n");
        comprobante.append("Fecha: ").append(this.fecha).append("\n");
        comprobante.append("Proveedor: ").append(proveedor.getNombre()).append("\n");
        comprobante.append("--- Detalles ---\n");
        
        for (Detalle d : this.detalles) {
            comprobante.append("Producto: ").append(d.getProducto().getNombre())
                    .append(" | Cantidad: ").append(d.getCantidad())
                    .append(" | Subtotal: $").append(d.calcularSubtotal()).append("\n");
        }
        
        comprobante.append("--- TOTAL: $").append(this.total).append(" ---\n");
        return comprobante.toString();
    }
}
