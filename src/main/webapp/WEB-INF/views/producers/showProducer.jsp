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

<title>Datos Producer</title>
</head>
<body class="position-relative" style="color:white;height:100%;background-color: #272727; color: white">
	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>
	<div class="d-flex position-relative flex-column" style="min-height:70%">
		<!-- Header producer -->
		<div class="d-flex justify-content-between p-3" style="margin-bottom: 5%">
			<div class="d-flex" style="width:60%">
				<img src="${producer.photo}" class="rounded-circle" style="width:20%">
				<div class="py-3 mx-3" style="width:40%">
					<h3>${producer.name}</h3>
					<h3>${producer.surName}</h3>
					
				</div>
			</div>
			<c:if test="${showButton == false}">
				<button class="btn rounded-pill" onClick="location.href='/messages/create/${producerUsername}'" style="color:white;height: fit-content;background-color: #af3248">Contactar</button>
			</c:if>
			<c:if test="${showButton == true}">
				<button class="btn rounded-pill" onClick="location.href='/producers/update/${producer.id}'" style="color:white;height: fit-content;background-color: #af3248">Editar</button>
			</c:if>
		</div>		
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
</body>
</html>