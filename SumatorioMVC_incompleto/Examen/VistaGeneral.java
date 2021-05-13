package jcolonia.daw2020.mayo;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Utilidades comunes para vistas.
 * 
 * @versión 2021.2.1
 * @author <a href="dmartin.jcolonia@gmail.com">David H. Martín</a>
 * 
 */
public abstract class VistaGeneral {

	/**
	 * Título asignado a la vista
	 */
	protected String título;

	/**
	 * Gestor único asociado a la entrada estándar sobre el que recoger todas las
	 * entradas por consola de texto realizadas.
	 */
	protected Scanner in;

	/**
	 * Salida general, salida estándar, a la que se enviarán todos los mensajes de
	 * salida.
	 */
	protected PrintStream out;

	/**
	 * Muestra por pantalla la bienvenida a el mismo.
	 */
	public void mostrarBienvenida() {
		System.out.println("██████████████████████████████████████████████████████████████████████");
		System.out.println("█         Bienvenido al programa de gestión de numeros               █");
		System.out.println("█         Elija una ópcion:                                          █");
		System.out.println("██████████████████████████████████████████████████████████████████████");
	}

	/**
	 * Declara las Opciones del menú.
	 */
	private String[] opciones;

	/**
	 * Crea una cadena de texto por repetición de un carácter. Útil para prepara
	 * subrayados o rellenos.
	 * 
	 * @param longitud el número de caracteres
	 * @param c        el carácter deseado
	 * @return la cadena producida
	 */
	public static String rellenar(int longitud, char c) {
		String resultado;

		char[] relleno = new char[longitud];

		Arrays.fill(relleno, c);
		resultado = new String(relleno);

		return resultado;
	}

	/**
	 * Recoge el título, la entrada y determina la salida.
	 * 
	 * @param nombre    el título o descripción principal
	 * @param scEntrada el gestor conectado a la entrada estándar
	 */
	public VistaGeneral(String[] mostrarMenú, Scanner scEntrada) {

		título = mostrarMenú[0];

		opciones = Arrays.copyOfRange(mostrarMenú, 1, mostrarMenú.length);

		in = scEntrada;

		out = System.out;
	}
	/**
	 * Muestra por pantalla los complementos y opciones del menú
	 */
	public void mostrarMenú() {
		final String FORMATO_OPCIONES = " 				%d) %s%n";
		System.out.println("██████████████████████████████████████████████████████████████████████");
		out.println(rellenarListado(título.length(), '-'));
		out.println(título);
		out.println(rellenarListado(título.length(), '-'));

		for (int i = 1; i <= opciones.length; i++) {
			out.printf(FORMATO_OPCIONES, i,
					opciones[i - 1]);
		}
		out.printf(FORMATO_OPCIONES, 0, "SALIR");

	}
	/**
	 * Muestra el título con borde simple.
	 * 
	 * <pre>
	 * Ej.:
	 *    Título
	 *    ------
	 * </pre>
	 */
	public void mostrarTítuloSimple() {
		out.printf("%n%s%n%s%n", título, rellenar(título.length(), '-'));
	}

	/**
	 * Muestra el título con doble borde.
	 * 
	 * <pre>
	 * Ej.:
	 *    ========
	 *     Título
	 *    ========
	 * </pre>
	 */
	public void mostrarTítuloDoble() {
		out.printf("%2$s%n %1$s%n%2$s%n", título, rellenar(título.length() + 2, '='));
	}

	/**
	 * Muestra un texto previo, invitación a introducir datos.
	 * 
	 * <pre>
	 * Ej.:
	 *     Escriba la opción elegida →
	 * </pre>
	 */
	public void mostrarInvitación() {
		out.printf("%n  Escriba la opción elegida → ");
	}

	/**
	 * Recoge la opción elegida por el usuario, comprueba que es un número valido
	 * comprendido entre las opciones del menú y lo devuelve.
	 * 
	 * @return entrada del usuario
	 */
	public int elegirOpción() {
		String s, mensaje;
		int entrada = -1;

		boolean salir = false;

		do {
			mostrarMenú();
			mostrarBienvenida();

			// Recoger y validar opciones
			try {
				s = in.nextLine();
				entrada = Integer.parseInt(s);
				if (entrada < 0 || entrada > opciones.length) {
					throw new ProgramaGestionNumberException("Opción no válida");
				}
				salir = true;
			} catch (NumberFormatException e) {
				mostrarMensajeERRORSISTEMA("[ProgramaGestion] El sistema solo admite números enteros!");
			} catch (ProgramaGestionNumberException e) {
				mensaje = String.format(
						"[ProgramaGestion] Hay que introducir una opción de menú válida (1-%d, 0 para salir)!",
						opciones.length);
				mostrarMensajeERRORSISTEMA(mensaje);
			}
		} while (!salir);
		return entrada;
	}

	/**
	 * Muestra un texto o aviso informativo.
	 * 
	 * <pre>
	 * Ej.:
	 *     *** Texto a aviso informativo
	 * </pre>
	 * 
	 * @param mensaje el texto deseado
	 */
	public void mostrarMensaje(String mensaje) {
		out.printf(" *** %s%n%n", mensaje);
	}
	/**
	 * Crea un lista de opciones para el menú.
	 * @param longitud cantidad de caracteres
	 * @param c parametro requerido en Arrays.fill
	 * @return una cadena rellenada de la longitud recibida
	 */
	public static String rellenarListado(int longitud, char c) {
		String resultado;

		char[] relleno = new char[longitud];

		Arrays.fill(relleno, c);
		resultado = new String(relleno);

		return resultado;
	}
	/**
	 * Muestra un texto y espera a recoger una entrada. Sin más objetivo que pausar
	 * la ejecución, la entrada se desecha.
	 * 
	 * <pre>
	 * Ej.:
	 *     Pulse «Intro» para continuar
	 * </pre>
	 * 
	 * @param mensaje el texto deseado
	 */
	public void pausar() {
		mostrarMensaje("Pulse «Intro» para continuar");
		in.nextLine();
	}
}
