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

    <title>Mensaje</title>
</head>
<body style="color:white;height:100%;background-color:#2b2b2b" class="position-relative">
    	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>
    
    <div class="container mt-4">
        <table class="table">
            <thead>
                <tr>
                    <th style="color:white">ASUNTO</th>
                    <th style="color:white">CUERPO</th>
                    <th style="color:white">FECHA</th>
                    <th style="color:white">ID DEL EMISOR</th>
                    <th style="color:white">ID DEL RECEPTOR</th>
                </tr>
            </thead>
            
            <tbody>
                <tr>
                  <td style="color:white"><c:out value="${message.issue}" /></td>
                  <td style="color:white"><c:out value="${message.body}" /></td>
				  <fmt:formatDate value="${message.messageDate}" type="date" pattern="yyyy/MM/dd HH:mm" var="messageDate"/>
				  <td style="color:white"><c:out value="${messageDate}" /></td>
				  <td style="color:white"><c:out value="${message.emisor.username}" /></td>
				  <td style="color:white"><c:out value="${message.receptor.username}" /></td>
				  <td style="color:white">
				  
                </tr>
                
            </tbody>
        </table>

     	<button class="btn btn-danger" style="background-color:#af3248" onclick="location.href = '/messages/listReceived';">Volver</button>    		
     		<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
    
</body>
</html>