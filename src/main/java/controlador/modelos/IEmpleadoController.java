package controlador.modelos;

import java.util.List;

import modelo.laboral.Empleado;

public interface IEmpleadoController {

	public boolean addEmployee(Empleado oEmpleado1);

	public List<Empleado> showAll();

	public String showEmployee(Empleado oEmpleado);

	public boolean editEmployee(Empleado oEmpleado, Empleado oEmpleadoModificado);

	public void upDateSalaryAll();

	public Empleado bringEmployee(Empleado oEmpleado);

	public boolean upDateSalary(Empleado oEmpleado, Empleado oEmpleadoEditado);

}
