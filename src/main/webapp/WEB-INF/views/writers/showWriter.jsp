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

<title>Datos Escritor</title>
</head>
<body class="h-100" style="background-color: #272727; color: white">
	<!-- Header Escritor -->
	<div class="d-flex justify-content-between p-3" style="margin-bottom: 5%">
		<div class="d-flex jsutify-content-center">
			<img src="https://via.placeholder.com/150" class="rounded-circle w-30">
			<div class="py-3 mx-3" style="width:40%">
				<h3>${writer.name}</h3>
				<p>${writer.sur_name}</p>
			</div>
		</div>
		<button class="btn rounded-pill" onClick="location.href='/messages/create/${writerId}'" style="color:white;height: fit-content;background-color: #af3248">Contactar</button>
	</div>

	<!-- Info general Escritor -->
	<div class="container" style="margin: 0 5%;max-width:90%">
		<div class="row">
			<div class="col-6 p-3" style="border-color: #af3248;border-style: solid;border-width: 0 2px 0 0;">
				<h4 style="margin-bottom: 4%">Sobre mi</h4>
				<p>${writer.description}</p>
			</div>
			<div class="col-6 p-3">
				<h4 style="margin-bottom: 4%">Historias</h4>
				<p>En construccion</p>
				<!--
				c:forEach items="${stories}" var="story"
					<div class="d-flex justify-content-between">
						<div>
							<h6 style="color:#af3248">${story.title}</h6>
						</div>
						<img src="https://via.placeholder.com/150" class="w-30">
					</div>
					<hr class="m-3" style="border-width: 3px;border-style: solid;border-radius: 20px;border-color:#af3248">
				/c:forEach
				-->
			</div>
		</div>
	</div>

</body>
</html>