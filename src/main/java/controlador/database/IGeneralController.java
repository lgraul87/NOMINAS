package controlador.database;

import controlador.modelos.EmpleadoController;

public interface IGeneralController {

	public ConexionDB getConexionDB();

	public EmpleadoController getEmpleadoController();

}
