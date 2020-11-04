<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">



<style>
body {
	background-image:
		url("https://image.freepik.com/free-vector/abstract-machine-background-with-technology_41981-321.jpg");
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

<body>
	<div class="p-3 mb-2 bg-info text-white">
		<h2>
			Bienvenido a la app calcula-nomina <span
				class="badge badge-secondary">New</span>
		</h2>

	</div>
	<br>
	<br>
	<br>
	<!-- #####   BOTONES #####################################################################-->
	<div class="btn-group-vertical">

		<form
			action="ServletController?action=urlConexion&method=Ok&eleccion=buscaPagina"
			method="post">



			<button class="btn btn-outline-primary"
				onmouseover="this.style.backgroundColor='yellow'"
				onmouseout="this.style.backgroundColor='#eeeeee'"
				style="border-radius: 20px" type="submit" name="menuApp"
				value="Entrar a la app">


				<img
					src="C:\Users\lgrau\eclipse-workspace\demoWebapp.zip_expanded\demoWebapp\src\main\imagenes\enter.jpg"
					style="border: 0px solid; width: 1750px; height: 1750px;" />

			</button>

		</form>

		<!-- #####   BOTONES #####################################################################-->

		<form
			action="ServletController?action=urlConexion&method=Ok&eleccion=buscaPagina"
			method="post">

			<button class="btn btn-outline-primary"
				onmouseover="this.style.backgroundColor='yellow'"
				onmouseout="this.style.backgroundColor='#eeeeee'"
				style="border-radius: 20px" type="submit" name="menuApp"
				value="Entrar a la demo">

				<img
					src="C:\Users\lgrau\eclipse-workspace\demoWebapp.zip_expanded\demoWebapp\src\main\imagenes\demo.jpg"
					style="border: 0px solid; width: 1750px; height: 1750px;" />
			</button>


		</form>

		<!-- #####   BOTONES #####################################################################-->

		<form
			action="ServletController?action=urlConexion&method=Ok&eleccion=buscaPagina"
			method="post">

			<button class="btn btn-outline-primary"
				onmouseover="this.style.backgroundColor='yellow'"
				onmouseout="this.style.backgroundColor='#eeeeee'"
				style="border-radius: 20px" type="submit" name="menuApp"
				value="Salir">


				<img
					src="C:\Users\lgrau\eclipse-workspace\demoWebapp.zip_expanded\demoWebapp\src\main\imagenes\exit.jpg"
					style="border: 0px solid; width: 1750px; height: 1750px;" />


			</button>
		</form>
	</div>
</body>
</html>
