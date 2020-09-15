<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>LISTA DE CURSOS</h1>

<c:forEach items="${cursos}" var="c">
	<p>${c}</p>
</c:forEach>

<br>

<p><a href="views/login.jsp">Iniciar sesión</a></p>

<br>

<h2>LOGIN</h2>
<ol>
	<li>Enlace para ir al formulario de login o ponerlo en esta misma página</li>
	<li>Formulario que llame a un controlador con action y method. Sus parámetros serán el usuario y la contraseña.</li>
	<li>Controlador que escuche en la url de "/login".</li>
	<li>Comprobar si existe un usuario en la bbdd, declarar nuevo método en el DAO e implementarlo.</li>
	<ol>
		<li>Si no existe volver a login y mensaje al usuario.</li>
		<li>Si es profesor que vaya a una jsp "privado/profesor.jsp.</li>
		<li>Si es alumno que vaya a una jsp "privado/alumno.jsp</li>
	</ol>
</ol>
		
<br>

<h2>TAREAS</h2>
<ol>
	<li>Maquetar página web, css e includes para reutilizar.</li>
</ol>