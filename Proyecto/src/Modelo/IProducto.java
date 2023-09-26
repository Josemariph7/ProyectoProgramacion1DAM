package Modelo;

/**
 * La interfaz IProducto define los métodos que deben implementar las clases que
 * representan un producto.
 */
public interface IProducto {

	/**
	 * Busca el producto por nombre.
	 * 
	 * @param cadenaBusqueda la cadena de búsqueda para buscar el producto
	 * @return true si se encontró el producto, false de lo contrario
	 */
	public boolean buscarPorNombre ( String cadenaBusqueda );

	/**
	 * Obtiene la información completa del producto.
	 * 
	 * @return la información completa del producto
	 */
	public String obtenerInformacionCompleta ( );

}
