<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../includes/head.jsp">
	<jsp:param name="pagina" value="Insertar un nuevo curso" />
	<jsp:param name="title" value="Insertar un nuevo curso" />
</jsp:include>

<div class="container my-5 bg-light">

	<h3 class="my-5 text-center">Insertar un nuevo curso</h3>

	<!-- Formulario -->

	<form action="insertar" method="post" class="mt-3 font-weight-bold">

		<div class="form-group">
			<label for="id">Id:</label>
			<input type="text"
				   id="id"
				   name="id"
				   value="${curso.id}"
				   class="form-control form-control-sm" 
				   readonly>
		</div>

		<div class="form-group">
			<label for="nombre">Nombre:</label>
			<input type="text"
				   id="nombre"
				   name="nombre"
				   value="${curso.nombre}"
				   class="form-control form-control-sm"
				   placeholder="El modelo debe tener entre 3 y 50 caracteres y no estar repetido.">
		</div>

		<div class="form-group">
			<label for="codigo">Código:</label>
			<input type="text"
				   id="codigo"
				   name="codigo"
				   value="${curso.codigo}"
				   class="form-control form-control-sm">
		</div>

		<div class="form-group">
			<label for="horas">Horas:</label>
			<input type="text"
				   id="horas"
				   name="horas"
				   value="${curso.horas}">	
		</div>
		
		
		
		<!-- SOLUCIÓN CHAPUCERA PARA OBTENER EN CURSOINSERTARCONTROLLER EL PROFESOR DEL CURSO. -->
		
		<div class="form-group">
			<input type="hidden" id="idprofesor" name="idprofesor" value="${profesor.id}">
		</div>
		<div class="form-group">
			<input type="hidden" id="nombreprofesor" name="nombreprofesor" value="${profesor.nombre}">
		</div>
		<div class="form-group">
			<input type="hidden" id="apellidosprofesor" name="apellidosprofesor" value="${profesor.apellidos}">
		</div>
		<div class="form-group">
			<input type="hidden" id="rolprofesor" name="rolprofesor" value="${profesor.rol}">
		</div>
		<div class="form-group">
			<input type="hidden" id="contrasenaprofesor" name="contrasenaprofesor" value="${profesor.contrasena}">
		</div>
		
		
		
		<div>
			<button type="submit" class="btn btn-primary btn-sm">Guardar</button>
		</div>

	</form>

</div>

<jsp:include page="../includes/footer.jsp"></jsp:include>