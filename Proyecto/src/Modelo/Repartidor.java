package Modelo;

public class Repartidor {

	private String id;
	private String nombre;
	private String apellido;
	private String telefono;

	/**
	 * Crea un objeto Repartidor con los detalles proporcionados.
	 *
	 * @param id       el ID del repartidor
	 * @param nombre   el nombre del repartidor
	 * @param apellido el apellido del repartidor
	 * @param telefono el número de teléfono del repartidor
	 */
	public Repartidor ( String id, String nombre, String apellido, String telefono ) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public Repartidor ( ) {
	}

	/**
	 * Obtiene el ID del repartidor.
	 *
	 * @return el ID del repartidor
	 */
	public String getId ( ) {
		return id;
	}

	/**
	 * Establece el ID del repartidor.
	 *
	 * @param id el ID del repartidor a establecer
	 */
	public void setId ( String id ) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del repartidor.
	 *
	 * @return el nombre del repartidor
	 */
	public String getNombre ( ) {
		return nombre;
	}

	/**
	 * Establece el nombre del repartidor.
	 *
	 * @param nombre el nombre del repartidor a establecer
	 */
	public void setNombre ( String nombre ) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el apellido del repartidor.
	 *
	 * @return el apellido del repartidor
	 */
	public String getApellido ( ) {
		return apellido;
	}

	/**
	 * Establece el apellido del repartidor.
	 *
	 * @param apellido el apellido del repartidor a establecer
	 */
	public void setApellido ( String apellido ) {
		this.apellido = apellido;
	}

	/**
	 * Obtiene el número de teléfono del repartidor.
	 *
	 * @return el número de teléfono del repartidor
	 */
	public String getTelefono ( ) {
		return telefono;
	}

	/**
	 * Establece el número de teléfono del repartidor.
	 *
	 * @param telefono el número de teléfono del repartidor a establecer
	 */
	public void setTelefono ( String telefono ) {
		this.telefono = telefono;
	}

	@Override
	public String toString ( ) {
		return "Repartidor{" + "id='" + id + '\'' + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\''
		+ ", telefono='" + telefono + '\'' + '}';
	}

}