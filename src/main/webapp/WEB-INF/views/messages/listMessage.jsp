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
</head>
<style>
	.background-image{
		z-index: -1;
	   background-image: url(https://hardfun.cl/inicio/wp-content/uploads/2018/02/Lets-Film.jpg);
	   width: 100%;
	   position: absolute;
	   height: 100%;
	   filter: blur(5px);
	}
	
	.msg-wrapper{
		padding: 1.5rem;
		width:90%;
		height: fit-content;
		box-shadow: 0 0 10px black;
		background-color: var(--gris);
		border-radius: 20px;
		margin: 1.5rem auto;
		display: flex;
		flex-direction: column;
		align-items: center;
	}	
	
	.msg-wrapper h3{
		margin-bottom: 2rem;
	}
		
	.grid-msg{
		display: grid;
	    grid-template-columns: 15% 15% 20% 20% 30%;
	    row-gap: 10px;
	    text-align: center;
	    width: 100%;
	}
	
	.grid-msg *{
		border-top: 1px solid white;
    	border-bottom: 1px solid white;
    	padding: 0.5rem 0;
	}
	
	.grid-msg .boton{
		padding: 0 0.5rem;
	}
	
	.msg-wrapper > button{
		margin-top: 1rem;
	}
	
	.bold{
		font-weight: bold;
		border-top: unset;
		border-bottom: unset;
	}
	
	.listMobile{
		display: none;
	}
	
			
	@media(max-width: 1160px) {
		
		.listMobile{
			display:block;
		}
		
		.grid-msg{
			display:none;
		}
		
		.padding-nav{
			padding-top: 6rem !important;
		}
		
		.linea-hor{
			border-color: var(--rojo);
			background-color: var(--rojo);
		}
		
		.listMobile .boton{
			padding: 0 0.5rem;
			margin: 0;
		}
		
		.acciones{
		    margin-top: 1rem;
		}
	}
</style>
<body>
	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>
	
	<div class="background-image"></div>
	<a id="top"></a>
	
	<div class="padding-nav padding-footer">
		<div class="msg-wrapper">
			<h3><c:if test="${ tipo=='received' }">Mensajes Recibidos</c:if><c:if test="${ tipo=='send' }">Mensajes Enviados</c:if></h3>
			<div class="grid-msg">
				<span class="bold">ASUNTO</span>
				<span class="bold">FECHA (UTC)</span>
				<span class="bold">EMISOR</span>
				<span class="bold">RECEPTOR</span>
				<span class="bold">ACCIONES</span>
                 	
				<!-- Contenido -->	
				<c:forEach items="${messages}" var="message">
                 	<span>${message.issue}</span>
                 	<fmt:formatDate value="${message.messageDate}" type="date" pattern="yyyy/MM/dd HH:mm" var="messageDate"/>
                 	<span>${messageDate}</span>
                 	<span>${message.emisor.username}</span>
                 	<span>${message.receptor.username}</span>
				 	<div class="acciones">
				 		<spring:url value="/messages/show/{messageId}" var="showUrl">
	                        <spring:param name="messageId" value="${message.id}"/>
	                    </spring:url>
	                    <a href="${fn:escapeXml(showUrl)}" class="boton btn rounded-pill">Mostrar</a>
		                   	 
	                    <spring:url value="/messages/delete/{messageId}" var="deleteUrl">
	                        <spring:param name="messageId" value="${message.id}"/>              
	                    </spring:url>
	                    <a href="${fn:escapeXml(deleteUrl)}" class="boton btn rounded-pill">Borrar</a>
		                    
	        			<c:if test="${ tipo=='received' }">
							<spring:url value="/messages/create/{userId}" var="createUrl">
								<spring:param name="userId" value="${message.emisor.username}"/>
							</spring:url>
							<a href="${fn:escapeXml(createUrl)}" class="boton btn rounded-pill">Responder</a>
						</c:if>
	                    
	        			<c:if test="${ tipo=='send' }">
							<spring:url value="/messages/create/{userId}" var="createUrl">
								<spring:param name="userId" value="${message.receptor.username}"/>
							</spring:url>
							<a href="${fn:escapeXml(createUrl)}" class="boton btn rounded-pill">Reescribir</a>
						</c:if>
				 	</div>
                </c:forEach>				
			</div>
			
			<!-- Mobile -->
			<div class="listMobile">			
				<c:forEach items="${messages}" var="message">
					
					<div class="msg-wrap-mobile">
						<div class="d-flex align-items-center justify-content-between">
							<div class="d-flex flex-column">
								<span class="bold">${message.issue}</span>
								<fmt:formatDate value="${message.messageDate}" type="date" pattern="yyyy/MM/dd HH:mm" var="messageDate"/>
			               		<span>${messageDate}</span>
							</div>
			               	
			               	<span>${message.emisor.username}</span>
						</div>			
		               	
					 	<div class="acciones">
					 		<spring:url value="/messages/show/{messageId}" var="showUrl">
		                        <spring:param name="messageId" value="${message.id}"/>
		                    </spring:url>
		                    <a href="${fn:escapeXml(showUrl)}" class="boton btn rounded-pill">Mostrar</a>
			                   	 
		                    <spring:url value="/messages/delete/{messageId}" var="deleteUrl">
		                        <spring:param name="messageId" value="${message.id}"/>              
		                    </spring:url>
		                    <a href="${fn:escapeXml(deleteUrl)}" class="boton btn rounded-pill">Borrar</a>
			                    
		        			<c:if test="${ tipo=='received' }">
								<spring:url value="/messages/create/{userId}" var="createUrl">
									<spring:param name="userId" value="${message.emisor.username}"/>
								</spring:url>
								<a href="${fn:escapeXml(createUrl)}" class="boton btn rounded-pill">Responder</a>
							</c:if>
		                    
		        			<c:if test="${ tipo=='send' }">
								<spring:url value="/messages/create/{userId}" var="createUrl">
									<spring:param name="userId" value="${message.receptor.username}"/>
								</spring:url>
								<a href="${fn:escapeXml(createUrl)}" class="boton btn rounded-pill">Reescribir</a>
							</c:if>
					 	</div>
					 	<hr class="linea-hor">
					</div>
	             </c:forEach>		
			</div>
			
	 	    <c:if test="${ tipo=='received' }">
				<button class="boton btn rounded-pill" onclick="location.href = '/messages/listSend';">Enviados</button>
			</c:if>
	   	    <c:if test="${ tipo=='send' }">
				<button class="boton btn rounded-pill" onclick="location.href = '/messages/listReceived';">Recibidos</button>
			</c:if>
		
		</div>
				
	</div>
	
	
	<c:if test="${tipo=='received'}">
		<c:set var="urlMsg" value="listReceived" />
	</c:if>
	<c:if test="${ tipo=='send' }">
		<c:set var="urlMsg" value="listSend" />
	</c:if>
	
	<div id="boton-up" onClick="location.href='/messages/${urlMsg}#top'">
		<span>^</span>
	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
 
</body>
</html>