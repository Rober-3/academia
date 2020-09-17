<jsp:include page="../includes/head.jsp">
	<jsp:param name="pagina" value="Inicio de sesion" />
	<jsp:param name="title" value="Inicio de sesion" />
</jsp:include>

<main>

	<div class="container my-5 formulario">

		<h1 class="text-center">Iniciar sesi�n</h1>
		<h5 class="text-center">Asier 123 --> alumno</h5>
		<h5 class="text-center">Alain 123 --> profesor</h5>

		<form action="login" method="post" class="mt-3">

			<div class="form-group">
				<label for="nombre">Nombre de usuario</label>
				<input type="text"
					   id="nombre"
					   name="nombre"
					   value="Alain"
					   class="form-control form-control-sm"
					   placeholder="Introduce tu nombre de usuario"
					   autofocus>
			</div>

			<div class="form-group">
				<label for="contrasena">Contrase�a</label>
				<input type="password"
					   id="contrasena"
					   name="contrasena"
					   value="123"
					   class="form-control form-control-sm"
					   placeholder="Introduce tu contrase�a">
			</div>

			<button type="submit" class="btn btn-primary btn-sm">Iniciar sesi�n</button>

		</form>

	</div>

</main>

<jsp:include page="../includes/footer.jsp"></jsp:include>