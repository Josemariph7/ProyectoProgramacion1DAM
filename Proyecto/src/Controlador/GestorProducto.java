package Controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Modelo.Producto;

/**
 * 
 * La clase GestorProducto implementa la interfaz CRUD para gestionar los
 * productos.
 */
public class GestorProducto implements CRUD <Producto> {

	private List <Producto> productos;

	/**
	 * 
	 * Crea una nueva instancia del GestorProducto.
	 */
	public GestorProducto ( ) {
		productos = new ArrayList <> ( );
	}

	@Override
	public boolean add ( Producto producto ) {
		return productos.add ( producto );
	}

	@Override
	public Producto search ( Producto producto ) {
		if ( productos.contains ( producto ) ) {
			return producto;
		}
		return null;
	}

	@Override
	public boolean update ( Producto producto ) {
		int index = productos.indexOf ( producto );
		if ( index != -1 ) {
			productos.set ( index, producto );
			return true;
		}
		return false;
	}

	@Override
	public boolean delete ( Producto producto ) {
		return productos.remove ( producto );
	}

	@Override
	public Iterator <Producto> listAll ( ) {
		return productos.iterator ( );
	}

	/**
	 * 
	 * Busca un producto por su nombre.
	 * 
	 * @param nombre el nombre del producto a buscar.
	 * @return el producto encontrado, o null si no se encuentra.
	 */
	public Producto searchByNombre ( String nombre ) {
		for ( Producto producto : productos ) {
			if ( producto.getNombre ( ).equalsIgnoreCase ( nombre ) ) {
				return producto;
			}
		}
		return null;
	}

	/**
	 * 
	 * Busca un producto por su ID.
	 * 
	 * @param id el ID del producto a buscar.
	 * @return el producto encontrado, o null si no se encuentra.
	 */
	public Producto buscarProductoPorId ( String id ) {
		for ( Producto producto : productos ) {
			if ( producto.getId ( ).equals ( id ) ) {
				return producto;
			}
		}
		return null;
	}

}