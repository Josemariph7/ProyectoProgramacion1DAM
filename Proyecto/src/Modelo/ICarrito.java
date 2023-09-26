package Modelo;

import java.util.List;

/**
 * 
 * La interfaz ICarrito define las operaciones que se pueden realizar en un
 * carrito de compras.
 */
public interface ICarrito {

	/**
	 * 
	 * Agrega un producto al carrito.
	 * 
	 * @param producto el producto a agregar.
	 */
	void agregarProducto ( Producto producto );
	/**
	 * 
	 * Elimina un producto del carrito.
	 * 
	 * @param producto el producto a eliminar.
	 */
	void eliminarProducto ( Producto producto );
	/**
	 * 
	 * Quita una unidad de un producto del carrito.
	 * 
	 * @param producto el producto del cual se va a quitar una unidad.
	 */
	void quitarUnidadProducto ( Producto producto );
	/**
	 * 
	 * Vacia el carrito, eliminando todos los productos.
	 */
	void vaciarCarrito ( );
	/**
	 * 
	 * Obtiene la lista de productos en el carrito.
	 * 
	 * @return la lista de productos en el carrito.
	 */
	List <Producto> getProductos ( );
	/**
	 * 
	 * Obtiene el total de la compra en el carrito.
	 * 
	 * @return el total de la compra.
	 */
	double getTotal ( );

}