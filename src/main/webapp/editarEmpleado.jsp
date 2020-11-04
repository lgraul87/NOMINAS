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
		<br> <br> <br> <br> <br> <br>
		<h1>EDITAR EMPLEADO</h1>
		<div style="text-align: center;">
			<br>
			<h1 style="text-align: center; color: white;">EMPLEADOS:</h1>
			<br>
			<h3><%=request.getAttribute("tablaEmpleados")%></h3>
		</div>

		<form
			action="ServletController?action=urlConexion&method=Ok&eleccion=editEmpleadoDNI"
			method="post">

			<input style="min-width: 300px; padding: 0.5em; font-size: 1.2em"
				type="text" name="menuApp" placeholder="Buscar por DNI"
				title="Debe poner 8 numeros y una letra" /> <input
				style="padding: 0.5em; font-size: 1.2em" type="submit"
				value="Enviar" />
		</form>
		<form
			action="ServletController?action=urlConexion&method=Ok&eleccion=editEmpleadoNOMBRE"
			method="post">

			<input style="min-width: 300px; padding: 0.5em; font-size: 1.2em"
				type="text" name="menuApp" placeholder="Buscar por NOMBRE"
				title="Debe poner 8 numeros y una letra" /> <input
				style="padding: 0.5em; font-size: 1.2em" type="submit"
				value="Enviar" />
		</form>
		<form
			action="ServletController?action=urlConexion&method=Ok&eleccion=editEmpleadoSEXO"
			method="post">

			<input style="min-width: 300px; padding: 0.5em; font-size: 1.2em"
				type="text" name="menuApp" placeholder="Buscar por SEXO"
				title="Debe poner 8 numeros y una letra" /> <input
				style="padding: 0.5em; font-size: 1.2em" type="submit"
				value="Enviar" />
		</form>
		<form
			action="ServletController?action=urlConexion&method=Ok&eleccion=editEmpleadoCATEGORIA"
			method="post">

			<input style="min-width: 300px; padding: 0.5em; font-size: 1.2em"
				type="text" name="menuApp" placeholder="Buscar por CATEGORIA"
				title="Debe poner 8 numeros y una letra" /> <input
				style="padding: 0.5em; font-size: 1.2em" type="submit"
				value="Enviar" />
		</form>
		<form
			action="ServletController?action=urlConexion&method=Ok&eleccion=editEmpleadoANIO"
			method="post">

			<input style="min-width: 300px; padding: 0.5em; font-size: 1.2em"
				type="text" name="menuApp" placeholder="Buscar por ANIO"
				title="Debe poner 8 numeros y una letra" /> <input
				style="padding: 0.5em; font-size: 1.2em" type="submit"
				value="Enviar" />
		</form>
	</div>

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