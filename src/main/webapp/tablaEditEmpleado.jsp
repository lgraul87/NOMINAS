<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: palegoldenrod;">

	<div style="text-align: center;">
		<br>
		<h1 style="text-align: center;">EDITAR EMPLEADO:</h1>
		<br>
		<h3><%=request.getAttribute("tablaEmpleados")%></h3>
	</div>
	
	<form action="ServletController?action=urlConexion&method=Ok&eleccion=buscaPagina"
		method="post">

		<!-- Atras ###################################################################################: -->
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