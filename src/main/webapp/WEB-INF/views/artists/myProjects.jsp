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

<title>Mis Proyectos</title>
</head>
<body class="h-100" style="background-color: #272727; color: white">
	<div class="d-flex">
		<div  class="d-flex flex-column justify-content-center">
			<div>
				<h4>Mis Proyectos</h4>
				<button class="btn rounded-circle">+</button>
			</div>
			<c:forEach items="${myProjects}" var="myProject">
				<div onClick="location.href='/artists/myProjects/${myProject.id}'">
					<img src="${myProject.photo}" class="w-30">
					<h6>${myProject.title}</h6>
					<button onClick="location.href='/projects/delete/${myProject.id}'">Borrar</button>
					<button onClick="location.href='/projects/update/${myProject.id}'">Editar</button>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>

<!-- COMENTARIOS PARA BACKEND -->
<!-- 


-->
