import java.util.Scanner;

import VistaTomaDatos.productoES;
/**
 * Vista que toma los distintos numeros 
 * @author JavierAcha
 *
 */
public class VistaTomaDatos {
	static Scanner sn = new Scanner(System.in);
	ListaNúmeros n = new ListaNúmeros();
	/**
	 * Acceso a la lista de numeros
	 */
	nummeroES[] listaNumeros = productoES.values();
	
	/**
	 * Declaración del numero1
	 */
	String num1;
	/**
	 * Declaración del numero2
	 */
	String num2;
	/**
	 * Declaración del numero3
	 */
	String num3;
	/**
	 * Declaración del numero4
	 */
	String num4;
	/**
	 * Declaración del numero5
	 */
	String num5;
	/**
	 * Declaración del numero6
	 */
	String num6;
	/**
	 * Pregunta al usuario una seríe de preguntas para formar los datos del producto
	 */
	public void vistaPreguntas() {
		primerNumero();
		segundoNumero();
		tercerNumero();
		cuartoNumero();
		quintoNumero();
		sextoNumero();
		preguntaConfirmacion();
	}

	/**
	 * Pregunta al usuario si los datos de los numeros que quiere añadir son
	 * correctos.
	 */
	public void preguntaConfirmacion() {
		
		System.out.printf("¿son correctos los numeros que quiere introducir?");
		System.out.printf("numero1: " + num1);
		System.out.printf("numero2: " + num2);
		System.out.printf("numero3: " + num3);
		System.out.printf("numero4: " + num4);
		System.out.printf("numero5: " + num5);
		System.out.printf("numero6: " + num6);
		System.out.printf("---------------------");
		System.out.printf("Pulsa 1 para dar de alta la lita y cualquier otra tecla para cancelar" + "%n");
		int respuesta = sn.nextInt();
		if (respuesta == 1) {
			enviarStrings();
		} else {
			vistaPreguntas();
		}
		/**
		 * Muestra por pantalla que se introduzca una ruta a exportar.
		 */
			public void exportarPedirRuta() {
				System.out.println("Porfavor introduce la ruta a la que quieres exportar el archivo");
			}
			
			/**
			 * Envia los datos
			 */
			public void enviarStrings() {
				n.enviar();
			}	
	}
	/**
	 * Recibe el numero y lo añade
	 * 
	 * @param num1
	 */
	public void productNumber(String numero1) {
		num1 = numero1;
		n.add(num1);
	}
	/**
	 * Recibe el numero y lo añade
	 * 
	 * @param num2
	 */
	public void productNumber(String numero2) {
		num2 = numero2;
		n.add(num2);
	}
	/**
	 * Recibe el numero y lo añade
	 * 
	 * @param num3
	 */
	public void productNumber(String numero3) {
		num3 = numero3;
		n.add(num3);
	}
	/**
	 * Recibe el numero y lo añade
	 * 
	 * @param num4
	 */
	public void productNumber(String numero4) {
		num4 = numero4;
		n.add(num4);
	}
	/**
	 * Recibe el numero y lo añade
	 * 
	 * @param num5
	 */
	public void productNumber(String numero5) {
		num5 = numero5;
		n.add(num5);
	}
	/**
	 * Recibe el numero y lo añade
	 * 
	 * @param num6
	 */
	public void productNumber(String numero6) {
		num6 = numero6;
		n.add(num6);
	}
}
