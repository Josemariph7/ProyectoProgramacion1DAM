package Modelo;

/**
 * 
 * Clase que contiene los tipos enumerados utilizados en el sistema.
 */
public class TiposEnumerados {

	/**
	 * 
	 * Enumerado que representa los tipos de establecimiento disponibles.
	 */
	public enum TipoEstablecimiento {
		FARMACIA, RESTAURANTE, SUPERMERCADO
	}

	/**
	 * 
	 * Enumerado que representa los tipos de medicamento disponibles.
	 */
	public enum TipoMedicamento {
		ANTIBIOTICO, ANALGESICO, ANTIHISTAMINICO, ANTIINFLAMATORIO
	}

	/**
	 * 
	 * Enumerado que representa los tipos de producto disponibles.
	 */
	public enum TipoProducto {
		PLATO, MEDICAMENTO, PRODUCTOSUPERMERCADO
	}

	/**
	 * 
	 * Enumerado que representa los tipos de producto disponibles en
	 * supermercados.
	 */
	public enum TipoProductoSupermercado {
		PRECOCINADOS, BEBIDAS, PANADERIA, CARNICERIA, PESCADERIA, CONGELADOS, VEGETALES, HIGIENE, LIMPIEZA, MASCOTAS, INFANTIL
	}

	/**
	 * 
	 * Enumerado que representa los métodos de pago disponibles.
	 */
	public enum MetodoPago {
		EFECTIVO, TARJETA_CREDITO, BIZUM, PAYPAL
	}

}