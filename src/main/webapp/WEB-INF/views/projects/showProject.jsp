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
	<link rel="shorcut icon" type="image/ico" href="https://github.com/Carcotmed/CinemaParadisoGrupo-04/blob/feature/fix-general/src/main/webapp/WEB-INF/views/static/favicon.ico?raw=true" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<title>Project</title>
</head>
<body class="h-100" style="background-color: #272727; color: white">
	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>

	<!-- Header Proyecto -->
	<div class="d-flex justify-content-between p-3" style="height:15%">
			<div class="d-flex align-items-center" style="width:50%">
				<div  class="rounded-circle d-flex" style="overflow:hidden;height:100%;width:12vh">
					<img src="${project.photo}" style="width:100%;height:100%;object-fit:cover">			
				</div>
				<div class="py-3 mx-3" style="width:40%">
					<h2>${project.title}</h2>
				</div>
			</div>

			<c:if test="${ !pertenece }">
			<button class="btn rounded-pill" onclick="location.href='/projects/join/${project.id}'" style="color:white;height: fit-content;background-color: #af3248">Unirse al equipo</button>
			</c:if>
	</div>
	<!-- Info general Proyecto -->
	<div>
		<div class="container-fluid" style="background-color:#4c4c4c; padding:1%">
			<h3 style="margin:0">Ficha técnica</h3>
		</div>
		
		<div class="d-flex justify-content-between" style="padding: 2% 5%;">
			<!-- Datos -->
			<div style="width:150%">
				<div style="margin:1% 0">
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Título</h5>
					</div>
					<p style="margin-left: 3%">${project.title}</p>
				</div>
				<div style="margin:1% 0">
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Género</h5>
					</div>
					<p style="margin-left: 3%">${project.genre}</p>
				</div style="margin:1% 0">
				<div>
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Resumen</h5>
					</div>
					<p style="margin-left: 3%">${project.description}</p>
				</div>
				<c:if test="${ story!= null}">
					<div>
						<div class="d-flex flex-wrap ">
							<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Historia asociada</h5>
						</div>
						<p style="margin-left: 3%">${story.title}</p>
				    </div>
				</c:if>
			</div>
			
			<!-- Imagen - Video -->
			<div class="d-flex justify-content-center align-items-center" style="width:100vh">
				<img src="${project.photo}" style="max-height:100%; max-width:100%">
			</div>
		</div>
		
		<div class="container-fluid" style="background-color:#4c4c4c; padding:1%">
			<h3 style="margin:0">Integrantes</h3>
		</div>
			
		<div style="padding: 2% 0;width:30%;margin:auto">
			<c:forEach items="${members}" var="member">
				<div class="d-flex align-items-center justify-content-evenly" style="height:15vh; margin: 1% 0">
					<div style="width:10vh;height:10vh;overflow:hidden" class="rounded-circle">
						<img onclick="location.href='/artists/show/${ member.id }'" src="https://d500.epimg.net/cincodias/imagenes/2018/11/13/lifestyle/1542113135_776401_1542116070_noticia_normal.jpg" style="width:100%;height:100%;object-fit:cover"><!-- {member.img} -->
					</div>
					<div style="margin-left: 12%">
						<h5>${member.name}</h5>
						<p>${member.role}</p>
					</div>
				</div>
				
				<hr style="border-width: 3px;border-style: solid;border-radius: 20px;border-color:#e8c71a; width:60%; margin:1% auto">
			</c:forEach>
		</div>

	</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
	
</body>
</html>
