<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busqueda editar empleado</title>
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
<body style="background-color: #D0F2E0;">

	<br>
	<h1>Busqueda editar empleado</h1>

	<form action="ServletController?eleccion=editEmpleado&menuApp=buscaPagina" method="post">
		<table border="1" style="margin: 0 auto;">
			<tr>
				<th>Buscar empleado</th>

				<th>Campo</th>
			</tr>

			<tr>

				<td><label for="nombre">Buscar por nombre:</label></td>

				<td><input type="text" id="nombre" name="nombre"
					placeholder="Nombre:"
					title="Introduzca aqui el nombre del empleado, si quiere encontrar las coincidencias respecto a los nombres de los empleados"></input>
				</td>
			</tr>

			<tr>
				<td><label for="dni">Buscar por DNI:</label></td>

				<td><input type="text" id="dni" name="dni" placeholder="Dni:"
					title="Introduzca aqui el dni del empleado, si quiere encontrar las coincidencias respecto a los dni de los empleados"></input>
				</td>
			</tr>

			<tr>
				<td><label for="sexo">Buscar por Sexo:</label></td>

				<td><input type="text" id="sexo" name="sexo"
					placeholder="Sexo(H o M):"
					title="Introduzca aqui el sexo del empleado, solo con la letra H (Hombre) o M (Mujer) si quiere encontrar las coincidencias respecto al sexo de los empleados"></input>
				</td>
			</tr>

			<tr>
				<td><label for="categoria">Buscar por Categoria:</label></td>

				<td><input type="text" id="categoria" name="categoria"
					placeholder="Categoria:"
					title="Introduzca aqui la categoria del empleado, solo valores entre 1 y 10, si quiere encontrar las coincidencias respecto a las categorias de los empleados"></input>
				</td>
			</tr>

			<tr>
				<td><label for="anio">Buscar por Anios:</label></td>

				<td><input type="text" id="anio" name="anio"
					placeholder="Anio/s:"
					title="Introduzca aqui el numero de anios del empleado, si quiere encontrar las coincidencias respecto a los anios de experiencia de los empleados"></input>
				</td>
			</tr>
			<tr>
				<td>Pulsa enviar para enviar todos los datos:</td>
				<td><input type="submit" value="enviar"></td>
			</tr>



		</table>
	</form>


	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
		<h1>Datos en la base de datos:</h1>
	
	<br>

	<table>
		<tbody>
			<tr>
				<th>NOMBRE</th>
				<th>DNI</th>
				<th>SEXO</th>
				<th>CATEGORIA</th>
				<th>ANIOS</th>
			</tr>

			<c:forEach var="empleado" items="${listaEmpleados}">
				<tr>
					<td><c:out value="${empleado.sNombre}" /></td>
					<td><c:out value="${empleado.sDni}" /></td>
					<td><c:out value="${empleado.cLetra}" /></td>
					<td><c:out value="${empleado.bCategoria}" /></td>
					<td><c:out value="${empleado.bAnyosTrabajados}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>