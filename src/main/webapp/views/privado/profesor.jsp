<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../includes/head.jsp">
	<jsp:param name="pagina" value="Cursos" />
	<jsp:param name="title" value="Cursos" />
</jsp:include>


<h1>PÁGINA DEL PROFESOR</h1>

<p>Bienvenido ${usuario_sesion.nombre} ${usuario_sesion.apellidos}</p>

<a href="insertar?&idprofesor=${usuario_sesion.id}">Insertar un nuevo curso</a>

<h3 class="text-center">Cursos que impartes</h3>

<table class="table table-success table-striped mt-3 container">
	<thead class="thead">
		<tr>
			<th scope="col">CURSO</th>
			<th scope="col">CODIGO</th>
			<th scope="col">HORAS</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cursosp}" var="c">
			<tr>
				<td class="align-middle">${c.nombre}</td>
				<td class="align-middle">${c.codigo}</td>
				<td class="align-middle">${c.horas}</td>
				<td class="align-middle">
					<!-- El evento confirmar ejecuta un script para confirmar la eliminación de un curso. 
						 Se pasa el id del curso a eliminar como parámetro en la URL.-->
					<a href="eliminar?id=${c.id}" onclick="confirmar('${c.nombre}')"><i class="fas fa-trash fa-1x mx-2" title="Eliminar"></i></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<jsp:include page="../../includes/footer.jsp"></jsp:include>