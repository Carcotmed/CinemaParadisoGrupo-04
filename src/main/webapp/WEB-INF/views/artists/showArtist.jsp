<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shorcut icon" type="image/ico"
	href="https://github.com/Carcotmed/CinemaParadisoGrupo-04/blob/feature/fix-general/src/main/webapp/WEB-INF/views/static/favicon.ico?raw=true" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<title>Datos Artista</title>
</head>
<body class="position-relative"
	style="color: white; height: 100%; background-color: #272727; color: white">
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<div class="d-flex position-relative flex-column"
		style="min-height: 70%">
		<!-- Header Artista -->
		<div class="d-flex justify-content-between p-3"
			style="margin-bottom: 5%">
			<div class="d-flex" style="width: 60%">
				<img src="${artist.photo}" class="rounded-circle" style="width: 20%">
				<div class="py-3 mx-3" style="width: 40%">
					<h3>${artist.name}</h3>
					<p>Rol: ${artist.role}</p>
				</div>
			</div>
			<button class="btn rounded-pill"
				onClick="location.href='/messages/create/${artistUsername}'"
				style="color: white; height: fit-content; background-color: #af3248">Contactar</button>
		</div>

		<!-- Info general Artista -->
		<div class="container" style="margin: 0 5%; max-width: 90%">
			<div class="row">
				<div class="col-6 p-3"
					style="border-color: #af3248; border-style: solid; border-width: 0 2px 0 0;">
					<h4 style="margin-bottom: 4%">Sobre mi</h4>
					<p>${artist.description}</p>
				</div>
				<div class="col-6 p-3">
					<div class="d-flex justify-content-between align-items-center">
						<h4 style="margin-bottom: 4%">Proyectos</h4>
						<c:choose>
							<c:when test="${projectsLeft == null || projectsLeft == 0}">
								<span style="text-align: center;">¡Hazte PRO para poder seguir creando proyectos!</span>
							</c:when>
							<c:when test="${projectsLeft != null}">
								<span style="text-align: center;">Proyectos disponibles: ${projectsLeft}</span>
								<button class="btn rounded-circle" style="background-color:#af3248" onClick="location.href='/projects/create'"><strong style="color:white">+</strong></button>
							</c:when>
						</c:choose>
					</div>
					
					<c:forEach items="${myProjects}" var="project">
						<div class="d-flex align-items-center justify-content-evenly"
							style="height: 15vh; margin: 1% 0; cursor: pointer"
							onClick="location.href='/projects/show/${project.id}'">
							<div style="width: 10vh; height: 10vh; overflow: hidden"
								class="rounded-circle">
								<img
									src="${project.photo}"
									style="width: 100%; height: 100%; object-fit: cover">
							</div>
							<div style="margin-left: 12%">
								<h5>${project.title}</h5>
								<p>${project.genre}</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>


</body>
</html>
