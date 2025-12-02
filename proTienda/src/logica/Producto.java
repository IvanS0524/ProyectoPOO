package logica;

public class Producto extends Entidad {
    private int enInventario;
    private double precioCompra;
    private double precioVenta;

    public Producto(){

        this.precioCompra = 0;
        this.precioVenta = 0;
        this.enInventario = 0;
    }
    public Producto(String nombre, Integer id, int enInventario, double precioCompra, double precioVenta) {
        super(nombre, id);
        this.enInventario = enInventario;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public int getEnInventario() {
        return enInventario;
    }
    public void setEnInventario(int enInventario) {
        if (enInventario < 0) {
            throw new IllegalArgumentException("La cantidad en inventario no puede ser negativa.");
        }
        this.enInventario = enInventario;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }
    public void setPrecioCompra(double precioCompra) {
        if (precioCompra < 0) {
            throw new IllegalArgumentException("El precio de compra no puede ser negativo.");
        }
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(double precioVenta) {
        if (precioVenta < 0) {
            throw new IllegalArgumentException("El precio de venta no puede ser negativo.");
        }
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "NOMBRE PRODUCTO: " + nombre + " | ID: " + id + " | EN INVENTARIO: " + enInventario + " | PRECIO COMPRA: " + precioCompra + " | PRECIO VENTA: " + precioVenta;
    }

}
