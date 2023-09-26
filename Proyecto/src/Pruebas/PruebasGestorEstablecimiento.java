package Pruebas;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Controlador.GestorEstablecimiento;
import Modelo.Establecimiento;
import Modelo.Farmacia;
import Modelo.Restaurante;
import Modelo.Supermercado;
import Modelo.TiposEnumerados.TipoEstablecimiento;

public class PruebasGestorEstablecimiento {

	private GestorEstablecimiento gestorEstablecimiento;

	@Before
	public void setUp ( ) {
		gestorEstablecimiento = new GestorEstablecimiento ( );
	}

	@Test
	public void testAdd ( ) {
		Establecimiento establecimiento = new Establecimiento ( );
		boolean result = gestorEstablecimiento.add ( establecimiento );
		Assert.assertTrue ( result );
	}

	@Test
	public void testSearch ( ) {
		Establecimiento establecimiento = new Establecimiento ( );
		gestorEstablecimiento.add ( establecimiento );
		Establecimiento result = gestorEstablecimiento.search ( establecimiento );
		Assert.assertEquals ( establecimiento, result );
	}

	@Test
	public void testUpdate ( ) {
		Establecimiento establecimiento = new Establecimiento ( );
		gestorEstablecimiento.add ( establecimiento );
		Establecimiento updatedEstablecimiento = new Establecimiento ( );
		boolean result = gestorEstablecimiento.update ( updatedEstablecimiento );
		Assert.assertTrue ( result );
		Establecimiento searchResult = gestorEstablecimiento.search ( updatedEstablecimiento );
		Assert.assertEquals ( updatedEstablecimiento, searchResult );
	}

	@Test
	public void testSearchByNombre ( ) {
		Establecimiento establecimiento = new Establecimiento ( );
		establecimiento.setNombre ( "Establecimiento 1" );
		gestorEstablecimiento.add ( establecimiento );

		Establecimiento result = gestorEstablecimiento.searchByNombre ( "Establecimiento 1" );
		Assert.assertEquals ( establecimiento, result );
	}

	@Test
	public void testDelete ( ) {
		Establecimiento establecimiento = new Establecimiento ( );
		gestorEstablecimiento.add ( establecimiento );
		boolean result = gestorEstablecimiento.delete ( establecimiento );
		Assert.assertTrue ( result );
		Establecimiento searchResult = gestorEstablecimiento.search ( establecimiento );
		Assert.assertNull ( searchResult );
	}

	@Test
	public void testListAll ( ) {
		Establecimiento establecimiento1 = new Establecimiento ( );
		Establecimiento establecimiento2 = new Establecimiento ( );
		gestorEstablecimiento.add ( establecimiento1 );
		gestorEstablecimiento.add ( establecimiento2 );
		Iterator <Establecimiento> iterator = gestorEstablecimiento.listAll ( );
		int count = 0;
		while ( iterator.hasNext ( ) ) {
			iterator.next ( );
			count++;
		}
		Assert.assertEquals ( 2, count );
	}

	@Test
	public void testBuscarEstablecimientoPorTipo ( ) {
		Establecimiento establecimiento1 = new Establecimiento ( );
		Establecimiento establecimiento2 = new Establecimiento ( );
		establecimiento1.setTipo ( TipoEstablecimiento.RESTAURANTE );
		establecimiento2.setTipo ( TipoEstablecimiento.SUPERMERCADO );
		gestorEstablecimiento.add ( establecimiento1 );
		gestorEstablecimiento.add ( establecimiento2 );
		List <Establecimiento> resultados = gestorEstablecimiento
		.buscarEstablecimientoPorTipo ( TipoEstablecimiento.RESTAURANTE );
		Assert.assertEquals ( 1, resultados.size ( ) );
		Assert.assertEquals ( establecimiento1, resultados.get ( 0 ) );
	}

	@Test
	public void testBuscarRestaurantesPorTipoCocina ( ) {
		Restaurante restaurante1 = new Restaurante ( );
		restaurante1.setTipoCocina ( "Italiana" );
		Restaurante restaurante2 = new Restaurante ( );
		restaurante2.setTipoCocina ( "Mexicana" );
		gestorEstablecimiento.add ( restaurante1 );
		gestorEstablecimiento.add ( restaurante2 );
		List <Restaurante> resultados = gestorEstablecimiento.buscarRestaurantesPorTipoCocina ( "Italiana" );
		Assert.assertEquals ( 1, resultados.size ( ) );
		Assert.assertEquals ( restaurante1, resultados.get ( 0 ) );
	}

	@Test
	public void testPuntuarRestaurante ( ) {
		Restaurante restaurante = new Restaurante ( );
		gestorEstablecimiento.add ( restaurante );
		gestorEstablecimiento.puntuarRestaurante ( restaurante, 5 );
		Assert.assertEquals ( 5, restaurante.getPuntuacion ( ) );
		gestorEstablecimiento.puntuarRestaurante ( restaurante, 3 );
		Assert.assertEquals ( 4, restaurante.getPuntuacion ( ) );
	}

	@Test
	public void testPuntuarSupermercado ( ) {
		Supermercado supermercado = new Supermercado ( );
		gestorEstablecimiento.add ( supermercado );
		gestorEstablecimiento.puntuarSupermercado ( supermercado, 4 );
		Assert.assertEquals ( 4, supermercado.getPuntuacion ( ) );
		gestorEstablecimiento.puntuarSupermercado ( supermercado, 2 );
		Assert.assertEquals ( 3, supermercado.getPuntuacion ( ) );
	}

	@Test
	public void testListarOfertasSupermercado ( ) {
		Supermercado supermercado = new Supermercado ( );
		HashMap <String, Double> ofertas = new HashMap <> ( );
		ofertas.put ( "Producto 1", 10.0 );
		ofertas.put ( "Producto 2", 5.0 );
		supermercado.setOfertas ( ofertas );
		gestorEstablecimiento.add ( supermercado );

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream ( );
		PrintStream printStream = new PrintStream ( outputStream );
		PrintStream originalPrintStream = System.out;
		System.setOut ( printStream );

		gestorEstablecimiento.listarOfertasSupermercado ( supermercado );

		System.out.flush ( );
		System.setOut ( originalPrintStream );

		String output = outputStream.toString ( ).trim ( );
		String [ ] lines = output.split ( System.lineSeparator ( ) );
		Assert.assertEquals ( 2, lines.length );
		Assert.assertEquals ( "Producto 1: 10.0", lines [ 0 ] );
		Assert.assertEquals ( "Producto 2: 5.0", lines [ 1 ] );
	}

	@Test
	public void testMostrarTelefonoFarmacia ( ) {
		Farmacia farmacia1 = new Farmacia ( );
		farmacia1.setNumeroTelefonoConsulta ( "123456789" );
		Farmacia farmacia2 = new Farmacia ( );
		gestorEstablecimiento.add ( farmacia1 );
		gestorEstablecimiento.add ( farmacia2 );

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream ( );
		PrintStream printStream = new PrintStream ( outputStream );
		PrintStream originalPrintStream = System.out;
		System.setOut ( printStream );

		gestorEstablecimiento.mostrarTelefonoFarmacia ( farmacia1 );

		System.out.flush ( );
		System.setOut ( originalPrintStream );

		String output = outputStream.toString ( ).trim ( );
		Assert.assertEquals ( "El teléfono de consulta es: 123456789", output );
	}

}