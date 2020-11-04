package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletController
 */
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {


			System.out.println("Cargando...");

			String action = request.getParameter("action");
			String method = request.getParameter("method");
			String sEleccion = request.getParameter("eleccion");

			if (action.equals("urlConexion")) {

				try {
					if (method.equals("Ok")) {
						conexionGenerica(request, response, sEleccion);
					}

				} catch (SQLException e) {
					e.getStackTrace();
				}

			}
		}

		public void conexionGenerica(HttpServletRequest request, HttpServletResponse response, String sEleccion)
				throws SQLException, ServletException, IOException {

			String sEntrar = request.getParameter("eleccion");
			String sAccion = request.getParameter("menuApp");

			request.setAttribute("sEntrar", sEntrar);
			request.setAttribute("sAccion", sAccion);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ServletComunicador");
			requestDispatcher.forward(request, response);

		}

	}
