<h1>ACADEMIA</h1>

<%	// jsp redirect que evita tener que hacer un welcome-file en el web.xml.
	// Seg�n carga la p�gina principal, redirecciona a un controlador.
	response.sendRedirect(request.getContextPath() + "/cursos");

%>