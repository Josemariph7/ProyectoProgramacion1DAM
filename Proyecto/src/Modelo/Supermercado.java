package Modelo;

import java.util.HashMap;

public class Supermercado extends Establecimiento {

	private HashMap <String, Double> ofertas;
	private int puntuacion;

	/**
	 * Crea un objeto Supermercado con los detalles proporcionados.
	 *
	 * @param id         el ID del supermercado
	 * @param nombre     el nombre del supermercado
	 * @param direccion  la dirección del supermercado
	 * @param inventario el inventario del supermercado
	 * @param tipo       el tipo de establecimiento del supermercado
	 * @param ofertas    las ofertas del supermercado
	 * @param puntuacion la puntuación del supermercado
	 */
	public Supermercado ( String id, String nombre, String direccion, Inventario inventario, TiposEnumerados.TipoEstablecimiento tipo, HashMap <String, Double> ofertas, int puntuacion ) {
		super ( id, nombre, direccion, tipo );
		this.ofertas = ofertas;
		this.puntuacion = puntuacion;
	}

	/**
	 * Crea un objeto Supermercado vacío.
	 */
	public Supermercado ( ) {
		super ( );
	}

	/**
	 * Crea un objeto Supermercado con los detalles básicos proporcionados.
	 *
	 * @param id         el ID del supermercado
	 * @param nombre     el nombre del supermercado
	 * @param direccion  la dirección del supermercado
	 * @param inventario el inventario del supermercado
	 * @param tipo       el tipo de establecimiento del supermercado
	 */
	public Supermercado ( String id, String nombre, String direccion, Inventario inventario, TiposEnumerados.TipoEstablecimiento tipo ) {
		super ( id, nombre, direccion, tipo );
	}

	/**
	 * Obtiene las ofertas del supermercado.
	 *
	 * @return las ofertas del supermercado
	 */
	public HashMap <String, Double> getOfertas ( ) {
		return ofertas;
	}

	/**
	 * Establece las ofertas del supermercado.
	 *
	 * @param ofertas las ofertas del supermercado a establecer
	 */
	public void setOfertas ( HashMap <String, Double> ofertas ) {
		this.ofertas = ofertas;
	}

	/**
	 * Obtiene la puntuación del supermercado.
	 *
	 * @return la puntuación del supermercado
	 */
	public int getPuntuacion ( ) {
		return puntuacion;
	}

	/**
	 * Establece la puntuación del supermercado.
	 *
	 * @param puntuacion la puntuación del supermercado a establecer
	 */
	public void setPuntuacion ( int puntuacion ) {
		this.puntuacion = puntuacion;
	}

}
