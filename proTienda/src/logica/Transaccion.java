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
    
    public Transaccion(){
        this.fecha = LocalDateTime.now();
        this.detalles = new ArrayList<>();
        this.total = 0;
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
}
