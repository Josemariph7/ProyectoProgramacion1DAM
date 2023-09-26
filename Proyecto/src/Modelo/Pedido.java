package Modelo;

/**
 * La clase Pedido representa un pedido realizado por un usuario.
 */
public class Pedido {

	private String id;
	private String idUsuario;
	private String idRepartidor;
	private TiposEnumerados.MetodoPago metodoPago;
	private Carrito carrito;
	private double total;

	/**
	 * Crea un objeto Pedido con los detalles proporcionados.
	 *
	 * @param id           el ID del pedido
	 * @param idUsuario    el ID del usuario que realizó el pedido
	 * @param idRepartidor el ID del repartidor asignado al pedido
	 * @param metodoPago   el método de pago utilizado para el pedido
	 * @param carrito      el carrito que contiene los productos del pedido
	 * @param total        el total del pedido
	 */
	public Pedido ( String id, String idUsuario, String idRepartidor, TiposEnumerados.MetodoPago metodoPago, Carrito carrito, double total ) {
		this.id = id;
		this.idUsuario = idUsuario;
		this.idRepartidor = idRepartidor;
		this.metodoPago = metodoPago;
		this.carrito = carrito;
		this.total = total;
	}

	public Pedido ( ) {
	}

	/**
	 * Obtiene el total del pedido.
	 *
	 * @return el total del pedido
	 */
	public double getTotal ( ) {
		return total;
	}

	/**
	 * Establece el total del pedido.
	 *
	 * @param total el total del pedido a establecer
	 */
	public void setTotal ( double total ) {
		this.total = total;
	}

	/**
	 * Obtiene el ID del pedido.
	 *
	 * @return el ID del pedido
	 */
	public String getId ( ) {
		return id;
	}

	/**
	 * Establece el ID del pedido.
	 *
	 * @param id el ID del pedido a establecer
	 */
	public void setId ( String id ) {
		this.id = id;
	}

	/**
	 * Obtiene el ID del usuario que realizó el pedido.
	 *
	 * @return el ID del usuario
	 */
	public String getIdUsuario ( ) {
		return idUsuario;
	}

	/**
	 * Establece el ID del usuario que realizó el pedido.
	 *
	 * @param idUsuario el ID del usuario a establecer
	 */
	public void setIdUsuario ( String idUsuario ) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Obtiene el ID del repartidor asignado al pedido.
	 *
	 * @return el ID del repartidor
	 */
	public String getIdRepartidor ( ) {
		return idRepartidor;
	}

	/**
	 * Establece el ID del repartidor asignado al pedido.
	 *
	 * @param idRepartidor el ID del repartidor a establecer
	 */
	public void setIdRepartidor ( String idRepartidor ) {
		this.idRepartidor = idRepartidor;
	}

	/**
	 * Obtiene el método de pago utilizado para el pedido.
	 *
	 * @return el método de pago
	 */
	public TiposEnumerados.MetodoPago getMetodoPago ( ) {
		return metodoPago;
	}

	/**
	 * Establece el método de pago utilizado para el pedido.
	 *
	 * @param metodoPago el método de pago a establecer
	 */
	public void setMetodoPago ( TiposEnumerados.MetodoPago metodoPago ) {
		this.metodoPago = metodoPago;
	}

	/**
	 * Obtiene el carrito que contiene los productos del pedido.
	 *
	 * @return el carrito del pedido
	 */
	public Carrito getCarrito ( ) {
		return carrito;
	}

	/**
	 * Establece el carrito del pedido.
	 *
	 * @param carrito el carrito a establecer
	 */
	public void setCarrito ( Carrito carrito ) {
		this.carrito = carrito;
	}

	@Override
	public String toString ( ) {
		return "Pedido [id=" + id + ", idUsuario=" + idUsuario + ", idRepartidor=" + idRepartidor + ", metodoPago="
		+ metodoPago + ", carrito=" + carrito + ", total=" + total + "]";
	}

}
