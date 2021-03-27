<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<title>Project</title>
</head>
<body class="h-100" style="background-color: #272727; color: white">
	<!-- Header Proyecto -->
	<div class="d-flex jsutify-content-center p-3" style="margin-bottom: 5%">
		<img src="https://via.placeholder.com/150" class="rounded-circle w-30">
		<div class="py-3 mx-3" style="width:40%">
			<h2>${project.title}</h2>
		</div>
		<button class="btn rounded-pill" style="color:white;height: fit-content;background-color: #af3248">Contactar con el equipo</button>
	</div>

	<!-- Info general Proyecto -->
	<div style="overflow:scroll">
		<div class="container-fluid">
			<h3>Ficha técnica</h3>
		</div>
		<div class="d-flex justify-content-between" style="margin: 0 5%;max-width:90%">
			<!-- Datos -->
			<div>
				<h5>Título:</h5>
				<p>${project.title}</p>
				<h5>Géneros</h5>
				<div class="d-flex flex-wrap">
					<span class="p-2" style="background-color:#3e3e3e">${project.genre}</span>
				</div>
				<h5>Resumen</h5>
				<p>${project.description}</p>
			</div>
			
			<!-- Imagen - Video -->
			<div>
				<img src="https://via.placeholder.com/150" class="w-50">
			</div>
		</div>
		<div class="container-fluid">
			<h3>Integrantes</h3>
		</div>
		<c:forEach items="${members}" var="member">
			<div class="d-flex">
				<img src="https://via.placeholder.com/150" class="w-50"><!-- ${member.img} -->
				<div>
					<h5>${member.name}</h5>
					<p>${member.role}</p>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>

<!-- COMENTARIOS PARA BACKEND -->
<!-- 


-->
