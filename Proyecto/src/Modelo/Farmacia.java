package Modelo;

/**
 * 
 * La clase Farmacia es una subclase de Establecimiento y representa una
 * farmacia.
 */
public class Farmacia extends Establecimiento {

	private boolean tieneTelefonoConsulta;
	private String numeroTelefonoConsulta;

	/**
	 * 
	 * Crea una nueva instancia de Farmacia sin valores iniciales.
	 */
	public Farmacia ( ) {
		super ( );
	}

	/**
	 * 
	 * Crea una nueva instancia de Farmacia con los valores especificados.
	 * 
	 * @param id                     el ID de la farmacia.
	 * @param nombre                 el nombre de la farmacia.
	 * @param direccion              la dirección de la farmacia.
	 * @param inventario             el inventario de la farmacia.
	 * @param tipo                   el tipo de establecimiento de la
	 *                               farmacia.
	 * @param tieneTelefonoConsulta  indica si la farmacia tiene servicio de
	 *                               consulta telefónica.
	 * @param numeroTelefonoConsulta el número de teléfono de consulta de la
	 *                               farmacia.
	 */
	public Farmacia ( String id, String nombre, String direccion, Inventario inventario, TiposEnumerados.TipoEstablecimiento tipo, boolean tieneTelefonoConsulta, String numeroTelefonoConsulta ) {
		super ( id, nombre, direccion, tipo );
		this.tieneTelefonoConsulta = tieneTelefonoConsulta;
		this.numeroTelefonoConsulta = numeroTelefonoConsulta;
	}

	/**
	 * 
	 * Indica si la farmacia tiene servicio de consulta telefónica.
	 * 
	 * @return true si la farmacia tiene servicio de consulta telefónica,
	 *         false de lo contrario.
	 */
	public boolean isTieneTelefonoConsulta ( ) {
		return tieneTelefonoConsulta;
	}

	/**
	 * 
	 * Establece si la farmacia tiene servicio de consulta telefónica.
	 * 
	 * @param tieneTelefonoConsulta true si la farmacia tiene servicio de
	 *                              consulta telefónica, false de lo
	 *                              contrario.
	 */
	public void setTieneTelefonoConsulta ( boolean tieneTelefonoConsulta ) {
		this.tieneTelefonoConsulta = tieneTelefonoConsulta;
	}

	/**
	 * 
	 * Devuelve el número de teléfono de consulta de la farmacia.
	 * 
	 * @return el número de teléfono de consulta de la farmacia.
	 */
	public String getNumeroTelefonoConsulta ( ) {
		return numeroTelefonoConsulta;
	}

	/**
	 * 
	 * Establece el número de teléfono de consulta de la farmacia.
	 * 
	 * @param numeroTelefonoConsulta el número de teléfono de consulta de la
	 *                               farmacia a establecer.
	 */
	public void setNumeroTelefonoConsulta ( String numeroTelefonoConsulta ) {
		this.numeroTelefonoConsulta = numeroTelefonoConsulta;
	}

}
