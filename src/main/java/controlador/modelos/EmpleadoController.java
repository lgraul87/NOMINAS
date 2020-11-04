package controlador.modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.database.ConexionDB;

import modelo.laboral.Empleado;
import modelo.laboral.Nomina;

public class EmpleadoController implements IEmpleadoController {

	@Override
	public boolean addEmployee(Empleado oEmpleado1) {

		boolean bExito = false;

		String sNombre = oEmpleado1.getsNombre();
		String sDni = oEmpleado1.getsDni();
		char cLetra = oEmpleado1.getcLetra();
		byte bCategoria = oEmpleado1.getbCategoria();
		byte bAnio = oEmpleado1.getbAnyosTrabajados();

		String sql = "SELECT COUNT(*) FROM EMPLEADO WHERE DNI = '" + sDni + "'";

		if (ConexionDB.executeCount(sql) == 0) {

			String sql2 = "INSERT INTO EMPLEADO VALUES ('" + sNombre + "'," + bCategoria + "," + bAnio + ",'" + sDni
					+ "','" + cLetra + "')";

			ConexionDB.executeUpdate(sql2);

			String sqlSalary = "INSERT INTO NOMINA VALUES (" + Nomina.setSalaryDB(bCategoria, bAnio) + ",'" + sDni
					+ "');";
			ConexionDB.executeUpdate(sqlSalary);
			bExito = true;

		}
		return bExito;

	}

	@Override
	public String showAll() {

		String sNombre = null;
		String sLetra = null;
		String sDni = null;
		String sDni2 = null;
		String bCategoria = null;
		String bAnios = null;

		String sResultado = "No hay Empleados";

		String sql = "SELECT COUNT(*) FROM EMPLEADO;";

		if (ConexionDB.executeCount(sql) > 0) {

			sResultado = "<table border='1px' style='margin: 0 auto;'><tr style='background-color: aqua;'><th>NOMBRE</th><th>DNI</th><th>SEXO</th><th>CATEGORIA</th><th>ANIOS</th><th>SUELDO (EUROS)</th></tr>";

			String sql2 = "SELECT * FROM EMPLEADO;";

			try {
				Statement statement = ConexionDB.getConnection().createStatement();
				ResultSet resultSet = statement.executeQuery(sql2);
				while (resultSet.next()) {

					sNombre = "<td>" + resultSet.getString("nombre") + "</td>";
					sLetra = "<td>" + resultSet.getString("sexo") + "</td>";
					sDni = resultSet.getString("dni");
					sDni2 = "<td>" + resultSet.getString("dni") + "</td>";
					bCategoria = "<td>" + resultSet.getByte("categoria") + "</td>";
					bAnios = "<td>" + resultSet.getByte("anio") + "</td>";

					sResultado += "<tr style='text-align: center;" + "        background-color: pink;'>" + sNombre
							+ sDni2 + sLetra + bCategoria + bAnios + "<td>" + Float.toString(getSalaryDB(sDni))
							+ "</td></tr>";

				}
				sResultado += "</table>";

				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sResultado;

	}

	@Override
	public String showEmployee(Empleado oEmpleado) {
		String sResultado = "Empleado no registrado";

		String sNombre = null;
		String sLetra = null;
		String sDni = null;
		String sDni2 = null;
		String bCategoria = null;
		String bAnios = null;

		sDni = oEmpleado.getsDni();

		String sql2 = "SELECT COUNT(*) FROM EMPLEADO WHERE DNI = '" + sDni + "';";

		if (ConexionDB.executeCount(sql2) != 0) {

			String sql = "SELECT * FROM EMPLEADO WHERE DNI = '" + sDni + "';";

			sResultado = "<table border='1px' style='margin: 0 auto;'><tr style='background-color: aqua;'><th>NOMBRE</th><th>DNI</th><th>SEXO</th><th>CATEGORIA</th><th>ANIOS</th><th>SUELDO (EUROS)</th></tr>";

			try {
				Statement statement = ConexionDB.getConnection().createStatement();
				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {

					sNombre = "<td>" + resultSet.getString("nombre") + "</td>";
					sLetra = "<td>" + resultSet.getString("sexo") + "</td>";
					sDni = resultSet.getString("dni");
					sDni2 = "<td>" + resultSet.getString("dni") + "</td>";
					bCategoria = "<td>" + resultSet.getByte("categoria") + "</td>";
					bAnios = "<td>" + resultSet.getByte("anio") + "</td>";

					sResultado += "<tr style='text-align: center;" + "        background-color: pink;'>" + sNombre
							+ sDni2 + sLetra + bCategoria + bAnios + "<td>" + Float.toString(getSalaryDB(sDni))
							+ "</td></tr>";

				}
				sResultado += "</table>";

				resultSet.close();
				statement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return sResultado;
		}
		return sResultado;

	}

	@Override
	public boolean editEmployee(Empleado oEmpleado, Empleado oEmpleadoModificado) {

		boolean bExito = false;

		String sDniBuscador = oEmpleado.getsDni();

		String sql = "SELECT COUNT(*) FROM EMPLEADO WHERE DNI = '" + sDniBuscador + "' ";

		if (ConexionDB.executeCount(sql) != 0) {

			String sNombre = oEmpleadoModificado.getsNombre();
			char cLetra = oEmpleadoModificado.getcLetra();
			String sDni = oEmpleadoModificado.getsDni();
			byte bCategoria = oEmpleadoModificado.getbCategoria();
			byte bAnios = oEmpleadoModificado.getbAnyosTrabajados();

			String sql2 = "INSERT INTO EMPLEADO VALUES ('" + sNombre + "'," + bCategoria + "," + bAnios + ",'" + sDni
					+ "','" + cLetra + "')";

			ConexionDB.executeUpdate(sql2);
			bExito = true;

		}
		return bExito;

	}

	@Override
	public void upDateSalaryAll() {

		String sql = "UPDATE empleado SET anio = (SELECT anio FROM empleado)+1;";

		ConexionDB.executeUpdate(sql);
	}

	@Override
	public Empleado bringEmployee(Empleado oEmpleado) {

		String sDni = oEmpleado.getsDni();

		Empleado oEmpleadoBuscador = null;

		String sql = "SELECT COUNT(*) FROM EMPLEADO WHERE DNI = '" + sDni + "'";

		if (ConexionDB.executeCount(sql) != 0) {

			String sql2 = "SELECT * FROM EMPLEADO WHERE DNI = '" + sDni + "'";

			try {
				Statement statement = ConexionDB.getConnection().createStatement();
				ResultSet resultSet = statement.executeQuery(sql2);

				while (resultSet.next()) {

					String sNombre = resultSet.getString("nombre");
					String sLetra = resultSet.getString("sexo");
					sDni = resultSet.getString("dni");
					byte bCategoria = resultSet.getByte("categoria");
					byte bAnios = resultSet.getByte("anio");

					char cLetra = sLetra.charAt(0);

					oEmpleadoBuscador = new Empleado(sNombre, sDni, cLetra, bAnios, bCategoria);
				}
				resultSet.close();
				statement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return oEmpleadoBuscador;
		}
		return oEmpleadoBuscador;
	}

	@Override
	public boolean upDateSalary(Empleado oEmpleado, Empleado oEmpleadoEditado) {

		boolean bExito = false;

		String sDniBuscador = oEmpleado.getsDni();

		String sql = "SELECT COUNT(*) FROM EMPLEADO WHERE DNI = '" + sDniBuscador + "'";

		if (ConexionDB.executeCount(sql) != 0) {

		}
		return bExito;

	}

	public float getSalaryDB(String sDni) {
		float fResultado = 0;
		String sql = "SELECT SUELDO FROM NOMINA WHERE DNI = '" + sDni + "';";
		try {
			Statement statement = ConexionDB.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				float fSueldo = resultSet.getFloat("sueldo");

				fResultado = fSueldo;

			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fResultado;
	}

	public String showAllEmployeeEditDNI(Empleado oEmpleado) {
		String sResultado = "Empleado no registrado";

		String sNombre = null;
		String sLetra = null;
		String sDni = null;
		String sDni2 = null;
		String bCategoria = null;
		String bAnios = null;
		sDni = oEmpleado.getsDni();

		String sql2 = "SELECT COUNT(*) FROM EMPLEADO WHERE DNI = '" + sDni + "';";

		if (ConexionDB.executeCount(sql2) != 0) {

			String sql = "SELECT * FROM EMPLEADO WHERE DNI = '" + sDni + "';";

			sResultado = "<table border='1px' style='margin: 0 auto;'><tr style='background-color: aqua;'><th>NOMBRE</th><th>DNI</th><th>SEXO</th><th>CATEGORIA</th><th>ANIOS</th><th>SUELDO (EUROS)</th></tr>";

			try {
				Statement statement = ConexionDB.getConnection().createStatement();
				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					sDni = resultSet.getString("dni");

					sNombre = "<td>" + resultSet.getString("nombre")
					+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoNOMBRE&campoEdit="+sDni+"' method='post'>"
					+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
					+ "				type='text' name='menuApp' placeholder='Introduzca (NOMBRE):'"
					+ "				title='Debe poner 8 numeros y una letra'"
					+ "				size='3px'/> <input"
					+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
					+ "				value='EDIT'/>" + "</form></td>";
					sLetra = "<td>" + resultSet.getString("sexo")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoSEXO&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Introduzca H o M (SEXO):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";
					sDni2 = "<td>" + resultSet.getString("dni")
					+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoDNI&campoEdit="+sDni+"' method='post'>"
					+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
					+ "				type='text' name='menuApp' placeholder='Introduzca (DNI):'"
					+ "				title='Debe poner 8 numeros y una letra'"
					+ "				size='3px'/> <input"
					+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
					+ "				value='EDIT'/>" + "</form></td>";
					bCategoria = "<td>" + resultSet.getByte("categoria")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoCATEGORIA&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Categoria (1-10):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";
					bAnios = "<td>" + resultSet.getByte("anio")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoANIO&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Introduzca 1-80 (ANIOS):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";

					sResultado += "<tr style='text-align: center;" + "        background-color: pink;'>" + sNombre
							+ sDni2 + sLetra + bCategoria + bAnios + "<td>" + Float.toString(getSalaryDB(sDni))
							+ "</td></tr>";

				}
				sResultado += "</table>";

				resultSet.close();
				statement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return sResultado;
		}
		return sResultado;

	}

	public String upDateCampoDNI(Empleado oEmpleadoExistente, Empleado oEmpleadoActualizado) {
		
		String sDniAnterior = oEmpleadoExistente.getsDni();
		String sDniUpDate = oEmpleadoActualizado.getsDni();
		
		String sql ="UPDATE EMPLEADO SET DNI = '"+sDniUpDate+"' WHERE DNI = '"+sDniAnterior+"';";

		ConexionDB.executeUpdate(sql);
		
		return showEmployee(oEmpleadoActualizado);


		
	}

	public String upDateCampoNOMBRE(Empleado oEmpleadoExistente, Empleado oEmpleadoActualizado) {

		String sDniAnterior = oEmpleadoExistente.getsDni();
		String sNombreUpDate = oEmpleadoActualizado.getsNombre();
		
		String sql ="UPDATE EMPLEADO SET NOMBRE = '"+sNombreUpDate+"' WHERE DNI = '"+sDniAnterior+"';";

		ConexionDB.executeUpdate(sql);
		
		return showEmployee(oEmpleadoExistente);


		
	}

	public String upDateCampoLETRA(Empleado oEmpleadoExistente, Empleado oEmpleadoActualizado) {
		String sDniAnterior = oEmpleadoExistente.getsDni();
		char cLetra =oEmpleadoActualizado.getcLetra();
		
		String sql ="UPDATE EMPLEADO SET SEXO = '"+cLetra+"' WHERE DNI = '"+sDniAnterior+"';";

		ConexionDB.executeUpdate(sql);
		
		return showEmployee(oEmpleadoExistente);


		
	}

	public String upDateCampoCATEGORIA(Empleado oEmpleadoExistente, Empleado oEmpleadoActualizado) {
		String sDniAnterior = oEmpleadoExistente.getsDni();
		byte bCategoria =oEmpleadoActualizado.getbCategoria();
		
		String sql ="UPDATE EMPLEADO SET CATEGORIA = "+bCategoria+" WHERE DNI = '"+sDniAnterior+"';";

		ConexionDB.executeUpdate(sql);
		
		return showEmployee(oEmpleadoExistente);


		
	}

	public String upDateCampoANIO(Empleado oEmpleadoExistente, Empleado oEmpleadoActualizado) {
		String sDniAnterior = oEmpleadoExistente.getsDni();
		byte bAnio =oEmpleadoActualizado.getbAnyosTrabajados();
		
		String sql ="UPDATE EMPLEADO SET ANIO = "+bAnio+" WHERE DNI = '"+sDniAnterior+"';";

		ConexionDB.executeUpdate(sql);
		
		return showEmployee(oEmpleadoExistente);


		
	}

	public String showAllEmployeeEditNOMBRE(Empleado oEmpleado) {
		String sResultado = "Empleado no registrado con ese nombre";

		String sNombre = null;
		String sLetra = null;
		String sDni = null;
		String sDni2 = null;
		String bCategoria = null;
		String bAnios = null;

		sNombre = oEmpleado.getsNombre();

		String sql2 = "SELECT COUNT(*) FROM EMPLEADO WHERE NOMBRE = '" + sNombre + "';";

		if (ConexionDB.executeCount(sql2) != 0) {

			String sql = "SELECT * FROM EMPLEADO WHERE NOMBRE = '" + sNombre + "';";

			sResultado = "<table border='1px' style='margin: 0 auto;'><tr style='background-color: aqua;'><th>NOMBRE</th><th>DNI</th><th>SEXO</th><th>CATEGORIA</th><th>ANIOS</th><th>SUELDO (EUROS)</th></tr>";

			try {
				Statement statement = ConexionDB.getConnection().createStatement();
				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					sDni = resultSet.getString("dni");

					sNombre = "<td>" + resultSet.getString("nombre")
					+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoNOMBRE&campoEdit="+sDni+"' method='post'>"
					+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
					+ "				type='text' name='menuApp' placeholder='Introduzca (NOMBRE):'"
					+ "				title='Debe poner 8 numeros y una letra'"
					+ "				size='3px'/> <input"
					+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
					+ "				value='EDIT'/>" + "</form></td>";
					sLetra = "<td>" + resultSet.getString("sexo")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoSEXO&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Introduzca H o M (SEXO):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";
					sDni2 = "<td>" + resultSet.getString("dni")
					+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoDNI&campoEdit="+sDni+"' method='post'>"
					+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
					+ "				type='text' name='menuApp' placeholder='Introduzca (DNI):'"
					+ "				title='Debe poner 8 numeros y una letra'"
					+ "				size='3px'/> <input"
					+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
					+ "				value='EDIT'/>" + "</form></td>";
					bCategoria = "<td>" + resultSet.getByte("categoria")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoCATEGORIA&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Categoria (1-10):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";
					bAnios = "<td>" + resultSet.getByte("anio")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoANIO&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Introduzca 1-80 (ANIOS):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";

					sResultado += "<tr style='text-align: center;" + "        background-color: pink;'>" + sNombre
							+ sDni2 + sLetra + bCategoria + bAnios + "<td>" + Float.toString(getSalaryDB(sDni))
							+ "</td></tr>";

				}
				sResultado += "</table>";

				resultSet.close();
				statement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return sResultado;
		}
		return sResultado;

	}
	public String showAllEmployeeEditSEXO(Empleado oEmpleado) {
		String sResultado = "Empleado no registrado con ese sexo";

		String sNombre = null;
		String sLetra = null;
		String sDni = null;
		String sDni2 = null;
		String bCategoria = null;
		String bAnios = null;
		char cLetra =0;

		cLetra = oEmpleado.getcLetra();
		
		String sLetraBuscador = cLetra+"";

		String sql2 = "SELECT COUNT(*) FROM EMPLEADO WHERE SEXO = '" + sLetraBuscador + "';";

		if (ConexionDB.executeCount(sql2) != 0) {

			String sql = "SELECT * FROM EMPLEADO WHERE SEXO = '" + sLetraBuscador + "';";

			sResultado = "<table border='1px' style='margin: 0 auto;'><tr style='background-color: aqua;'><th>NOMBRE</th><th>DNI</th><th>SEXO</th><th>CATEGORIA</th><th>ANIOS</th><th>SUELDO (EUROS)</th></tr>";

			try {
				Statement statement = ConexionDB.getConnection().createStatement();
				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					sDni = resultSet.getString("dni");

					sNombre = "<td>" + resultSet.getString("nombre")
					+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoNOMBRE&campoEdit="+sDni+"' method='post'>"
					+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
					+ "				type='text' name='menuApp' placeholder='Introduzca (NOMBRE):'"
					+ "				title='Debe poner 8 numeros y una letra'"
					+ "				size='3px'/> <input"
					+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
					+ "				value='EDIT'/>" + "</form></td>";
					sLetra = "<td>" + resultSet.getString("sexo")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoSEXO&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Introduzca H o M (SEXO):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";
					sDni2 = "<td>" + resultSet.getString("dni")
					+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoDNI&campoEdit="+sDni+"' method='post'>"
					+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
					+ "				type='text' name='menuApp' placeholder='Introduzca (DNI):'"
					+ "				title='Debe poner 8 numeros y una letra'"
					+ "				size='3px'/> <input"
					+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
					+ "				value='EDIT'/>" + "</form></td>";
					bCategoria = "<td>" + resultSet.getByte("categoria")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoCATEGORIA&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Categoria (1-10):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";
					bAnios = "<td>" + resultSet.getByte("anio")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoANIO&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Introduzca 1-80 (ANIOS):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";

					sResultado += "<tr style='text-align: center;" + "        background-color: pink;'>" + sNombre
							+ sDni2 + sLetra + bCategoria + bAnios + "<td>" + Float.toString(getSalaryDB(sDni))
							+ "</td></tr>";

				}
				sResultado += "</table>";

				resultSet.close();
				statement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return sResultado;
		}
		return sResultado;

	}
	public String showAllEmployeeEditCATEGORIA(Empleado oEmpleado) {
		String sResultado = "Empleado no registrado con esa categoria";

		String sNombre = null;
		String sLetra = null;
		String sDni = null;
		String sDni2 = null;
		String bCategoria = null;
		String bAnios = null;

		byte bCategoriaBuscador = oEmpleado.getbCategoria();
		

		String sql2 = "SELECT COUNT(*) FROM EMPLEADO WHERE CATEGORIA = '" + bCategoriaBuscador + "';";

		if (ConexionDB.executeCount(sql2) != 0) {

			String sql = "SELECT * FROM EMPLEADO WHERE CATEGORIA = '" + bCategoriaBuscador + "';";

			sResultado = "<table border='1px' style='margin: 0 auto;'><tr style='background-color: aqua;'><th>NOMBRE</th><th>DNI</th><th>SEXO</th><th>CATEGORIA</th><th>ANIOS</th><th>SUELDO (EUROS)</th></tr>";

			try {
				Statement statement = ConexionDB.getConnection().createStatement();
				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					sDni = resultSet.getString("dni");

					sNombre = "<td>" + resultSet.getString("nombre")
					+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoNOMBRE&campoEdit="+sDni+"' method='post'>"
					+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
					+ "				type='text' name='menuApp' placeholder='Introduzca (NOMBRE):'"
					+ "				title='Debe poner 8 numeros y una letra'"
					+ "				size='3px'/> <input"
					+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
					+ "				value='EDIT'/>" + "</form></td>";
					sLetra = "<td>" + resultSet.getString("sexo")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoSEXO&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Introduzca H o M (SEXO):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";
					sDni2 = "<td>" + resultSet.getString("dni")
					+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoDNI&campoEdit="+sDni+"' method='post'>"
					+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
					+ "				type='text' name='menuApp' placeholder='Introduzca (DNI):'"
					+ "				title='Debe poner 8 numeros y una letra'"
					+ "				size='3px'/> <input"
					+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
					+ "				value='EDIT'/>" + "</form></td>";
					bCategoria = "<td>" + resultSet.getByte("categoria")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoCATEGORIA&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Categoria (1-10):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";
					bAnios = "<td>" + resultSet.getByte("anio")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoANIO&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Introduzca 1-80 (ANIOS):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";

					sResultado += "<tr style='text-align: center;" + "        background-color: pink;'>" + sNombre
							+ sDni2 + sLetra + bCategoria + bAnios + "<td>" + Float.toString(getSalaryDB(sDni))
							+ "</td></tr>";

				}
				sResultado += "</table>";

				resultSet.close();
				statement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return sResultado;
		}
		return sResultado;

	}
	public String showAllEmployeeEditANIO(Empleado oEmpleado) {
		String sResultado = "Empleado no registrado con esa experiencia en anios";

		String sNombre = null;
		String sLetra = null;
		String sDni = null;
		String sDni2 = null;
		String bCategoria = null;
		String bAnios = null;

		byte bAnioBuscador = oEmpleado.getbAnyosTrabajados();
		

		String sql2 = "SELECT COUNT(*) FROM EMPLEADO WHERE ANIO = '" + bAnioBuscador + "';";

		if (ConexionDB.executeCount(sql2) != 0) {

			String sql = "SELECT * FROM EMPLEADO WHERE ANIO = '" + bAnioBuscador + "';";

			sResultado = "<table border='1px' style='margin: 0 auto;'><tr style='background-color: aqua;'><th>NOMBRE</th><th>DNI</th><th>SEXO</th><th>CATEGORIA</th><th>ANIOS</th><th>SUELDO (EUROS)</th></tr>";

			try {
				Statement statement = ConexionDB.getConnection().createStatement();
				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					sDni = resultSet.getString("dni");

					sNombre = "<td>" + resultSet.getString("nombre")
					+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoNOMBRE&campoEdit="+sDni+"' method='post'>"
					+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
					+ "				type='text' name='menuApp' placeholder='Introduzca (NOMBRE):'"
					+ "				title='Debe poner 8 numeros y una letra'"
					+ "				size='3px'/> <input"
					+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
					+ "				value='EDIT'/>" + "</form></td>";
					sLetra = "<td>" + resultSet.getString("sexo")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoSEXO&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Introduzca H o M (SEXO):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";
					sDni2 = "<td>" + resultSet.getString("dni")
					+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoDNI&campoEdit="+sDni+"' method='post'>"
					+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
					+ "				type='text' name='menuApp' placeholder='Introduzca (DNI):'"
					+ "				title='Debe poner 8 numeros y una letra'"
					+ "				size='3px'/> <input"
					+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
					+ "				value='EDIT'/>" + "</form></td>";
					bCategoria = "<td>" + resultSet.getByte("categoria")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoCATEGORIA&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Categoria (1-10):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";
					bAnios = "<td>" + resultSet.getByte("anio")
							+ "<form action='ServletController?action=urlConexion&method=Ok&eleccion=UpDateEditEmpleadoANIO&campoEdit="+sDni+"' method='post'>"
							+ "			<input style='padding: 0.5m;  font-size: 0.9em'"
							+ "				type='text' name='menuApp' placeholder='Introduzca 1-80 (ANIOS):'"
							+ "				title='Debe poner 8 numeros y una letra'"
							+ "				size='3px'/> <input"
							+ "				style='padding: 0.5em; font-size: 0.9em' type='submit'"
							+ "				value='EDIT'/>" + "</form></td>";

					sResultado += "<tr style='text-align: center;" + "        background-color: pink;'>" + sNombre
							+ sDni2 + sLetra + bCategoria + bAnios + "<td>" + Float.toString(getSalaryDB(sDni))
							+ "</td></tr>";

				}
				sResultado += "</table>";

				resultSet.close();
				statement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return sResultado;
		}
		return sResultado;

	}
}
