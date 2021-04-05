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

    <title>Muestra de Mensaje</title>
</head>
<body>
    <div class="container mt-4">
        <table class="table">
            <thead>
                <tr>
                    <th>ASUNTO</th>
                    <th>CUERPO</th>
                    <th>FECHA</th>
                    <th>ID DEL EMISOR</th>
                    <th>ID DEL RECEPTOR</th>
                </tr>
            </thead>
            
            <tbody>
                <tr>
                  <td><c:out value="${message.issue}" /></td>
                  <td><c:out value="${message.body}" /></td>
				  <fmt:formatDate value="${message.messageDate}" type="date" pattern="yyyy/MM/dd HH:mm" var="messageDate"/>
				  <td><c:out value="${messageDate}" /></td>
				  <td><c:out value="${message.emisor.username}" /></td>
				  <td><c:out value="${message.receptor.username}" /></td>
				  <td>
				  
                </tr>
                
            </tbody>
        </table>

     	<button class="btn btn-danger" onclick="location.href = '/messages/listReceived';">Volver</button>    		
    
</body>
</html>