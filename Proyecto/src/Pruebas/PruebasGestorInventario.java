package Pruebas;

import java.util.Iterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import Controlador.GestorInventario;
import Modelo.Establecimiento;
import Modelo.Inventario;
import Modelo.Producto;

public class PruebasGestorInventario {

	private GestorInventario gestorInventario;

	@Before
	public void setUp ( ) {
		gestorInventario = new GestorInventario ( );
	}

	@Test
	public void testAdd ( ) {
		Inventario inventario = new Inventario ( );
		boolean result = gestorInventario.add ( inventario );
		Assert.assertTrue ( result );
	}

	@Test
	public void testSearch ( ) {
		Inventario inventario = new Inventario ( );
		gestorInventario.add ( inventario );
		Inventario result = gestorInventario.search ( inventario );
		Assert.assertEquals ( inventario, result );
	}

	@Test
	public void testUpdate ( ) {
		Inventario inventario = new Inventario ( );
		gestorInventario.add ( inventario );
		Inventario updatedInventario = new Inventario ( );
		boolean result = gestorInventario.update ( updatedInventario );
		Assert.assertTrue ( result );
		Inventario searchResult = gestorInventario.search ( updatedInventario );
		Assert.assertEquals ( updatedInventario, searchResult );
	}

	@Test
	public void testDelete ( ) {
		Inventario inventario = new Inventario ( );
		gestorInventario.add ( inventario );
		boolean result = gestorInventario.delete ( inventario );
		Assert.assertTrue ( result );
		Inventario searchResult = gestorInventario.search ( inventario );
		Assert.assertNull ( searchResult );
	}

	@Test
	public void testListAll ( ) {
		Inventario inventario1 = new Inventario ( );
		Inventario inventario2 = new Inventario ( );
		gestorInventario.add ( inventario1 );
		gestorInventario.add ( inventario2 );
		Iterator <Inventario> iterator = gestorInventario.listAll ( );
		int count = 0;
		while ( iterator.hasNext ( ) ) {
			iterator.next ( );
			count++;
		}
		Assert.assertEquals ( 2, count );
	}

	@Test
	public void testSearchByNombre ( ) {
		Inventario inventario = new Inventario ( );
		Producto producto = new Producto ( );
		producto.setNombre ( "Producto 1" );
		inventario.setProducto ( producto );
		gestorInventario.add ( inventario );

		Inventario result = gestorInventario.searchByNombre ( "Producto 1" );
		Assert.assertEquals ( inventario, result );
	}

	@Test
	public void testBuscarInventarioPorId ( ) {
		Inventario inventario = new Inventario ( );
		Establecimiento establecimiento = new Establecimiento ( );
		establecimiento.setId ( "1" );
		inventario.setEstablecimiento ( establecimiento );
		gestorInventario.add ( inventario );

		Inventario result = gestorInventario.buscarInventarioPorId ( "1" );
		Assert.assertEquals ( inventario, result );
	}

}
