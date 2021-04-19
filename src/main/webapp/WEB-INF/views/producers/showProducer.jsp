<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<title>Datos Producer</title>
</head>
<body class="position-relative"
	style="color: white; height: 100%; background-color: #272727; color: white">
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<div class="d-flex position-relative flex-column"
		style="min-height: 70%">
		<!-- Header producer -->
		<div class="d-flex justify-content-between p-3"
			style="margin-bottom: 5%">
			<div class="d-flex" style="width: 60%">
				<img src="${producer.photo}" class="rounded-circle"
					style="width: 20%">
				<div class="py-3 mx-3" style="width: 40%">
					<h3>${producer.name}</h3>
					<h3>${producer.surName}</h3>

				</div>
			</div>
			<c:if test="${!userDisabled}">
				<c:if test="${showButton == false || isAdmin}">
					<button class="btn rounded-pill"
						onClick="location.href='/messages/create/${producerUsername}'"
						style="color: white; height: fit-content; background-color: #af3248">Contactar</button>
				</c:if>
				<c:if test="${showButton == true}">
					<button class="btn rounded-pill"
						onClick="location.href='/producers/update/${producer.id}'"
						style="color:white;height: fit-content;background-color: ${isAdmin?'#8a4380':'#af3248'}">Actualizar
						perfil</button>
					<button class="btn rounded-pill"
						onClick="location.href='/producers/delete/${producer.id}'"
						style="color:white;height: fit-content;background-color: ${isAdmin?'#8a4380':'#af3248'}">Desactivar
						perfil</button>
				</c:if>
			</c:if>
			<c:if test="${userDisabled}">
				<div class="py-3 mx-3" style="width: 40%">
					<h2>Usuario desactivado</h2>
				</div>
				<c:if test="${isAdmin}">
					<button class="btn rounded-pill"
						style="background-color: ${isAdmin?'#8a4380':'#af3248'}; color: white;"
						onclick="location.href='/producers/activate/${producer.id}'">Activar
						productora</button>
				</c:if>
			</c:if>
		</div>

		<!-- Info general Productor -->

		<c:if test="${!userDisabled}">
			<div class="container" style="margin: 0 5%; max-width: 90%">
				<div class="row">
					<div class="col-6 p-3" style="border-color: #af3248; border-style: solid; border-width: 0 2px 0 0;">
						<h4 style="margin-bottom: 4%">Datos de la productora</h4>
						<p>${producer.description}</p>
					</div>
					<div class="col-6 p-3 d-flex justify-content-between align-items-center flex-column" >
						<div class="d-flex justify-content-between align-items-center">
							<h4 style="margin-bottom: 4%">Proyectos</h4>
							<c:forEach items="${myProjects}" var="project">
								<div class="d-flex align-items-center justify-content-evenly"
									style="height: 15vh; margin: 1% 0; cursor: pointer"
									onClick="location.href='/projects/show/${project.id}'">
									<div style="width: 10vh; height: 10vh; overflow: hidden"
										class="rounded-circle">
										<img src="${project.photo}"
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
		</c:if>
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>