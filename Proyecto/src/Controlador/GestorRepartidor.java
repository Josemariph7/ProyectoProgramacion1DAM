package Controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Modelo.Repartidor;

/**
 * 
 * La clase GestorRepartidor implementa la interfaz CRUD para gestionar los
 * repartidores.
 */
public class GestorRepartidor implements CRUD <Repartidor> {

	private List <Repartidor> repartidores;

	/**
	 * 
	 * Crea una nueva instancia del GestorRepartidor.
	 */
	public GestorRepartidor ( ) {
		repartidores = new ArrayList <> ( );
	}

	@Override
	public boolean add ( Repartidor repartidor ) {
		return repartidores.add ( repartidor );
	}

	@Override
	public Repartidor search ( Repartidor repartidor ) {
		int index = repartidores.indexOf ( repartidor );
		if ( index != -1 ) {
			return repartidores.get ( index );
		}
		return null;
	}

	@Override
	public boolean update ( Repartidor repartidor ) {
		int index = repartidores.indexOf ( repartidor );
		if ( index != -1 ) {
			repartidores.set ( index, repartidor );
			return true;
		}
		return false;
	}

	@Override
	public boolean delete ( Repartidor repartidor ) {
		return repartidores.remove ( repartidor );
	}

	@Override
	public Iterator <Repartidor> listAll ( ) {
		return repartidores.iterator ( );
	}

	/**
	 * 
	 * Busca un repartidor por su nombre.
	 * 
	 * @param nombre el nombre del repartidor a buscar.
	 * @return el repartidor encontrado, o null si no se encuentra.
	 */
	public Repartidor searchByNombre ( String nombre ) {
		for ( Repartidor repartidor : repartidores ) {
			if ( repartidor.getNombre ( ).equalsIgnoreCase ( nombre ) ) {
				return repartidor;
			}
		}
		return null;
	}

	/**
	 * 
	 * Busca un repartidor por su ID.
	 * 
	 * @param idRepartidor el ID del repartidor a buscar.
	 * @return el repartidor encontrado, o null si no se encuentra.
	 */
	public Repartidor buscarRepartidorPorId ( String idRepartidor ) {
		for ( Repartidor repartidor : repartidores ) {
			if ( repartidor.getId ( ).equals ( idRepartidor ) ) {
				return repartidor;
			}
		}
		return null;
	}

}