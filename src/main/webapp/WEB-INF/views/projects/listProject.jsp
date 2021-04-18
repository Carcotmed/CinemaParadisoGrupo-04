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
<title>Lista de Proyectos</title>
</head>
<body style="color:white;height:100%;" class="position-relative">
	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>

	<div class="d-flex position-relative" style="min-height:70%">

		<!--  Filtros -->
		<div class="p-4 w-25" style="background-color: #af3248">
			<h3 class="text-center page-header mb-4" >Filtros</h3>
			<hr class="m-3" style="border-width: 3px;border-style: solid;border-radius: 20px;">
			<form:form class="my-5" action="list" method="POST" modelAttribute="projectsFiltered">
				<div class="form-group d-flex justify-content-between align-items-center my-4">
					<form:label class="form-control-label" path="title">T&iacutetulo:</form:label>
					<form:input class="form-control" style="width:60%" type="text" placeholder="Titulo" path="title" />
				</div>
				
				<div class="form-group d-flex justify-content-between align-items-center my-4">
					<form:label class="form-control-label" path="genre">G&eacutenero:</form:label>
					<form:select class="form-control" style="width:60%" path="genre">
						<form:option value="" selected="true">Selecciona un g&eacutenero</form:option>
						<c:forEach items="${genres}" var="genre">
							<form:option value="${genre}">${genre}</form:option>
						</c:forEach>
					</form:select>
				</div>
								
				<div class="form-group d-flex justify-content-center align-items-center my-4">
					<form:button class="btn" style="color:white;background-color: #3e3e3e">Filtrar</form:button>
				</div>
			</form:form>
		</div>

		<!--  Listado  -->
		<div class="w-75 p-4 d-flex flex-column justify-content-start align-items-center" style="background-color: #3e3e3e">
			<c:if test="${ sponsoredProjects.size()>0 }">
				<div class="row">
					<h4 style="padding-bottom: 1.5vw; padding-left: 4vw;">Proyectos descatacados</h4>
					<c:forEach items="${ sponsoredProjects }" var="sponsoredProject">
						<div onclick="location.href='/projects/show/${sponsoredProject.id}'" class="col-sm" style="cursor: pointer; height: fit-content; background-color: #c1c113; border-radius: 2vw; margin: 1vw 3vw 1vw 3vw; text-align: center; padding-bottom: 1vw; padding-top: 1vw;">
							<div style="margin-bottom: 1vw; padding-left: 6vw; overflow:hidden;height:40%;width:80%">
								<div  class="rounded-circle d-flex">
									<img src="${ sponsoredProject.photo }" style="border-radius: 50%; width:5vw;height:5vw;object-fit:cover">
								</div>
							</div>
							<i>
								<b>
									${ sponsoredProject.title }
								</b>
							</i>
						</div>
					</c:forEach>
				</div>
				<hr width="100%">
			</c:if>
			<!-- Listado Proyectos PRO -->
			<div class="d-flex flex-wrap justify-content-center align-items-center">
	      		<c:forEach items="${projectsPro}" var="projectPro">
	      			<div class="d-flex flex-column align-items-center justify-content-evenly" style="cursor:pointer;flex-basis: 15%; margin: 1vw;height:10vw" onClick="location.href='/projects/show/${projectPro.id}'">
						<div  class="rounded-circle d-flex" style="border-style:solid;border-color:#edd214;overflow:hidden;height:100%;width:80%">
	      					<img src="${projectPro.photo}"  style="cursor:pointer;width:100%;height:100%;object-fit:cover">
	      				</div>
		      			<h5 style="margin: 0.5vw; text-align:center">${projectPro.title}</h5>
		      		</div>
	      		</c:forEach>
	      	</div>
			
			<hr style="border-width: 3px;border-style: solid;border-radius: 20px;border-color:#e8c71a; width:60%; margin:1%">
			
			<!-- Listado Proyectos No PRO -->
			<div class="d-flex flex-wrap justify-content-center align-items-center">
				<c:forEach items="${projectsNoPro}" var="projectNoPro">
	      			<div class="d-flex flex-column align-items-center justify-content-evenly" style="cursor:pointer;flex-basis: 15%; margin: 1vw;height:10vw" onClick="location.href='/projects/show/${projectNoPro.id}'">
						<div  class="rounded-circle d-flex" style="overflow:hidden;height:100%;width:80%">
							<img src="${projectNoPro.photo}" style="cursor:pointer;width:100%;height:100%;object-fit:cover">
						</div>
						<h5 style="margin: 0.5vw; text-align:center">${projectNoPro.title}</h5>
					</div>
				</c:forEach>
			</div>
					
		</div>
	</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
	
</body>
</html>