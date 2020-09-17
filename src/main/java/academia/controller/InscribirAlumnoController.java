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
import academia.modelo.dao.impl.CursoUsuarioDAOImpl;

/**
 * Servlet implementation class InscribirAlumnoController
 */
@WebServlet("/inscribir")
public class InscribirAlumnoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(InscribirAlumnoController.class);
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CursoUsuarioDAOImpl dao = CursoUsuarioDAOImpl.getInstance();
		CursoDAOImpl daoCurso = CursoDAOImpl.getInstance();
		Mensaje mensaje = new Mensaje();
		
		String paramIdAlumno = request.getParameter("idalumno");
		String paramIdCurso = request.getParameter("idcurso");
		
		try {
			
			int idAlumno = Integer.parseInt(paramIdAlumno);
			int idCurso = Integer.parseInt(paramIdCurso);
			
			dao.inscribirAlumno(idAlumno, idCurso);
			
			mensaje = new Mensaje("success", "Te has inscrito correctamente en el curso " + daoCurso.getById(idCurso) + ".");
			
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("views/privado/alumno").forward(request, response);
			
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
