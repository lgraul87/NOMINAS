package vista.principal;

import controlador.database.GeneralController;


public class CalculaNominas {
	
	public static GeneralController controlGeneral = new GeneralController("nomina");

	public static void main(String[] args) {
		/*
		 * Se desea desarrollar una aplicaciï¿½n en Java para controlar las nï¿½minas de los
		 * empleados de una empresa. Para ello, debes realizar los siguientes apartados
		 * (en principio, no se suponen errores en los datos de entrada): 1. Definir la
		 * clase pï¿½blica Persona que pertenece al paquete Laboral. 1.1. Los atributos
		 * que definen una Persona son: un nombre (cadena), un dni (cadena) y un sexo
		 * (carï¿½cter). Los atributos son pï¿½blicos. 1.2. La clase tiene dos
		 * constructores, uno con los tres atributos de la Persona, y otro con sï¿½lo el
		 * nombre y el sexo. 1.3.
		 * 
		 * 
		 * Tendrï¿½ dos mï¿½todos pï¿½blicos: 1.3.1. setDni para modificar el valor del dni de
		 * una persona. 1.3.2. Imprime que presenta por pantalla el nombre y el dni.
		 * 
		 * 
		 * 2. Definir la clase Empleado que extiende a Persona y que tiene: 2.1. Dos
		 * nuevos atributos: categoria (atributo privado) debe ser una valor positivo
		 * entre 1 y 10; y aï¿½os (anyos) trabajados (atributo pï¿½blico) que debe ser
		 * positivo.
		 * 
		 */

		/*
		 * 2.2. Dos constructores: uno que recibe todos los valores de sus atributos y
		 * otro que solo recibe el nombre, sexo y dni. En este caso, se entiende que la
		 * categorï¿½a es 1 y el nï¿½mero de aï¿½os trabajados es 0. 2.3.
		 * 
		 * 
		 * 
		 * 
		 * Los siguientes mï¿½todos pï¿½blicos: 2.3.1. setCategoria que sirve para cambiar
		 * de categorï¿½a de un empleado, que recibe como parï¿½metro de entrada. 2.3.2.
		 * getCategoria que devuelve el valor del atributo categoria. 2.3.3. incrAnyo
		 * que incrementa en uno el nï¿½mero de aï¿½os trabajados.
		 * 
		 * 
		 * 2.3.4. imprime que presenta todos los datos del empleado. 3. La siguiente
		 * tabla contiene los sueldos base de cada Empleado, de acuerdo con su
		 * categorï¿½a. Siendo 50000 para la categorï¿½a 1 e incrementï¿½ndose en 20000 para
		 * cada nueva categorï¿½a. Esta tabla debe definirse en una nueva clase de nombre
		 * Nomina: private static final int SUELDO_BASE[] = {50000, 70000, 90000,
		 * 110000, 130000, 150000, 170000, 190000, 210000, 230000} 3.1. La clase es una
		 * biblioteca y tiene un mï¿½todo sueldo que recibe un Empleado y devuelve su
		 * sueldo obtenido como resultado de evaluar la expresiï¿½n: sueldo = sueldoBase +
		 * 5000*aï¿½os trabajados 4. Crear la clase CalculaNominas con un programa
		 * principal que:
		 * 
		 */
		/**
		 * #################################################
		 */

		/*
		 * 4.1. Cree el empleado: ï¿½James Coslingï¿½, dni=32000032G, sexo=ï¿½Mï¿½, categorï¿½a=4,
		 * aï¿½os=7 4.2. Cree el empleado: ï¿½Ada Lovelaceï¿½, dni=32000031R, sexo=ï¿½Fï¿½ 4.3.
		 * Declare un mï¿½todo privado escribe que reciba los valores de los dos empleados
		 * e imprima sus atributos y el sueldo que cada uno gana. 4.4. Haga una llamada
		 * en el programa principal a ese mï¿½todo. 4.5.
		 * 
		 * 
		 * Incremente los aï¿½os trabajados del segundo empleado y haga que la categorï¿½a
		 * del primero sea 9. 4.6. Imprima de nuevo ambos empleados y su sueldo. 5.
		 * 
		 * 
		 * Modificar el cï¿½digo para comprobar que los datos que se pasan son correctos
		 * cuando se crea un nuevo Empleado y en caso contrario se eleve la excepciï¿½n
		 * DatosNoCorrectosException. Declara un manejador de excepciones que cuando se
		 * produzca dicha excepciï¿½n, emita el mensaje ï¿½Datos no correctosï¿½, y termine la
		 * ejecuciï¿½n. Modifica el programa principal para que pueda elevarse esta
		 * excepciï¿½n. Deberï¿½s controlar las excepciones del sistema, asï¿½ como documenta
		 * convenientemente el cï¿½digo generando el Javadoc.
		 */

		
		
	}

	

}
