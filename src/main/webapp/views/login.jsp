<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>

<head>

<title>Inicio de sesión</title>

<base href="${pageContext.request.contextPath}/" />

</head>

<body>

	<main>

		<div>

			<h3>Iniciar sesión</h3>
			<h5>Asier 123 --> alumno</h5>
			<h5>Alain 123 --> profesor</h5>


			<form action="login" method="post" onsubmit="cifrar()">

				<div>
					<label for="nombre">Nombre de usuario</label>
					<input type="text"
						   id="nombre"
						   name="nombre"
						   value="Asier"
						   class="form-control form-control-sm"
						   placeholder="Introduce tu nombre de usuario">
				</div>


				<div>
					<label for="contrasena">Contraseña</label>
					<input type="password"
						   id="contrasena"
						   name="contrasena"
						   value="123"
						   class="form-control form-control-sm"
						   placeholder="Introduce tu contraseña">
				</div>
				
				<button type="submit">Iniciar sesión</button>

				<p>${mensaje}</p>

			</form>

		</div>

	</main>

	<!-- Script para cifrar en MD5. -->
	<script src="js/md5.min.js"></script>

	<!-- Script personalizado. -->
	<script src="js/custom.js"></script>

</body>

</html>
