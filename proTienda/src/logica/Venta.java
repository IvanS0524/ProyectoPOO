/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import Interfaz.ITransaccion;

/**
 *
 * @author ivans
 */
public class Venta extends Transaccion implements ITransaccion{
    private Cliente cliente;

    public Venta(Cliente cliente) {
        super();
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    } 
        
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
