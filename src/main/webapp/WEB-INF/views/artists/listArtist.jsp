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
<title>Artist List</title>
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
					<h5 class="form-control-label">Rol:</h5>
					<select class="form-control" style="width:60%" id="role">
						<c:forEach items="${roles}" var="role">
							<option value="${role}">${role}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group d-flex justify-content-between align-items-center my-4">
					<h5 class="form-control-label m-0" style="width:fit-content">Experiencia:</h5>
					<div class="d-flex justify-content-between align-items-center">
						<div class="form-check form-check-inline m-0">
							 <input	class="form-check-input" type="radio" value="1" name="exp">
						</div>
						<div class="form-check form-check-inline m-0">
							 <input	class="form-check-input" type="radio" value="2" name="exp">
						</div>
						<div class="form-check form-check-inline m-0">
							 <input	class="form-check-input" type="radio" value="3" name="exp">
						</div>
						<div class="form-check form-check-inline m-0">
							 <input	class="form-check-input" type="radio" value="4" name="exp">
						</div>
						<div class="form-check form-check-inline m-0">
							 <input	class="form-check-input" type="radio" value="5" name="exp">
						</div>
					</div>
				</div>
				
				<div class="form-group d-flex justify-content-between align-items-center my-4">
					<h5 class="form-control-label"> Disponibilidad:</h5>
					<div class="d-flex flex-column">
						<div class="form-group">
							<label><input type="checkbox" class="mx-2" value="morning" id="av-morning">Ma�ana</label>
						</div>
						<div class="form-group">
							<label><input type="checkbox" class="mx-2" value="afternoon" id="av-afternoon">Tarde</label>
						</div>
					</div>
				</div>
				
				<div class="form-group d-flex justify-content-center align-items-center my-4">
					<button class="btn" style="color:white;background-color: #3e3e3e" type="submit">Filtrar</button>
				</div>
				
			</form>
		</div>

		<!--  Listado  -->
		
		
			<!-- Listado Artistas PRO -->
				<div>
		      		<c:forEach items="${artistsPro}" var="artistPro">
		      			<a href="artist/detailsArtist/${artistPro.id}"><img src="https://via.placeholder.com/150/FFFF00/000000"></a>
		      			<span>${artistPro.name}</span>
		      			<p>${artistPro.summary}</p>
		      		</c:forEach>
		      	</div>
				
				
				<div class="w-75 p-4 d-flex flex-wrap justify-content-center align-items-center" style="background-color: #3e3e3e">
		      		<c:forEach items="${artists}" var="artist">
						<div class="d-flex flex-column align-items-center justify-content-center" style="flex-basis: 15%">
							<img src="https://via.placeholder.com/150" onClick="location.href='/artists/show/${artist.id}'" class="rounded-circle w-50" style="cursor:pointer">
							<h4 style="margin: 0">${artist.name}</h4>
							<p>${artist.summary}</p>
						</div>
					</c:forEach>
				</div>

	</div>
</body>
</html>

<!-- COMENTARIOS PARA BACKEND -->
<!-- 

-Necesito que el modelo Persona tenga una propiedad "pro" (boolean) para indicar si es de pago o no (HECHO)

-Necesito que se me pase en una variable "artistsPro" (por ej) aquellos usuarios que tienen pro a true (HECHO)

-Necesito que el modelo Persona tenga una imagen almacenada en DB para poder mostrar la foto del user (REDIRECCIONADO AL GRUPO QUE LE CORRESPONDE)

-Necesito que se me pase en una variable "roles" (por ej) todos los valores del Enum Roles (HECHO)












 -->