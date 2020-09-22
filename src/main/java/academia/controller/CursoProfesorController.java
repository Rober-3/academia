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
 * Servlet implementation class CursoProfesorController
 */
@WebServlet("/views/privado/profesor")
public class CursoProfesorController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(CursoController.class);


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CursoDAOImpl dao = CursoDAOImpl.getInstance();
		ArrayList<Curso> cursos = new ArrayList<Curso>();

		try {

			// Recupera el usuario de la sesión y obtiene su id.
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_sesion");
			int idProfesor = usuario.getId();

			cursos = dao.getAllByProfeWithNumAlumnos(idProfesor);

			request.setAttribute("cursosp", cursos);

		} catch (Exception e) {
			LOG.error(e);
			
		} finally {
			request.getRequestDispatcher("profesor.jsp").forward(request, response);
		}

	} // doGet


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

} // class
