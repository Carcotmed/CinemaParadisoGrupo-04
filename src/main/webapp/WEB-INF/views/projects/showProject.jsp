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
	<div class="d-flex justify-content-between p-3" style="margin-bottom: 2%">
			<div class="d-flex jsutify-content-center">
	
				<img src="${project.photo}" class="rounded-circle" style="width:10vw;height:10vw">
				<div class="py-3 mx-3" style="width:40%">
					<h2>${project.title}</h2>
				</div>
			</div>
			<button class="btn rounded-pill" style="color:white;height: fit-content;background-color: #af3248">Contactar con el equipo</button>
	</div>
	<!-- Info general Proyecto -->
	<div>
		<div class="container-fluid" style="background-color:#4c4c4c; padding:1%">
			<h3 style="margin:0">Ficha técnica</h3>
		</div>
		<div class="d-flex justify-content-between" style="margin: 2% 5%;max-width:90%">
			<!-- Datos -->
			<div class="w-100">
				<div style="margin:1% 0">
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Título</h5>
					</div>
					<p style="margin-left: 3%">${project.title}</p>
				</div>
				<div style="margin:1% 0">
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Género</h5>
					</div>
					<p style="margin-left: 3%">${project.genre}</p>
				</div style="margin:1% 0">
				<div>
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Resumen</h5>
					</div>
					<p style="margin-left: 3%">${project.description}</p>
				</div>
			</div>
			
			<!-- Imagen - Video -->
			<div class="d-flex justify-content-center" style="width:100%">
				<img src="${project.photo}" class="w-50">
			</div>
		</div>
		<div class="container-fluid" style="background-color:#4c4c4c; padding:1%">
			<h3 style="margin:0">Integrantes</h3>
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
