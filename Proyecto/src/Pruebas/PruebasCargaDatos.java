package Pruebas;

import java.io.IOException;
import java.util.Iterator;
import Modelo.Carrito;
import Modelo.Establecimiento;
import Modelo.Inventario;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Repartidor;
import Modelo.TiposEnumerados.TipoProducto;
import Modelo.Usuario;
import Vista.CargaDatos;

public class PruebasCargaDatos {

	public static void main ( String [ ] args ) throws IOException {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		// Mostrar los datos de los establecimientos
		System.out.println ( "Datos de los establecimientos:" );
		Iterator <Establecimiento> establecimientoIterator = cargaDatos.gestorEstablecimiento.listAll ( );
		while ( establecimientoIterator.hasNext ( ) ) {
			Establecimiento establecimiento = establecimientoIterator.next ( );
			System.out.println ( "ID: " + establecimiento.getId ( ) );
			System.out.println ( "Nombre: " + establecimiento.getNombre ( ) );
			System.out.println ( "Dirección: " + establecimiento.getDireccion ( ) );
			System.out.println ( "------------------------" );
		}
		System.out.println ( "\n" );
		// Mostrar los datos de los productos
		System.out.println ( "Datos de los productos:" );
		Iterator <Producto> productoIterator = cargaDatos.gestorProducto.listAll ( );
		while ( productoIterator.hasNext ( ) ) {
			Producto producto = productoIterator.next ( );
			System.out.println ( "ID: " + producto.getId ( ) );
			System.out.println ( "Nombre: " + producto.getNombre ( ) );
			System.out.println ( "Precio: " + producto.getPrecio ( ) );
			System.out.println ( "------------------------" );
		}
		System.out.println ( "\n\n" );
		// Mostrar los datos del inventario
		System.out.println ( "Datos del inventario:" );
		Iterator <Inventario> inventarioIterator = cargaDatos.gestorInventario.listAll ( );
		while ( inventarioIterator.hasNext ( ) ) {
			Inventario inventario = inventarioIterator.next ( );
			System.out.println ( "ID: " + inventario.getId ( ) );
			System.out.println ( "ID Establecimiento: " + inventario.getEstablecimiento ( ).getId ( ) );
			System.out.println ( "ID Producto: " + inventario.getProducto ( ).getId ( ) );
			System.out.println ( "Cantidad: " + inventario.getCantidad ( ) );
			System.out.println ( "------------------------" );
			System.out.println ( "\n\n" );
		}
		System.out.println ( "Datos de los usuarios:" );
		Iterator <Usuario> usuarioIterator = cargaDatos.gestorUsuario.listAll ( );
		while ( usuarioIterator.hasNext ( ) ) {
			Usuario usuario = usuarioIterator.next ( );
			System.out.println ( "ID: " + usuario.getId ( ) );
			System.out.println ( "Nombre: " + usuario.getNombre ( ) );
			System.out.println ( "Dirección: " + usuario.getDireccion ( ) );
			System.out.println ( "Teléfono: " + usuario.getTelefono ( ) );
			System.out.println ( "------------------------" );
			System.out.println ( "\n\n" );
		}
		// Mostrar los datos de los repartidores
		System.out.println ( "Datos de los repartidores:" );
		Iterator <Repartidor> repartidorIterator = cargaDatos.gestorRepartidor.listAll ( );
		while ( repartidorIterator.hasNext ( ) ) {
			Repartidor repartidor = repartidorIterator.next ( );
			System.out.println ( "ID: " + repartidor.getId ( ) );
			System.out.println ( "Nombre: " + repartidor.getNombre ( ) );
			System.out.println ( "Teléfono: " + repartidor.getTelefono ( ) );
			System.out.println ( "------------------------" );
			System.out.println ( "\n\n" );
		}
		System.out.println ( "Datos de los pedidos:" );
		Iterator <Pedido> pedidoIterator = cargaDatos.gestorPedido.listAll ( );
		while ( pedidoIterator.hasNext ( ) ) {
			Pedido pedido = pedidoIterator.next ( );
			System.out.println ( "ID: " + pedido.getId ( ) );
			System.out.println ( "ID Usuario: " + pedido.getIdUsuario ( ) );
			System.out.println ( "ID Repartidor: " + pedido.getIdRepartidor ( ) );
			System.out.println ( "Método de Pago: " + pedido.getMetodoPago ( ) );
			System.out.println ( "Productos:" );
			for ( Producto producto : pedido.getCarrito ( ).getProductos ( ) ) {
				System.out.println ( producto.toString ( ) );
			}
			System.out.println ( "Total: " + pedido.getTotal ( ) );
			System.out.println ( "------------------------" );
		}
		System.out.println ( "\n\n" );
		/*
		 * Establecimiento est1 = new Establecimiento ( "EST011",
		 * "La Tagliatella", "Calle Benito, ciudad",
		 * TiposEnumerados.TipoEstablecimiento.RESTAURANTE );
		 * cargaDatos.gestorEstablecimiento.add ( est1 );
		 * 
		 * Producto p1 = new Producto ( "PROD011", "Bacalao",
		 * "Bacalao salado", 10, TipoProducto.PRODUCTOSUPERMERCADO );
		 * cargaDatos.gestorProducto.add ( p1 );
		 * 
		 * Inventario inv1 = new Inventario ( "INV011", est1, p1, 3 );
		 * cargaDatos.gestorInventario.add ( inv1 );
		 * 
		 * Usuario usu1 = new Usuario ( "USR001", "John Doe",
		 * "Calle Principal, Ciudad", "john.doe@example.com", "123456789",
		 * "password", false ); cargaDatos.gestorUsuario.add ( usu1 );
		 * 
		 * Repartidor repartidor = new Repartidor ( "REP011", "Juan",
		 * "Vázquez", "234567876" ); cargaDatos.gestorRepartidor.add (
		 * repartidor );
		 * 
		 * Pedido ped1 = new Pedido ( "PED011", usu1, repartidor,
		 * TiposEnumerados.MetodoPago.PAYPAL, null, 125.9 );
		 * cargaDatos.gestorPedido.add ( ped1 );
		 */
		Carrito carrito = new Carrito ( );
		Producto producto1 = new Producto ( "PROD011", "Pan bimbo", "Pan refinado", 2.79,
		TipoProducto.PRODUCTOSUPERMERCADO );
		Producto producto2 = new Producto ( "PROD012", "Solomillo", "Solomillo de cerdo", 2.49,
		TipoProducto.PRODUCTOSUPERMERCADO );
		carrito.agregarProducto ( producto1 );
		carrito.agregarProducto ( producto2 );
		cargaDatos.Guardar ( carrito );
	}

}
