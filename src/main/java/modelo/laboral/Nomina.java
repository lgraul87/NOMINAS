package modelo.laboral;

public class Nomina implements INomina {
	
	/**
	 * 
	 * @param oEmpleado tipo: Empleado (Objeto)
	 * @return tipo: Float
	 */
	public static float setSalaryDB(byte bCategoria, byte bAnio) {
		float fSueldo = -1;
		if (bCategoria == -1) {
			bCategoria = 1;
		}

		if (bAnio == -1) {
			bAnio = 0;
		}
		fSueldo = (float) SUELDO_BASE[bCategoria - 1] + (float) INCENTIVO_ANYO * bAnio;

		return fSueldo;
	}
}
