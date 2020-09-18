<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../includes/head.jsp">
	<jsp:param name="pagina" value="Cursos" />
	<jsp:param name="title" value="Cursos" />
</jsp:include>

<div class="my-5">

	<h1 class="text-center">Cursos impartidos</h1>

	<!-- Tabla de cursos -->

	<table class="table table-info table-striped mt-3 container">
		<thead class="thead">
			<tr>
				<th scope="col">CURSO</th>
				<th scope="col">CODIGO</th>
				<th scope="col">HORAS</th>
				<th scope="col">PROFESOR</th>
			</tr>
		</thead>
		<tbody>
			<!-- Recoge la información de los cursos enviada desde el controlador. -->
			<c:forEach items="${cursos}" var="c">
				<tr>
					<td class="align-middle">${c.nombre}</td>
					<td class="align-middle">${c.codigo}</td>
					<td class="align-middle">${c.horas}</td>
					<td class="align-middle">${c.profesor.nombre} ${c.profesor.apellidos}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<br>

<h2>LOGIN</h2>
<ol>
	<li>Enlace para ir al formulario de login o ponerlo en esta misma página.</li>
	
	<li>Formulario que llame a un controlador con action y method. Sus parámetros serán el usuario y la contraseña.</li>
	
	<li>Controlador que escuche en la url de "/login".</li>
	
	<li>Comprobar si existe un usuario en la bbdd, declarar un nuevo método en el DAO e implementarlo.</li>
	<ol>
		<li>Si no existe volver a login y pasarle un mensaje al usuario.</li>
		<li>Si es profesor que vaya a la jsp "privado/profesor.jsp.</li>
		<li>Si es alumno que vaya a la jsp "privado/alumno.jsp</li>
	</ol>
</ol>

<br>

<h2>TAREAS</h2>
<ol>
	<li>Maquetar página web, css e includes para reutilizar</li>
	
	<li>Miércoles: si inicia sesión un profesor que muestre sus cursos. Desde la misma jsp podria crear un nuevo curso y eliminarlo.</li>
	
	<li>Jueves: si inicia sesión un alumno que muestre los cursosena los que está inscrito. Desde la misma jsp debe poder apuntarse a un nuevo curso.</li>
</ol>

<br>

<h2>EXTRAS</h2>
<ol>
	<li>Trazas de LOG.</li>
	
	<li>Singleton.</li>
	
	<li>Gestion de errores con try-catch, sobre todo en los controladores.</li>
	
	<li>Validación de datos de los formularios con javax.validation.</li>
	
	<li>Gestión de seguridad: que los profesores y alumnos sólo puedan modificar sus datos. No poder saltarse el inicio de sesión.</li>
	
	<li>Un alumno debe poder escribir una reseña de un curso o profesor, calificando del 1 al 5 y escribiendo un comentario.</li>
</ol>

<jsp:include page="../includes/footer.jsp"></jsp:include>
