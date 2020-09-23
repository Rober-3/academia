package academia.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import academia.controller.LoginController;
import academia.modelo.pojo.Usuario;

/**
 * Servlet Filter implementation class AlumnoFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/views/privado/*" })
public class AlumnoFilter implements Filter {
	
	private static final Logger LOG = Logger.getLogger(LoginController.class);

    /**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		LOG.trace("Filtro destruído.");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings("static-access")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// Casteo de request y response.
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		// URL donde comienza la aplicación para construir la ruta absoluta.
		String urlInicioApp = req.getContextPath();
		
		LOG.trace("Filtrando URI" + req.getRequestURI());
		
		Usuario alumno = (Usuario) req.getSession().getAttribute("usuario_sesion");
		
		if (alumno == null) {
			LOG.warn("Usuario == null: no ha iniciado sesión. Sin autentificar. Redirigido al login.");
			res.sendRedirect(urlInicioApp + "/login");
			
		} else if (alumno.getRol() != alumno.ROL_ALUMNO) {
			LOG.warn("El usuario no tiene privilegios como alumno. Redirigido al login.");
			res.sendRedirect(urlInicioApp + "/views/login.jsp");

		} else {
			// El usuario pasa si su rol es el de alumno.
			chain.doFilter(request, res);
		}

	} // doFilter

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		LOG.trace("Filtro iniciado.");
	}

} // class
