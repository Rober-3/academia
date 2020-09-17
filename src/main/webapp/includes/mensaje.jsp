<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty mensaje}">

	<div class="alert alert-${mensaje.tipo} alert-dismissible fade show text-center" role="alert">
		${mensaje.texto}
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	
	<%
		// Eliminar el atributo de la sesión tras mostrar alerta.
		session.setAttribute("mensaje", null);
	%>
	
</c:if>