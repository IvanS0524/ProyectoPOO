/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Interfaz que define el comportamiento común para todas las transacciones.
 * Define operaciones esenciales de procesamiento de stock y generación de comprobantes.
 */
package Interfaz;

public interface ITransaccion {
    void procesarStock();
    String generarComprobante();
}
