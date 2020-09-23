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
 * Servlet Filter implementation class ProfesorFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/privado/*" })
public class ProfesorFilter implements Filter {

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
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
				
		String urlInicioApp = req.getContextPath();
		
		LOG.trace("Filtrando URI " + req.getRequestURI());
		
		Usuario profesor = (Usuario) req.getSession().getAttribute("usuario_sesion");
		
		if (profesor == null) {
			LOG.warn("Usuario == null: no ha iniciado sesión. Sin autentificar. Redirigido al login.");
			System.out.println("Usuario == null: no ha iniciado sesión. Sin autentificar. Redirigido al login.");
			res.sendRedirect(urlInicioApp + "/views/loging.jsp");
			
		} else if (profesor.getRol() != Usuario.ROL_PROFESOR) {
			LOG.warn("El usuario no tiene privilegios como profesor. Redirigido al login.");
			res.sendRedirect(urlInicioApp + "/views/loging.jsp");

		} else {
			// pass the request along the filter chain
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
