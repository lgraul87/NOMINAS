<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

	<ul>
		<li><form
				action="ServletController?action=urlConexion&method=Ok&eleccion=buscaPagina"
				method="post">
				<!-- Atras ###################################################################################: -->
				<button onmouseover="this.style.backgroundColor='yellow'"
					onmouseout="this.style.backgroundColor='#eeeeee'" type="submit"
					style="border: 0px solid; width: 50px; height: 50px;"
					name="menuApp" value="atrasIndex">
					<img
						src="C:\Users\lgrau\eclipse-workspace\demoWebapp.zip_expanded\demoWebapp\src\main\imagenes\atras.png"
						style="border: 0px solid; width: 50px; height: 50px;" />

				</button>

			</form>
			<h2>Pagina demo</h2></li>
	</ul>

	<div class="p-3 mb-2 bg-info text-white"></div>




</body>
</html>