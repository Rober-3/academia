<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>LISTA DE CURSOS</h1>

${cursos}

<c:forEach items="${cursos}" var="c">
	
</c:forEach>