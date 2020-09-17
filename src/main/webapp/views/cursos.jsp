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

<p>
	<a href="views/login.jsp">Iniciar sesión</a>
</p>

<p>alumno select e insert en nuevo curso</p>


<br>

<h2>LOGIN</h2>
<ol>
	<li>Enlace para ir al formulario de login o ponerlo en esta misma
		página</li>
	<li>Formulario que llame a un controlador con action y method. Sus
		parámetros serán el usuario y la contraseña.</li>
	<li>Controlador que escuche en la url de "/login".</li>
	<li>Comprobar si existe un usuario en la bbdd, declarar nuevo
		método en el DAO e implementarlo.</li>
	<ol>
		<li>Si no existe volver a login y mensaje al usuario.</li>
		<li>Si es profesor que vaya a una jsp "privado/profesor.jsp.</li>
		<li>Si es alumno que vaya a una jsp "privado/alumno.jsp</li>
	</ol>
</ol>

<br>

<h2>TAREAS</h2>
<ol>
	<li>Maquetar pagina web, css e includes para reutilizar</li>
	<li>miercoles: Si se logea un PROFESOR que muestre sus curso,
		desde la misma JSP podria crear un nuevo curso y eliminarlo</li>
	<li>jueves: Si se logea un ALUMNO que muestre sus curso a los que
		esta inscrito, desde la misma JSP apuntarse a un nuevo curso</li>
</ol>

<br>

<h2>EXTRAS</h2>
<ol>
	<li>Trazas de LOG</li>
	<li>Singleton</li>
	<li>Gestion de errores TRY y CACTH sobre todo en los controladore</li>
	<li>Validacion de datos de los formulario con javax.validation</li>
	<li>Gestion de Seguridad, que los profesores y alumnos solo puedan
		modificar sus datos, No poder saltarse el Login</li>
	<li>Un ALUMNO puede escribir una reseña de un curso/profesor,
		calificando del 1 al 5 y escribiendo un comentario</li>
</ol>

<jsp:include page="../includes/footer.jsp"></jsp:include>
