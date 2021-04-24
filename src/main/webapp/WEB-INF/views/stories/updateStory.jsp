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

<title>Crear historia</title>
</head>
<body class="h-100" style="background-color: #272727; color: white">
	<div class="d-flex justify-content-center align-items-center" style="padding:2%">
		
		<!-- Info general historia -->
			
			<div class="d-flex justify-content-between" style="width:40%;">
				
				<form:form method="POST" action="${story.id}" modelAttribute="story" style="width:100%">
				
					<!-- Datos -->
					<div>
						<div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" style="background-color:#828282" path="title">T&iacutetulo</form:label>
							</div>
							<form:input class="form-control" value="${story.title}" placeholder="Titulo" style="margin-left: 3%;width:60%" type="text" path="title"></form:input>
						</div>
						<form:errors style="color:red" path="title"/>
						
						<div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" style="background-color:#828282" path="body">Historia</form:label>
							</div>
							<form:input class="form-control" value="${story.body}" placeholder="Historia" style="margin-left: 3%;width:60%" type="text" path="body"></form:input>
						</div>
						<form:errors style="color:red" path="body"/>
						
					
					
						<div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" path="genre" style="background-color:#828282">G&eacutenero</form:label>
							</div>
							<form:select value="${story.genre}" class="form-control" style="width:60%" path="genre">
								<form:option value="" selected="true">Selecciona un g&eacutenero</form:option>
								<c:forEach items="${genres}" var="genre">
									<form:option value="${genre}">${genre}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<form:errors style="color:red" path="genre"/>
						<div class="d-flex justify-content-between align-items-center"
						style="margin: 1% 0">
						<div class="d-flex flex-wrap ">
							<form:label class="p-2 rounded-pill form-control-label"
								style="background-color:#828282" path="photo">Url imagen</form:label>
						</div>
						<form:input class="form-control" value="${story.photo}"
							placeholder="url" style="margin-left: 3%;width:60%" type="text"
							path="photo"></form:input>
						</div>
						<form:errors style="color:red" path="photo" />
						<div class="form-group d-flex justify-content-center align-items-center my-4">
							<form:button class="btn" style="color:white;background-color: #af3248">Guardar</form:button>
						</div>
					</div>
				</form:form>
			</div>
		
		</div>
</body>
</html>