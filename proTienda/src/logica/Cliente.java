/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.io.*;

/**
 *
 * @author ivans
 */
public class Cliente extends Entidad {
    private String telefono;

    public Cliente() {
    }
    public Cliente(String nombre, int id, String telefono) {
        super(nombre, id);
        setTelefono(telefono);
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        if(telefono == null || telefono.isBlank()){
            throw new IllegalArgumentException("El teléfono no puede ser nulo ni vacío.");
        }
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "NOMBRE CLIENTE: " + nombre + " | ID: " + id + " | TELEFONO: " + telefono;
    }
}
