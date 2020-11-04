package modelo.laboral;

public class Empleado extends Persona implements IEmpleado{

	private byte bCategoria;
	private byte bAnyosTrabajados;

	/**
	 * 
	 * @param sNombre tipo: String
	 * @param sDni    tipo: String
	 * @param cLetra  tipo: Char
	 */
	
	public Empleado(String sNombre, String sDni, char cLetra) {
		super(sNombre, sDni, cLetra);
		this.bCategoria = MIN_CATEGORIA;
		this.bAnyosTrabajados = SIN_EXP;
	}

	/**
	 * 
	 * @param sNombre          tipo: String
	 * @param sDni             tipo: String
	 * @param cLetra           tipo: Char
	 * @param bAnyosTrabajados tipo: Byte
	 * @param bCategoria       tipo: Byte
	 */
	public Empleado(String sNombre, String sDni, char cLetra, byte bAnyosTrabajados, byte bCategoria) {
		super(sNombre, sDni, cLetra);
		setbCategoria(bCategoria);
		setbAnyosTrabajados(bAnyosTrabajados);
	}

	public Empleado(String sDni) {
		super(sDni);
	}

	/**
	 * 
	 * @return tipo: Byte
	 */
	@Override
	public byte getbCategoria() {
		return this.bCategoria;
	}

	/**
	 * 
	 * @param bCategoria tipo: Byte
	 * @return tipo: Boolean
	 */
	@Override
	public boolean setbCategoria(byte bCategoria) {
		boolean bExito = false;
		if (bCategoria >= MIN_CATEGORIA && bCategoria <= MAX_CATEGORIA) {

			this.bCategoria = bCategoria;
			bExito = true;

		} else {
			this.bCategoria = -1;
		}
		return bExito;

	}

	/**
	 * 
	 * @return tipo: Byte
	 */
	@Override
	public byte getbAnyosTrabajados() {
		return this.bAnyosTrabajados;
	}

	/**
	 * 
	 * @param bAnyosTrabajados tipo: Byte
	 * @return tipo: Boolean
	 */
	@Override
	public void setbAnyosTrabajados(byte bAnyosTrabajados) {

		if (bAnyosTrabajados >= MIN_ANIOSTRABAJADOS && bCategoria <= MAX_ANIOSTRABAJADOS) {

			this.bAnyosTrabajados = bAnyosTrabajados;

		} else {
			this.bAnyosTrabajados = -1;
		}

	}

	/**
	 * 
	 * @return tipo: Boolean
	 */
	@Override
	public boolean incrAnyo() {
		boolean bValido = false;

		if (this.bAnyosTrabajados >= MIN_ANIOSTRABAJADOS && this.bAnyosTrabajados < MAX_ANIOSTRABAJADOS) {
			this.bAnyosTrabajados = (byte) (this.bAnyosTrabajados + MIN_ANIOSTRABAJADOS);
			bValido = true;
		}

		return bValido;
	}

	/**
	 * 
	 * @param oEmpleado tipo: Empleado (Objeto)
	 * @return tipo: String
	 */
	@Override
	public String toString() {

		return "##############################################################" + "\n  --Empleado: \n"
				+ super.toString()
				//
				+ "\n  --Sexo: " + super.cLetra
				//
				+ "\n  --Categoria: " + this.bCategoria
				//
				+ "\n  --Anyos trabajados: " + this.bAnyosTrabajados;
	}
	@Override
	public boolean validaEmpleado(Empleado oEmpleado) {
		boolean bValido = false;
		if (super.sNombre != null && super.sDni != null && super.cLetra != 0 && this.bCategoria != -1) {
			bValido = true;
		}
		return bValido;

	}

}
