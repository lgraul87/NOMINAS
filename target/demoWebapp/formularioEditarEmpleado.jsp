<%@page import="vista.principal.CalculaNominas"%>
<%@page import="modelo.laboral.Empleado"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado de la busqueda editar empleado</title>
<style type="text/css">
table {
	align-content: center;
	text-align: center;
	margin: 0 auto;
	border: 1px;
	width: 60%;
}

th {
	background-color: black;
	color: white;
}

td {
	text-align: left;
	background-color: #DFCFF5;
	color: black;
	background-color: #DFCFF5;
}

h1 {
	text-align: center;
}
</style>
</head>
<body>
<body style="background-color: #D0F2E0;">

	<%
		String sDni = request.getParameter("dni");
	Empleado oEmpleado = new Empleado(sDni);
	
	Empleado oEmpleadoEncontrado = CalculaNominas.controlGeneral.getEmpleadoController().bringEmployee(oEmpleado);
	%>

	<form action="ServletController?eleccion=upDateEmpleado" method="post">

		<table>
			<tbody>
				<tr>
					<th>CAMPO</th>
					<th>VALOR</th>

				</tr>
				<tr>

					<td><label for="nombre">Nombre:</label></td>

					<td><input type="text" id="nombre"
						name="nombre" value=<%oEmpleadoEncontrado.getsNombre(); %> placeholder="Nombre:"
						title="Introduzca aqui el nombre del empleado, si quiere editarlo."></input>
					</td>
				</tr>

				<tr>
					<td><label for="dni">DNI:</label></td>

					<td><input type="text" id="dni"
						name="dni"; value=<%oEmpleadoEncontrado.getsDni(); %> placeholder="Dni:"
						title="Introduzca aqui el dni del empleado, si quiere editarlo."></input>
					</td>
				</tr>

				<tr>
					<td><label for="sexo">Sexo:</label></td>

					<td><input type="text" id="sexo"
						name="sexo" value=<%oEmpleadoEncontrado.getcLetra(); %> placeholder="Sexo(H o M):"
						title="Introduzca aqui el sexo del empleado, si quiere editarlo."></input>
					</td>
				</tr>

				<tr>
					<td><label for="categoria">Categoria:</label></td>

					<td><input type="text" id="categoria"
						name="categoria" value=<%oEmpleadoEncontrado.getbCategoria(); %>
						placeholder="Categoria:"
						title="Introduzca aqui la categoria del empleado, si quiere editarlo."></input>
					</td>
				</tr>

				<tr>
					<td><label for="anio">Anios:</label></td>

					<td><input type="text" id="anio"
						name="anio" value=<%oEmpleadoEncontrado.getbAnyosTrabajados(); %>
						 placeholder="Anio/s:"
						title="Introduzca aqui el numero de anios del empleado, si quiere editarlo."></input>
				</tr>
				<tr>
					<td><label for="enviar">Enviar Datos: </label></td>

					<td><input type="submit"></input>
				</tr>
			</tbody>
		</table>
	</form>
</html>