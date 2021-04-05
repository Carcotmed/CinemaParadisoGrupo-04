<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	<link rel="shorcut icon" type="image/ico" href="https://github.com/Carcotmed/CinemaParadisoGrupo-04/blob/feature/fix-general/src/main/webapp/WEB-INF/views/static/favicon.ico?raw=true" />

<title>Descubre Productoras</title>
</head>
<body style="color:white;height:100%;" class="position-relative">
	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>

	<div class="d-flex position-relative" style="min-height:70%">

		<!--  Listado  -->
		<div class="p-4 d-flex flex-column justify-content-start align-items-center" style="width:100%;background-color: #3e3e3e">
		
			<!-- Listado producers -->
			<div class="p-4 d-flex flex-wrap justify-content-center align-items-center">
	      		<c:forEach items="${producers}" var="producer">
					<div class="d-flex flex-column align-items-center justify-content-center" style="flex-basis: 15%; margin: 1vw;">
						<img src="${producer.photo}" onClick="location.href='/producers/show/${producer.id}'" class="rounded-circle" style="cursor:pointer;width:5vw;height:5vw">
						<h5 style="margin: 0.5vw">${producer.name}</h5>
						<h5 style="margin: 0.5vw">${producer.surName}</h5>
					</div>
				</c:forEach>
	      	</div>
			
		</div>
	</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
	
</body>
</html>