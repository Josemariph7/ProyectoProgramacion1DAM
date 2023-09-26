package Controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import Modelo.Establecimiento;
import Modelo.Farmacia;
import Modelo.Restaurante;
import Modelo.Supermercado;
import Modelo.TiposEnumerados.TipoEstablecimiento;

/**
 * 
 * La clase GestorEstablecimiento implementa la interfaz CRUD para gestionar los
 * establecimientos.
 */
public class GestorEstablecimiento implements CRUD <Establecimiento> {

	private List <Establecimiento> establecimientos;

	/**
	 * 
	 * Crea una nueva instancia del GestorEstablecimiento.
	 */
	public GestorEstablecimiento ( ) {
		establecimientos = new ArrayList <> ( );
	}

	@Override
	public boolean add ( Establecimiento establecimiento ) {
		return establecimientos.add ( establecimiento );
	}

	@Override
	public Establecimiento search ( Establecimiento establecimiento ) {
		if ( establecimientos.contains ( establecimiento ) ) {
			return establecimiento;
		}
		return null;
	}

	@Override
	public boolean update ( Establecimiento establecimiento ) {
		int index = establecimientos.indexOf ( establecimiento );
		if ( index != -1 ) {
			establecimientos.set ( index, establecimiento );
			return true;
		}
		return false;
	}

	@Override
	public Establecimiento searchByNombre ( String nombre ) {
		for ( Establecimiento establecimiento : establecimientos ) {
			if ( establecimiento.getNombre ( ).equals ( nombre ) ) {
				return establecimiento;
			}
		}
		return null;
	}

	@Override
	public boolean delete ( Establecimiento establecimiento ) {
		return establecimientos.remove ( establecimiento );
	}

	@Override
	public Iterator <Establecimiento> listAll ( ) {
		return establecimientos.iterator ( );
	}

	/**
	 * 
	 * Busca los establecimientos por tipo.
	 * 
	 * @param tipo el tipo de establecimiento a buscar.
	 * @return una lista de establecimientos del tipo especificado.
	 */
	public List <Establecimiento> buscarEstablecimientoPorTipo ( TipoEstablecimiento tipo ) {
		List <Establecimiento> resultados = new ArrayList <> ( );
		for ( Establecimiento e : establecimientos ) {
			if ( e.getTipo ( ) == tipo ) {
				resultados.add ( e );
			}
		}
		return resultados;
	}

	/**
	 * 
	 * Busca los restaurantes por tipo de cocina.
	 * 
	 * @param tipoCocina el tipo de cocina a buscar.
	 * @return una lista de restaurantes del tipo de cocina especificado.
	 */
	public List <Restaurante> buscarRestaurantesPorTipoCocina ( String tipoCocina ) {
		List <Restaurante> resultados = new ArrayList <> ( );
		for ( Establecimiento e : establecimientos ) {
			if ( e instanceof Restaurante ) {
				Restaurante r = ( Restaurante ) e;
				if ( r.getTipoCocina ( ).equalsIgnoreCase ( tipoCocina ) ) {
					resultados.add ( r );
				}
			}
		}
		return resultados;
	}

	/**
	 * 
	 * Asigna una puntuación a un restaurante.
	 * 
	 * @param restaurante el restaurante al que se le asignará la puntuación.
	 * @param puntuacion  la puntuación a asignar.
	 */
	public void puntuarRestaurante ( Restaurante restaurante, int puntuacion ) {
		if ( restaurante.getPuntuacion ( ) == 0 ) {
			restaurante.setPuntuacion ( puntuacion );
		} else {
			restaurante.setPuntuacion ( ( restaurante.getPuntuacion ( ) + puntuacion ) / 2 );
		}
	}

	/**
	 * 
	 * Asigna una puntuación a un supermercado.
	 * 
	 * @param supermercado el supermercado al que se le asignará la
	 *                     puntuación.
	 * @param puntuacion   la puntuación a asignar.
	 */
	public void puntuarSupermercado ( Supermercado supermercado, int puntuacion ) {
		if ( supermercado.getPuntuacion ( ) == 0 ) {
			supermercado.setPuntuacion ( puntuacion );
		} else {
			supermercado.setPuntuacion ( ( supermercado.getPuntuacion ( ) + puntuacion ) / 2 );
		}
	}

	/**
	 * 
	 * Lista todas las ofertas de un supermercado.
	 * 
	 * @param supermercado el supermercado del que se listarán las ofertas.
	 */
	public void listarOfertasSupermercado ( Supermercado supermercado ) {
		HashMap <String, Double> ofertas = supermercado.getOfertas ( );
		for ( String nombreProducto : ofertas.keySet ( ) ) {
			System.out.println ( nombreProducto + ": " + ofertas.get ( nombreProducto ) );
		}
	}

	/**
	 * 
	 * Muestra el número de teléfono de una farmacia.
	 * 
	 * @param farmacia la farmacia de la que se mostrará el número de
	 *                 teléfono.
	 */
	public void mostrarTelefonoFarmacia ( Farmacia farmacia ) {
		if ( farmacia.getNumeroTelefonoConsulta ( ) != null ) {
			System.out.println ( "El teléfono de consulta es: " + farmacia.getNumeroTelefonoConsulta ( ) );
		} else {
			System.out.println ( "Este establecimiento no tiene teléfono de consulta" );
		}
	}

	/**
	 * 
	 * Busca un establecimiento por su ID.
	 * 
	 * @param id el ID del establecimiento a buscar.
	 * @return el establecimiento encontrado, o null si no se encuentra.
	 */
	public Establecimiento buscarEstablecimientoPorId ( String id ) {
		for ( Establecimiento establecimiento : establecimientos ) {
			if ( establecimiento.getId ( ).equals ( id ) ) {
				return establecimiento;
			}
		}
		return null;
	}

}
