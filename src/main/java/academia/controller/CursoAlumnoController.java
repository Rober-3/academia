package academia.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import academia.modelo.dao.impl.CursoDAOImpl;
import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Usuario;

/**
 * Servlet implementation class CursoAlumnoController
 */
@WebServlet("/views/privado/alumno")
public class CursoAlumnoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(CursoController.class);
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CursoDAOImpl dao = CursoDAOImpl.getInstance();
		ArrayList<Curso> cursosi = new ArrayList<Curso>(); // Cursos en los que el alumno está inscrito
		ArrayList<Curso> cursosd = new ArrayList<Curso>(); // Cursos disponibles para el alumno.

		try {

			// Recupera el usuario de la sesión y obtiene su id.
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_sesion");
			int idAlumno = usuario.getId();

			cursosi = dao.getAllByAlumno(idAlumno);
			cursosd = dao.getAllDisponibles(idAlumno);

			request.setAttribute("cursosi", cursosi);
			request.setAttribute("cursosd", cursosd);
			request.getRequestDispatcher("alumno.jsp").forward(request, response);

		} catch (Exception e) {
			LOG.error(e);
		}

	} // doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

} // class
