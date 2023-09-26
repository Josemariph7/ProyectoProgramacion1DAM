package Vista;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import Modelo.Establecimiento;
import Modelo.Inventario;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Repartidor;
import Modelo.TiposEnumerados;
import Modelo.TiposEnumerados.TipoEstablecimiento;
import Modelo.Usuario;

public class VistaAdministrador {

	private Scanner scanner;

	public VistaAdministrador ( ) {

		scanner = new Scanner ( System.in );
	}

	public void MostrarMenuAdministrador ( ) throws IOException {

		int opcion;
		do {
			System.out.println ( "\n	\n  	 --- Menú Admin ---\n" );
			System.out.println ( "	        1. Añadir establecimiento" );
			System.out.println ( "	        2. Eliminar establecimiento" );
			System.out.println ( "	        3. Añadir producto" );
			System.out.println ( "	        4. Eliminar producto" );
			System.out.println ( "	        5. Añadir usuario" );
			System.out.println ( "	        6. Eliminar usuario" );
			System.out.println ( "	        7. Añadir repartidor" );
			System.out.println ( "	        8. Eliminar repartidor" );
			System.out.println ( "	        9. Listar establecimientos" );
			System.out.println ( "	        10. Listar inventarios" );
			System.out.println ( "	        11. Listar pedidos" );
			System.out.println ( "	        12. Listar productos" );
			System.out.println ( "	        13. Listar repartidores" );
			System.out.println ( "	        14. Listar usuarios" );
			System.out.println ( "	        15. Salir" );
			System.out.print ( "\nSelecciona una opción: " );
			opcion = scanner.nextInt ( );
			scanner.nextLine ( );
			System.out.println ( );
			switch ( opcion ) {
			case 1 :
				agregarEstablecimiento ( );
				break;

			case 2 :
				eliminarEstablecimiento ( );
				break;

			case 3 :
				agregarProducto ( );
				break;

			case 4 :
				eliminarProducto ( );
				break;

			case 5 :
				agregarUsuario ( );
				break;

			case 6 :
				eliminarUsuario ( );
				break;

			case 7 :
				agregarRepartidor ( );
				break;

			case 8 :
				eliminarRepartidor ( );
				break;

			case 9 :
				listarEstablecimientos ( );
				break;

			case 10 :
				listarInventarios ( );
				break;

			case 11 :
				listarPedidos ( );
				break;

			case 12 :
				listarProductos ( );
				break;

			case 13 :
				listarRepartidores ( );
				break;

			case 14 :
				listarUsuarios ( );
				break;

			case 15 :
				System.out.println ( "Saliendo del menú admin..." );
				break;

			default :
				System.out.println ( "Opción no válida. Inténtalo de nuevo." );
				break;
			}
		} while ( opcion != 15 );
	}

	public void agregarEstablecimiento ( ) throws IOException {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		@SuppressWarnings ( "resource" )
		Scanner scanner = new Scanner ( System.in );
		System.out.println ( "Ingrese los datos del establecimiento:\n" );
		System.out.print ( "\n     > ID: " );
		String id = scanner.nextLine ( );
		System.out.print ( "\n     > Nombre: " );
		String nombre = scanner.nextLine ( );
		System.out.print ( "\n     > Dirección: " );
		String direccion = scanner.nextLine ( );
		System.out.print ( "\n     > Tipo (Restaurante, Farmacia, Supermercado): " );
		String tipoStr = scanner.nextLine ( );
		TipoEstablecimiento tipo = null;
		if ( tipoStr.equalsIgnoreCase ( "Restaurante" ) ) {
			tipo = TipoEstablecimiento.RESTAURANTE;
		} else if ( tipoStr.equalsIgnoreCase ( "Farmacia" ) ) {
			tipo = TipoEstablecimiento.FARMACIA;
		} else if ( tipoStr.equalsIgnoreCase ( "Supermercado" ) ) {
			tipo = TipoEstablecimiento.SUPERMERCADO;
		} else {
			System.out.println ( "Tipo de establecimiento inválido." );
		}
		Establecimiento nuevoEstablecimiento = new Establecimiento ( id, nombre, direccion, tipo );
		cargaDatos.gestorEstablecimiento.add ( nuevoEstablecimiento );
		System.out.println ( "\nEstablecimiento agregado exitosamente." );
		cargaDatos.Guardar ( null );
	}

	public void eliminarEstablecimiento ( ) throws IOException {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		@SuppressWarnings ( "resource" )
		Scanner scanner = new Scanner ( System.in );
		System.out.println ( "Ingrese el ID del establecimiento a eliminar:\n" );
		System.out.print ( "\n     > ID: " );
		String idEstablecimiento = scanner.nextLine ( );
		if ( cargaDatos.gestorEstablecimiento.buscarEstablecimientoPorId ( idEstablecimiento ) != null ) {
			Establecimiento est = new Establecimiento ( );
			est = cargaDatos.gestorEstablecimiento.buscarEstablecimientoPorId ( idEstablecimiento );
			cargaDatos.gestorEstablecimiento.delete ( est );
			System.out.println ( "\nEstablecimiento eliminado exitosamente." );
			cargaDatos.Guardar ( null );
		} else {
			System.out.println ( "\nEl establecimiento no existe." );
		}
	}

	public void agregarProducto ( ) throws IOException {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		@SuppressWarnings ( "resource" )
		Scanner scanner = new Scanner ( System.in );
		System.out.println ( "Ingrese los datos del producto:\n" );
		System.out.print ( "\n     > ID: " );
		String id = scanner.nextLine ( );
		System.out.print ( "\n     > Nombre: " );
		String nombre = scanner.nextLine ( );
		System.out.print ( "\n     > Descripción: " );
		String descripcion = scanner.nextLine ( );
		System.out.print ( "\n     > Precio: " );
		double precio = scanner.nextDouble ( );
		System.out.print ( "\n     > Tipo (PLATO, MEDICAMENTO, PRODUCTOSUPERMERCADO): " );
		String tipoStr = scanner.next ( );
		TiposEnumerados.TipoProducto tipo = null;
		if ( tipoStr.equalsIgnoreCase ( "PLATO" ) ) {
			tipo = TiposEnumerados.TipoProducto.PLATO;
		} else if ( tipoStr.equalsIgnoreCase ( "MEDICAMENTO" ) ) {
			tipo = TiposEnumerados.TipoProducto.MEDICAMENTO;
		} else if ( tipoStr.equalsIgnoreCase ( "PRODUCTOSUPERMERCADO" ) ) {
			tipo = TiposEnumerados.TipoProducto.PRODUCTOSUPERMERCADO;
		} else {
			System.out.println ( "\nTipo de producto inválido." );
			tipo = null;
		}
		Producto nuevoProducto = new Producto ( id, nombre, descripcion, precio, tipo );
		cargaDatos.gestorProducto.add ( nuevoProducto );
		System.out.println ( "\nProducto agregado exitosamente." );
		cargaDatos.Guardar ( null );
	}

	public void eliminarProducto ( ) throws IOException {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		@SuppressWarnings ( "resource" )
		Scanner scanner = new Scanner ( System.in );
		System.out.println ( "Ingrese el ID del producto a eliminar:\n" );
		System.out.print ( "\n     > ID: " );
		String idProducto = scanner.nextLine ( );
		Producto producto = cargaDatos.gestorProducto.buscarProductoPorId ( idProducto );
		if ( producto != null ) {
			cargaDatos.gestorProducto.delete ( producto );
			System.out.println ( "\nProducto eliminado exitosamente." );
			cargaDatos.Guardar ( null );
		} else {
			System.out.println ( "\nEl producto no existe." );
		}
	}

	public void agregarUsuario ( ) throws IOException {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		@SuppressWarnings ( "resource" )
		Scanner scanner = new Scanner ( System.in );
		System.out.println ( "Ingrese los datos del usuario:\n" );
		System.out.print ( "\n     > ID: " );
		String id = scanner.nextLine ( );
		System.out.print ( "\n     > Nombre: " );
		String nombre = scanner.nextLine ( );
		System.out.print ( "\n     > Dirección: " );
		String direccion = scanner.nextLine ( );
		System.out.print ( "\n     > Email: " );
		String email = scanner.nextLine ( );
		System.out.print ( "\n     > Teléfono: " );
		String telefono = scanner.nextLine ( );
		System.out.print ( "\n     > Contraseña: " );
		String contraseña = scanner.nextLine ( );
		System.out.print ( "\n     > Es administrador (true/false): " );
		boolean esAdmin = scanner.nextBoolean ( );
		Usuario nuevoUsuario = new Usuario ( id, nombre, direccion, email, telefono, contraseña, esAdmin );
		cargaDatos.gestorUsuario.add ( nuevoUsuario );
		System.out.println ( "\nUsuario agregado exitosamente." );
		cargaDatos.Guardar ( null );
	}

	public void eliminarUsuario ( ) throws IOException {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		@SuppressWarnings ( "resource" )
		Scanner scanner = new Scanner ( System.in );
		System.out.println ( "Ingrese el ID del usuario a eliminar:\n" );
		System.out.print ( "\n     > ID: " );
		String idUsuario = scanner.nextLine ( );
		Usuario usuario = cargaDatos.gestorUsuario.buscarUsuarioPorId ( idUsuario );
		if ( usuario != null ) {
			cargaDatos.gestorUsuario.delete ( usuario );
			System.out.println ( "\nUsuario eliminado exitosamente." );
			cargaDatos.Guardar ( null );
		} else {
			System.out.println ( "\nEl usuario no existe." );
		}
	}

	public void agregarRepartidor ( ) throws IOException {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		@SuppressWarnings ( "resource" )
		Scanner scanner = new Scanner ( System.in );
		System.out.println ( "Ingrese los datos del repartidor:\n" );
		System.out.print ( "\n     > ID: " );
		String id = scanner.nextLine ( );
		System.out.print ( "\n     > Nombre: " );
		String nombre = scanner.nextLine ( );
		System.out.print ( "\n     > Apellido: " );
		String apellido = scanner.nextLine ( );
		System.out.print ( "\n     > Teléfono: " );
		String telefono = scanner.nextLine ( );
		Repartidor nuevoRepartidor = new Repartidor ( id, nombre, apellido, telefono );
		cargaDatos.gestorRepartidor.add ( nuevoRepartidor );
		System.out.println ( "\nRepartidor agregado exitosamente." );
		cargaDatos.Guardar ( null );
	}

	public void eliminarRepartidor ( ) throws IOException {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		@SuppressWarnings ( "resource" )
		Scanner scanner = new Scanner ( System.in );
		System.out.println ( "Ingrese el ID del repartidor a eliminar:\n" );
		System.out.print ( "\n     > ID: " );
		String idRepartidor = scanner.nextLine ( );
		Repartidor repartidor = cargaDatos.gestorRepartidor.buscarRepartidorPorId ( idRepartidor );
		if ( repartidor != null ) {
			cargaDatos.gestorRepartidor.delete ( repartidor );
			System.out.println ( "\nRepartidor eliminado exitosamente." );
			cargaDatos.Guardar ( null );
		} else {
			System.out.println ( "\nEl repartidor no existe." );
		}
	}

	public void listarEstablecimientos ( ) {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		Iterator <Establecimiento> est = cargaDatos.gestorEstablecimiento.listAll ( );
		while ( est.hasNext ( ) ) {
			Establecimiento e = est.next ( );
			System.out.println ( "Establecimientos:" );
			System.out.println ( "Nombre: " + e.getNombre ( ) );
			System.out.println ( "ID: " + e.getId ( ) );
			System.out.println ( "Dirección: " + e.getDireccion ( ) );
			System.out.println ( "Tipo: " + e.getTipo ( ) );
			System.out.println ( "-------------------------" );
		}
	}

	public void listarInventarios ( ) {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		Iterator <Inventario> inv = cargaDatos.gestorInventario.listAll ( );
		while ( inv.hasNext ( ) ) {
			Inventario i = inv.next ( );
			System.out.println ( "Inventarios:" );
			System.out.println ( "Id: " + i.getId ( ) );
			System.out.println ( "Producto: " + i.getProducto ( ).getId ( ) );
			System.out.println ( "Establecimiento: " + i.getEstablecimiento ( ).getId ( ) );
			System.out.println ( "-------------------------" );
		}
	}

	public void listarPedidos ( ) {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		Iterator <Pedido> pedidos = cargaDatos.gestorPedido.listAll ( );
		while ( pedidos.hasNext ( ) ) {
			Pedido pedido = pedidos.next ( );
			System.out.println ( "Pedidos:" );
			System.out.println ( "ID: " + pedido.getId ( ) );
			System.out.println ( "ID Usuario: " + pedido.getIdUsuario ( ) );
			System.out.println ( "ID Repartidor: " + pedido.getIdRepartidor ( ) );
			System.out.println ( "Método de Pago: " + pedido.getMetodoPago ( ) );
			System.out.println ( "Productos:" );
			for ( Producto producto : pedido.getCarrito ( ).getProductos ( ) ) {
				System.out.println ( producto.toString ( ) );
			}
			System.out.println ( "Total: " + pedido.getTotal ( ) );
			System.out.println ( "-------------------------" );
		}
	}

	public void listarProductos ( ) {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		Iterator <Producto> productos = cargaDatos.gestorProducto.listAll ( );
		while ( productos.hasNext ( ) ) {
			Producto producto = productos.next ( );
			System.out.println ( "Productos:" );
			System.out.println ( "ID: " + producto.getId ( ) );
			System.out.println ( "Nombre: " + producto.getNombre ( ) );
			System.out.println ( "Descripción: " + producto.getDescripcion ( ) );
			System.out.println ( "Precio: " + producto.getPrecio ( ) );
			System.out.println ( "Tipo: " + producto.getTipo ( ) );
			System.out.println ( "-------------------------" );
		}
	}

	public void listarRepartidores ( ) {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		Iterator <Repartidor> repartidores = cargaDatos.gestorRepartidor.listAll ( );
		while ( repartidores.hasNext ( ) ) {
			Repartidor repartidor = repartidores.next ( );
			System.out.println ( "Repartidores:" );
			System.out.println ( "ID: " + repartidor.getId ( ) );
			System.out.println ( "Nombre: " + repartidor.getNombre ( ) );
			System.out.println ( "Apellido: " + repartidor.getApellido ( ) );
			System.out.println ( "Teléfono: " + repartidor.getTelefono ( ) );
			System.out.println ( "-------------------------" );
		}
	}

	public void listarUsuarios ( ) {

		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		Iterator <Usuario> usuarios = cargaDatos.gestorUsuario.listAll ( );
		while ( usuarios.hasNext ( ) ) {
			Usuario usuario = usuarios.next ( );
			System.out.println ( "Usuarios:" );
			System.out.println ( "ID: " + usuario.getId ( ) );
			System.out.println ( "Nombre: " + usuario.getNombre ( ) );
			System.out.println ( "Dirección: " + usuario.getDireccion ( ) );
			System.out.println ( "Email: " + usuario.getEmail ( ) );
			System.out.println ( "Teléfono: " + usuario.getTelefono ( ) );
			System.out.println ( "Contraseña: " + usuario.getContraseña ( ) );
			System.out.println ( "Es administrador: " + usuario.isEsAdmin ( ) );
			System.out.println ( "-------------------------" );
		}
	}

}
