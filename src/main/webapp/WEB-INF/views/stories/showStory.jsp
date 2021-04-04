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

<title>Story</title>
</head>
<body class="h-100" style="background-color: #272727; color: white">
	<!-- Header Historia -->
	<div class="d-flex justify-content-between p-3" style="height:15%">
			<div class="d-flex align-items-center" style="width:50%">
				<div  class="rounded-circle d-flex" style="overflow:hidden;height:100%;width:12vh">
					<img src="${story.photo}" style="width:100%;height:100%;object-fit:cover">			
				</div>
				<div class="py-3 mx-3" style="width:40%">
					<h2>${story.title}</h2>
				</div>
			</div>
			<button class="btn rounded-pill" style="color:white;height: fit-content;background-color: #af3248">Contactar con el escritor</button>
	</div>
	<!-- Info general Historia -->
	<div>
		<div class="container-fluid" style="background-color:#4c4c4c; padding:1%">
			<h3 style="margin:0">Ficha técnica</h3>
		</div>
		
		<div class="d-flex justify-content-between" style="padding: 2% 5%;height:40vh">
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
				</div style="margin:1% 0">
				<div>
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Descripción</h5>
					</div>
					<p style="margin-left: 3%">${story.description}</p>
				</div>
			</div>
			
			<!-- Imagen - Video -->
			<div class="d-flex justify-content-center align-items-center" style="width:100vh">
				<img src="${story.photo}" style="max-height:100%; max-width:100%">
			</div>
		</div>
	</div>
</body>
</html>