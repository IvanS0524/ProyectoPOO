/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author ivans
 */
public class Venta extends Transaccion{
    private Cliente cliente;

    public Venta(Cliente cliente) {
        super();
        this.cliente = cliente;
    }
}
