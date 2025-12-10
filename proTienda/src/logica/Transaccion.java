/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Clase abstracta que representa una transacción compra o venta
 * Define la estructura común y operaciones para todas las transacciones.
 * Utiliza métodos abstractos para comportamiento polimórfico específico.
 */
package logica;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Transaccion implements Serializable {
    protected LocalDateTime fecha;
    protected List<Detalle> detalles;
    protected int id;
    protected double total;
    private static int contadorId = 1;
    
    /**
     * Constructor que inicializa una nueva transacción.
     * Asigna automáticamente un ID secuencial y la fecha actual.
     */
    public Transaccion(){
        this.fecha = LocalDateTime.now();
        this.detalles = new ArrayList<>();
        this.total = 0;
        this.id = contadorId++;
    }
    
    /**
     * Calcula el total de la transacción sumando los subtotales de todos los detalles.
     * Actualiza el atributo total con el resultado.
     * @return El total calculado de la transacción
     */
    public double calcularTotal() {
        double suma = 0;
        for (Detalle d : detalles) {
            suma += d.calcularSubtotal();
        }
        this.total = suma;
        return suma;
    }
    /**
     * Obtiene la fecha y hora de la transacción.
     * @return La fecha de la transacción
     */
    public LocalDateTime getFecha() { return fecha; }
    /**
     * Obtiene el identificador único de la transacción.
     * @return El ID de la transacción
     */
    public int getId() { return id; }
    /**
     * Obtiene el monto total de la transacción.
     * @return El total de la transacción
     */
    public double getTotal() { return total; }
    /**
     * Obtiene la lista de detalles de la transacción.
     * @return Lista de detalles asociados a esta transacción
     */
    public List<Detalle> getDetalles() { return detalles; }
    /**
     * Genera un comprobante de la transacción.
     * Metodo abstracto implementado por las clases hijas.
     * @return String con el comprobante 
     */
    public abstract String generarComprobante();
    /**
     * Procesa el stock de los productos involucrados en la transacción.
     * Método abstracto implementado por las clases hijas según el tipo de transacción.
     */
    public abstract void procesarStock();
    
    /**
     * Agrega un detalle a la lista de detalles de la transacción.
     * @param detalle El detalle a agregar
     */
    public void agregarDetalle(Detalle detalle) {
        this.detalles.add(detalle);
    }
    
    /**
     * Establece manualmente el total de la transacción.
     * @param total El nuevo total
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    /**
     * Genera un resumen de los productos involucrados en la transacción.
     * @return String con los nombres de los productos separados por comas
     */
    public String getResumenProductos() {
        String lista = "";
        for (Detalle d : detalles) {
            if (!lista.isEmpty()) {
                lista += ", ";
            }
            lista += d.getProducto().getNombre();
        }
        return lista;
    }
}
