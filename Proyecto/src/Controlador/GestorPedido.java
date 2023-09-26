package Controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Modelo.Pedido;
import Modelo.Producto;

/**
 * 
 * La clase GestorPedido implementa la interfaz CRUD para gestionar los pedidos.
 */
public class GestorPedido implements CRUD <Pedido> {

	private List <Pedido> pedidos;

	/**
	 * 
	 * Crea una nueva instancia del GestorPedido.
	 */
	public GestorPedido ( ) {
		pedidos = new ArrayList <> ( );
	}

	@Override
	public boolean add ( Pedido pedido ) {
		return pedidos.add ( pedido );
	}

	@Override
	public Pedido search ( Pedido pedido ) {
		if ( pedidos.contains ( pedido ) ) {
			return pedido;
		}
		return null;
	}

	@Override
	public boolean update ( Pedido pedido ) {
		int index = pedidos.indexOf ( pedido );
		if ( index != -1 ) {
			pedidos.set ( index, pedido );
			return true;
		}
		return false;
	}

	@Override
	public boolean delete ( Pedido pedido ) {
		return pedidos.remove ( pedido );
	}

	@Override
	public Iterator <Pedido> listAll ( ) {
		return pedidos.iterator ( );
	}

	/**
	 * 
	 * Busca un producto por su ID en los pedidos.
	 * 
	 * @param id el ID del producto a buscar.
	 * @return el producto encontrado, o null si no se encuentra.
	 */
	public Producto buscarProductoPorId ( String id ) {
		for ( Pedido pedido : pedidos ) {
			for ( Producto producto : pedido.getCarrito ( ).getProductos ( ) ) {
				if ( producto.getId ( ).equals ( id ) ) {
					return producto;
				}
			}
		}
		return null;
	}

	@Override
	public Pedido searchByNombre ( String nombre ) {
		// TODO: Implementar el método de búsqueda por nombre
		return null;
	}

}