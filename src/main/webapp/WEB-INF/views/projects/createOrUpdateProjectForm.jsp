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
				</div>
			</c:forEach>
		</div>
		
		<!-- Info general Proyecto -->
		<div>
			<div class="container-fluid" style="background-color:#4c4c4c; padding:1%">
				<h3 style="margin:0">Ficha técnica</h3>
			</div>
			
			<div class="d-flex justify-content-between" style="padding: 2% 5%;height:40vh">
				<form:form method="POST" action="create" modelAttribute="project">
					<!-- Datos -->
					<div style="width:150%">
						<div style="margin:1% 0">
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" style="background-color:#3e3e3e" path="title">Título</form:label>
							</div>
							<form:input class="form-control" value="${project.title}" placeholder="Título" style="margin-left: 3%" type="text" path="title"></form:input>
						</div>
						<div style="margin:1% 0">
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" style="background-color:#3e3e3e">Género</form:label>
							</div>
							<form:select class="form-control" style="width:60%" path="genre">
								<form:option value="${project.genre}" selected="true">Selecciona un género</form:option>
								<c:forEach items="${genres}" var="genre">
									<form:option value="${genre}">${genre}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<div>
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" style="background-color:#3e3e3e" path="description">Resumen</form:label>
							</div>
							<form:textarea class="form-control" value="${project.description}" placeholder="Descripción" style="margin-left: 3%" type="text" path="description"></form:textarea>
						</div>
						<div>
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" style="background-color:#3e3e3e" path="photo">Url imagen</form:label>
							</div>
							<form:input class="form-control" value="${project.photo}" placeholder="url" style="margin-left: 3%" type="text" path="photo"></form:input>
						</div>
						
						<div class="form-group d-flex justify-content-center align-items-center my-4">
							<form:button class="btn" style="color:white;background-color: #3e3e3e">Guardar</form:button>
						</div>
					</div>
				</form:form>
			</div>
		
		</div>
	</div>
</body>
</html>
