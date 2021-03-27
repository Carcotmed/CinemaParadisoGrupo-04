<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>Artist List</title>
</head>
<body class="h-100" style="color:white">
	<div class="d-flex h-100">

		<!--  Filtros -->
		<div class="p-4 w-25" style="background-color: #af3248">
			<h3 class="text-center page-header mb-4" >Filtros</h3>
			<hr class="m-3" style="border-width: 3px;border-style: solid;border-radius: 20px;">
			<form:form class="my-5" method="GET" action="/list" modelAttribute="artistsFiltered">
				<div class="form-group d-flex justify-content-between align-items-center my-4">
					<form:label class="form-control-label" path="name">Nombre:</form:label>
					<form:input class="form-control" style="width:60%" type="text" value="" placeholder="Nombre" path="name" />
				</div>
				
				<div class="form-group d-flex justify-content-between align-items-center my-4">
					<form:label class="form-control-label" path="role">Rol:</form:label>
					<form:select class="form-control" style="width:60%" path="role">
						<c:forEach items="${roles}" var="role">
							<form:option value="${role}">${role}</form:option>
						</c:forEach>
					</form:select>
				</div>
				
				<div class="form-group d-flex justify-content-between align-items-center my-4">
					<form:label class="form-control-label m-0" style="width:fit-content" path="exp">Experiencia:</form:label>
					<div class="d-flex justify-content-between align-items-center">
						<div class="form-check form-check-inline m-0">
							 <form:input class="form-check-input" type="radio" value="1" path="exp" />
						</div>
						<div class="form-check form-check-inline m-0">
							 <form:input class="form-check-input" type="radio" value="2" path="exp" />
						</div>
						<div class="form-check form-check-inline m-0">
							 <form:input class="form-check-input" type="radio" value="3" path="exp" />
						</div>
						<div class="form-check form-check-inline m-0">
							 <form:input class="form-check-input" type="radio" value="4" path="exp" />
						</div>
						<div class="form-check form-check-inline m-0">
							 <form:input class="form-check-input" type="radio" value="5" path="exp" />
						</div>
					</div>
				</div>
				
				<div class="form-group d-flex justify-content-between align-items-center my-4">
					<form:label class="form-control-label" path="availability"> Disponibilidad:</form:label>
					<div class="d-flex flex-column">
						<div class="form-group">
							<label><form:input type="checkbox" class="mx-2" path="availability" value="morning" id="av-morning" />Mañana</label>
						</div>
						<div class="form-group">
							<label><form:input type="checkbox" class="mx-2" path="availability" value="afternoon" id="av-afternoon" />Tarde</label>
						</div>
					</div>
				</div>
				
				<div class="form-group d-flex justify-content-center align-items-center my-4">
					<input class="btn" style="color:white;background-color: #3e3e3e" type="submit" value="Submit">Filtrar</input>
				</div>
				
			</form:form>
		</div>

		<!--  Listado  -->
		<div class="w-75 p-4 d-flex flex-column justify-content-start align-items-center" style="background-color: #3e3e3e">
		
			<!-- Listado Artistas PRO -->
			<div class="p-4 d-flex flex-wrap justify-content-center align-items-center">
	      		<c:forEach items="${artistsPro}" var="artistPro">
					<div class="d-flex flex-column align-items-center justify-content-center" style="flex-basis: 15%; margin: 1vw;">
						<img src="https://via.placeholder.com/150/FFFF00/00000" onClick="location.href='/artists/show/${artistPro.id}'" class="rounded-circle" style="cursor:pointer;width:5vw;">
						<h5 style="margin: 0.5vw">${artistPro.name}</h5>
						<p>${artistPro.summary}</p>
					</div>
				</c:forEach>
	      	</div>
			
			<hr style="border-width: 3px;border-style: solid;border-radius: 20px;border-color:#e8c71a; width:60%; margin:0">
			
			<!-- Listado Artistas normales -->
			<div class="p-4 d-flex flex-wrap justify-content-center align-items-center">
	      		<c:forEach items="${artistsNoPro}" var="artistNoPro">
					<div class="d-flex flex-column align-items-center justify-content-center" style="flex-basis: 15%; margin: 1vw;">
						<img src="https://via.placeholder.com/150" onClick="location.href='/artists/show/${artistNoPro.id}'" class="rounded-circle" style="cursor:pointer;width:5vw;">
						<h5 style="margin: 0.5vw">${artistNoPro.name}</h5>
						<p>${artistNoPro.summary}</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>

<!-- COMENTARIOS PARA BACKEND -->
<!-- 

-Necesito que la entidad artist tenga un atributo availability (enum: MORNING, AFTERNOON, BOTH)












 -->