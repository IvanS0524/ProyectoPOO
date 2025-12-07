package logica;

import java.io.Serializable;

public abstract class Entidad  implements Serializable {
    protected String nombre;
    protected Integer id;

    public Entidad() {
        this.nombre = "NN";
        this.id = 0;
    }
    public Entidad(String nombre, Integer id) {
        setNombre(nombre);
        setId(id);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío.");
        }
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }
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