package Modelo;

/**
 * La clase Inventario representa el stock de un producto en un establecimiento.
 */
public class Inventario {

	private String id;
	private Establecimiento establecimiento;
	private Producto producto;
	private int cantidad;

	/**
	 * Constructor de la clase Inventario.
	 * 
	 * @param id              el ID del inventario
	 * @param establecimiento el establecimiento al que pertenece el
	 *                        inventario
	 * @param producto        el producto asociado al inventario
	 * @param cantidad        la cantidad disponible del producto en el
	 *                        inventario
	 */
	public Inventario ( String id, Establecimiento establecimiento, Producto producto, int cantidad ) {
		this.id = id;
		this.establecimiento = establecimiento;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Inventario ( ) {
		this.id = "0";
		this.establecimiento = null;
		this.producto = null;
		this.cantidad = 0;
	}

	/**
	 * Obtiene el ID del inventario.
	 * 
	 * @return el ID del inventario
	 */
	public String getId ( ) {
		return id;
	}

	/**
	 * Establece el ID del inventario.
	 * 
	 * @param id el ID del inventario
	 */
	public void setId ( String id ) {
		this.id = id;
	}

	/**
	 * Obtiene el establecimiento al que pertenece el inventario.
	 * 
	 * @return el establecimiento
	 */
	public Establecimiento getEstablecimiento ( ) {
		return establecimiento;
	}

	/**
	 * Establece el establecimiento al que pertenece el inventario.
	 * 
	 * @param establecimiento el establecimiento
	 */
	public void setEstablecimiento ( Establecimiento establecimiento ) {
		this.establecimiento = establecimiento;
	}

	/**
	 * Obtiene el producto asociado al inventario.
	 * 
	 * @return el producto
	 */
	public Producto getProducto ( ) {
		return producto;
	}

	/**
	 * Establece el producto asociado al inventario.
	 * 
	 * @param producto el producto
	 */
	public void setProducto ( Producto producto ) {
		this.producto = producto;
	}

	/**
	 * Obtiene la cantidad disponible del producto en el inventario.
	 * 
	 * @return la cantidad disponible
	 */
	public int getCantidad ( ) {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto en el inventario.
	 * 
	 * @param cantidad la cantidad disponible
	 */
	public void setCantidad ( int cantidad ) {
		this.cantidad = cantidad;
	}

}
