/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Clase que representa un proveedor en el sistema
 * Hereda de Entidad y añade información de contacto
 * Se utiliza en las transacciones de compra de productos
 */
package logica;

public class Proveedor extends Entidad {
    private String email;

    /**
     * Constructor por defecto.
     */
    public Proveedor() {
    }
    /**
     * Constructor parametrizado que crea un proveedor completo.
     * @param nombre Nombre del proveedor
     * @param id Identificador único del proveedor
     * @param email Correo electrónico del proveedor
     * @throws IllegalArgumentException Si algún parámetro es inválido
     */
    public Proveedor(String nombre, Integer id, String email) {
        super(nombre, id);
        setEmail(email);
    }

    /**
     * Obtiene el correo electrónico del proveedor.
     * @return El email del proveedor
     */
    public String getEmail() {
        return email;
    }
    /**
     * Establece el correo electrónico del proveedor.
     * Valida el formato del email antes de asignarlo.
     * @param email El nuevo correo electrónico
     * @throws IllegalArgumentException Si el email es nulo, vacío o tiene formato inválido
     */
    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email no puede ser nulo ni vacío.");
        }
        String c = email.trim();
        if (!c.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("Formato de correo inválido: " + email);
        }
        this.email = email;
    }

    /**
     * Genera una representación en texto del proveedor.
     * @return String con la información del proveedor
     */
    @Override
    public String toString() {
        return "NOMBRE PROVEEDOR: " + nombre + " | ID: " + id + " | EMAIL: " + email;
    }

}
