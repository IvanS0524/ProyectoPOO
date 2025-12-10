/*
 * Proyecto: Sistema de Gestión de Inventario - Tienda Minorista
 * Integrantes:
 *   - Iván Sierra Arrieta (0222420035)
 *   - Carlos Romero Paternina (0222420028)
 *   - Salomón Restrepo Güette (0222410050)
 * 
 * Descripción:
 * Clase que representa un producto en el sistema de inventario.
 * Contiene información sobre stock, precios de compra y venta.
 * Implementa validaciones para garantizar la integridad de los datos.
 */
package logica;

public class Producto extends Entidad {
    private int stock;
    private double precioCompra;
    private double precioVenta;

    /**
     * Constructor por defecto.
     * Inicializa un producto con valores en cero.
     */
    public Producto(){
        this.precioCompra = 0;
        this.precioVenta = 0;
        this.stock = 0;
    }
    /**
     * Constructor parametrizado que crea un producto completo.
     * @param nombre Nombre del producto
     * @param id Identificador único del producto
     * @param stock Cantidad en inventario
     * @param precioCompra Precio al que se compra el producto
     * @param precioVenta Precio al que se vende el producto
     */
    public Producto(String nombre, Integer id, int stock, double precioCompra, double precioVenta) {
        super(nombre, id);
        this.stock = stock;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    /**
     * Obtiene la cantidad disponible en stock.
     * @return La cantidad en inventario
     */
    public int getStock() {
        return stock;
    }
    /**
     * Establece la cantidad en stock del producto.
     * @param stock La nueva cantidad en inventario
     * @throws IllegalArgumentException Si el stock es negativo
     */
    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("La cantidad en inventario no puede ser negativa.");
        }
        this.stock = stock;
    }

    /**
     * Obtiene el precio de compra del producto.
     * @return El precio al que se compra el producto
     */
    public double getPrecioCompra() {
        return precioCompra;
    }
    /**
     * Establece el precio de compra del producto.
     * @param precioCompra El nuevo precio de compra
     * @throws IllegalArgumentException Si el precio es negativo
     */
    public void setPrecioCompra(double precioCompra) {
        if (precioCompra < 0) {
            throw new IllegalArgumentException("El precio de compra no puede ser negativo.");
        }
        this.precioCompra = precioCompra;
    }

    /**
     * Obtiene el precio de venta del producto.
     * @return El precio al que se vende el producto
     */
    public double getPrecioVenta() {
        return precioVenta;
    }
    /**
     * Establece el precio de venta del producto.
     * @param precioVenta El nuevo precio de venta
     * @throws IllegalArgumentException Si el precio es negativo
     */
    public void setPrecioVenta(double precioVenta) {
        if (precioVenta < 0) {
            throw new IllegalArgumentException("El precio de venta no puede ser negativo.");
        }
        this.precioVenta = precioVenta;
    }

    /**
     * Genera una representación en texto del producto.
     * @return String con toda la información del producto
     */
    @Override
    public String toString() {
        return "NOMBRE PRODUCTO: " + 
        nombre + " | ID: " + 
        id + " | STOCK: " + 
        stock + 
        " | PRECIO COMPRA: " + 
        precioCompra + 
        " | PRECIO VENTA: " + 
        precioVenta;
    }

}
