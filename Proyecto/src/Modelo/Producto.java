package Modelo;

public class Producto {

	private String id;
	private String nombre;
	private String descripcion;
	private double precio;
	private TiposEnumerados.TipoProducto tipo;

	/**
	 * Crea un objeto Producto con los detalles proporcionados.
	 *
	 * @param id          el ID del producto
	 * @param nombre      el nombre del producto
	 * @param descripcion la descripción del producto
	 * @param precio      el precio del producto
	 * @param tipo        el tipo de producto
	 */
	public Producto ( String id, String nombre, String descripcion, double precio, TiposEnumerados.TipoProducto tipo ) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tipo = tipo;
	}

	/**
	 * Crea un objeto Producto vacío.
	 */
	public Producto ( ) {
	}

	/**
	 * Crea un objeto Producto con el ID y la cantidad especificados.
	 *
	 * @param id       el ID del producto
	 * @param cantidad la cantidad del producto
	 */
	public Producto ( String id, int cantidad ) {
		// Aquí podrías establecer la cantidad en algún atributo si es
		// necesario
	}

	/**
	 * Obtiene el ID del producto.
	 *
	 * @return el ID del producto
	 */
	public String getId ( ) {
		return id;
	}

	/**
	 * Establece el ID del producto.
	 *
	 * @param id el ID del producto a establecer
	 */
	public void setId ( String id ) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del producto.
	 *
	 * @return el nombre del producto
	 */
	public String getNombre ( ) {
		return nombre;
	}

	/**
	 * Establece el nombre del producto.
	 *
	 * @param nombre el nombre del producto a establecer
	 */
	public void setNombre ( String nombre ) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la descripción del producto.
	 *
	 * @return la descripción del producto
	 */
	public String getDescripcion ( ) {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto.
	 *
	 * @param descripcion la descripción del producto a establecer
	 */
	public void setDescripcion ( String descripcion ) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene el precio del producto.
	 *
	 * @return el precio del producto
	 */
	public double getPrecio ( ) {
		return precio;
	}

	/**
	 * Establece el precio del producto.
	 *
	 * @param precio el precio del producto a establecer
	 */
	public void setPrecio ( double precio ) {
		this.precio = precio;
	}

	/**
	 * Obtiene el tipo de producto.
	 *
	 * @return el tipo de producto
	 */
	public TiposEnumerados.TipoProducto getTipo ( ) {
		return tipo;
	}

	/**
	 * Establece el tipo de producto.
	 *
	 * @param tipo el tipo de producto a establecer
	 */
	public void setTipo ( TiposEnumerados.TipoProducto tipo ) {
		this.tipo = tipo;
	}

	@Override
	public String toString ( ) {
		return "ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio;
	}

}