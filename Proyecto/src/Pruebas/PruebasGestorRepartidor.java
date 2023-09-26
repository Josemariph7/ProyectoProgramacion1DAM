package Pruebas;

import java.util.Iterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import Controlador.GestorRepartidor;
import Modelo.Repartidor;

public class PruebasGestorRepartidor {

	private GestorRepartidor gestorRepartidor;

	@Before
	public void setUp ( ) {
		gestorRepartidor = new GestorRepartidor ( );
	}

	@Test
	public void testAdd ( ) {
		Repartidor repartidor = new Repartidor ( );
		boolean result = gestorRepartidor.add ( repartidor );
		Assert.assertTrue ( result );
	}

	@Test
	public void testSearch ( ) {
		Repartidor repartidor = new Repartidor ( );
		gestorRepartidor.add ( repartidor );
		Repartidor result = gestorRepartidor.search ( repartidor );
		Assert.assertEquals ( repartidor, result );
	}

	@Test
	public void testUpdate ( ) {
		Repartidor repartidor = new Repartidor ( );
		gestorRepartidor.add ( repartidor );
		Repartidor updatedRepartidor = new Repartidor ( );
		boolean result = gestorRepartidor.update ( updatedRepartidor );
		Assert.assertTrue ( result );
		Repartidor searchResult = gestorRepartidor.search ( updatedRepartidor );
		Assert.assertEquals ( updatedRepartidor, searchResult );
	}

	@Test
	public void testDelete ( ) {
		Repartidor repartidor = new Repartidor ( );
		gestorRepartidor.add ( repartidor );
		boolean result = gestorRepartidor.delete ( repartidor );
		Assert.assertTrue ( result );
		Repartidor searchResult = gestorRepartidor.search ( repartidor );
		Assert.assertNull ( searchResult );
	}

	@Test
	public void testListAll ( ) {
		Repartidor repartidor1 = new Repartidor ( );
		Repartidor repartidor2 = new Repartidor ( );
		gestorRepartidor.add ( repartidor1 );
		gestorRepartidor.add ( repartidor2 );
		Iterator <Repartidor> iterator = gestorRepartidor.listAll ( );
		int count = 0;
		while ( iterator.hasNext ( ) ) {
			iterator.next ( );
			count++;
		}
		Assert.assertEquals ( 2, count );
	}

	@Test
	public void testSearchByNombre ( ) {
		Repartidor repartidor = new Repartidor ( );
		repartidor.setNombre ( "Repartidor 1" );
		gestorRepartidor.add ( repartidor );

		Repartidor result = gestorRepartidor.searchByNombre ( "Repartidor 1" );
		Assert.assertEquals ( repartidor, result );
	}

	@Test
	public void testBuscarRepartidorPorId ( ) {
		Repartidor repartidor = new Repartidor ( );
		repartidor.setId ( "1" );
		gestorRepartidor.add ( repartidor );

		Repartidor result = gestorRepartidor.buscarRepartidorPorId ( "1" );
		Assert.assertEquals ( repartidor, result );
	}

}