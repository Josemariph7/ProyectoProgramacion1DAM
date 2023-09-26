package Vista;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import Modelo.Usuario;

public class Main {

	public static void main ( String [ ] args ) throws IOException {

		// Carga de datos
		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		// Nombre de la aplicación
		System.out.println ( "+-------------------------------------+" );
		System.out.println ( " |       	    DeliveryApp                    |" );
		System.out.println ( "+-------------------------------------+" );
		int opcionInicio;
		do {
			Scanner scanner = new Scanner ( System.in );
			System.out.println ( "\n		    --- Inicio ---\n" );
			System.out.println ( "	        1. Registrar usuario" );
			System.out.println ( "	        2. Iniciar sesión" );
			System.out.println ( "	        3. Salir" );
			System.out.print ( "\nSelecciona una opción: " );
			opcionInicio = scanner.nextInt ( );
			scanner.nextLine ( );
			switch ( opcionInicio ) {
			case 1 :
				registrarUsuario ( scanner );
				break;

			case 2 :
				iniciarSesion ( scanner, cargaDatos );
				break;

			case 3 :
				System.out.println ( "Saliendo..." );
				break;

			default :
				System.out.println ( "Opción no válida. Inténtalo de nuevo." );
				break;
			}
		} while ( opcionInicio != 3 );
	}

	private static void registrarUsuario ( Scanner scanner ) throws IOException {

		System.out.println ( "\n	   --- Registro de Usuario ---" );
		System.out.print ( "	\n     > Nickname: " );
		String username = scanner.nextLine ( );
		System.out.print ( "\n     > Nombre: " );
		String nombre = scanner.nextLine ( );
		System.out.print ( "	\n     > Dirección: " );
		String direccion = scanner.nextLine ( );
		System.out.print ( "\n     > Email: " );
		String email = scanner.nextLine ( );
		System.out.print ( "\n     > Teléfono: " );
		String telefono = scanner.nextLine ( );
		System.out.print ( "\n     > Contraseña: " );
		String password = scanner.nextLine ( );
		boolean esAdmin = false;
		System.out.print ( "\n     > ¿Es administrador? (S/N): " );
		String opcionAdmin = scanner.nextLine ( );
		System.out.println ( );
		if ( opcionAdmin.equalsIgnoreCase ( "S" ) ) {
			esAdmin = true;
		}
		Usuario nuevoUsuario = new Usuario ( username, nombre, direccion, email, telefono, password, esAdmin );
		CargaDatos cargaDatos = new CargaDatos ( );
		cargaDatos.Cargar ( );
		cargaDatos.gestorUsuario.add ( nuevoUsuario );
		cargaDatos.Guardar ( null );
		System.out.println ( "Usuario registrado con éxito." );
	}

	private static void iniciarSesion ( Scanner scanner, CargaDatos cargaDatos ) throws IOException {

		System.out.println ( "\n\n	    --- Inicio de Sesión ---" );
		System.out.print ( "\n     > Usuario: " );
		String username = scanner.nextLine ( );
		System.out.print ( "\n     > Contraseña: " );
		String password = scanner.nextLine ( );
		Iterator <Usuario> usuarioIterator = cargaDatos.gestorUsuario.listAll ( );
		boolean validCredentials = false;
		Usuario usuario = null;
		while ( usuarioIterator.hasNext ( ) ) {
			Usuario user = usuarioIterator.next ( );
			if ( user.getId ( ).equals ( username ) && user.getContraseña ( ).equals ( password ) ) {
				validCredentials = true;
				usuario = user;
				break;
			}
		}
		if ( validCredentials ) {
			if ( usuario.isEsAdmin ( ) ) {
				VistaAdministrador vistaAdmin = new VistaAdministrador ( );
				vistaAdmin.MostrarMenuAdministrador ( );
			} else {
				VistaUsuario vistaUsuario = new VistaUsuario ( );
				vistaUsuario.mostrarMenuUsuario ( scanner, usuario );
			}
		} else {
			System.out.println ( "\nInicio de sesión fallido. Por favor, inténtelo nuevamente." );
		}
	}

}
