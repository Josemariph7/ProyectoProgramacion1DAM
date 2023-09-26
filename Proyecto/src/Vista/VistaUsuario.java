package Vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import Modelo.Carrito;
import Modelo.Establecimiento;
import Modelo.Inventario;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.TiposEnumerados.MetodoPago;
import Modelo.Usuario;

class VistaUsuario {

	public Carrito mostrarMenuUsuario ( Scanner scanner, Usuario usuario ) throws IOException {

		System.out.println ( "\n	\n	Bienvenido, Usuario" );
		Carrito carrito = new Carrito ( );
		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		int opcionPrincipal;
		do {
			System.out.println ( "\n		 --- Menú Usuario ---" );
			System.out.println ( "\n	        1. Consultar pedidos" );
			System.out.println ( "	        2. Realizar pedido" );
			System.out.println ( "	        3. Salir" );
			System.out.print ( "\nSelecciona una opción: " );
			opcionPrincipal = scanner.nextInt ( );
			System.out.println ( );
			switch ( opcionPrincipal ) {
			case 1 :
				consultarPedidos ( usuario );
				break;

			case 2 :
				int opcionTipoEstablecimiento;
				do {
					System.out.println ( "\n		  --- Realizar Pedido ---" );
					System.out.println ( "\n	        1. Farmacia" );
					System.out.println ( "	        2. Restaurante" );
					System.out.println ( "	        3. Supermercado" );
					System.out.println ( "	        4. Volver" );
					System.out.print ( "\nSelecciona un tipo de establecimiento: " );
					if ( !scanner.hasNextLine ( ) ) {
						break;
					}
					opcionTipoEstablecimiento = scanner.nextInt ( );
					System.out.println ( );
					switch ( opcionTipoEstablecimiento ) {
					case 1 :
						realizarPedido ( "Farmacia", usuario );
						break;

					case 2 :
						realizarPedido ( "Restaurante", usuario );
						break;

					case 3 :
						realizarPedido ( "Supermercado", usuario );
						break;

					case 4 :
						System.out.println ( "Volviendo al menú principal..." );
						break;

					default :
						System.out.println ( "Opción no válida. Inténtalo de nuevo." );
						break;
					}
					break;
				} while ( opcionTipoEstablecimiento != 4 );
				break;

			case 3 :
				System.out.println ( "Saliendo del menú..." );
				break;

			default :
				System.out.println ( "Opción no válida. Inténtalo de nuevo." );
				break;
			}
		} while ( opcionPrincipal != 3 );
		cargaDatos.Guardar ( carrito );
		return carrito;
	}

	private void consultarPedidos ( Usuario usuario ) {

		System.out.println ( "\nConsultando pedidos...\n" );
		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		Iterator <Pedido> pedidoIterator = cargaDatos.gestorPedido.listAll ( );
		while ( pedidoIterator.hasNext ( ) ) {
			Pedido pedido = pedidoIterator.next ( );
			if ( pedido.getIdUsuario ( ).equals ( usuario.getId ( ) ) ) {
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
		}
		System.out.println ( );
	}

	public boolean mostrarProductos ( String nombreEstablecimiento ) {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		Establecimiento establecimiento = cargaDatos.gestorEstablecimiento.searchByNombre ( nombreEstablecimiento );
		if ( establecimiento == null ) {
			System.out.println ( "No se encontró el establecimiento." );
			return false;
		}
		Iterator <Inventario> inventarioIterator = cargaDatos.gestorInventario.listAll ( );
		List <Producto> productos = new ArrayList <> ( );
		while ( inventarioIterator.hasNext ( ) ) {
			Inventario invent = inventarioIterator.next ( );
			String s = invent.getProducto ( ).getId ( );
			Producto p = cargaDatos.gestorProducto.buscarProductoPorId ( s );
			if ( establecimiento.getId ( ) == invent.getEstablecimiento ( ).getId ( ) ) {
				productos.add ( p );
			}
		}
		mostrarProductos ( productos );
		return true;
	}

	private void agregarProductoAlCarrito ( Producto producto, Carrito carrito ) {

		carrito.agregarProducto ( producto );
	}

	private void consultarCarrito ( Carrito carrito ) {

		mostrarProductos ( carrito.getProductos ( ) );
	}

	public void mostrarProductos ( List <Producto> productos ) {

		System.out.println ( );
		if ( productos.isEmpty ( ) ) {
			System.out.println ( "No hay productos." );
		} else {
			for ( Producto producto : productos ) {
				System.out.println ( "Nombre: " + producto.getNombre ( ) );
				System.out.println ( "Descripción: " + producto.getDescripcion ( ) );
				System.out.println ( "Precio: " + producto.getPrecio ( ) );
				System.out.println ( "-------------------------" );
			}
		}
	}

	private void eliminarProductoDelCarrito ( Producto producto, Carrito carrito ) {

		carrito.eliminarProducto ( producto );
	}

	private void vaciarCarrito ( Carrito carrito ) {

		carrito.vaciarCarrito ( );
	}

	public void mostrarEstablecimientos ( String tipoEstablecimiento ) {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		Iterator <Establecimiento> establecimientoIterator = cargaDatos.gestorEstablecimiento.listAll ( );
		if ( !establecimientoIterator.hasNext ( ) ) {
			System.out.println ( "No se encontraron establecimientos." );
			return;
		}
		while ( establecimientoIterator.hasNext ( ) ) {
			Establecimiento establecimiento = establecimientoIterator.next ( );
			String tipo = establecimiento.getTipo ( ).toString ( ).toUpperCase ( );
			if ( tipo.equals ( tipoEstablecimiento.toUpperCase ( ) ) ) {
				System.out.println ( "Nombre: " + establecimiento.getNombre ( ) );
				System.out.println ( "Dirección: " + establecimiento.getDireccion ( ) );
				System.out.println ( "-------------------------" );
			}
		}
	}

	private void realizarPedido ( String tipoEstablecimiento, Usuario usuario ) throws IOException {

		boolean valido;
		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		@SuppressWarnings ( "resource" )
		Scanner scanner = new Scanner ( System.in );
		System.out.println ( "\n--- " + tipoEstablecimiento + "s ---\n" );
		mostrarEstablecimientos ( tipoEstablecimiento );
		System.out.print ( "\nSelecciona un/a " + tipoEstablecimiento + ": " );
		String establecimiento = scanner.nextLine ( );
		System.out.println ( "\n--- " + establecimiento + " ---" );
		System.out.println ( "\nProductos disponibles:" );
		valido = mostrarProductos ( establecimiento );
		Carrito carrito = new Carrito ( );
		String opcion;
		if ( valido ) {
			do {
				System.out.print ( "\nSelecciona un producto: " );
				String producto = scanner.nextLine ( );
				Producto productoSeleccionado = cargaDatos.gestorProducto.searchByNombre ( producto );
				Iterator <Producto> productoIterator = cargaDatos.gestorProducto.listAll ( );
				do {
					Producto producto1 = productoIterator.next ( );
					if ( producto1.getNombre ( ).equals ( producto ) ) {
						agregarProductoAlCarrito ( productoSeleccionado, carrito );
						System.out.println ( "\nProducto agregado al carrito." );
						break;
					}
				} while ( productoIterator.hasNext ( ) );
				System.out.print ( "\n¿Deseas agregar otro producto? (S/N): " );
				opcion = scanner.nextLine ( );
			} while ( opcion.equalsIgnoreCase ( "S" ) );
			System.out.println ( "\n		   --- Carrito ---" );
			consultarCarrito ( carrito );
			System.out.print ( "\n¿Deseas eliminar algún producto del carrito? (S/N): " );
			opcion = scanner.nextLine ( );
			if ( opcion.equalsIgnoreCase ( "S" ) ) {
				System.out.print ( "\nSelecciona el producto a eliminar: " );
				String productoEliminar = scanner.nextLine ( );
				Producto elim = cargaDatos.gestorProducto.searchByNombre ( productoEliminar );
				if ( elim != null ) {
					eliminarProductoDelCarrito ( elim, carrito );
					System.out.println ( "\nProducto eliminado del carrito." );
				} else {
					System.out.println ( "\nProducto no encontrado en el carrito." );
				}
			}
			System.out.print ( "\n¿Deseas vaciar el carrito? (S/N): " );
			opcion = scanner.nextLine ( );
			if ( opcion.equalsIgnoreCase ( "S" ) ) {
				vaciarCarrito ( carrito );
				System.out.println ( "\nEl carrito ha sido vaciado." );
			}
			System.out.print ( "\n¿Deseas realizar el pedido? (S/N): " );
			opcion = scanner.nextLine ( );
			Pedido pedidoConf = new Pedido ( );
			if ( opcion.equalsIgnoreCase ( "S" ) ) {
				System.out.print ( "\nSelecciona el método de pago (tarjeta, bizum o efectivo): " );
				String metodoPago = scanner.nextLine ( );
				Random random = new Random ( );
				int numero1 = random.nextInt ( 9 );
				int numero2 = random.nextInt ( 9 );
				int numero3 = random.nextInt ( 9 );
				String p = "PED" + numero1 + numero2 + numero3;
				Random random1 = new Random ( );
				int numero4 = random1.nextInt ( 9 );
				int numero5 = random1.nextInt ( 9 );
				int numero6 = random1.nextInt ( 9 );
				String r = "REP" + numero4 + numero5 + numero6;
				metodoPago = metodoPago.toLowerCase ( );
				if ( metodoPago.equals ( "tarjeta" ) ) {
					pedidoConf.setMetodoPago ( MetodoPago.TARJETA_CREDITO );
				} else if ( metodoPago.equals ( "bizum" ) ) {
					pedidoConf.setMetodoPago ( MetodoPago.BIZUM );
				} else if ( metodoPago.equals ( "efectivo" ) ) {
					pedidoConf.setMetodoPago ( MetodoPago.EFECTIVO );
				} else {
					System.out.println ( "El método de pago seleccionado no es válido." );
				}
				String u = usuario.getId ( );
				pedidoConf.setId ( p );
				pedidoConf.setIdUsuario ( u );
				pedidoConf.setIdRepartidor ( r );
				pedidoConf.setCarrito ( carrito );
				pedidoConf.setTotal ( carrito.getTotal ( ) );
				pedidoConf.setId ( p );
				pedidoConf.setId ( p );
				cargaDatos.gestorPedido.add ( pedidoConf );
				System.out.println ( "\nPedido realizado. Se ha generado el comprobante." );
				cargaDatos.Guardar ( carrito );
				// System.exit(0);
			}
		}
		// System.exit(0);
	}

}