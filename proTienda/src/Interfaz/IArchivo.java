/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Interfaz que define el contrato para operaciones de persistencia de datos.
 * Implementa el principio de Inversión de Dependencias SOLID
 */
package Interfaz;

import logica.Tienda;

public interface IArchivo {
    void guardarEnArchivo(Tienda tienda) throws Exception;
    Tienda cargarDesdeArchivo() throws Exception;
}
