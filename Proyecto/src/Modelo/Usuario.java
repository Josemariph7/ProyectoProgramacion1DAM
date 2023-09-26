package Modelo;

/**
 * 
 * Clase que representa un usuario del sistema.
 */
public class Usuario {

	private String id;
	private String nombre;
	private String direccion;
	private String email;
	private String telefono;
	private String contraseña;
	private boolean esAdmin;

	/**
	 * 
	 * Constructor de la clase Usuario.
	 * 
	 * @param id         ID del usuario.
	 * @param nombre     Nombre del usuario.
	 * @param direccion  Dirección del usuario.
	 * @param email      Email del usuario.
	 * @param telefono   Teléfono del usuario.
	 * @param contraseña Contraseña del usuario.
	 * @param esAdmin    Indica si el usuario es administrador.
	 */
	public Usuario ( String id, String nombre, String direccion, String email, String telefono, String contraseña, boolean esAdmin ) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.contraseña = contraseña;
		this.esAdmin = esAdmin;
	}

	/**
	 * 
	 * Constructor vacío de la clase Usuario.
	 */
	public Usuario ( ) {
	}

	/**
	 * 
	 * Obtiene el ID del usuario.
	 * 
	 * @return ID del usuario.
	 */
	public String getId ( ) {
		return id;
	}

	/**
	 * 
	 * Establece el ID del usuario.
	 * 
	 * @param id ID del usuario.
	 */
	public void setId ( String id ) {
		this.id = id;
	}

	/**
	 * 
	 * Verifica si el usuario es administrador.
	 * 
	 * @return true si el usuario es administrador, false de lo contrario.
	 */
	public boolean isEsAdmin ( ) {
		return esAdmin;
	}

	/**
	 * 
	 * Establece si el usuario es administrador.
	 * 
	 * @param esAdmin true si el usuario es administrador, false de lo
	 *                contrario.
	 */
	public void setEsAdmin ( boolean esAdmin ) {
		this.esAdmin = esAdmin;
	}

	/**
	 * 
	 * Obtiene el nombre del usuario.
	 * 
	 * @return Nombre del usuario.
	 */
	public String getNombre ( ) {
		return nombre;
	}

	/**
	 * 
	 * Establece el nombre del usuario.
	 * 
	 * @param nombre Nombre del usuario.
	 */
	public void setNombre ( String nombre ) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * Obtiene la dirección del usuario.
	 * 
	 * @return Dirección del usuario.
	 */
	public String getDireccion ( ) {
		return direccion;
	}

	/**
	 * 
	 * Establece la dirección del usuario.
	 * 
	 * @param direccion Dirección del usuario.
	 */
	public void setDireccion ( String direccion ) {
		this.direccion = direccion;
	}

	/**
	 * 
	 * Obtiene el email del usuario.
	 * 
	 * @return Email del usuario.
	 */
	public String getEmail ( ) {
		return email;
	}

	/**
	 * 
	 * Establece el email del usuario.
	 * 
	 * @param email Email del usuario.
	 */
	public void setEmail ( String email ) {
		this.email = email;
	}

	/**
	 * 
	 * Obtiene el teléfono del usuario.
	 * 
	 * @return Teléfono del usuario.
	 */
	public String getTelefono ( ) {
		return telefono;
	}

	/**
	 * 
	 * Establece el teléfono del usuario.
	 * 
	 * @param telefono Teléfono del usuario.
	 */
	public void setTelefono ( String telefono ) {
		this.telefono = telefono;
	}

	/**
	 * 
	 * Obtiene la contraseña del usuario.
	 * 
	 * @return Contraseña del usuario.
	 */
	public String getContraseña ( ) {
		return contraseña;
	}

	/**
	 * 
	 * Establece la contraseña del usuario.
	 * 
	 * @param contraseña Contraseña del usuario.
	 */
	public void setContraseña ( String contraseña ) {
		this.contraseña = contraseña;
	}

	/**
	 * 
	 * Verifica si el usuario es administrador.
	 * 
	 * @return true si el usuario es administrador, false de lo contrario.
	 */
	public boolean esAdmin ( ) {
		return esAdmin;
	}

	/**
	 * 
	 * Establece si el usuario es administrador.
	 * 
	 * @param esAdmin true si el usuario es administrador, false de lo
	 *                contrario.
	 */
	public void setAdmin ( boolean esAdmin ) {
		this.esAdmin = esAdmin;
	}

}
