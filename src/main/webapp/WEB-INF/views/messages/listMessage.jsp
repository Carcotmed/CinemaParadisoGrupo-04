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

    <title>Lista de Mensajes</title>
</head>
<body style="color:white;height:100%;background-color:#2b2b2b;" class="position-relative">
	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>
	<div style="min-height:70%;background-color:#3e3e3e;padding:5%">
	
	<h3>
   	    <c:if test="${ tipo=='received' }">Mensajes Recibidos</c:if>
   	    <c:if test="${ tipo=='send' }">Mensajes Enviados</c:if>
	</h3>
    <div class="container mt-4">
        <table class="table">
            <thead>
                <tr>
                    <th style="color:white">ASUNTO</th>
                    <th style="color:white">FECHA (UTC)</th>
                    <th style="color:white">EMISOR</th>
                    <th style="color:white">RECEPTOR</th>
                    <th style="color:white">             </th> 
                </tr>
            </thead>
            
            <tbody>
                <c:forEach items="${messages}" var="message">
                <tr>
                  <td style="color:white"><c:out value="${message.issue}" /></td>
				  <fmt:formatDate value="${message.messageDate}" type="date" pattern="yyyy/MM/dd HH:mm" var="messageDate"/>
				  <td  style="color:white"><c:out value="${messageDate}" /></td>	
				  <td style="color:white"><c:out value="${message.emisor.username}" /></td>
				  <td style="color:white"><c:out value="${message.receptor.username}" /></td>
                  <td>
                    <spring:url value="/messages/show/{messageId}" var="showUrl">
                        <spring:param name="messageId" value="${message.id}"/>
                    </spring:url>

                    <a href="${fn:escapeXml(showUrl)}" style="background-color:${(!message.seen && tipo=='received')?'#359106; border-color: #359106':'#af3248;'}" class="btn btn-danger">Mostrar</a>
                   	 
                    <spring:url value="/messages/delete/{messageId}" var="deleteUrl">
                        <spring:param name="messageId" value="${message.id}"/>              
                    </spring:url>
                    <a href="${fn:escapeXml(deleteUrl)}" style="background-color:#af3248" class="btn btn-danger">Borrar</a>
                    
        			<c:if test="${ tipo=='received' }">
					<spring:url value="/messages/create/{userId}" var="createUrl">
					<spring:param name="userId" value="${message.emisor.username}"/>
					</spring:url>
				
					<a href="${fn:escapeXml(createUrl)}" style="background-color:#af3248" class="btn btn-danger">Responder</a>
					</c:if>
                    
        			<c:if test="${ tipo=='send' }">
					<spring:url value="/messages/create/{userId}" var="createUrl">
					<spring:param name="userId" value="${message.receptor.username}"/>
					</spring:url>
				
					<a href="${fn:escapeXml(createUrl)}" style="background-color:#af3248" class="btn btn-danger">Volver a escribir</a>
					</c:if>
                </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>   
   	    </div>
   	    <div style="margin-top: 10%"class="d-flex justify-content-evenly align-items-center">
   	    	<c:if test="${ tipo=='received' }">
		<button class="btn btn-danger" style="background-color:#af3248" onclick="location.href = '/';">Volver</button>
		<button class="btn btn-danger" style="background-color:#af3248"onclick="location.href = '/messages/listSend';">Enviados</button>
		</c:if>
   	    <c:if test="${ tipo=='send' }">
		<button class="btn btn-danger" style="background-color:#af3248" onclick="location.href = '/';">Volver</button>
		<button class="btn btn-danger" style="background-color:#af3248" onclick="location.href = '/messages/listReceived';">Recibidos</button>
		</c:if>
   	    </div>
   	    
	</div>
	
 		<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
 
</body>
</html>