package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.database.ConexionDB;
import modelo.laboral.Empleado;
import vista.principal.CalculaNominas;

/**
 * Servlet implementation class ServletComunicador
 */
public class ServletComunicador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletComunicador() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

		System.out.println("Estableciendo comunicacion");

		String sMode = (String) request.getAttribute("sEntrar");

		String sKeyPagina = (String) request.getAttribute("sAccion");

		String sNext = null;

		switch (sMode) {
		case "buscaPagina":
			switch (sKeyPagina) {
			// ###################### ENTRAR A LA APP ##################
			case "Entrar a la app":
				sNext = "menuApp.jsp";
				break;
			// ###################### ENTRAR A LA DEMO #################

			case "Entrar a la demo":
				sNext = "demo.jsp";
				break;
			// ###################### SALIR DE LA APP ##################

			case "Salir":
				sNext = "salir.jsp";
				break;
			// ###################### ATRAS -> INDEX ###################

			case "atrasIndex": {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
				requestDispatcher.forward(request, response);
			}
				break;
			// ###################### ATRAS -> MENU APP #################

			case "atrasMenuApp": {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("menuApp.jsp");
				requestDispatcher.forward(request, response);
			}
				break;

			// ###################### ENTRAR A LA DEMO ##################

			case "mostrarSalarioFormulario": {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("mostrarSalarioFormulario.jsp");
				requestDispatcher.forward(request, response);
			}
				break;
			// ###################### MODIFICAR EMPLEADO ###############

			case "modificarEmpleado": {
				List<Empleado> lLista = CalculaNominas.controlGeneral.getEmpleadoController().showAll();

				if (lLista == null) {

					String sCausa = "No hay empleados";

					request.setAttribute("causa", sCausa);

					enviarError(request, response);

				} else {

					request.setAttribute("listaEmpleados", lLista);

					sNext = "busquedaEditarEmpleado.jsp";

				}
				break;
			}
			// ############# MOSTRAR EMPLEADOS (TODOS) #################

			case "mostrarEmpleados": {

				List<Empleado> lLista = CalculaNominas.controlGeneral.getEmpleadoController().showAll();

				request.setAttribute("listaEmpleados", lLista);

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("tablaEmpleados.jsp");

				requestDispatcher.forward(request, response);

			}
				break;
			}break;

			case "upDateEmpleado": {

				String sNombre =  request.getParameter("nombre");
				String sDni =  request.getParameter("dni");
				String sSexo =  request.getParameter("sexo");
				String sCategoria = request.getParameter("categoria");
				int iCategoria= Integer.parseInt(sCategoria);
				String sAnio = request.getParameter("anio");
				int iAnio = Integer.parseInt(sAnio);
				
				String sQuery ="UPDATE EMPLEADO SET NOMBRE = '"+sNombre+"', DNI = '"+sDni+"'"
						+ ", SEXO = '"+sSexo+"', CATEGORIA = "+iCategoria+", ANIO = "+iAnio+" WHERE DNI = '"+sDni+"'";
				
				ConexionDB.executeUpdate(sQuery);
				
				sNext="menuApp.jsp";

			}
				break;
			

		case "dniSueldo":
			switch (sKeyPagina) {
			default:
				if (sKeyPagina.length() == 9) {

					if (verificarDni(sKeyPagina, request, response).equals("no")) {
						String sCausa = "Introduciste un DNI erroneo, sin letra o con mas letras de la cuenta";
						request.setAttribute("causa", sCausa);
						enviarError(request, response);
					} else if (verificarDni(sKeyPagina, request, response).equals("ok")) {
						buscarEmpleadoPorDni(request, response);
					}
				} else if (sKeyPagina.length() != 9) {
					String sCausa = "Introduciste un DNI erroneo, no son 9 caracteres, te lo inventaste";
					request.setAttribute("causa", sCausa);
					enviarError(request, response);
				}
				break;
			}

		case "editEmpleado":

			boolean bNombre = false;
			boolean bDni = false;
			boolean bSexo = false;
			boolean bCategoria = false;
			boolean bAnio = false;

			String sNombre = request.getParameter("nombre");
			String sDni = request.getParameter("dni");
			String sSexo = request.getParameter("sexo");
			String sCategoria = request.getParameter("categoria");
			String sAnio = request.getParameter("anio");

			String sQuery = "SELECT * FROM EMPLEADO WHERE ";

			if (sNombre != "") {
				bNombre = true;
				sQuery += "NOMBRE = '" + sNombre + "'";
			}
			if (sDni != "") {
				bDni = true;
				if (bNombre) {
					sQuery += " AND DNI = '" + sDni + "'";
				} else {
					sQuery += "DNI = '" + sDni + "'";
				}
			}
			if (sSexo != "") {
				bSexo = true;
				if (bNombre || bDni) {
					sQuery += " AND SEXO = '" + sSexo + "'";

				} else {
					sQuery += "SEXO = '" + sSexo + "'";
				}

			}
			if (sCategoria != "") {
				bCategoria = true;
				if (bNombre || bDni | bSexo) {
					sQuery += " AND CATEGORIA = " + sCategoria + "";

				} else {
					sQuery += "CATEGORIA = " + sCategoria + "";
				}

			}
			if (sAnio != "") {
				bAnio = true;
				if (bNombre || bDni | bSexo || bCategoria) {
					sQuery += " AND ANIO = '" + sAnio + "'";

				} else {
					sQuery += "ANIO = '" + sAnio + "'";
				}

			}

			if (!bNombre && !bDni && !bSexo && !bCategoria && !bAnio) {
				String sCausa = "No existen coincidencias";
				request.setAttribute("causa", sCausa);
				enviarError(request, response);
			} else {
				List<Empleado> lLista = CalculaNominas.controlGeneral.getEmpleadoController().showParameters(sQuery);
				request.setAttribute("listaEmpleados", lLista);

				sNext = "resultadoBusquedaEditarEmpleado.jsp";

			}

			break;

		case "editEmpleadoNOMBRE":
			switch (sKeyPagina) {
			default:

				buscarEmpleadoPorNombreEdit(request, response);

				break;
			}
		case "editEmpleadoSEXO":
			switch (sKeyPagina) {
			default:

				buscarEmpleadoPorSEXOEdit(request, response);

				break;
			}
		case "editEmpleadoCATEGORIA":
			switch (sKeyPagina) {
			default:

				buscarEmpleadoPorCATEGORIAEdit(request, response);

				break;
			}
		case "editEmpleadoANIO":
			switch (sKeyPagina) {
			default:

				buscarEmpleadoPorANIOEdit(request, response);

				break;
			}

		case "UpDateEditEmpleadoDNI":
			switch (sKeyPagina) {
			default:
				String sDniBusqueda = request.getParameter("campoEdit");
				String sNuevoCampoActualizado = sKeyPagina;

				Empleado oEmpleadoExistente = null;
				Empleado oEmpleadoActualizado = null;

				oEmpleadoExistente = new Empleado(sDniBusqueda);
				oEmpleadoActualizado = new Empleado(sNuevoCampoActualizado);

				if (oEmpleadoExistente.getsDni() != null && oEmpleadoActualizado.getsDni() != null) {

					String sTabla = CalculaNominas.controlGeneral.getEmpleadoController()
							.upDateCampoDNI(oEmpleadoExistente, oEmpleadoActualizado);

					request.setAttribute("tablaEmpleados", sTabla);

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("resultadoEdit.jsp");

					requestDispatcher.forward(request, response);

				} else {
					String sCausa = "Introduciste formato de DNI erroneo, no se puede actualizar eso";
					request.setAttribute("causa", sCausa);
					enviarError(request, response);
				}

				break;
			}
		case "UpDateEditEmpleadoNOMBRE":
			switch (sKeyPagina) {
			default:
				String sDniBusqueda = request.getParameter("campoEdit");
				String sNuevoCampoActualizado = sKeyPagina;

				Empleado oEmpleadoExistente = null;
				Empleado oEmpleadoActualizado = null;

				oEmpleadoExistente = new Empleado(sDniBusqueda);

				oEmpleadoActualizado = new Empleado(sNuevoCampoActualizado, "00000000A", 'c');

				if (oEmpleadoExistente.getsDni() != null && oEmpleadoActualizado.getsNombre() != null) {

					String sTabla = CalculaNominas.controlGeneral.getEmpleadoController()
							.upDateCampoNOMBRE(oEmpleadoExistente, oEmpleadoActualizado);

					request.setAttribute("tablaEmpleados", sTabla);

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("resultadoEdit.jsp");

					requestDispatcher.forward(request, response);

				} else {
					String sCausa = "Introduciste formato de NOMBRE erroneo, no se puede actualizar eso";
					request.setAttribute("causa", sCausa);
					enviarError(request, response);
				}

				break;
			}

		case "UpDateEditEmpleadoSEXO":
			switch (sKeyPagina) {
			default:

				String sDniBusqueda = request.getParameter("campoEdit");
				String sNuevoCampoActualizado = sKeyPagina;

				Empleado oEmpleadoExistente = null;
				Empleado oEmpleadoActualizado = null;

				oEmpleadoExistente = new Empleado(sDniBusqueda);

				char cLetra = sNuevoCampoActualizado.charAt(0);

				oEmpleadoActualizado = new Empleado("DEFAULT", sDniBusqueda, cLetra);

				if (oEmpleadoExistente.getsDni() != null && oEmpleadoActualizado.getcLetra() == 'h'
						|| oEmpleadoExistente.getsDni() != null && oEmpleadoActualizado.getcLetra() == 'H'
						|| oEmpleadoExistente.getsDni() != null && oEmpleadoActualizado.getcLetra() == 'M'
						|| oEmpleadoExistente.getsDni() != null && oEmpleadoActualizado.getcLetra() == 'm') {

					String sTabla = CalculaNominas.controlGeneral.getEmpleadoController()
							.upDateCampoLETRA(oEmpleadoExistente, oEmpleadoActualizado);

					request.setAttribute("tablaEmpleados", sTabla);

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("resultadoEdit.jsp");

					requestDispatcher.forward(request, response);

				} else {
					String sCausa = "Introduciste formato de LETRA erroneo, solo H O M";
					request.setAttribute("causa", sCausa);
					enviarError(request, response);
				}

				break;
			}

		case "UpDateEditEmpleadoCATEGORIA":
			switch (sKeyPagina) {
			default:

				String sDniBusqueda = request.getParameter("campoEdit");
				int iNuevoCampoActualizado = Integer.parseInt(sKeyPagina);

				Empleado oEmpleadoExistente = null;
				Empleado oEmpleadoActualizado = null;

				oEmpleadoExistente = new Empleado(sDniBusqueda);

				oEmpleadoActualizado = new Empleado("DEFAULT", sDniBusqueda, 'f', (byte) 0,
						(byte) iNuevoCampoActualizado);

				if (oEmpleadoExistente.getsDni() != null && oEmpleadoActualizado.getbCategoria() != -1) {

					String sTabla = CalculaNominas.controlGeneral.getEmpleadoController()
							.upDateCampoCATEGORIA(oEmpleadoExistente, oEmpleadoActualizado);

					request.setAttribute("tablaEmpleados", sTabla);

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("resultadoEdit.jsp");

					requestDispatcher.forward(request, response);

				} else {
					String sCausa = "Introduciste formato de CATEGORIA erroneo, solo de 1 a 10";
					request.setAttribute("causa", sCausa);
					enviarError(request, response);
				}

				break;
			}

		case "UpDateEditEmpleadoANIO":
			switch (sKeyPagina) {
			default:

				String sDniBusqueda = request.getParameter("campoEdit");
				int iNuevoCampoActualizado = Integer.parseInt(sKeyPagina);

				Empleado oEmpleadoExistente = null;
				Empleado oEmpleadoActualizado = null;

				oEmpleadoExistente = new Empleado(sDniBusqueda);

				oEmpleadoActualizado = new Empleado("DEFAULT", sDniBusqueda, 'f', (byte) iNuevoCampoActualizado,
						(byte) 0);

				if (oEmpleadoExistente.getsDni() != null && oEmpleadoActualizado.getbAnyosTrabajados() != (byte) -1) {

					String sTabla = CalculaNominas.controlGeneral.getEmpleadoController()
							.upDateCampoANIO(oEmpleadoExistente, oEmpleadoActualizado);

					request.setAttribute("tablaEmpleados", sTabla);

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("resultadoEdit.jsp");

					requestDispatcher.forward(request, response);

				} else {
					String sCausa = "Introduciste formato de ANIO erroneo, solo de 1 a 80";
					request.setAttribute("causa", sCausa);
					enviarError(request, response);
				}

				break;
			}

		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(sNext);
		requestDispatcher.forward(request, response);
	}

	// ###################### FIN SWITCH SMODE ################################
	// ---------------------------------------------------------------------------
	// ---------------------------------------------------------------------------

	public void buscarEmpleadoPorNombreEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sNombre = request.getParameter("menuApp");

		Empleado oEmpleado = new Empleado(sNombre, "DEFAULT00", 'f');

		String sTabla = CalculaNominas.controlGeneral.getEmpleadoController().showAllEmployeeEditNOMBRE(oEmpleado);

		if (sTabla.equals("Empleado no registrado con ese nombre")) {

			String sCausa = sTabla;

			request.setAttribute("causa", sCausa);

			enviarError(request, response);

		} else {

			request.setAttribute("tablaEmpleados", sTabla);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("tablaEditEmpleado.jsp");

			requestDispatcher.forward(request, response);

		}

	}

	public void buscarEmpleadoPorSEXOEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sSexo = request.getParameter("menuApp");

		char cSexo = sSexo.charAt(0);

		Empleado oEmpleado = new Empleado("DEFAULT", "DEFAULT00", cSexo);

		String sTabla = CalculaNominas.controlGeneral.getEmpleadoController().showAllEmployeeEditSEXO(oEmpleado);

		if (sTabla.equals("Empleado no registrado con ese sexo")) {

			String sCausa = sTabla;

			request.setAttribute("causa", sCausa);

			enviarError(request, response);

		} else {

			request.setAttribute("tablaEmpleados", sTabla);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("tablaEditEmpleado.jsp");

			requestDispatcher.forward(request, response);
		}
	}

	public void buscarEmpleadoPorCATEGORIAEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sCategoria = request.getParameter("menuApp");

		byte bCategoria = Byte.parseByte(sCategoria);

		Empleado oEmpleado = new Empleado("DEFAULT", "DEFAULT00", 'f', (byte) -1, (byte) bCategoria);

		String sTabla = CalculaNominas.controlGeneral.getEmpleadoController().showAllEmployeeEditCATEGORIA(oEmpleado);

		if (sTabla.equals("Empleado no registrado con esa categoria")) {

			String sCausa = sTabla;

			request.setAttribute("causa", sCausa);

			enviarError(request, response);

		} else {

			request.setAttribute("tablaEmpleados", sTabla);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("tablaEditEmpleado.jsp");

			requestDispatcher.forward(request, response);

		}
	}

	public void buscarEmpleadoPorANIOEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sAnio = request.getParameter("menuApp");

		byte bAnio = Byte.parseByte(sAnio);

		Empleado oEmpleado = new Empleado("DEFAULT", "DEFAULT00", 'f', (byte) bAnio, (byte) -1);

		String sTabla = CalculaNominas.controlGeneral.getEmpleadoController().showAllEmployeeEditANIO(oEmpleado);

		if (sTabla.equals("Empleado no registrado con esa experiencia en anios")) {

			String sCausa = sTabla;

			request.setAttribute("causa", sCausa);

			enviarError(request, response);

		} else {

			request.setAttribute("tablaEmpleados", sTabla);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("tablaEditEmpleado.jsp");

			requestDispatcher.forward(request, response);

		}
	}

	// ###################### FUNCIONES ################################
	// ---------------------------------------------------------------------------
	// ########## PAGINA ERROR ###############
	public void enviarError(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
		requestDispatcher.forward(request, response);
	}

	// ########## VERIFICAR DNI (UN EMPLEADO) ###############
	public String verificarDni(String skey, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sVerificacion = "no";
		if ((byte) skey.length() == 9) {

			boolean bTengoNumero = false;
			boolean bTengoLetra = false;
			String sResultadoNumero = "";

			for (int i = 0; i < skey.length() - 1; i++) {

				sResultadoNumero += skey.charAt(i);
			}

			try {
				int iNumero = Integer.parseInt(sResultadoNumero);
				System.out.println("Numero valido para DNI: " + iNumero);
				bTengoNumero = true;

			} catch (Exception e) {
				bTengoNumero = false;

			}

			String sResultadoLetra = "" + skey.charAt(8);

			System.out.println("Letra introducida para DNI: " + sResultadoLetra);
			if (sResultadoLetra.equalsIgnoreCase("a") || sResultadoLetra.equalsIgnoreCase("b")
					|| sResultadoLetra.equalsIgnoreCase("c") || sResultadoLetra.equalsIgnoreCase("d")
					|| sResultadoLetra.equalsIgnoreCase("e") || sResultadoLetra.equalsIgnoreCase("f")
					|| sResultadoLetra.equalsIgnoreCase("g") || sResultadoLetra.equalsIgnoreCase("h")
					|| sResultadoLetra.equalsIgnoreCase("i") || sResultadoLetra.equalsIgnoreCase("j")
					|| sResultadoLetra.equalsIgnoreCase("k") || sResultadoLetra.equalsIgnoreCase("l")
					|| sResultadoLetra.equalsIgnoreCase("m") || sResultadoLetra.equalsIgnoreCase("n")
					|| sResultadoLetra.equalsIgnoreCase("ñ") || sResultadoLetra.equalsIgnoreCase("o")
					|| sResultadoLetra.equalsIgnoreCase("p") || sResultadoLetra.equalsIgnoreCase("q")
					|| sResultadoLetra.equalsIgnoreCase("r") || sResultadoLetra.equalsIgnoreCase("s")
					|| sResultadoLetra.equalsIgnoreCase("t") || sResultadoLetra.equalsIgnoreCase("u")
					|| sResultadoLetra.equalsIgnoreCase("w") || sResultadoLetra.equalsIgnoreCase("x")
					|| sResultadoLetra.equalsIgnoreCase("y") || sResultadoLetra.equalsIgnoreCase("z")) {
				System.out.println("Letra valida: " + sResultadoLetra);
				bTengoLetra = true;

			} else {
				System.out.println("Letra invalida: " + sResultadoLetra);
				bTengoLetra = false;
			}
			if (bTengoLetra && bTengoNumero) {
				sVerificacion = "ok";
			}
		}
		return sVerificacion;
	}

	// ########## BUSCAR EMPLEADO (DNI) ###############
	public void buscarEmpleadoPorDni(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sDni = request.getParameter("menuApp");

		Empleado oEmpleado = null;
		boolean bError = false;
		String sCausa = "";

		try {
			oEmpleado = new Empleado(sDni);
		} catch (Exception e) {
			sCausa = "Empleado no registrado,¡Mira si has metido ese DNI bien anda!";
			request.setAttribute("causa", sCausa);
			enviarError(request, response);
		}

		if (oEmpleado.getsDni() == null) {
			sCausa = "Empleado no registrado o introduciste un DNI erroneo con mas caracteres o menos de la cuenta";
			request.setAttribute("causa", sCausa);

			enviarError(request, response);
			bError = true;
		}

		if (bError == false) {

			String sTabla = CalculaNominas.controlGeneral.getEmpleadoController().showEmployee(oEmpleado);

			if (sTabla.equals("Empleado no registrado")) {

				sCausa = sTabla;

				request.setAttribute("causa", sCausa);

				enviarError(request, response);

			} else {

				request.setAttribute("tablaEmpleados", sTabla);

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("sueldoEmpleado.jsp");

				requestDispatcher.forward(request, response);

			}
		}
	}

	// ########## BUSCAR EMPLEADO (DNI) ###############
	public void buscarEmpleadoPorDniEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sDni = request.getParameter("menuApp");

		Empleado oEmpleado = null;
		boolean bError = false;
		String sCausa = "";

		try {
			oEmpleado = new Empleado(sDni);
		} catch (Exception e) {
			sCausa = "Empleado no registrado,¡Mira si has metido ese DNI bien anda!";
			request.setAttribute("causa", sCausa);
			enviarError(request, response);
		}

		if (oEmpleado.getsDni() == null) {
			sCausa = "Empleado no registrado o introduciste un DNI erroneo con mas caracteres o menos de la cuenta";
			request.setAttribute("causa", sCausa);

			enviarError(request, response);
			bError = true;
		}

		if (bError == false) {

			String sTabla = CalculaNominas.controlGeneral.getEmpleadoController().showAllEmployeeEditDNI(oEmpleado);

			if (sTabla.equals("Empleado no registrado")) {

				sCausa = sTabla;

				request.setAttribute("causa", sCausa);

				enviarError(request, response);

			} else {

				request.setAttribute("tablaEmpleados", sTabla);

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("tablaEditEmpleado.jsp");

				requestDispatcher.forward(request, response);

			}
		}
	}

	// ########## ENVIA A PAGINA ERROR ###############
	public void noLetra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		enviarError(request, response);

	}
	// ########## ENVIA A PAGINA ERROR ###############

	public void noNumerico(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		enviarError(request, response);

	}

}
