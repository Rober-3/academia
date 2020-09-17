<h1>ACADEMIA</h1>

<%	// jsp redirect que evita tener que hacer un welcome-file en el web.xml.
	// Según carga la página principal, redirecciona a un controlador.
	response.sendRedirect(request.getContextPath() + "/cursos");

%>