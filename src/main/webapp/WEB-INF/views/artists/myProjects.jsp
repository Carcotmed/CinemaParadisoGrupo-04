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
	<div  class="d-flex flex-column justify-content-center">
	
		<div class="d-flex justify-content-between" style="background-color:#4c4c4c; padding:1%">
			<h4>Mis Proyectos</h4>
			<button class="btn rounded-circle" style="background-color:#af3248" onClick="location.href='/projects/create'"><strong style="color:white">+</strong></button>
		</div>
		
		<c:forEach items="${myProjects}" var="myProject">
			<div class="d-flex justify-content-between align-items-evenly" style="padding:1% 2%;width:70%;height:12vh;margin:auto">
				<div class="d-flex align-items-center" style="width:100%">
					<div  class="rounded-circle d-flex" style="overflow:hidden;height:100%;width:10%">
						<img src="${myProject.photo}" onClick="location.href='/projects/show/${myProject.id}'" style="cursor:pointer;width:100%;height:100%;object-fit:cover">
					</div>
					<h5 style="margin:0 2%">${myProject.title}</h5>
				</div>
				
				<div class="d-flex justify-content-between align-items-center" style="width:30%">
					<button style="color:white;height: fit-content;background-color:#af3248" class="btn rounded-pill" onClick="location.href='/projects/update/${myProject.id}'">Editar</button>
					<button style="color:white;height: fit-content;background-color:#af3248" class="btn rounded-pill"  onClick="location.href='/projects/delete/${myProject.id}'">Salir del proyecto</button>
				</div>
				
			</div>
			
			<hr style="border-width: 3px;border-style: solid;border-radius: 20px;border-color:#e81a1a; width:60%; margin:1% auto">
			
		</c:forEach>
	</div>
</body>
</html>

<!-- COMENTARIOS PARA BACKEND -->
<!-- 


-->
