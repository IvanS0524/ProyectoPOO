/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Clase abstracta base para entidades del sistema (Producto, Cliente, Proveedor).
 * Define atributos comunes como nombre e identificador.
 * Implementa Serializable para permitir la persistencia de datos.
 */
package logica;

import java.io.Serializable;

public abstract class Entidad  implements Serializable {
    protected String nombre;
    protected Integer id;

    /**
     * Constructor por defecto.
     * Inicializa una entidad con valores predeterminados.
     */
    public Entidad() {
        this.nombre = "NN";
        this.id = 0;
    }
    /**
     * Constructor parametrizado que crea una entidad con nombre e ID.
     * @param nombre Nombre de la entidad
     * @param id Identificador único de la entidad
     * @throws IllegalArgumentException Si el nombre es nulo/vacío o el ID es inválido
     */
    public Entidad(String nombre, Integer id) {
        setNombre(nombre);
        setId(id);
    }

    /**
     * Obtiene el nombre de la entidad.
     * @return El nombre de la entidad
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre de la entidad.
     * @param nombre El nuevo nombre de la entidad
     * @throws IllegalArgumentException Si el nombre es nulo o está vacío
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío.");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador de la entidad.
     * @return El ID de la entidad
     */
    public Integer getId() {
        return id;
    }
    /**
     * Establece el identificador de la entidad.
     * @param id El nuevo ID de la entidad
     * @throws IllegalArgumentException Si el ID es nulo o negativo
     */
    public void setId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        if (id < 0) {
            throw new IllegalArgumentException("El ID no puede ser negativo.");
        }
        this.id = id;
    }

}