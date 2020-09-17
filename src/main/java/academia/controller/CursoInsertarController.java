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
import academia.modelo.dao.impl.UsuarioDAOImpl;
import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Usuario;

/**
 * Servlet implementation class CursoInsertarController
 */
@WebServlet("/insertar")
public class CursoInsertarController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(CursoController.class);
	private static CursoDAOImpl dao = CursoDAOImpl.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Curso curso = new Curso();
		
		//-------------------------------------------------------
		UsuarioDAOImpl daoUsuario = UsuarioDAOImpl.getInstance();
		Usuario profesor = new Usuario();
		String paramIdProfesor = request.getParameter("idprofesor"); // <a href="insertar?&idprofesor=${usuario_sesion.id}">
		//-------------------------------------------------------
		
		try {
			
			//-------------------------------------------------
			int idProfesor = Integer.parseInt(paramIdProfesor);
			profesor = daoUsuario.getById(idProfesor);
			//-------------------------------------------------
			
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		//----------------------------------------
		request.setAttribute("profesor", profesor);
		//----------------------------------------
		
		request.setAttribute("curso", curso);
		
		request.getRequestDispatcher("views/formulario-cursos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Curso curso = new Curso();
		Mensaje mensaje = new Mensaje();
		
		String paramId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String codigo = request.getParameter("codigo");
		String paramHoras = request.getParameter("horas");
		
		
		
		// SOLUCIÓN CHAPUCERA PARA ESTABLECER EL PROFESOR DEL CURSO.
		
		String paramIdProfesor = request.getParameter("idprofesor");
		String nombreProfesor = request.getParameter("nombreprofesor");
		String apellidosProfesor = request.getParameter("apellidosprofesor");
		String paramRolProfesor = request.getParameter("rolprofesor");
		String contrasenaProfesor = request.getParameter("contrasenaprofesor");
		
		
		try {
			
			
			int idProfesor = Integer.parseInt(paramIdProfesor);
			int rolProfesor = Integer.parseInt(paramRolProfesor);
			Usuario profesor = new Usuario();
			profesor.setId(idProfesor);
			profesor.setNombre(nombreProfesor);
			profesor.setApellidos(apellidosProfesor);
			profesor.setRol(rolProfesor);
			profesor.setContrasena(contrasenaProfesor);
			
			
			// Recupera el usuario de la sesión y obtiene su id.
			// Usuario profesor = (Usuario) request.getSession().getAttribute("usuario_sesion");
			// int idProfesor = profesor.getId();
			
			int id = Integer.parseInt(paramId);
			int horas = Integer.parseInt(paramHoras);
			
			curso.setId(id);
			curso.setNombre(nombre);
			curso.setCodigo(codigo);
			curso.setHoras(horas);
			curso.setProfesor(profesor);
			
			if (id == 0) {
				curso = dao.insertByProfe(curso);
				mensaje = new Mensaje("success", "Curso registrado con éxito en la base de datos.");
			}
			
		} catch (Exception e) {
			mensaje = new Mensaje("danger","Ha habido un problema: " + e.getMessage());
			LOG.error(e);
			
		} finally {
			request.setAttribute("cursop", curso);
			request.setAttribute("mensaje", mensaje);
			
			request.getRequestDispatcher("views/privado/profesor.jsp").forward(request, response);
			
		} // try-catch-finally
		
	} // dopost

} // class
