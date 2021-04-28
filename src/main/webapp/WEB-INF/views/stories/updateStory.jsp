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
		   background-image: url(https://www.teahub.io/photos/full/55-553913_photo-wallpaper-background-wallpaper-blur-book-book-background.jpg);
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
		
		
		form input, form textarea, form select{
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
			<h3>Editar historia</h3>
	
			<form:form method="POST" action="${story.id}" modelAttribute="story" style="width:100%">
                <div class="d-flex justify-content-between align-items-center">
					<form:label class="rounded-pill form-control-label" path="title">T&iacutetulo</form:label>
					<form:input class="form-control" value="${story.title}" placeholder="Titulo" type="text" path="title"></form:input>
				</div>
				<form:errors style="color:red" path="title"/>
				
				<div class="d-flex justify-content-between align-items-center">
					<form:label class="rounded-pill form-control-label" path="body">Historia</form:label>
					<form:textarea class="form-control" value="${story.body}" placeholder="Historia" path="body"></form:textarea>
				</div>
				<form:errors style="color:red" path="body"/>
						
<!--  HEAD -->

				<div class="d-flex justify-content-between align-items-center">
					<div class="d-flex flex-wrap ">
						<form:label class="rounded-pill form-control-label" path="genre">G&eacutenero</form:label>
<!-- ======= -->
						<div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" style="background-color:#828282" path="body">Historia</form:label>
							</div>
							<form:input class="form-control" value="${story.body}" placeholder="Historia" style="margin-left: 3%;width:60%" type="text" path="body"></form:input>
						</div>
						<form:errors style="color:red" path="body"/>
						
					
					
						<div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" path="genre" style="background-color:#828282">G&eacutenero</form:label>
							</div>
							<form:select value="${story.genre}" class="form-control" style="width:60%" path="genre">
								<form:option value="" selected="true">Selecciona un g&eacutenero</form:option>
								<c:forEach items="${genres}" var="genre">
									<form:option value="${genre}">${genre}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<form:errors style="color:red" path="genre"/>
						<div class="d-flex justify-content-between align-items-center"
						style="margin: 1% 0">
						<div class="d-flex flex-wrap ">
							<form:label class="p-2 rounded-pill form-control-label"
								style="background-color:#828282" path="photo">Url imagen</form:label>
						</div>
						<form:input class="form-control" value="${story.photo}"
							placeholder="url" style="margin-left: 3%;width:60%" type="text"
							path="photo"></form:input>
						</div>
						<form:errors style="color:red" path="photo" />
						<div class="form-group d-flex justify-content-center align-items-center my-4">
							<form:button class="btn" style="color:white;background-color: #af3248">Guardar</form:button>
						</div>
<!-- develop -->
					</div>
					<form:select value="${story.genre}" class="form-control" path="genre">
						<form:option value="" selected="true">Selecciona un g&eacutenero</form:option>
						<c:forEach items="${genres}" var="genre">
							<form:option value="${genre}">${genre}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<form:errors style="color:red" path="genre"/>
				
				<div class="d-flex justify-content-center align-items-center" style="margin-top: 2rem;">
					<form:button class="boton btn rounded-pill">Guardar</form:button>
				</div>
			</form:form>
		</div>

	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
</body>
</html>