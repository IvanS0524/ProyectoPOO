/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import Interfaz.ITransaccion;

/**
 *
 * @author ivans
 */
public class Compra extends Transaccion implements ITransaccion{
    private Proveedor proveedor;

    public Compra(Proveedor proveedor) {
        super();
        this.proveedor = proveedor;
    }

    @Override
    public void procesarStock() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String generarComprobante() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
