<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" %>


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
	}
	
	.msg-wrapper h4{
		text-align: center;
	}	
	
	.msg-wrapper p{
		margin-bottom: 3rem;
		padding: 0 2rem;
	}
	
	.linea-hor{
		background-color: var(--rojo);
		border-color: var(--rojo);
	}
	
	.acciones > div{
		width: 33%;
		display: flex;
		align-items:center;
	}
	
	.acciones span{
		visibility: hidden;
	}

			
	@media(max-width: 1160px) {
		
		.padding-nav{
			padding-top: 6rem !important;
		}
		
		.volver{
			display: none !important;
		}
		
		.acciones > div{
			width: 100%;
		}

	}
</style>
<body>
	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>
	<div class="background-image"></div>
	
	<div class="padding-nav padding-footer">
		<div class="msg-wrapper">
                 	
				<!-- Contenido -->
				
                 	<h4>${message.issue}</h4>
                 	
                 	<div class="d-flex justify-content-between align-items-center w-100">
                 		<div class="d-flex flex-column">
	              		    <span><strong>De:</strong> ${message.emisor.username}</span>
	              			<span><strong>Para: </strong> ${message.receptor.username}</span>
	                 	</div>
	                
	                	<fmt:formatDate value="${message.messageDate}" type="date" pattern="yyyy/MM/dd HH:mm" var="messageDate"/>
	                 	<span>${messageDate}</span>
	                </div>
	                
	                <hr class="linea-hor">
	                
	                
                	<p>${message.body}</p>
                	
                	 <hr class="linea-hor">
                	
                	<div class="acciones d-flex justify-content-between align-items-center">
                		<div class="volver"></div>
                		
                		<div class="justify-content-center">
                			<c:if test="${isRequest}">
		                		<c:if test="${isWriter}">
		                			<button class="boton btn rounded-pill"
											onClick="location.href='/messages/show/${message.id}/acceptRequestStory'">Aceptar</button>
									<button class="boton btn rounded-pill"
											onClick="location.href='/messages/show/${message.id}/rejectRequestStory'">Rechazar</button>
		                		</c:if>
		                		
		                		<c:if test="${!isWriter}">
		                			<c:if test="${isArtist}">
		                				<button class="boton btn rounded-pill"
											onClick="location.href='/messages/show/${message.id}/acceptRequestArtist'">Aceptar</button>
										<button class="boton btn rounded-pill"
											onClick="location.href='/messages/show/${message.id}/rejectRequestArtist'">Rechazar</button>
		                			</c:if>
		                			
		                			<c:if test="${isProducer}">
		                				<button class="boton btn rounded-pill"
											onClick="location.href='/messages/show/${message.id}/acceptRequestProducer'">Aceptar</button>
										<button class="boton btn rounded-pill"
											onClick="location.href='/messages/show/${message.id}/rejectRequestProducer'">Rechazar</button>
		                			</c:if>
		                		</c:if>
		                	
		                	</c:if>
                		</div>
                		
                		<div class="justify-content-end volver">
                			<button class="boton btn rounded-pill" onclick="location.href = '/messages/listReceived';">Volver</button>
                		</div>
                	</div>

			</div>
			
							
	</div>
	
	<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
 
</body>
</html>