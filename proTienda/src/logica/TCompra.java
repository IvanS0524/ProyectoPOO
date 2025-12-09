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
public class TCompra extends Transaccion implements ITransaccion{
    private Proveedor proveedor;

    public TCompra(Proveedor proveedor) {
        super();
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    } 
        
    @Override
    public void procesarStock() {
        for (Detalle detalle : this.detalles) {
            detalle.getProducto().setStock(detalle.getProducto().getStock() + detalle.getCantidad());
        }
    }

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
