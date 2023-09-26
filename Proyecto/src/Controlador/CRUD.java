package Controlador;

import java.util.Iterator;

/**
 * La interfaz CRUD define las operaciones básicas para crear, leer, actualizar
 * y eliminar elementos.
 *
 * @param <E> el tipo de elemento con el que se trabaja.
 */
public interface CRUD <E> {

	/**
	 * Agrega un elemento a la fuente de datos.
	 *
	 * @param element el elemento a agregar.
	 * @return true si se agrega exitosamente, false en caso contrario.
	 */
	boolean add ( E element );

	/**
	 * Busca un elemento en la fuente de datos.
	 *
	 * @param element el elemento a buscar.
	 * @return el elemento encontrado, o null si no se encuentra.
	 */
	E search ( E element );

	/**
	 * Actualiza un elemento en la fuente de datos.
	 *
	 * @param element el elemento a actualizar.
	 * @return true si se actualiza exitosamente, false en caso contrario.
	 */
	boolean update ( E element );

	/**
	 * Elimina un elemento de la fuente de datos.
	 *
	 * @param element el elemento a eliminar.
	 * @return true si se elimina exitosamente, false en caso contrario.
	 */
	boolean delete ( E element );

	/**
	 * Obtiene un iterador para recorrer todos los elementos en la fuente de
	 * datos.
	 *
	 * @return un iterador de elementos.
	 */
	Iterator <E> listAll ( );

	/**
	 * Busca un elemento por su nombre en la fuente de datos.
	 *
	 * @param nombre el nombre del elemento a buscar.
	 * @return el elemento encontrado, o null si no se encuentra.
	 */
	E searchByNombre ( String nombre );

}