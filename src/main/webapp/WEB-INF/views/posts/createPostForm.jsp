<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
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
		   background-image: url(https://www.indecsur.cl/wp-content/uploads/2020/03/272910-desk-laptop.jpg);
		   width: 100%;
		   position: absolute;
		   height: 100%;
		   filter: blur(5px);
		   background-size: contain;
		}
		
		.form-wrapper{
			display: flex;
			flex-direction: column;
			align-items: center;
			padding: 1.5rem;
			width:30rem;
			height: fit-content;
			box-shadow: 0 0 10px black;
			background-color: var(--gris);
			border-radius: 20px;
			margin: 1rem 0 2rem 0;
		}
		
		
		form input, form textarea{
			width: 60% !important;
		}
		
		form div{
			margin: 0.5rem 0;
		}
		
		form {
			margin: 0;
		}
		
		form label{
			font-weight: bold;
		}
	
		
		@media(max-width: 1160px) {
			
			.padding-nav{
				padding-top: 6rem !important;
			}
		
			.form-wrapper{
				box-shadow: unset;
				border-radius: unset;
				margin: unset;
			}
		
		}
		
</style>
<body>
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<div class="background-image"></div>

	<div class="padding-nav padding-footer d-flex justify-content-center align-items-center">

		<div class="form-wrapper">
			<h3>Nuevo anuncio</h3>
	
			<form:form method="POST" action="${formAction}" modelAttribute="post" style="width:100%">				
				
                <div class="d-flex justify-content-between align-items-center">
            		<div class="d-flex flex-wrap ">
						<form:label path="title">T&iacutetulo: </form:label>
					</div>
					<form:input class="form-control" type="text" path="title" placeholder="Titulo" />
				</div>
				<form:errors style="color:red" path="title"/>
						
				<div class="d-flex justify-content-between align-items-center">
					<div class="d-flex flex-wrap ">
						<form:label path="body">Cuerpo: </form:label>
					</div>
					<form:textarea class="form-control"  path="body"  placeholder="Mensaje" />
				</div>
				<form:errors style="color:red" path="body"/>
				
				<div class="d-flex justify-content-center align-items-center" style="margin-top: 2rem;">
					<form:button class="boton btn rounded-pill">Guardar</form:button>
				</div>
			</form:form>
		</div>

	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
</body>
</html>