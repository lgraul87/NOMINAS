<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>

<title>Tabla empleados</title>
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
	background-color: #DFCFF5;
	color: black;
}

h1{
text-align: center;
}
</style>
</head>
<body style="background-color: #D0F2E0;">

<br>
<h1>Tabla empleados</h1>
	
	<br>
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
</html>