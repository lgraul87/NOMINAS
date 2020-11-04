package modelo.laboral;

public interface INomina {

	/*
	 * SE CREA UNA INTERFAZ PARA RECOGER TODAS LAS COSTANTES Y ASI MEJORAR LA
	 * FUNCIONALIDAD DE LA APP EN VISTA A POSTERIORES MODIFICACIONES
	 */

	// TAMANIO DE STRING PARA BBDD
	public static final int MIN_STRING = 2;
	public static final int MAX_STRING_NOMBRE = 40;

	// TABLA DE SUELDO EN CATEGORIAS DESDE LA 1 A LA 10
	public static final int SUELDO_BASE[] = { 50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000,
			230000 };

	// MIN Y MAX DE CATEGORIAS Y ANIOS
	public static final byte MIN_CATEGORIA = 1;
	public static final byte MAX_CATEGORIA = 10;
	public static final byte MIN_ANIOSTRABAJADOS = 0;
	public static final byte MAX_ANIOSTRABAJADOS = 80;

	// OTROS
	public static final byte SIN_EXP = 0;
	public static final byte ANYO_MAS_UNO = 1;
	public static final short INCENTIVO_ANYO = 5000;

	
	
}
