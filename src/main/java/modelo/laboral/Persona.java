package modelo.laboral;

public class Persona implements INomina, IPersona {

	public String sNombre;
	public String sDni;
	public char cLetra;

	/**
	 * 
	 * @param sNombre tipo: String
	 * @param sDni    tipo: String
	 * @param cLetra  tipo: Char
	 */
	public Persona(String sNombre, String sDni, char cLetra) {

		setsNombre(sNombre);
		setsDni(sDni);
		setcLetra(cLetra);

	}

	/**
	 * 
	 * @param sNombre tipo: String
	 * @param cLetra  tipo: Char
	 */
	
	
	public Persona(String sNombre, char cLetra) {

		setsNombre(sNombre);
		setcLetra(cLetra);
	}
	
	public Persona(String sDni) {
		setsDni(sDni);
	}

	/**
	 * 
	 * @return tipo: String
	 */
	@Override
	public String getsNombre() {
		return this.sNombre;
	}

	/**
	 * 
	 * @param sNombre tipo: String
	 * @return Boolean
	 */
	@Override
	public void setsNombre(String sNombre) {
		if (sNombre != null && sNombre.length() >= MIN_STRING && sNombre.length() <= MAX_STRING_NOMBRE) {
			this.sNombre = sNombre;
		} else {
			this.sNombre = null;
		}
	}

	/**
	 * 
	 * @return tipo: String
	 */
	@Override
	public String getsDni() {
		return this.sDni;
	}

	/**
	 * MODIFICA EL DNI DE UNA PERSONA
	 * 
	 * @param sDni tipo: String
	 * @return tipo: Boolean
	 */
	@Override
	public void setsDni(String sDni) {
		if (sDni != null && sDni.length() == 9) {
			this.sDni = sDni;
		} else {
			this.sDni = null;
		}

	}

	/**
	 * 
	 * @return tipo: Char
	 */
	@Override
	public char getcLetra() {
		return this.cLetra;
	}

	/**
	 * 
	 * @param cLetra tipo: Char
	 */
	@Override
	public void setcLetra(char cLetra) {

		this.cLetra = cLetra;

	}

	/**
	 * 
	 * @param sDni tipo: String
	 * @return tipo: String
	 */
	@Override
	public String toString() {
		return "  --Nombre: " + this.sNombre + "  --Dni: " + this.sDni;
	}

	

}
