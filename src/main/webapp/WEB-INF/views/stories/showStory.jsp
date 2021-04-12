<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html class="h-100">
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script>
	$(document).ready(function(){
		$("#levantaModal").click(function(){
		    $("#fondoModal").show();
		    $("#modalProyectos").show();
		});
		$("#fondoModal").click(function(){
		    $("#fondoModal").hide();
		    $("#modalProyectos").hide();
		});
	});
</script>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<title>Story</title>
</head>
<body class="h-100" style="background-color: #272727; color: white">
	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>
	<div id="fondoModal" style="display: none; position: fixed; width: 100%; height: 100%; background-color: transparent;"></div>
	<div id="modalProyectos" style="color: black; display: none; left: 20vw; top: 10vw; position: fixed; height: 50vw; width: 50vw; background-color: white">
		<c:forEach items="${projects}" var="projects">
			<a onclick="location.href='/stories/request/${story.id}/${projects.id}'">${ projects.title }</a>
		</c:forEach>
	</div>

	<!-- Header Historia -->
	<div class="d-flex justify-content-between p-3" style="height:15%">
			<div class="d-flex align-items-center" style="width:50%">
				<div  class="rounded-circle d-flex" style="overflow:hidden;height:100%;width:12vh">
					<img src="https://www.psicoactiva.com/wp-content/uploads/puzzleclopedia/Libros-codificados-300x262.jpg" style="width:100%;height:100%;object-fit:cover">			
				</div>
				<div class="py-3 mx-3" style="width:40%">
					<h2>${story.title}</h2>
				</div>
			</div>
			<button class="btn rounded-pill" onClick="location.href='/messages/create/${writerUsername}'" style="color:white;height: fit-content;background-color: #af3248">Contactar con el escritor</button>
			<button class="btn rounded-pill" id="levantaModal" style="color:white;height: fit-content;background-color: #af3248">Levanta modal</button>
	</div>
	<!-- Info general Historia -->
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
					<p style="margin-left: 3%">${story.title}</p>
				</div>
				<div style="margin:1% 0">
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Género</h5>
					</div>
					<p style="margin-left: 3%">${story.genre}</p>
				</div>
				<div>
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Descripción</h5>
					</div>
					<p style="margin-left: 3%">${story.body}</p>
				</div>
								<div>
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Writer</h5>
					</div>
					<p style="margin-left: 3%">${myWriter.user.username}</p>
					<div style="width:20vh;height:20vh;overflow:hidden" class="rounded-circle">
					<img src="${myWriter.photo}" onClick="location.href='/writers/show/${myWriter.id}'" style="width:100%;height:100%;object-fit:cover">
					</div>
				</div>
			</div>
			
		</div>
	</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
	
</body>
</html>