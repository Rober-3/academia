package academia.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import academia.modelo.dao.impl.UsuarioDAOImpl;
import academia.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	

	
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
		Usuario usuario = new Usuario();
		String url = "";
		String mensaje = "";
		
		
		// Recogida de parámetros del formulario.
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		
		
		try {
			
			usuario = dao.buscar(nombre, contrasena); // Busca el usuario en base a los parámetros.
			
			if (usuario != null) { // Si encuentra un usuario con las credenciales correctas.
				
				if (usuario.getRol() == 1) {
					url = "views/privado/alumno.jsp";
					
				} else {
					url = "views/privado/profesor.jsp";
				}
				
				mensaje = "Has iniciado sesión correctamente.";
				
			} else { // Si no coinciden las credenciales o una o varias están vacías.
				
				url = "views/login.jsp";
				mensaje = "El nombre de usuario y/o la contraseña no son válidos. Introduce los dos correctamente.";
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response); // Redirige a la jsp correspondiente.
		}
		
	} // doPost

} // class
