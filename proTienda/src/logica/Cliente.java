/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Clase que representa un cliente del sistema.
 * Hereda de Entidad y añade información de contacto telefónico.
 * Implementa validaciones para datos de clientes.
 */
package logica;

public class Cliente extends Entidad {
    private String telefono;

    /**
     * Constructor por defecto.
     */
    public Cliente() {
    }
    /**
     * Constructor parametrizado que crea un cliente completo.
     * @param nombre Nombre del cliente
     * @param id Identificador único del cliente
     * @param telefono Número telefónico del cliente
     * @throws IllegalArgumentException Si algún parámetro es inválido
     */
    public Cliente(String nombre, int id, String telefono) {
        super(nombre, id);
        setTelefono(telefono);
    }

    /**
     * Obtiene el número telefónico del cliente.
     * @return El teléfono del cliente
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * Establece el número telefónico del cliente.
     * @param telefono El nuevo número telefónico
     * @throws IllegalArgumentException Si el teléfono es nulo o vacío
     */
    public void setTelefono(String telefono) {
        if(telefono == null || telefono.isBlank()){
            throw new IllegalArgumentException("El teléfono no puede ser nulo ni vacío.");
        }
        this.telefono = telefono;
    }

    /**
     * Genera una representación en texto del cliente.
     * @return String con la información del cliente
     */
    @Override
    public String toString() {
        return "NOMBRE CLIENTE: " + nombre + " | ID: " + id + " | TELEFONO: " + telefono;
    }
}
