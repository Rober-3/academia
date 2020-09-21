package academia.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import academia.modelo.Mensaje;
import academia.modelo.dao.impl.CursoDAOImpl;
import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Usuario;

/**
 * Servlet implementation class CursoInsertarController
 */
@WebServlet("/insertar")
public class CursoInsertarController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(CursoInsertarController.class);
	private static CursoDAOImpl dao = CursoDAOImpl.getInstance();

	// Objeto Validator  al que se le pasa el POJO para ver si cumple las validaciones.
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static Validator validator = factory.getValidator();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Curso curso = new Curso();

		request.setAttribute("curso", curso);

		request.getRequestDispatcher("views/formulario-cursos.jsp").forward(request, response);

	} // doGet

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


		try {
			// Recupera el usuario de la sesión y obtiene su id.
			Usuario profesor = (Usuario) request.getSession().getAttribute("usuario_sesion");

			int id = Integer.parseInt(paramId);
			int horas = Integer.parseInt(paramHoras);

			curso.setId(id);
			curso.setNombre(nombre);
			curso.setCodigo(codigo);
			curso.setHoras(horas);
			curso.setProfesor(profesor);


			// Devuelve un set con todas las validaciones.
			Set<ConstraintViolation<Curso>> violations = validator.validate(curso);

			if (violations.isEmpty()) { // Sin errores de validación puede guardarse el curso en la bbdd.

				if (id == 0) {
					dao.insert(curso);
					mensaje = new Mensaje("success", "Curso registrado con éxito en la base de datos.");
				}

			} else { // Si alguna de las propiedades del curso no cumple con las validaciones habrá errores de validación.

				String errores = "";

				// Recorre el set de violaciones y almacena el resultado para mostrarlo en pantalla.
				for (ConstraintViolation<Curso> violation : violations) {
					errores += "<p> <b>" + violation.getPropertyPath() + "</b>: "  + violation.getMessage() + "</p>";

				} // for

				mensaje = new Mensaje("danger", errores);

			} // if-else

		} catch (Exception e) {
			mensaje = new Mensaje("danger", "Ha habido un problema: " + e.getMessage());
			LOG.error(e);

		} finally {
			request.setAttribute("cursop", curso);
			request.setAttribute("mensaje", mensaje);

			request.getRequestDispatcher("views/privado/profesor").forward(request, response);

		} // try-catch-finally

	} // dopost

} // class
