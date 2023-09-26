package Modelo;

/**
 * La clase Medicamento representa un medicamento que es un tipo de producto.
 */
public class Medicamento extends Producto {

	private TiposEnumerados.TipoMedicamento tipo;
	private String marca;

	/**
	 * Crea un objeto Medicamento con los detalles proporcionados.
	 *
	 * @param id           el ID del medicamento
	 * @param nombre       el nombre del medicamento
	 * @param descripcion  la descripción del medicamento
	 * @param precio       el precio del medicamento
	 * @param tipoproducto el tipo de producto del medicamento
	 * @param tipo         el tipo de medicamento
	 * @param marca        la marca del medicamento
	 */
	public Medicamento ( String id, String nombre, String descripcion, double precio, TiposEnumerados.TipoProducto tipoproducto, TiposEnumerados.TipoMedicamento tipo, String marca ) {
		super ( id, nombre, descripcion, precio, tipoproducto );
		this.tipo = tipo;
		this.marca = marca;
	}

	/**
	 * Obtiene el tipo de medicamento.
	 *
	 * @return el tipo de medicamento
	 */
	public TiposEnumerados.TipoMedicamento getTipoMedicamento ( ) {
		return tipo;
	}

	/**
	 * Establece el tipo de medicamento.
	 *
	 * @param tipoMedicamento el tipo de medicamento a establecer
	 */
	public void setTipoMedicamento ( TiposEnumerados.TipoMedicamento tipoMedicamento ) {
		this.tipo = tipoMedicamento;
	}

	/**
	 * Obtiene la marca del medicamento.
	 *
	 * @return la marca del medicamento
	 */
	public String getMarca ( ) {
		return marca;
	}

	/**
	 * Establece la marca del medicamento.
	 *
	 * @param marca la marca del medicamento a establecer
	 */
	public void setMarca ( String marca ) {
		this.marca = marca;
	}

}