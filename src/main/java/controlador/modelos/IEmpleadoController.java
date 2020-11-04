package controlador.modelos;

import modelo.laboral.Empleado;

public interface IEmpleadoController {

	public boolean addEmployee(Empleado oEmpleado1);

	public String showAll();

	public String showEmployee(Empleado oEmpleado);

	public boolean editEmployee(Empleado oEmpleado, Empleado oEmpleadoModificado);

	public void upDateSalaryAll();

	public Empleado bringEmployee(Empleado oEmpleado);

	public boolean upDateSalary(Empleado oEmpleado, Empleado oEmpleadoEditado);

}
