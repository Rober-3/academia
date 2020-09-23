package academia.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import academia.modelo.Mensaje;
import academia.modelo.dao.impl.UsuarioDAOImpl;
import academia.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(LoginController.class);

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
		String url = "";
		
		
		// Recogida de parámetros del formulario.
		String nombre = request.getParameter("nombre"); 
		String contrasena = request.getParameter("contrasena");
		
		
		try {
			
			Usuario usuario = dao.buscar(nombre, contrasena); // Busca el usuario en base a los parámetros.
			
			if (usuario != null) { // Si encuentra un usuario con las credenciales correctas.
				
				request.getSession().setAttribute("usuario_sesion", usuario); // Guarda el usuario en la sesión.
				
				if (usuario.getRol() == Usuario.ROL_ALUMNO) {
					url = "/views/privado/alumno"; // CursoAlumnoController
					
				} else {
					url = "/views/privado/profesor"; // CursoProfesorController
				}
				
				// En los sendRedirect se pierden los atributos. Hay que guardarlos en la sesión.
				request.getSession().setAttribute("mensaje", new Mensaje("success","Has iniciado sesión correctamente."));
				
				// response.sendRedirect(url);
				// Es recomendable usar el ContextPath para evitar posibles problemas en los redireccionamientos.
				response.sendRedirect(request.getContextPath() + url);
				
			} else { // Si no coinciden las credenciales o una o varias están vacías.
				
				request.setAttribute("mensaje", new Mensaje("warning","El nombre de usuario y/o la contraseña no son válidos. Introduce los dos correctamente."));
				request.getRequestDispatcher("views/login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			LOG.error(e);

		}
		
	} // doPost

} // class
