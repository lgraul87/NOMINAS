package controlador.database;

import controlador.modelos.EmpleadoController;

public class GeneralController implements IGeneralController{

	private ConexionDB conexionDB;
	private EmpleadoController empleadoController;

	public GeneralController(String sDatabase) {

		this.conexionDB = new ConexionDB(sDatabase);
		this.empleadoController = new EmpleadoController();

	}

	@Override
	public ConexionDB getConexionDB() {
		return this.conexionDB;
	}

	
	@Override
	public EmpleadoController getEmpleadoController() {
		return this.empleadoController;
	}

}
