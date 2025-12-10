/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Excepción personalizada para valores ilegales en el sistema.
 * Extiende RuntimeException para manejo de errores no verificados.
 */
package exceptions;

public class IlegalValueException extends RuntimeException {
    public IlegalValueException(String message) {
        super(message);
    }
}
