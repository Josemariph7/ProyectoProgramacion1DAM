package Controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Modelo.Inventario;

/**
 * 
 * La clase GestorInventario implementa la interfaz CRUD para gestionar el
 * inventario.
 */
public class GestorInventario implements CRUD <Inventario> {

	private List <Inventario> inventario;

	/**
	 * 
	 * Crea una nueva instancia del GestorInventario.
	 */
	public GestorInventario ( ) {
		inventario = new ArrayList <> ( );
	}

	@Override
	public boolean add ( Inventario inventario ) {
		return this.inventario.add ( inventario );
	}

	@Override
	public Inventario search ( Inventario inventario ) {
		int index = this.inventario.indexOf ( inventario );
		if ( index != -1 ) {
			return this.inventario.get ( index );
		}
		return null;
	}

	@Override
	public boolean update ( Inventario inventario ) {
		int index = this.inventario.indexOf ( inventario );
		if ( index != -1 ) {
			this.inventario.set ( index, inventario );
			return true;
		}
		return false;
	}

	@Override
	public boolean delete ( Inventario inventario ) {
		return this.inventario.remove ( inventario );
	}

	@Override
	public Iterator <Inventario> listAll ( ) {
		return this.inventario.iterator ( );
	}

	@Override
	public Inventario searchByNombre ( String nombre ) {
		for ( Inventario inventario : this.inventario ) {
			if ( inventario.getProducto ( ).getNombre ( ).equals ( nombre ) ) {
				return inventario;
			}
		}
		return null;
	}

	/**
	 * 
	 * Busca un inventario por su ID de establecimiento.
	 * 
	 * @param id el ID del establecimiento asociado al inventario.
	 * @return el inventario encontrado, o null si no se encuentra.
	 */
	public Inventario buscarInventarioPorId ( String id ) {
		for ( Inventario inventario : this.inventario ) {
			if ( inventario.getEstablecimiento ( ).getId ( ).equals ( id ) ) {
				return inventario;
			}
		}
		return null;
	}

}