package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * La clase Carrito implementa la interfaz ICarrito y representa un carrito de
 * compras.
 */
public class Carrito implements ICarrito {

	private List <Producto> productos;

	/**
	 * 
	 * Crea una nueva instancia del Carrito.
	 */
	public Carrito ( ) {
		productos = new ArrayList <> ( );
	}

	@Override
	public void agregarProducto ( Producto producto ) {
		productos.add ( producto );
	}

	@Override
	public void eliminarProducto ( Producto producto ) {
		productos.remove ( producto );
	}

	@Override
	public void quitarUnidadProducto ( Producto producto ) {
		productos.remove ( producto );
	}

	@Override
	public void vaciarCarrito ( ) {
		productos.clear ( );
	}

	@Override
	public List <Producto> getProductos ( ) {
		return productos;
	}

	@Override
	public double getTotal ( ) {
		double total = 0;
		for ( Producto producto : productos ) {
			total += producto.getPrecio ( );
		}
		return total;
	}

	/**
	 * 
	 * Verifica si el carrito contiene un producto específico.
	 * 
	 * @param producto el producto a verificar.
	 * @return true si el carrito contiene el producto, false en caso
	 *         contrario.
	 */
	public boolean contieneProducto ( Producto producto ) {
		return productos.contains ( producto );
	}

}