<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html style="height:100%">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shorcut icon" type="image/ico" href="https://github.com/Carcotmed/CinemaParadisoGrupo-04/blob/feature/fix-general/src/main/webapp/WEB-INF/views/static/favicon.ico?raw=true" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
	
	<style>
		.filtro-wrap-mobile{
			display: none  !important;
		}
		
		.filtro-wrap{
			display: block;
			position: relative;
			background-color: var(--rojo);
			border-radius: 0 100px 100px 0;
		    box-shadow: 0 0 10px black;
		}
		
		
		.padding-nav > h2{
			text-align:center;
			margin-bottom: 2rem;
			text-shadow: 0 0 10px black;
		}
		
		
		.filtro-scroller{
			position: sticky;
			top:10rem;
			bottom:0;
		}
		
		.background-image{
			z-index: -1;
		   background-image: url(https://www.teahub.io/photos/full/55-553913_photo-wallpaper-background-wallpaper-blur-book-book-background.jpg);
		   width: 110%;
		   position: absolute;
		   height: 100%;
		   filter: blur(5px);
		   background-size: contain;
		}
		
		.fondo-w {
			background-color: rgb(49 28 5 / 69%);
		}
			
		#list-wrap{
			transition: 0.5s;
			display: block;
		}
		
		.filtro-wrap button{
			border-color: var(--gris);
		}
		
		.filtro-wrap button:hover{
			background-color: var(--gris);
		}
		
		h3,h5,label{
			text-align: center;
		}
		
		h5{
			margin: 0.5vw;
		}
		
		.lista{
			display: grid;
 			 grid-template-columns: repeat(5, 15rem);
		}
		
		#list-wrap-mobile{
			display: none  !important;
		}
				
			
		@media(max-width: 1545px) {
			.lista{
			 	grid-template-columns: repeat(4, 13rem);
			}
	
		}
			
			
		@media(max-width: 1160px) {
			
			.filtro-wrap-mobile{
				display: block  !important;
    			padding: 0 1.5rem;
			}
			
			.filtro-wrap{
				display: none  !important;
			}
			
			#global-wrap{
				display:block !important;
			}
			
			#list-wrap-mobile{
				display: block  !important;
				background-color: var(--gris-claro);
			}
			
			#list-wrap{
				display:none !important;
			}
			
			.background-image{
				width: 100%;
			}
			
			.padding-nav > h2{
				font-size: 2.5rem;
			}
			
			.padding-nav{
			    background-color: rgb(0,0,0, 20%);
			}
			
			.linea-hor{
				border-color: var(--rojo);
				background-color: var(--rojo);
			}
			
		}
</style>
 <!--  crear Post normal -->
<title>Crear anuncio</title>
</head>
<body class="position-relative" style="color:white;height:100%;background-color: #272727; color: white">
	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>

	<div class="d-flex position-relative justify-content-center align-items-center" style="min-height:70%;padding:2%">
		
			
		<form:form method="POST" action="${formAction}" modelAttribute="post" style="width:100%">
		<div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
		 <div class="d-flex flex-wrap ">
		    <form:label class="p-2 rounded-pill form-control-label" style="background-color:#828282" path="title">Título</form:label>
		 </div>
		 <form:input class="form-control" value="${post.title}" placeholder="Título" style="margin-left: 3%;width:60%" type="text" path="title"></form:input>
		</div>
		 <form:errors style="color:red" path="title"/>
		<div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
		 <div class="d-flex flex-wrap ">
		  <form:label class="p-2 rounded-pill form-control-label" style="background-color:#828282" path="body">Cuerpo</form:label>
		 </div>
		 <form:textarea class="form-control" value="${post.body}" placeholder="body" style="margin-left: 3%; width:60%" type="text" path="body"></form:textarea>
		</div>
		<form:errors style="color:red" path="body"/>
		<div class="form-group d-flex justify-content-center align-items-center my-4">
		 <form:button class="btn" style="color:white;background-color: #af3248">Guardar</form:button>
		  <a href="/projects/show/${post.project.id}" style="color:white;height: fit-content; margin:0 1% ;background-color:#af3248 " class="btn ">Volver</a>
						</div>
				</form:form>
			</div>
		
		<!--  crear Post movil -->
		<div id="list-wrap-mobile" class="padding-footer">
		<form:form method="POST" action="${formAction}" modelAttribute="post" style="width:100%">
		<div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
		 <div class="d-flex flex-wrap ">
		    <form:label class="p-2 rounded-pill form-control-label" style="background-color:#828282" path="title">Título</form:label>
		 </div>
		 <form:input class="form-control" value="${post.title}" placeholder="Título" style="margin-left: 3%;width:60%" type="text" path="title"></form:input>
		</div>
		 <form:errors style="color:red" path="title"/>
		<div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
		 <div class="d-flex flex-wrap ">
		  <form:label class="p-2 rounded-pill form-control-label" style="background-color:#828282" path="body">Cuerpo</form:label>
		 </div>
		 <form:textarea class="form-control" value="${post.body}" placeholder="body" style="margin-left: 3%; width:60%" type="text" path="body"></form:textarea>
		</div>
		<form:errors style="color:red" path="body"/>
		<div class="form-group d-flex justify-content-center align-items-center my-4">
		 <form:button class="btn" style="color:white;background-color: #af3248">Guardar</form:button>
		  <a href="/projects/show/${post.project.id}" style="color:white;height: fit-content; margin:0 1% ;background-color:#af3248 " class="btn ">Volver</a>
						</div>
				</form:form>
		
		
		
		
		
		
		
		
		
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
		
</body>
</html>
