package Interfaz;

import logica.Tienda;

public interface IArchivo {
    void guardarEnArchivo(Tienda tienda) throws Exception;
    Tienda cargarDesdeArchivo() throws Exception;
}
