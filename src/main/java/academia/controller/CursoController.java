package academia.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import academia.modelo.dao.impl.CursoDAOImpl;
import academia.modelo.pojo.Curso;

/**
 * Servlet implementation class CursoController
 */
@WebServlet("/cursos")
public class CursoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(CursoController.class);


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CursoDAOImpl dao = CursoDAOImpl.getInstance();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		
		
		// Invalida la sesión para que al pulsar en el botón Inicio no se muestre el nombre del usuario que ha hecho login.
		// Debería estar en un controlador para hacer logout, pero se encuentra aquí de manera provisional.
		HttpSession session = request.getSession();
		session.invalidate();
		session = null;

		
		try {
			cursos = dao.getAll();

		} catch (Exception e) {
			LOG.error(e);
		}

		request.setAttribute("cursos", cursos);
		request.getRequestDispatcher("/views/cursos.jsp").forward(request, response);
		
	} // doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

} // class

