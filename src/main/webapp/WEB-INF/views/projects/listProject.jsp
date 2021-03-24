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
<title>Project List</title>
</head>
<body class="h-100" style="color:white">
	<div class="d-flex h-100">

		<!--  Filtros -->
		<div class="p-4 w-25" style="background-color: #af3248">
			<h3 class="text-center page-header mb-4" >Filtros</h3>
			<hr class="m-3" style="border-width: 3px;border-style: solid;border-radius: 20px;">
			<form class="my-5">
				<div class="form-group d-flex justify-content-between align-items-center my-4">
					<h5 class="form-control-label" for="name">Nombre:</h5>
					<input class="form-control" style="width:60%" type="text" value="" placeholder="Nombre" id="name">
				</div>
				
				<div class="form-group d-flex justify-content-between align-items-center my-4">
					<h5 class="form-control-label">Género:</h5>
					<select class="form-control" style="width:60%" id="genre">
						<c:forEach items="${genres}" var="genre">
							<option value="${genre}">${genre}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group d-flex justify-content-between align-items-center my-4">
					<h5 class="form-control-label">Género:</h5>
					<select class="form-control" style="width:60%" id="genre">
							<option value="small">Pequeño (1-4 personas)</option>
							<option value="medium">Mediano (5-10 personas)</option>
							<option value="big">Grande (10-15 personas)</option>
							<option value="large">Enorme (15-20 personas)</option>
					</select>
				</div>
				
				<div class="form-group d-flex justify-content-center align-items-center my-4">
					<button class="btn" style="color:white;background-color: #3e3e3e" type="submit">Filtrar</button>
				</div>
				
			</form>
		</div>

		<!--  Listado  -->
		
		
			<!-- Listado Proyectos PRO -->
				<!-- 
				<div>
		      		<c:forEach items="${projectsPro}" var="projectPro">
		      			<a href="artist/showProject/${projectPro.id}"><img src="https://via.placeholder.com/150/FFFF00/000000"></a>
		      			<span>${projectPro.name}</span>
		      		</c:forEach>
		      	</div>
				
				-->
				
				<div class="w-75 p-4 d-flex flex-wrap justify-content-center align-items-center" style="background-color: #3e3e3e">
		      		<c:forEach items="${projects}" var="project">
						<div class="d-flex flex-column align-items-center justify-content-center" style="flex-basis: 15%">
							<img src="https://via.placeholder.com/150" onClick="location.href='/projects/show/${project.id}'" class="rounded-circle w-50" style="cursor:pointer">
							<h4 style="margin: 0">${project.title}</h4>
						</div>
					</c:forEach>
				</div>

	</div>
</body>
</html>

<!-- COMENTARIOS PARA BACKEND -->
<!-- 

-Necesito que el modelo Project tenga una propiedad "pro" (boolean) para indicar si es de pago o no

-Necesito que se me pase en una variable "projectsPro" (por ej) aquellos usuarios que tienen pro a true

-Necesito que el modelo Project tenga una imagen almacenada en DB para poder mostrar la foto del project

-Necesito que se me pase en una variable "genres" (por ej) todos los valores del Enum Genre












 -->