/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Clase que representa una transacción de venta a clientes.
 * Implementa procesamiento de stock (decremento) y generación de comprobante.
 * Valida disponibilidad de stock antes de procesar la venta.
 * Se aplica el concepto de herencia multiple mediante la implementación de ITransaccion y la herencia de Transaccion
 */
package logica;

import Interfaz.ITransaccion;

public class TVenta extends Transaccion implements ITransaccion{
    private Cliente cliente;

    /**
     * Constructor que crea una transacción de venta asociada a un cliente.
     * @param cliente El cliente que realiza la compra
     */
    public TVenta(Cliente cliente) {
        super();
        this.cliente = cliente;
    }

    /**
     * Obtiene el cliente asociado a esta venta.
     * @return El cliente de la venta
     */
    public Cliente getCliente() {
        return cliente;
    } 
        
    /**
     * Procesa el stock decrementando la cantidad de cada producto.
     * Valida que haya stock suficiente antes de decrementar.
     * @throws IllegalArgumentException Si no hay stock suficiente para alguno de los productos
     */
    @Override
    public void procesarStock() {
        for (Detalle detalle : this.detalles) {
            int stockActual = detalle.getProducto().getStock();
            if (stockActual >= detalle.getCantidad()) {
                detalle.getProducto().setStock(stockActual - detalle.getCantidad());
            } else {
                throw new IllegalArgumentException("Stock insuficiente para: " + detalle.getProducto().getNombre());
            }
        }
    }

    /**
     * Genera un comprobante detallado de la venta.
     * Incluye ID, fecha, cliente, teléfono, detalles de productos y total.
     * @return String formateado con el comprobante de venta
     */
    @Override
    public String generarComprobante() {
        StringBuilder comprobante = new StringBuilder();
        comprobante.append("=== COMPROBANTE DE VENTA ===\n");
        comprobante.append("ID Transacción: ").append(this.id).append("\n");
        comprobante.append("Fecha: ").append(this.fecha).append("\n");
        comprobante.append("Cliente: ").append(cliente.getNombre()).append("\n");
        comprobante.append("Teléfono: ").append(cliente.getTelefono()).append("\n");
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
