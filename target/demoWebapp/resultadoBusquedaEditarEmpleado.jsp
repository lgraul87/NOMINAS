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
					<td><c:out value="${empleado.sNombre}"/></td>
					<td><c:out value="${empleado.sDni}" /></td>
					<td><c:out value="${empleado.cLetra}" /></td>
					<td><c:out value="${empleado.bCategoria}" /></td>
					<td><c:out value="${empleado.bAnyosTrabajados}" /></td>
					<td><a href="./formularioEditarEmpleado.jsp?dni=${empleado.sDni}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- Atras ###################################################################################: -->
	<form
		action="ServletController?action=urlConexion&method=Ok&eleccion=buscaPagina"
		method="post">

		<button onmouseover="this.style.backgroundColor='yellow'"
			onmouseout="this.style.backgroundColor='#eeeeee'" type="submit"
			style="border: 0px solid; width: 150px; height: 150px;"
			name="menuApp" value="atrasMenuApp">
			<img
				src="C:\Users\lgrau\eclipse-workspace\demoWebapp.zip_expanded\demoWebapp\src\main\imagenes\atras.png"
				style="border: 0px solid; width: 150px; height: 150px;" />
		</button>
	</form>
</body>
</html>