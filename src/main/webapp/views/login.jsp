<jsp:include page="../includes/head.jsp">
	<jsp:param name="pagina" value="Inicio de sesion" />
	<jsp:param name="title" value="Inicio de sesion" />
</jsp:include>

<main>

	<div class="container my-5 formulario">

		<h1 class="text-center">Iniciar sesión</h1>
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
				<label for="contrasena">Contraseña</label>
				<input type="password"
					   id="contrasena"
					   name="contrasena"
					   value="123"
					   class="form-control form-control-sm"
					   placeholder="Introduce tu contraseña">
			</div>

			<button type="submit" class="btn btn-primary btn-sm">Iniciar sesión</button>

		</form>

	</div>

</main>

<jsp:include page="../includes/footer.jsp"></jsp:include>