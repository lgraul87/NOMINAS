<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu gestor de nominas</title>
<style>
body {
	background-image:
		url("https://lh3.googleusercontent.com/proxy/nIGOEPRIkza2S8wX_Id7sLE3ixtJlbC5kEVorwJ3MqNy2Kykx7App4y9nmfJhJtsvjXkFGuBktU0M308Gt3EycV8M7e4CIF_6qyC2Mmz4Ax4J5KmeQtgTfXYti9XQjUEi5NRGswnHWa16jCYalv4RTrpPAEQ9-PVCEg");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	height: 100%;
	width: 100%;
}

button {
	padding: 0px;
	margin: 0px;
}
</style>

</head>

<body style="background: teal;">
	<h1>Gestor de nominas</h1>
	<h2>Elija opcion:</h2>

	<form action="ServletController?action=urlConexion&method=Ok&eleccion=buscaPagina"
		method="post">

		<!-- Atras ###################################################################################: -->
		<button onmouseover="this.style.backgroundColor='yellow'"
			onmouseout="this.style.backgroundColor='#eeeeee'" type="submit"
			style="border: 0px solid; width: 1750px; height: 1750px;"
			name="menuApp" value="atrasIndex">
			<img
				src="C:\Users\lgrau\eclipse-workspace\demoWebapp.zip_expanded\demoWebapp\src\main\imagenes\atras.png"
				style="border: 0px solid; width: 1750px; height: 1750px;" />
		</button>
	</form>

	<!-- Mostrar empleados (Todos)###################################################################################: -->

	<form action="ServletController?action=urlConexion&method=Ok&eleccion=buscaPagina"
		method="post">

		<button onmouseover="this.style.backgroundColor='yellow'"
			onmouseout="this.style.backgroundColor='#eeeeee'" type="submit"
			style="border: 0px solid; width: 1750px; height: 1750px;"
			name="menuApp" value="mostrarEmpleados">
			<img
				src="C:\Users\lgrau\eclipse-workspace\demoWebapp.zip_expanded\demoWebapp\src\main\imagenes\verTodos.png"
				style="border: 0px solid; width: 1750px; height: 1750px;" />
		</button>
	</form>

	<!--Mostrar Salario de un empleado (DNI):###################################################################################: -->

	<form action="ServletController?action=urlConexion&method=Ok&eleccion=buscaPagina"
		method="post">
		<button onmouseover="this.style.backgroundColor='yellow'"
			onmouseout="this.style.backgroundColor='#eeeeee'" type="submit"
			style="border: 0px solid; width: 1750px; height: 1750px;"
			name="menuApp" value="mostrarSalarioFormulario">
			<img
				src="C:\Users\lgrau\eclipse-workspace\demoWebapp.zip_expanded\demoWebapp\src\main\imagenes\buscarEmpleado.jpg"
				style="border: 0px solid; width: 1750px; height: 1750px;" />
		</button>
	</form>

	<!--Modificar empleado (DNI):###################################################################################: -->

	<form action="ServletController?action=urlConexion&method=Ok&eleccion=buscaPagina"
		method="post">
		<button onmouseover="this.style.backgroundColor='yellow'"
			onmouseout="this.style.backgroundColor='#eeeeee'" type="submit"
			style="border: 0px solid; width: 1750px; height: 1750px;"
			name="menuApp" value="modificarEmpleado">
			<img
				src="C:\Users\lgrau\eclipse-workspace\demoWebapp.zip_expanded\demoWebapp\src\main\imagenes\edit.png"
				style="border: 0px solid; width: 1750px; height: 1750px;" />
		</button>



	</form>

</body>
</html>