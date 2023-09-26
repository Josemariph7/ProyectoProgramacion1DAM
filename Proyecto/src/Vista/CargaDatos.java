package Vista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import Controlador.GestorEstablecimiento;
import Controlador.GestorInventario;
import Controlador.GestorPedido;
import Controlador.GestorProducto;
import Controlador.GestorRepartidor;
import Controlador.GestorUsuario;
import Modelo.Carrito;
import Modelo.Establecimiento;
import Modelo.Inventario;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Repartidor;
import Modelo.TiposEnumerados;
import Modelo.Usuario;

/**
 * La clase CargaDatos se encarga de cargar y guardar los datos del sistema
 * desde/hacia archivos de texto.
 */
public class CargaDatos {

	private static final String DATA_FOLDER_PATH = "Data";
	private static final String ESTABLECIMIENTOS_FILE = "establecimientos.txt";
	private static final String INVENTARIO_FILE = "inventario.txt";
	private static final String PEDIDOS_FILE = "pedidos.txt";
	private static final String PRODUCTOS_FILE = "productos.txt";
	private static final String REPARTIDORES_FILE = "repartidores.txt";
	private static final String USUARIOS_FILE = "usuarios.txt";
	public GestorEstablecimiento gestorEstablecimiento;
	public GestorInventario gestorInventario;
	public GestorPedido gestorPedido;
	public GestorProducto gestorProducto;
	public GestorRepartidor gestorRepartidor;
	public GestorUsuario gestorUsuario;

	/**
	 * Constructor de la clase CargaDatos. Inicializa los gestores de cada
	 * entidad del sistema.
	 */
	public CargaDatos ( ) {

		this.gestorEstablecimiento = new GestorEstablecimiento ( );
		this.gestorInventario = new GestorInventario ( );
		this.gestorPedido = new GestorPedido ( );
		this.gestorProducto = new GestorProducto ( );
		this.gestorRepartidor = new GestorRepartidor ( );
		this.gestorUsuario = new GestorUsuario ( );
	}

	/**
	 * Carga los datos del sistema desde los archivos de texto.
	 */
	public void Cargar ( ) {

		cargarEstablecimientos ( );
		cargarProductos ( );
		cargarInventario ( );
		cargarPedidos ( );
		cargarRepartidores ( );
		cargarUsuarios ( );
	}

	/**
	 * Carga los establecimientos desde el archivo de texto
	 * establecimientos.txt.
	 */
	private void cargarEstablecimientos ( ) {

		try ( BufferedReader br = new BufferedReader ( new FileReader ( DATA_FOLDER_PATH + "/"
		+ ESTABLECIMIENTOS_FILE ) ) ) {
			String linea;
			while ( ( linea = br.readLine ( ) ) != null ) {
				Establecimiento establecimiento = parsearLineaEstablecimiento ( linea );
				gestorEstablecimiento.add ( establecimiento );
			}
		} catch ( IOException e ) {
			e.printStackTrace ( );
		}
	}

	/**
	 * Parsea una línea del archivo de establecimientos y crea un objeto
	 * Establecimiento.
	 *
	 * @param linea la línea del archivo de establecimientos a parsear.
	 * @return el objeto Establecimiento creado.
	 */
	private Establecimiento parsearLineaEstablecimiento ( String linea ) {

		String [ ] partes = linea.split ( ";" );
		String id = partes [ 0 ];
		String nombre = partes [ 1 ];
		String direccion = partes [ 2 ];
		TiposEnumerados.TipoEstablecimiento tipo = TiposEnumerados.TipoEstablecimiento.valueOf ( partes [ 3 ] );
		return new Establecimiento ( id, nombre, direccion, tipo );
	}

	/**
	 * Carga el inventario desde el archivo de texto inventario.txt.
	 */
	private void cargarInventario ( ) {

		try ( BufferedReader br = new BufferedReader ( new FileReader ( DATA_FOLDER_PATH + "/"
		+ INVENTARIO_FILE ) ) ) {
			String linea;
			while ( ( linea = br.readLine ( ) ) != null ) {
				Inventario inventario = parsearLineaInventario ( linea );
				if ( inventario != null ) {
					gestorInventario.add ( inventario );
				} else {
					// System.out.println ( "Error al cargar el
					// inventario: " + linea );
				}
			}
		} catch ( IOException e ) {
			e.printStackTrace ( );
		}
	}

	/**
	 * Parsea una línea del archivo de inventario y crea un objeto Inventario.
	 *
	 * @param linea la línea del archivo de inventario a parsear.
	 * @return el objeto Inventario creado.
	 */
	private Inventario parsearLineaInventario ( String linea ) {

		String [ ] partes = linea.split ( ";" );
		String id = partes [ 0 ];
		String idEstablecimiento = partes [ 1 ];
		String idProducto = partes [ 2 ];
		int stock = Integer.parseInt ( partes [ 3 ] );
		Establecimiento establecimiento = gestorEstablecimiento.buscarEstablecimientoPorId ( idEstablecimiento );
		if ( establecimiento == null ) {
			// System.out.println ( "Establecimiento no encontrado: " +
			// idEstablecimiento );
			return null;
		}
		Producto producto = gestorProducto.buscarProductoPorId ( idProducto );
		if ( producto == null ) {
			// System.out.println ( "Producto no encontrado: " +
			// idProducto );
			return null;
		}
		Inventario inv = new Inventario ( id, establecimiento, producto, stock );
		return inv;
	}

	/**
	 * Carga los pedidos desde el archivo de texto pedidos.txt.
	 */
	private void cargarPedidos ( ) {

		try ( BufferedReader br = new BufferedReader ( new FileReader ( DATA_FOLDER_PATH + "/"
		+ PEDIDOS_FILE ) ) ) {
			String linea;
			while ( ( linea = br.readLine ( ) ) != null ) {
				Pedido pedido = parsearLineaPedido ( linea );
				gestorPedido.add ( pedido );
			}
		} catch ( IOException e ) {
			e.printStackTrace ( );
		}
	}

	private Pedido parsearLineaPedido ( String linea ) {

		String [ ] partes = linea.split ( ";" );
		String id = partes [ 0 ];
		String idUsuario = partes [ 1 ];
		String idRepartidor = partes [ 2 ];
		TiposEnumerados.MetodoPago metodoPago;
		try {
			metodoPago = TiposEnumerados.MetodoPago.valueOf ( partes [ 3 ] );
		} catch ( IllegalArgumentException e ) {
			System.err.println ( "Valor no válido para el método de pago: " + partes [ 3 ] );
			metodoPago = TiposEnumerados.MetodoPago.EFECTIVO;
		}
		Carrito carrito = new Carrito ( );
		String productosParte = partes [ 4 ];
		String [ ] productos = productosParte.split ( "," );
		for ( String producto : productos ) {
			String [ ] productoInfo = producto.split ( "-" );
			String productoID = productoInfo [ 0 ];
			Producto productoObj = buscarProductoPorID ( productoID );
			if ( productoObj != null ) {
				carrito.agregarProducto ( productoObj );
			}
		}
		double total = Double.parseDouble ( partes [ 5 ] );
		return new Pedido ( id, idUsuario, idRepartidor, metodoPago, carrito, total );
	}

	private Producto buscarProductoPorID ( String id ) {

		Iterator <Producto> productoIterator = gestorProducto.listAll ( );
		while ( productoIterator.hasNext ( ) ) {
			Producto producto = productoIterator.next ( );
			if ( producto.getId ( ).equals ( id ) ) {
				return producto;
			}
		}
		return null;
	}

	/**
	 * Carga los productos desde el archivo de texto productos.txt.
	 */
	private void cargarProductos ( ) {

		try ( BufferedReader br = new BufferedReader ( new FileReader ( DATA_FOLDER_PATH + "/"
		+ PRODUCTOS_FILE ) ) ) {
			String linea;
			while ( ( linea = br.readLine ( ) ) != null ) {
				Producto producto = parsearLineaProducto ( linea );
				gestorProducto.add ( producto );
			}
		} catch ( IOException e ) {
			e.printStackTrace ( );
		}
	}

	private Producto parsearLineaProducto ( String linea ) {

		String [ ] partes = linea.split ( ";" );
		String id = partes [ 0 ];
		String nombre = partes [ 1 ];
		String descripcion = partes [ 2 ];
		double precio = Double.parseDouble ( partes [ 3 ] );
		TiposEnumerados.TipoProducto tipo = TiposEnumerados.TipoProducto.valueOf ( partes [ 4 ] );
		return new Producto ( id, nombre, descripcion, precio, tipo );
	}

	/**
	 * Carga los repartidores desde el archivo de texto repartidores.txt.
	 */
	private void cargarRepartidores ( ) {

		try ( BufferedReader br = new BufferedReader ( new FileReader ( DATA_FOLDER_PATH + "/"
		+ REPARTIDORES_FILE ) ) ) {
			String linea;
			while ( ( linea = br.readLine ( ) ) != null ) {
				Repartidor repartidor = parsearLineaRepartidor ( linea );
				gestorRepartidor.add ( repartidor );
			}
		} catch ( IOException e ) {
			e.printStackTrace ( );
		}
	}

	private Repartidor parsearLineaRepartidor ( String linea ) {

		String [ ] partes = linea.split ( ";" );
		String id = partes [ 0 ];
		String nombre = partes [ 1 ];
		String apellido = partes [ 2 ];
		String vehiculo = partes [ 3 ];
		return new Repartidor ( id, nombre, apellido, vehiculo );
	}

	/**
	 * Carga los usuarios desde el archivo de texto usuarios.txt.
	 */
	private void cargarUsuarios ( ) {

		try ( BufferedReader br = new BufferedReader ( new FileReader ( DATA_FOLDER_PATH + "/"
		+ USUARIOS_FILE ) ) ) {
			String linea;
			while ( ( linea = br.readLine ( ) ) != null ) {
				Usuario usuario = parsearLineaUsuario ( linea );
				gestorUsuario.add ( usuario );
			}
		} catch ( IOException e ) {
			e.printStackTrace ( );
		}
	}

	private Usuario parsearLineaUsuario ( String linea ) {

		String [ ] partes = linea.split ( ";" );
		String id = partes [ 0 ];
		String nombre = partes [ 1 ];
		String direccion = partes [ 2 ];
		String email = partes [ 3 ];
		String telefono = partes [ 4 ];
		String contraseña = partes [ 5 ];
		boolean esAdmin = Boolean.parseBoolean ( partes [ 6 ] );
		return new Usuario ( id, nombre, direccion, email, telefono, contraseña, esAdmin );
	}

	/**
	 * Guarda los datos del sistema en los archivos de texto.
	 */
	public void Guardar ( Carrito carrito ) throws IOException {

		guardarEstablecimientos ( );
		guardarInventario ( );
		guardarPedidos ( carrito );
		guardarProductos ( );
		guardarRepartidores ( );
		guardarUsuarios ( );
	}

	/**
	 * Guarda los establecimientos en el archivo de texto
	 * establecimientos.txt.
	 */
	private void guardarEstablecimientos ( ) {

		try ( BufferedWriter bw = new BufferedWriter ( new FileWriter ( DATA_FOLDER_PATH + "/"
		+ ESTABLECIMIENTOS_FILE ) ) ) {
			Iterator <Establecimiento> establecimientoIterator = gestorEstablecimiento.listAll ( );
			Set <Establecimiento> establecimientos = new HashSet <> ( );
			while ( establecimientoIterator.hasNext ( ) ) {
				Establecimiento establecimiento = establecimientoIterator.next ( );
				establecimientos.add ( establecimiento );
			}
			for ( Establecimiento establecimiento : establecimientos ) {
				String linea = establecimiento.getId ( ) + ";" + establecimiento.getNombre ( ) + ";"
				+ establecimiento.getDireccion ( ) + ";" + establecimiento.getTipo ( ).name ( );
				bw.write ( linea );
				bw.newLine ( );
			}
		} catch ( IOException e ) {
			e.printStackTrace ( );
		}
	}

	/**
	 * Guarda el inventario en el archivo de texto inventario.txt.
	 */
	private void guardarInventario ( ) {

		try ( BufferedWriter bw = new BufferedWriter ( new FileWriter ( DATA_FOLDER_PATH + "/"
		+ INVENTARIO_FILE ) ) ) {
			Iterator <Inventario> inventarioIterator = gestorInventario.listAll ( );
			Set <Inventario> inventarios = new HashSet <> ( );
			while ( inventarioIterator.hasNext ( ) ) {
				Inventario inventario = inventarioIterator.next ( );
				inventarios.add ( inventario );
			}
			for ( Inventario inventario : inventarios ) {
				String linea = inventario.getId ( ) + ";" + inventario.getEstablecimiento ( ).getId ( ) + ";"
				+ inventario.getProducto ( ).getId ( ) + ";" + inventario.getCantidad ( );
				bw.write ( linea );
				bw.newLine ( );
			}
		} catch ( IOException e ) {
			e.printStackTrace ( );
		}
	}

	/**
	 * Guarda los pedidos en el archivo de texto pedidos.txt.
	 */
	private void guardarPedidos ( Carrito carrito ) throws IOException {

		FileWriter fileWriter = new FileWriter ( DATA_FOLDER_PATH + "/" + PEDIDOS_FILE, false );
		BufferedWriter bw = new BufferedWriter ( fileWriter );
		Iterator <Pedido> pedidoIterator = gestorPedido.listAll ( );
		Set <Pedido> pedidos = new HashSet <> ( );
		while ( pedidoIterator.hasNext ( ) ) {
			Pedido pedido = pedidoIterator.next ( );
			pedidos.add ( pedido );
		}
		for ( Pedido pedido : pedidos ) {
			String idPedido = pedido.getId ( );
			String idUsuario = pedido.getIdUsuario ( );
			String idRepartidor = pedido.getIdRepartidor ( );
			String metodoPago = pedido.getMetodoPago ( ).toString ( );
			StringBuilder productosBuilder = new StringBuilder ( );
			double total = 0.0;
			for ( Producto producto : pedido.getCarrito ( ).getProductos ( ) ) {
				double precio = producto.getPrecio ( );
				total += precio;
				String idProducto = producto.getId ( );
				productosBuilder.append ( idProducto ).append ( "," );
			}
			if ( productosBuilder.length ( ) > 0 ) {
				productosBuilder.deleteCharAt ( productosBuilder.length ( ) - 1 );
			}
			String productos = productosBuilder.toString ( );
			String linea = idPedido + ";" + idUsuario + ";" + idRepartidor + ";" + metodoPago + ";" + productos
			+ ";" + total;
			bw.write ( linea );
			bw.newLine ( );
		}
		bw.close ( );
		fileWriter.close ( );
	}

	/**
	 * Guarda los productos en el archivo de texto productos.txt.
	 */
	private void guardarProductos ( ) {

		try ( BufferedWriter bw = new BufferedWriter ( new FileWriter ( DATA_FOLDER_PATH + "/"
		+ PRODUCTOS_FILE ) ) ) {
			Iterator <Producto> productoIterator = gestorProducto.listAll ( );
			Set <Producto> productos = new HashSet <> ( );
			while ( productoIterator.hasNext ( ) ) {
				Producto producto = productoIterator.next ( );
				productos.add ( producto );
			}
			for ( Producto producto : productos ) {
				String linea = producto.getId ( ) + ";" + producto.getNombre ( ) + ";" + producto
				.getDescripcion ( ) + ";" + producto.getPrecio ( ) + ";" + producto.getTipo ( );
				bw.write ( linea );
				bw.newLine ( );
			}
		} catch ( IOException e ) {
			e.printStackTrace ( );
		}
	}

	/**
	 * Guarda los repartidores en el archivo de texto repartidores.txt.
	 */
	private void guardarRepartidores ( ) {

		try ( BufferedWriter bw = new BufferedWriter ( new FileWriter ( DATA_FOLDER_PATH + "/"
		+ REPARTIDORES_FILE ) ) ) {
			Iterator <Repartidor> repartidorIterator = gestorRepartidor.listAll ( );
			Set <Repartidor> repartidores = new HashSet <> ( );
			while ( repartidorIterator.hasNext ( ) ) {
				Repartidor repartidor = repartidorIterator.next ( );
				repartidores.add ( repartidor );
			}
			for ( Repartidor repartidor : repartidores ) {
				String linea = repartidor.getId ( ) + ";" + repartidor.getNombre ( ) + ";" + repartidor
				.getApellido ( ) + ";" + repartidor.getTelefono ( );
				bw.write ( linea );
				bw.newLine ( );
			}
		} catch ( IOException e ) {
			e.printStackTrace ( );
		}
	}

	/**
	 * Guarda los usuarios en el archivo de texto usuarios.txt.
	 */
	private void guardarUsuarios ( ) {

		try ( BufferedWriter bw = new BufferedWriter ( new FileWriter ( DATA_FOLDER_PATH + "/"
		+ USUARIOS_FILE ) ) ) {
			Iterator <Usuario> usuarioIterator = gestorUsuario.listAll ( );
			Set <Usuario> usuarios = new HashSet <> ( );
			while ( usuarioIterator.hasNext ( ) ) {
				Usuario usuario = usuarioIterator.next ( );
				usuarios.add ( usuario );
			}
			for ( Usuario usuario : usuarios ) {
				String linea = usuario.getId ( ) + ";" + usuario.getNombre ( ) + ";" + usuario.getDireccion ( )
				+ ";" + usuario.getEmail ( ) + ";" + usuario.getTelefono ( ) + ";" + usuario.getContraseña ( )
				+ ";" + usuario.isEsAdmin ( );
				bw.write ( linea );
				bw.newLine ( );
			}
		} catch ( IOException e ) {
			e.printStackTrace ( );
		}
	}

}