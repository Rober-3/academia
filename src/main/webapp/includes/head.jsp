<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    HttpSession s = request.getSession(true);
    request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="es">
<html>
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

<!-- CSS personalizado -->
<link rel="stylesheet" type="text/css" href="css/style.css">

<title>${param.title}</title>

</head>

<body>

	<header>
		<div id="header_title">
			<div id="header_img">
				<img src="img/logo.png" alt="Maleta" title="Musix">
			</div>
		</div>
	</header>
	<nav id="menu_principal">
		<ul>
			<li><a href="index.jsp"><div class="icono home"></div>Inicio</a></li>
		</ul>
	</nav>

	<jsp:include page="mensaje.jsp"></jsp:include>

	<main class="container">