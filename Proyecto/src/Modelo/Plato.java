package Modelo;

/**
 * La clase Plato representa un plato de comida.
 */
public class Plato extends Producto {

	private boolean esVegetariano;
	private int calorias;

	/**
	 * Crea un objeto Plato con los detalles proporcionados.
	 *
	 * @param id            el ID del plato
	 * @param nombre        el nombre del plato
	 * @param descripcion   la descripción del plato
	 * @param precio        el precio del plato
	 * @param tipo          el tipo de producto del plato
	 * @param esVegetariano indica si el plato es vegetariano
	 * @param calorias      las calorías del plato
	 */
	public Plato ( String id, String nombre, String descripcion, double precio, TiposEnumerados.TipoProducto tipo, boolean esVegetariano, int calorias ) {
		super ( id, nombre, descripcion, precio, tipo );
		this.esVegetariano = esVegetariano;
		this.calorias = calorias;
	}

	/**
	 * Verifica si el plato es vegetariano.
	 *
	 * @return true si el plato es vegetariano, false de lo contrario
	 */
	public boolean getEsVegetariano ( ) {
		return esVegetariano;
	}

	/**
	 * Establece si el plato es vegetariano.
	 *
	 * @param esVegetariano true si el plato es vegetariano, false de lo
	 *                      contrario
	 */
	public void setEsVegetariano ( boolean esVegetariano ) {
		this.esVegetariano = esVegetariano;
	}

	/**
	 * Obtiene las calorías del plato.
	 *
	 * @return las calorías del plato
	 */
	public int getCalorias ( ) {
		return calorias;
	}

	/**
	 * Establece las calorías del plato.
	 *
	 * @param calorias las calorías del plato a establecer
	 */
	public void setCalorias ( int calorias ) {
		this.calorias = calorias;
	}

}