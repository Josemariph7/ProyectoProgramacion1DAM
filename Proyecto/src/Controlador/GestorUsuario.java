package Controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Modelo.Usuario;

/**
 * 
 * La clase GestorUsuario implementa la interfaz CRUD para gestionar los
 * usuarios.
 */
public class GestorUsuario implements CRUD <Usuario> {

	private List <Usuario> usuarios;

	/**
	 * 
	 * Crea una nueva instancia del GestorUsuario.
	 */
	public GestorUsuario ( ) {
		usuarios = new ArrayList <> ( );
	}

	@Override
	public boolean add ( Usuario usuario ) {
		return usuarios.add ( usuario );
	}

	@Override
	public Usuario search ( Usuario usuario ) {
		if ( usuarios.contains ( usuario ) ) {
			return usuario;
		}
		return null;
	}

	@Override
	public boolean update ( Usuario usuario ) {
		int index = usuarios.indexOf ( usuario );
		if ( index != -1 ) {
			usuarios.set ( index, usuario );
			return true;
		}
		return false;
	}

	@Override
	public boolean delete ( Usuario usuario ) {
		return usuarios.remove ( usuario );
	}

	@Override
	public Iterator <Usuario> listAll ( ) {
		return usuarios.iterator ( );
	}

	/**
	 * 
	 * Busca un usuario por su nombre.
	 * 
	 * @param nombre el nombre del usuario a buscar.
	 * @return el usuario encontrado, o null si no se encuentra.
	 */
	public Usuario searchByNombre ( String nombre ) {
		for ( Usuario usuario : usuarios ) {
			if ( usuario.getNombre ( ).equals ( nombre ) ) {
				return usuario;
			}
		}
		return null;
	}

	/**
	 * 
	 * Busca un usuario por su ID.
	 * 
	 * @param idUsuario el ID del usuario a buscar.
	 * @return el usuario encontrado, o null si no se encuentra.
	 */
	public Usuario buscarUsuarioPorId ( String idUsuario ) {
		for ( Usuario usuario : usuarios ) {
			if ( usuario.getId ( ).equals ( idUsuario ) ) {
				return usuario;
			}
		}
		return null;
	}

}