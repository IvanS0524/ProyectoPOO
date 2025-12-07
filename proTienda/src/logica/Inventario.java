/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ivans
 */
public class Inventario {
    private ArrayList<Producto> productos;
    
    public Inventario(){
       productos = new ArrayList();
    }
    
    public boolean addProducto(Producto p){
        return productos.add(p);
    }
    public void eliminarProducto(Producto p){
        
    }
    
    public ArrayList<Producto> getProductos(){
        
        return productos;
    }
    
    public String listarProductos(){
        StringBuilder sb = new StringBuilder();
        if (productos.isEmpty()) return null;
        
        return "ssss";
    }
    
    public void guardarEnArchivo(String nombreArchivo) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(productos); // serializa todo el ArrayList
        }
    }
    
    public void cargarDesdeArchivo(String nombreArchivo)throws IOException, ClassNotFoundException {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            // Si no existe, iniciamos con lista vacía y no es error
            productos = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                productos = (ArrayList<Producto>) obj;
            } else {
                throw new IOException("El archivo no contiene una lista de productos válida.");
            }
        }
        
    }
}
