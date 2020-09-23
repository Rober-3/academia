<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    HttpSession s = request.getSession(true);
    request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">

<meta name="description" content="Ipartek formación">
<meta name="viewport" content="width=device-width, user-scalable=no">

<base href="${pageContext.request.contextPath}/" />

<!-- Bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

<!-- Datatables -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

<!-- CSS personalizado. El parámetro en css sirve para forzar al navegador a recargar la caché. -->
<link rel="stylesheet" type="text/css" href="css/styles.css?1">

<title>${param.title}</title>

</head>

<body>

	<jsp:include page="mensaje.jsp"></jsp:include>

	<header>
		<!-- Barra de navegación -->

		<nav
			class="barra text-light navbar navbar-expand-lg navbar-light bg-light py-4">

			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo02"
				aria-controls="navbarTogglerDemo02" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>


			<div class="collapse navbar-collapse" id="navbarTogglerDemo02">

				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">

					<li class="nav-item active font-weight-bold"><a
						class="nav-link" href="index.jsp">Inicio <span class="sr-only">(current)</span>
					</a></li>



				</ul>

				<span class="form-inline my-2 my-lg-0 font-weight-bold">
					<c:if test="${empty sessionScope.usuario_sesion}">
						<!-- Accediendo a login en vez de a views/login.jsp, en login.jsp se mostrará un mensaje indicando que 
						el nombre de usuario y la contraseña no son correctos. Esto es debido a que aún no se han enviado las
						credenciales, por lo que en el controlador usuario == null.
						Accediendo a /views/login.jsp en vez de  a views/login.jsp no se encontrará la ruta. -->
						<a class="nav-link" href="views/login.jsp">Iniciar sesión</a>
					</c:if>
					<c:if test="${not empty sessionScope.usuario_sesion}">
						<span class="text-success">Bienvenido ${sessionScope.usuario_sesion.nombre} ${sessionScope.usuario_sesion.apellidos}</span>
					</c:if>
				</span>
			</div>
		</nav>
	</header>

	<main class="container">