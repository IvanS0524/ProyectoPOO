package persistencia;

import Interfaz.IArchivo;
import logica.Tienda;

import java.io.*;

/**
 *
 * @author Ivan Sierra Arrieta 0222420035 - Carlos Romero 02224200 - Salomon Restrepo  
 */
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
            return new Tienda(); // Retorna una tienda nueva si no hay datos previos
        }

        // Usamos buffer para optimizar la lectura
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(archivo)))) {
            Object objeto = ois.readObject();
            return (Tienda) objeto;
        }
    }


}
