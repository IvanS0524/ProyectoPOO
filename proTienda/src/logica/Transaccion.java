/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivans
 */
public abstract class Transaccion implements Serializable {
    protected LocalDateTime fecha;
    protected List<Detalle> detalles;
    protected int id;
    protected double total;
    private static int contadorId = 1;
    
    public Transaccion(){
        this.fecha = LocalDateTime.now();
        this.detalles = new ArrayList<>();
        this.total = 0;
        this.id = contadorId++;
    }
    
    public double calcularTotal() {
        double suma = 0;
        for (Detalle d : detalles) {
            suma += d.calcularSubtotal();
        }
        this.total = suma;
        return suma;
    }
    
    public LocalDateTime getFecha() { return fecha; }
    public int getId() { return id; }
    public double getTotal() { return total; }
    public List<Detalle> getDetalles() { return detalles; }
    public abstract String generarComprobante();
    
    public void agregarDetalle(Detalle detalle) {
        this.detalles.add(detalle);
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    
    public String getResumenProductos() {
        String lista = "";

        // Recorremos los detalles de esta transacción
        for (Detalle d : detalles) {
            // Si ya hay algo escrito, ponemos una coma para separar
            if (!lista.isEmpty()) {
                lista += ", ";
            }
            lista += d.getProducto().getNombre();
        }
        return lista;
    }
}
