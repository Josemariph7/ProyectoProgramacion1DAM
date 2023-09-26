package Modelo;

import java.time.LocalDate;

public class ProductoSupermercado extends Producto {

	private TiposEnumerados.TipoProductoSupermercado tipo;
	private String marca;
	private LocalDate fechaCaducidad;

	/**
	 * Crea un objeto ProductoSupermercado con los detalles proporcionados.
	 *
	 * @param id             el ID del producto
	 * @param nombre         el nombre del producto
	 * @param descripcion    la descripción del producto
	 * @param precio         el precio del producto
	 * @param tipoProducto   el tipo de producto general
	 * @param tipo           el tipo de producto específico para supermercado
	 * @param marca          la marca del producto
	 * @param fechaCaducidad la fecha de caducidad del producto
	 */
	public ProductoSupermercado ( String id, String nombre, String descripcion, double precio, TiposEnumerados.TipoProducto tipoProducto, TiposEnumerados.TipoProductoSupermercado tipo, String marca, LocalDate fechaCaducidad ) {
		super ( id, nombre, descripcion, precio, tipoProducto );
		this.tipo = tipo;
		this.marca = marca;
		this.fechaCaducidad = fechaCaducidad;
	}

	/**
	 * Obtiene el tipo de producto específico para supermercado.
	 *
	 * @return el tipo de producto específico para supermercado
	 */
	public TiposEnumerados.TipoProductoSupermercado getTipoProducto ( ) {
		return tipo;
	}

	/**
	 * Establece el tipo de producto específico para supermercado.
	 *
	 * @param tipo el tipo de producto específico para supermercado a
	 *             establecer
	 */
	public void setTipoProducto ( TiposEnumerados.TipoProductoSupermercado tipo ) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene la marca del producto.
	 *
	 * @return la marca del producto
	 */
	public String getMarca ( ) {
		return marca;
	}

	/**
	 * Establece la marca del producto.
	 *
	 * @param marca la marca del producto a establecer
	 */
	public void setMarca ( String marca ) {
		this.marca = marca;
	}

	/**
	 * Obtiene la fecha de caducidad del producto.
	 *
	 * @return la fecha de caducidad del producto
	 */
	public LocalDate getFechaCaducidad ( ) {
		return fechaCaducidad;
	}

	/**
	 * Establece la fecha de caducidad del producto.
	 *
	 * @param fechaCaducidad la fecha de caducidad del producto a establecer
	 */
	public void setFechaCaducidad ( LocalDate fechaCaducidad ) {
		this.fechaCaducidad = fechaCaducidad;
	}

}