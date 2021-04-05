<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html style="height:100%">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shorcut icon" type="image/ico" href="https://github.com/Carcotmed/CinemaParadisoGrupo-04/blob/feature/fix-general/src/main/webapp/WEB-INF/views/static/favicon.ico?raw=true" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<title>Mis Proyectos</title>
</head>
<body class="position-relative" style="color:white;height:100%;background-color: #272727; color: white">
	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>

	<div class="d-flex position-relative justify-content-center align-items-center" style="min-height:70%;padding:2%">
		
			
			<div class="d-flex justify-content-between" style="width:40%;">
				<c:choose>
					<c:when test="${buttonCreate == false}">
						<c:set var="formAction" value="${project.id}" />
					</c:when>
					<c:otherwise>
						<c:set var="formAction" value="create" />
					</c:otherwise>
				</c:choose>
				<form:form method="POST" action="${formAction}" modelAttribute="project" style="width:100%">
				
					<!-- Datos -->
					<div>
						<div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" style="background-color:#828282" path="title">Título</form:label>
							</div>
							<form:input class="form-control" value="${project.title}" placeholder="Título" style="margin-left: 3%;width:60%" type="text" path="title"></form:input>
						</div>
						<form:errors style="color:red" path="title"/>
						<div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" path="genre" style="background-color:#828282">Género</form:label>
							</div>
							<form:select value="${project.genre}" class="form-control" style="width:60%" path="genre">
								<form:option value="" selected="true">Selecciona un género</form:option>
								<c:forEach items="${genres}" var="genre">
									<form:option value="${genre}">${genre}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<form:errors style="color:red" path="genre"/>
						<div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" style="background-color:#828282" path="description">Resumen</form:label>
							</div>
							<form:textarea class="form-control" value="${project.description}" placeholder="Descripción" style="margin-left: 3%;width:60%" type="text" path="description"></form:textarea>
						</div>
						<form:errors style="color:red" path="description"/>
						<div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" style="background-color:#828282" path="photo">Url imagen</form:label>
							</div>
							<form:input class="form-control" value="${project.photo}" placeholder="url" style="margin-left: 3%;width:60%" type="text" path="photo"></form:input>
						</div>
						<form:errors style="color:red" path="photo"/>
						<div class="form-group d-flex justify-content-center align-items-center my-4">
							<form:button class="btn" style="color:white;background-color: #af3248">Guardar</form:button>
						</div>
					</div>
				</form:form>
			</div>
		
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
		
</body>
</html>
