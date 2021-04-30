<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>
<style>
		.background-image{
			z-index: -1;
		   background-image: url(https://cdn.hipwallpaper.com/i/33/55/hreiP4.jpg);
		   width: 110%;
		   position: absolute;
		   height: 100%;
		   filter: blur(5px);
		   background-size: contain;
		}
		
		.perfil-top img{
			width: 10rem;
		    height: 10rem;
		    border: 5px solid white;
		    object-fit: cover;
		}
		
		.perfil-top{
			width: 30%;
	    	margin: auto;
		}
		
	
		.perfil-bot{
			background: linear-gradient(180deg, transparent 0%, var(--gris) 9%, var(--gris) 100%);
		}
		
		.acciones-wrap{
			width: 100%;
			display: flex;
			justify-content: space-evenly;
			align-items: center;
			padding: 1rem;
		}
		
		.perfil-info-wrap > div{
			width:50%;
			padding: 1.5rem;
		}
		
		.perfil-info-wrap{
			padding: 2rem 0;
		}
		
		.perfil-borde{
			border-right: 3px solid var(--rojo);
		}
		
		h3{
			text-align: center;
			text-shadow: 0 0 10px black;
		}
		
		h4{
			margin-bottom: 1rem;
		}
		
		.perfil-element-wrap{
			display: flex;
			justify-content:space-between;
			align-items: center;
			padding: 1.5rem 1rem;
			cursor: pointer;
			border-radius: 20px;
			transition: 0.3s;
		    margin-top: 1rem;
		}
		
		.perfil-element-wrap:hover{
			padding: 1.5rem 8rem;
			background-color: var(--rojo);
		}
		
		.perfil-bot img{
			height:7rem;
			width:7rem;
			object-fit: cover;
		}
		
		.linea-hor{
			display: none;
		}
		
		.perfil-element-wrap div{
			text-align: end;
		}
		
		.perfil-borde > div > p {
			background-color: var(--rojo);
			padding: 0.2rem 1rem;
			font-weight: bold;
		}
		
		.b-create{
			width: 2rem;
		    padding: 0;
		    height: 2rem;
		    font-weight: bold;
		}
		
		.perfil-info-wrap .buy-mobile{
			display: none;
			text-align: center;
		}
		
		.perfil-info-wrap .buy{
			display: block;
			text-align: center;
		}
		
		.info-list-wrap{
			display: flex;
		}
		
		@media(max-width: 1160px) {
			.perfil-info-wrap{
				flex-direction: column;
			}
			
			.perfil-info-wrap > div{
				width:100%;
			}
			
			.perfil-borde{
				border: unset;
			}
			
			.perfil-bot{
				background: linear-gradient(180deg, transparent 0%, var(--gris) 10%, var(--gris) 100%);
			}
			
			.linea-hor{
				display: block;
				background-color: var(--rojo);
				border-color: var(--rojo);
				width: 80%;
   				margin: 0 auto;
			}
			
			.background-image{
				width: 100%;
			}
			
			.padding-footer{
				padding-bottom: 29rem !important;
			}
			
			.perfil-info-wrap .buy-mobile{
				display: block;
			}
			
			.perfil-info-wrap .buy{
				display: none;
			}
			
			.info-list-wrap{
				display: block;
			}
			
		}
				
		
</style>
<body>
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<div class="background-image"></div>
	<div class="padding-nav perfil-top d-flex flex-column justify-content-center align-items-center">
		<img src="${artist.photo}" style="border-color: ${artist.pro ? 'var(--amarillo)' : 'white'}" class="rounded-circle">
		<div>
			<h3>${artist.user.username}</h3>
			<h3>${artist.name}&nbsp${artist.surName}</h3>
		</div>
	</div>
	
	<div class="perfil-bot padding-footer d-flex position-relative flex-column">
	
		<div class="acciones-wrap">
			<c:if test="${!userDisabled}">
				<c:if test="${showButton == false || isAdmin}">
					<button class="boton btn rounded-pill"
						onClick="location.href='/messages/create/${artistUsername}'">Contactar</button>
				</c:if>
				<c:if test="${showButton == true}">
					<button class="boton btn rounded-pill" onClick="location.href='/artists/update/${artist.id}'">Editar</button>
					<button class="boton btn rounded-pill"
						onClick="location.href='/artists/delete/${artist.id}'">Desactivar</button>
				</c:if>
			</c:if>
			
			<c:if test="${userDisabled}">
				<c:if test="${isAdmin}">
					<button class="boton btn rounded-pill" onclick="location.href='/artists/activate/${artist.id}'">Activar</button>
				</c:if>
			</c:if>
		</div>

		<c:if test="${!userDisabled}">
			<div class="perfil-info-wrap d-flex">
				<div class="perfil-borde">
					<div class="d-flex justify-content-between align-items-center">
						<h4>Datos del artista</h4>
						<p class="rounded-pill">${artist.role}</p>
					</div>
					<p>${artist.description}</p>
				</div>
				
				<hr class="linea-hor">
				
				<div>
					<div class="info-list-wrap justify-content-between align-items-center"">
						<h4>Proyectos</h4>
						<p class="buy-mobile">¡Accede a la ventana PRO para comprar más proyectos!</p>
						<c:if test="${showButton == true}">
							<c:choose>
								<c:when test="${projectsLeft == null || projectsLeft == 0}">
									<span class="buy">¡Accede a la ventana PRO para comprar más proyectos!</span>
								</c:when>
								<c:when test="${projectsLeft != null && !isAdmin}">
									<span style="text-align: center;">Proyectos disponibles: ${projectsLeft}</span>
									<button class="b-create boton btn rounded-circle" onClick="location.href='/projects/create'">+</button>
								</c:when>
							</c:choose>
						</c:if>
					</div>
					<c:forEach items="${myProjects}" var="project">
						<div class="perfil-element-wrap" onClick="location.href='/projects/show/${project.id}'">
							<img class="rounded-circle" src="${project.photo}">
							<div>
								<h5>${project.title}</h5>
								<p>${project.genre}</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:if>
		<c:if test="${userDisabled}">
			<div class="d-flex justify-content-center align-items-center" style="width: 100%; padding-top: 4rem">
				<h2>Usuario desactivado</h2>
			</div>
		</c:if>
		
	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>