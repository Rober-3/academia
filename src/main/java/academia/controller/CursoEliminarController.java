package academia.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import academia.modelo.Mensaje;
import academia.modelo.dao.impl.CursoDAOImpl;
import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Usuario;

/**
 * Servlet implementation class CursoEliminarController
 */
@WebServlet("/eliminar")
public class CursoEliminarController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(CursoController.class);


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CursoDAOImpl dao = CursoDAOImpl.getInstance();
		Curso curso = new Curso();
		Mensaje mensaje = new Mensaje();

		String paramId = request.getParameter("id");
		
		// Recupera el usuario de la sesión y obtiene su id.
		Usuario profesor = (Usuario) request.getSession().getAttribute("usuario_sesion");
		int idProfesor = profesor.getId();

		try {
			
			int idCurso = Integer.parseInt(paramId);
			
			curso = dao.deleteByProfe(idCurso, idProfesor);
			mensaje = new Mensaje("success", "Se ha eliminado correctamente el curso " + curso + ".");
			
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("views/privado/profesor").forward(request, response);

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
