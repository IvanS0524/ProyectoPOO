/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Implementación de IArchivo para persistencia en archivos binarios.
 * Utiliza serialización de objetos Java para guardar/cargar el estado de la tienda.
 */
package persistencia;

import Interfaz.IArchivo;
import java.io.*;
import logica.Tienda;

public class Archivo implements IArchivo {
    private String nombreArchivo;

    public  Archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void guardarEnArchivo(Tienda tienda) throws ClassNotFoundException, IOException{
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(nombreArchivo)))) {
            oos.writeObject(tienda);
        }
    }
    @Override
    public Tienda cargarDesdeArchivo() throws ClassNotFoundException, IOException{
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            return new Tienda();
        }
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(archivo)))) {
            Object objeto = ois.readObject();
            return (Tienda) objeto;
        }
    }


}
