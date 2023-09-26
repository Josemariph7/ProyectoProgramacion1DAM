package Pruebas;

import java.util.Iterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import Controlador.GestorProducto;
import Modelo.Producto;

public class PruebasGestorProducto {

	private GestorProducto gestorProducto;

	@Before
	public void setUp ( ) {
		gestorProducto = new GestorProducto ( );
	}

	@Test
	public void testAdd ( ) {
		Producto producto = new Producto ( );
		boolean result = gestorProducto.add ( producto );
		Assert.assertTrue ( result );
	}

	@Test
	public void testSearch ( ) {
		Producto producto = new Producto ( );
		gestorProducto.add ( producto );
		Producto result = gestorProducto.search ( producto );
		Assert.assertEquals ( producto, result );
	}

	@Test
	public void testUpdate ( ) {
		Producto producto = new Producto ( );
		gestorProducto.add ( producto );
		Producto updatedProducto = new Producto ( );
		boolean result = gestorProducto.update ( updatedProducto );
		Assert.assertTrue ( result );
		Producto searchResult = gestorProducto.search ( updatedProducto );
		Assert.assertEquals ( updatedProducto, searchResult );
	}

	@Test
	public void testDelete ( ) {
		Producto producto = new Producto ( );
		gestorProducto.add ( producto );
		boolean result = gestorProducto.delete ( producto );
		Assert.assertTrue ( result );
		Producto searchResult = gestorProducto.search ( producto );
		Assert.assertNull ( searchResult );
	}

	@Test
	public void testListAll ( ) {
		Producto producto1 = new Producto ( );
		Producto producto2 = new Producto ( );
		gestorProducto.add ( producto1 );
		gestorProducto.add ( producto2 );
		Iterator <Producto> iterator = gestorProducto.listAll ( );
		int count = 0;
		while ( iterator.hasNext ( ) ) {
			iterator.next ( );
			count++;
		}
		Assert.assertEquals ( 2, count );
	}

	@Test
	public void testSearchByNombre ( ) {
		Producto producto = new Producto ( );
		producto.setNombre ( "Producto 1" );
		gestorProducto.add ( producto );

		Producto result = gestorProducto.searchByNombre ( "Producto 1" );
		Assert.assertEquals ( producto, result );
	}

	@Test
	public void testBuscarProductoPorId ( ) {
		Producto producto = new Producto ( );
		producto.setId ( "1" );
		gestorProducto.add ( producto );

		Producto result = gestorProducto.buscarProductoPorId ( "1" );
		Assert.assertEquals ( producto, result );
	}

}