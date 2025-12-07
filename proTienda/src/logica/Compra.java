/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author ivans
 */
public class Compra extends Transaccion{
    private Proveedor proveedor;

    public Compra(Proveedor proveedor) {
        super();
        this.proveedor = proveedor;
    }
}
