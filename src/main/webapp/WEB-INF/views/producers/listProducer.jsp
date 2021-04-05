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

    <title>Lista de Productoras</title>
</head>
<body>
    <div class="container mt-4">
        <table class="table">
            <thead>
                <tr>
                    <th>NAME</th>
                    <th>SURNAME</th>
                    <th>USERNAME</th>
                    <th>            </th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach items="${producers}" var="producer">
                <tr>
                  <td><c:out value="${producer.name}" /></td>
                  <td><c:out value="${producer.surName}" /></td>
                  <td><c:out value="${producer.user.username}" /></td>
                  <td>
				  <spring:url value="/producers/show/{producerUsername}" var="showUrl">
				  <spring:param name="producerUsername" value="${producer.user.username}"/>
				
				 </spring:url> 
				  <a href="${fn:escapeXml(showUrl)}" class="btn btn-danger">Mostrar</a>
				 
				 <c:if test="${ username!=null && producer.user.username==username }">
				 <spring:url value="/producers/delete/{producerUsername}" var="deleteUrl">
				  <spring:param name="producerUsername" value="${producer.user.username}"/>
				</spring:url> 
				  <a href="${fn:escapeXml(deleteUrl)}" class="btn btn-danger">Borrar</a>
				  
				  <spring:url value="/producers/update/{producerUsername}" var="updateUrl">
				  <spring:param name="producerUsername" value="${producer.user.username}"/>
				  </spring:url> 
				  	<a href="${fn:escapeXml(updateUrl)}" class="btn btn-danger">Actualizar</a>
				</c:if>
				  
				  
				</td>
                </tr>
                 
                </c:forEach>
                
            </tbody>
        </table>
        
		<spring:url value="/producers/create" var="createUrl">
		</spring:url>
	
		<a href="${fn:escapeXml(createUrl)}" class="btn btn-danger">Crear</a>
		<button class="btn btn-danger" onclick="location.href = '/';">Volver</button> 
   	    </div>

</body>
</html>