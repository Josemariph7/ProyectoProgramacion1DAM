package Modelo;

public class Restaurante extends Establecimiento {

	private int puntuacion;
	private String tipoCocina;

	/**
	 * Crea un objeto Restaurante con los detalles proporcionados.
	 *
	 * @param id         el ID del restaurante
	 * @param nombre     el nombre del restaurante
	 * @param direccion  la dirección del restaurante
	 * @param inventario el inventario del restaurante
	 * @param tipo       el tipo de establecimiento del restaurante
	 * @param puntuacion la puntuación del restaurante
	 * @param tipoCocina el tipo de cocina del restaurante
	 */
	public Restaurante ( String id, String nombre, String direccion, Inventario inventario, TiposEnumerados.TipoEstablecimiento tipo, int puntuacion, String tipoCocina ) {
		super ( id, nombre, direccion, tipo );
		this.puntuacion = puntuacion;
		this.tipoCocina = tipoCocina;
	}

	/**
	 * Crea un objeto Restaurante vacío.
	 */
	public Restaurante ( ) {
		super ( );
	}

	/**
	 * Crea un objeto Restaurante con los detalles básicos proporcionados.
	 *
	 * @param id         el ID del restaurante
	 * @param nombre     el nombre del restaurante
	 * @param direccion  la dirección del restaurante
	 * @param inventario el inventario del restaurante
	 * @param tipo       el tipo de establecimiento del restaurante
	 */
	public Restaurante ( String id, String nombre, String direccion, Inventario inventario, TiposEnumerados.TipoEstablecimiento tipo ) {
		super ( id, nombre, direccion, tipo );
	}

	/**
	 * Obtiene la puntuación del restaurante.
	 *
	 * @return la puntuación del restaurante
	 */
	public int getPuntuacion ( ) {
		return puntuacion;
	}

	/**
	 * Establece la puntuación del restaurante.
	 *
	 * @param puntuacion la puntuación del restaurante a establecer
	 */
	public void setPuntuacion ( int puntuacion ) {
		this.puntuacion = puntuacion;
	}

	/**
	 * Obtiene el tipo de cocina del restaurante.
	 *
	 * @return el tipo de cocina del restaurante
	 */
	public String getTipoCocina ( ) {
		return tipoCocina;
	}

	/**
	 * Establece el tipo de cocina del restaurante.
	 *
	 * @param tipoCocina el tipo de cocina del restaurante a establecer
	 */
	public void setTipoCocina ( String tipoCocina ) {
		this.tipoCocina = tipoCocina;
	}

}
