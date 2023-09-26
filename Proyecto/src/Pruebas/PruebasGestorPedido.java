package Pruebas;

import java.util.Iterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import Controlador.GestorPedido;
import Modelo.Pedido;

class PruebasGestorPedido {

	private GestorPedido gestorPedido;

	@Before
	public void setUp ( ) {
		gestorPedido = new GestorPedido ( );
	}

	@Test
	public void testAdd ( ) {
		Pedido pedido = new Pedido ( );
		boolean result = gestorPedido.add ( pedido );
		Assert.assertTrue ( result );
	}

	@Test
	public void testSearch ( ) {
		Pedido pedido = new Pedido ( );
		gestorPedido.add ( pedido );
		Pedido result = gestorPedido.search ( pedido );
		Assert.assertEquals ( pedido, result );
	}

	@Test
	public void testUpdate ( ) {
		Pedido pedido = new Pedido ( );
		gestorPedido.add ( pedido );
		Pedido updatedPedido = new Pedido ( );
		boolean result = gestorPedido.update ( updatedPedido );
		Assert.assertTrue ( result );
		Pedido searchResult = gestorPedido.search ( updatedPedido );
		Assert.assertEquals ( updatedPedido, searchResult );
	}

	@Test
	public void testDelete ( ) {
		Pedido pedido = new Pedido ( );
		gestorPedido.add ( pedido );
		boolean result = gestorPedido.delete ( pedido );
		Assert.assertTrue ( result );
		Pedido searchResult = gestorPedido.search ( pedido );
		Assert.assertNull ( searchResult );
	}

	@Test
	public void testListAll ( ) {
		Pedido pedido1 = new Pedido ( );
		Pedido pedido2 = new Pedido ( );
		gestorPedido.add ( pedido1 );
		gestorPedido.add ( pedido2 );
		Iterator <Pedido> iterator = gestorPedido.listAll ( );
		int count = 0;
		while ( iterator.hasNext ( ) ) {
			iterator.next ( );
			count++;
		}
		Assert.assertEquals ( 2, count );
	}

}