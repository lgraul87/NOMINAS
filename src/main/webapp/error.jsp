<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center; color: white; font-size: 5em;">
		<div class="p-3 mb-2 bg-danger text-white">
			<p>Sin acceso, motivo:</p>
			<p><%=request.getAttribute("causa")%></p>
		</div>
	</div>
	<form
		action="ServletController?action=urlConexion&method=Ok&eleccion=buscaPagina"
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