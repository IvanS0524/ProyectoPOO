/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;

/**
 *
 * @author ivans
 */
public abstract class Detalle implements Serializable{
    protected Producto producto;
    protected int cantidad;

    public Detalle(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Método abstracto: cada hijo define cómo calcular su subtotal
    public abstract double calcularSubtotal();
    
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
}

