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

<title>Create Story</title>
</head>
<body class="h-100" style="background-color: #272727; color: white">
	<div class="d-flex">
		<div class="d-flex flex-column justify-content-center">
			<h4>Mis Historias</h4>
			<button class="btn rounded-circle">+</button>
		</div>
		<!--  c:forEach items="${stories}" var="story" -->
		<div>
			<img src="https://via.placeholder.com/150" class="w-30">
			<h6>Historia</h6>
			<!-- ${story.title} -->
		</div>
		<!-- c:forEach -->

		<!-- Crear Historia -->
		<form>
			<!-- Info general Historia -->
			<div style="overflow: scroll">
				<div class="container-fluid">
					<h3>Ficha técnica</h3>
				</div>
				<div class="d-flex justify-content-between"	style="margin: 0 5%; max-width: 90%">
				
					<!-- Datos -->
					<div>
						<div class="form-group">
							<h5 class="form-control-label" for="title">Título:</h5>
							<input class="form-control" style="width:60%" type="text" value="" placeholder="Título" id="title">
						</div>
						
						<div class="form-group">
							<h5 class="form-control-label" for="genres">Géneros:</h5>
							<select class="form-control" style="width:60%" id="genres">
								<c:forEach items="${genres}" var="genre">
									<option value="${genre}">${genre}</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="form-group">
							<h5 class="form-control-label" for="description">Descripción:</h5>
							<input class="form-control" style="width:60%" type="text-area" value="" placeholder="Descripción" id="description">
						</div>
						
					</div>

					<!-- Imagen - Video -->
					<div>
						<img src="https://via.placeholder.com/150" class="w-50">
					</div>
				</div>
				
				<div class="form-group d-flex justify-content-center align-items-center my-4">
					<button class="btn" style="color:white;background-color: #3e3e3e" type="submit">Guardar</button>
				</div>
				
			</div>
		</form>


	</div>
</body>
</html>
