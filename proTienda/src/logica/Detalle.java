/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Clase abstracta que representa un detalle de transacción.
 * Define la estructura común para DetalleCompra y DetalleVenta.
 * Utiliza método abstracto para el cálculo polimórfico de subtotales.
 */
package logica;

import java.io.Serializable;

public abstract class Detalle implements Serializable{
    protected Producto producto;
    protected int cantidad;

    /**
     * Constructor que crea un detalle de transacción.
     * @param producto El producto asociado al detalle
     * @param cantidad La cantidad del producto en esta transacción
     */
    public Detalle(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /**
     * Calcula el subtotal del detalle.
     * Método abstracto implementado por las clases hijas.
     * @return El subtotal calculado según el tipo de transacción
     */
    public abstract double calcularSubtotal();
    
    /**
     * Obtiene el producto asociado a este detalle.
     * @return El producto del detalle
     */
    public Producto getProducto() { return producto; }
    /**
     * Obtiene la cantidad del producto en este detalle.
     * @return La cantidad de productos
     */
    public int getCantidad() { return cantidad; }
}

