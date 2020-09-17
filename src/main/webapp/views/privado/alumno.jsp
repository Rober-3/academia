<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../includes/head.jsp">
	<jsp:param name="pagina" value="Cursos" />
	<jsp:param name="title" value="Cursos" />
</jsp:include>


<h1 class="text-center mt-3">PÁGINA DEL ALUMNO</h1>
<p class="text-center mt-3">Bienvenido ${usuario_sesion.nombre} ${usuario_sesion.apellidos}</p>


<h3 class="text-center mt-5">Cursos en los que estás inscrito</h3>

<table class="table table-success table-striped mt-3 container">
	<thead class="thead">
		<tr>
			<th scope="col">CURSO</th>
			<th scope="col">CODIGO</th>
			<th scope="col">HORAS</th>
			<th scope="col">PROFESOR</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cursosi}" var="ci">
			<tr>
				<td class="align-middle">${ci.nombre}</td>
				<td class="align-middle">${ci.codigo}</td>
				<td class="align-middle">${ci.horas}</td>
				<td class="align-middle">${ci.profesor.nombre} ${ci.profesor.apellidos}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<h3 class="text-center mt-5">Cursos disponibles</h3>

<table class="table table-info table-striped mt-3 container">
	<thead class="thead">
		<tr>
			<th scope="col">CURSO</th>
			<th scope="col">CODIGO</th>
			<th scope="col">HORAS</th>
			<th scope="col">PROFESOR</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cursosd}" var="cd">
			<tr>
				<td class="align-middle">${cd.nombre}</td>
				<td class="align-middle">${cd.codigo}</td>
				<td class="align-middle">${cd.horas}</td>
				<td class="align-middle">${cd.profesor.nombre} ${cd.profesor.apellidos}</td>
				<td class="align-middle">Inscribirse</td>
			</tr>
		</c:forEach>
	</tbody>
</table>



<jsp:include page="../../includes/footer.jsp"></jsp:include>