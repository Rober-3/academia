<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<html>
<head>
<meta charset="UTF-8">

<base href="${pageContext.request.contextPath}/" />

<!-- Bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

<!-- Datatables -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

<!-- CSS personalizado -->
<link rel="stylesheet" href="css/styles.css">

<title>${param.title}</title>

</head>

<body>

	<jsp:include page="mensaje.jsp"></jsp:include>

	<main>