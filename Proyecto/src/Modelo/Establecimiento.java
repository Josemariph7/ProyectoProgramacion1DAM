package Modelo;

/**
 * 
 * La clase Establecimiento representa un establecimiento.
 */
public class Establecimiento {

	protected String id;
	protected String nombre;
	protected String direccion;
	protected Inventario inventario;
	protected TiposEnumerados.TipoEstablecimiento tipo;

	/**
	 * 
	 * Crea una nueva instancia de Establecimiento con los valores
	 * especificados.
	 * 
	 * @param id        el ID del establecimiento.
	 * @param nombre    el nombre del establecimiento.
	 * @param direccion la dirección del establecimiento.
	 * @param tipo      el tipo de establecimiento.
	 */
	public Establecimiento ( String id, String nombre, String direccion, TiposEnumerados.TipoEstablecimiento tipo ) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tipo = tipo;
	}

	/**
	 * 
	 * Crea una nueva instancia de Establecimiento sin valores iniciales.
	 */
	public Establecimiento ( ) {
	}

	/**
	 * 
	 * Devuelve el ID del establecimiento.
	 * 
	 * @return el ID del establecimiento.
	 */
	public String getId ( ) {
		return id;
	}

	/**
	 * 
	 * Establece el ID del establecimiento.
	 * 
	 * @param id el ID del establecimiento a establecer.
	 */
	public void setId ( String id ) {
		this.id = id;
	}

	/**
	 * 
	 * Devuelve el nombre del establecimiento.
	 * 
	 * @return el nombre del establecimiento.
	 */
	public String getNombre ( ) {
		return nombre;
	}

	/**
	 * 
	 * Establece el nombre del establecimiento.
	 * 
	 * @param nombre el nombre del establecimiento a establecer.
	 */
	public void setNombre ( String nombre ) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * Devuelve la dirección del establecimiento.
	 * 
	 * @return la dirección del establecimiento.
	 */
	public String getDireccion ( ) {
		return direccion;
	}

	/**
	 * 
	 * Establece la dirección del establecimiento.
	 * 
	 * @param direccion la dirección del establecimiento a establecer.
	 */
	public void setDireccion ( String direccion ) {
		this.direccion = direccion;
	}

	/**
	 * 
	 * Devuelve el tipo de establecimiento.
	 * 
	 * @return el tipo de establecimiento.
	 */
	public TiposEnumerados.TipoEstablecimiento getTipo ( ) {
		return tipo;
	}

	/**
	 * 
	 * Establece el tipo de establecimiento.
	 * 
	 * @param tipo el tipo de establecimiento a establecer.
	 */
	public void setTipo ( TiposEnumerados.TipoEstablecimiento tipo ) {
		this.tipo = tipo;
	}

	@Override
	public String toString ( ) {
		return "Establecimiento{" + "id='" + id + "" + ", nombre='" + nombre + "" + ", direccion='" + direccion + ""
		+ ", inventario=" + inventario + ", tipo=" + tipo + '}';
	}

}