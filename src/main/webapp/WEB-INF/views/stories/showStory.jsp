<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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
<!--  HEAD -->
</head>
<style>
.background-image {
	z-index: -1;
	background-image:
		url(https://www.teahub.io/photos/full/55-553913_photo-wallpaper-background-wallpaper-blur-book-book-background.jpg);
	width: 110%;
	position: absolute;
	height: 100%;
	filter: blur(5px);
	background-size: cover;
}

.card-wrap {
	width: 80%;
	box-shadow: 0 0 10px black;
	border-radius: 20px;
	margin: auto;
}

.ficha-tecnica {
	position: relative;
	overflow: hidden;
	display: flex;
	justify-content: flex-end;
	height: 50%;
}

.integrantes {
	margin: 1.5rem auto;
	padding: 1.5rem;
	background-color: var(--gris);
}

.card-wrap .element-wrapper:hover {
	background-color: var(--gris-claro);
}

.integrantes h4 {
	text-align: center;
}

.ficha-tecnica > div {
	padding: 1.5rem;
	position: absolute;
	background: linear-gradient(90deg, var(--gris) 0%, var(--gris) 70%,
		transparent 100%);
	width: 100%;
	height: 100%;
	overflow-y: scroll;
}

.ficha-tecnica > div > div {
	margin-bottom: 1rem;
}

.ficha-tecnica img {
	object-fit: cover;
	min-height: 20rem:
}

.lista {
	display: grid;
	grid-template-columns: repeat(5, 15rem);
	margin: auto;
	width: fit-content;
}

.adminP:hover {
	background-color: var(--rojo) !important;
}

.pago {
	width: 65%;
}

.pago h4 {
	margin-bottom: 1rem;
}

#resumen {
	width: 70%;
}

#list-wrap-mobile {
	display: none;
}

.ficha-tecnica > div img{
	height: 6rem;
	width: 6rem;
}

.escritor{
	transition: 0.3s;
	cursor: pointer;
	padding: 1rem 0;
	border-radius: 20px;
	width: 70%;
}

.escritor:hover{
	padding: 1rem 3rem;
	background-color: var(--rojo);
	font-weight: bold;
}

#fondoModal{
	display: none;
	position: fixed;
	width: 100%;
	height: 100%;
	background-color: transparent;
}

#modalProyectos{
	display: none;
	padding: 1rem 0;
	position: fixed;
	background-color: var(--gris);
	z-index: 90;
    box-shadow: 0 0 10px black;
    width: 25rem;
    border-radius: 20px 0 0 20px;
    right: 0;
    text-align: center;
    transition: 0.3s;
    top: 8rem;
}

#modalProyectos > div{
	margin-top:1rem;
	padding: 0.5rem;
	transition: 0.3s;
}

#modalProyectos > div:hover{
	background-color: var(--rojo);
}

#modalProyectos > div:hover button{
	border-color: var(--gris);
}

#modalProyectos > div:hover button:hover{
	background-color: var(--gris);
}

@media ( max-width : 1545px) {
	.lista {
		grid-template-columns: repeat(4, 13rem);
	}
}

@media ( max-width : 1160px) {
	.background-image {
		width: 100%;
	}
	
	.ficha-tecnica > div {
		background: linear-gradient(0deg, var(--gris) 0%, var(--gris) 70%,
			transparent 100%);
		position: unset;
		background-color: var(--gris);
	}
	
	.ficha-tecnica {
		justify-content: flex-start;
		flex-direction: column;
		position: unset;
		height: unset;
    }
	
	.padding-nav {
		padding-top: 6rem !important;
	}
	
	.card-wrap > div > div {
		display: flex;
		justify-content: space-between;
	}
	
	.card-wrap {
		width: unset;
		border-radius: unset;
	}
	
	.card-wrap > img {
		height: 15rem;
		width: 100%;
	}
	
	#resumen, #escritorWrap, .acciones, .pago, .pago > div {
		width: 100%;
		display: block !important;
	}
	
	.acciones {
		display: flex !important;
		flex-direction: column;
	}
	
	.acciones button {
		margin: 0.5rem;
	}
	
	.integrantes {
		display: none;
	}
	
	#list-wrap-mobile {
		display: block;
		background-color: var(--gris);
		margin-top: 1.5rem;
		padding: 1.5rem 0;
	}
	
	#list-wrap-mobile h4 {
		text-align: center;
	}
	
	.linea-hor {
		border-color: var(--rojo);
		background-color: var(--rojo);
	}
	
	.padding-footer{
		padding-bottom: 27rem !important;
	}
	
	#modalProyectos{
	    padding: 1rem 0;
	    position: fixed;
	    background-color: var(--gris);
	    z-index: 90;
	    width: 100%;
	    text-align: center;
	    transition: 0.3s;
	    height: 100%;
	    box-shadow: unset;
	    top:unset;
	    right:unset;
	    border-radius: unset;
	}

}
</style>
<script
	src="https://www.paypal.com/sdk/js?client-id=AXbp0NhXvchBXWtbvtRNBvVdch6cABb0d7084I04WtigxqKbiVA6WPNIJFwzLyXd-0el451LDtbOEwI2&currency=EUR"></script>
<body>
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<div class="background-image"></div>
	<div id="global-wrap" class="padding-nav">
		<script>
		<!-- ======= -->

<title>Story</title>
</head>

<body class="h-100" style="background-color: #272727; color: white">
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

<script>
//-- develop --//
		$(document).ready(function () {
		    var global = document.getElementById("global-wrap");
		    var card = document.getElementById("infoCard");

			if($(window).width() < 1160){
				card.classList.add("padding-footer");
				global.classList.remove("padding-footer");
			}else{
				card.classList.remove("padding-footer");
				global.classList.add("padding-footer");
			}
			
			$("#levantaModal").click(function () {
				$("#fondoModal").show();
				$("#modalProyectos").show();
			});
			$("#fondoModal").click(function () {
				$("#fondoModal").hide();
				$("#modalProyectos").hide();
			});
		});

		$(window).scroll(function () {
			$("#fondoModal").hide();
			$("#modalProyectos").hide();
		})
		
	</script>
<!--  HEAD -->

		<!-- Modal -->
		<div id="fondoModal"></div>
		<div id="modalProyectos">
			<h4>Proyectos a asociar</h4>
			<c:forEach items="${projects}" var="projects">
				<div class="d-flex justify-content-between align-items-center">
					<h6>${ projects.title }</h6>
					<button class="boton btn rounded-pill"
						onClick="location.href='/stories/request/${story.id}/${projects.id}'">Asociar</button>
				</div>
			</c:forEach>
<!-- ======= -->
	<div id="fondoModal"
		style="display: none; position: fixed; width: 100%; height: 100%; background-color: transparent;"></div>
	<div id="modalProyectos"
		style="color: white; border-radius: 20px; display: none; left: 24vw; top: 20vh; padding: 1%; position: fixed; width: 50vw; background-color: #3c3c3c">
		<div class="container-fluid"
			style="background-color: #af3248; border-radius: 20px; padding: 1%">
			<h2>Proyectos a asociar</h2>
<!-- develop -->
		</div>

<!--  HEAD -->

		<div id="infoCard" class="card-wrap ficha-tecnica">
			<img
				src="https://www.psicoactiva.com/wp-content/uploads/puzzleclopedia/Libros-codificados-300x262.jpg">

			<div>
				<div>
					<h4>T&iacutetulo</h4>
					<span>${story.title}</span>
<!-- ======= -->
	<!-- Header Historia -->
	<div class="d-flex justify-content-between p-3" style="height: 15%">
		<div class="d-flex align-items-center" style="width: 50%">
			<div class="rounded-circle d-flex"
				style="overflow: hidden; height: 100%; width: 12vh">
				<img src="${story.photo}"
					style="width: 100%; height: 100%; object-fit: cover">
			</div>
			<div class="py-3 mx-3" style="width: 40%">
				<h2>${story.title}</h2>
			</div>
		</div>
		<c:if test="${showButton == false}">
			<sec:authorize access="isAuthenticated()">
				<button class="btn rounded-pill"
					onClick="location.href='/messages/create/${writerUsername}'"
					style="color: white; height: fit-content; background-color: #af3248">Contactar
					con el escritor</button>
				<button class="btn rounded-pill" id="levantaModal" F
					style="color: white; height: fit-content; background-color: #af3248">Asociar
					proyecto</button>
			</sec:authorize>
		</c:if>
		<c:if test="${showButton == true and !story.isSponsored and !isAdmin}">
			<!-- PAYPAL -->

			<script
				src="https://www.paypal.com/sdk/js?client-id=AXbp0NhXvchBXWtbvtRNBvVdch6cABb0d7084I04WtigxqKbiVA6WPNIJFwzLyXd-0el451LDtbOEwI2&currency=EUR"> // Required. Replace YOUR_CLIENT_ID with your sandbox client ID.
							</script>

			<script>
							function post(path, params, method = 'post') {
								// The rest of this code assumes you are not using a library.
								// It can be made less verbose if you use one.
								const form = document.createElement('form');
								form.method = method;
								form.action = path;
								for (const key in params) {
									if (params.hasOwnProperty(key)) {
										const hiddenField = document.createElement('input');
										hiddenField.type = 'hidden';
										hiddenField.name = key;
										hiddenField.value = params[key];
										form.appendChild(hiddenField);
									}
								}
								document.body.appendChild(form);
								form.submit();
							}

						</script>

			<script>
							paypal.Buttons({
								createOrder: function (data, actions) {
									return actions.order.create({
										purchase_units: [{
											amount: {
												currency: "EUR",
												value: "30"
											},
										}]
									});
								},
								onApprove: function (data, actions) {
									// This function captures the funds from the transaction.
									return actions.order.capture().then(function (details) {
										post("/pro/confirmedAdStory", { storyID: ${ story.id }, paymentDetails: details, ${ _csrf.parameterName }: "${_csrf.token}"})
								});
						    }
						  }).render('#paypal-button-ad-story');
						  //This function displays Smart Payment Buttons on your web page.
						</script>

			<div>
				<p>Â¡Publicita tu historia! (30&#8364)</p>
			</div>
			<div id="paypal-button-ad-story" style="z-index: 1"></div>

			<!-- END PAYPAL -->
		</c:if>

		<sec:authorize access="isAuthenticated()">
			<c:if test="${isAdmin}">
				<button class="btn rounded-pill"
					onClick="location.href='/messages/create/${writerUsername}'"
					style="color: white; height: fit-content; background-color: #af3248">Contactar
					con el escritor</button>
			</c:if>
		</sec:authorize>
		<c:if test="${showButton == true}">
			<button class="btn rounded-pill"
				onClick="location.href='/stories/update/${story.id}'"
				style="color:white;height: fit-content;background-color: ${isAdmin?'#8a4380':'#af3248'}">Actualizar</button>
			<button class="btn rounded-pill"
				onClick="location.href='/stories/delete/${story.id}'"
				style="color:white;height: fit-content;background-color: ${isAdmin?'#8a4380':'#af3248'}">Eliminar</button>
		</c:if>
	</div>
	<!-- Info general Historia -->
	<div>
		<div class="container-fluid"
			style="background-color: #4c4c4c; padding: 1%">
			<h3 style="margin: 0">Ficha t&eacutecnica</h3>
		</div>

	
		
	   <!-- Datos -->
	   <div style="display:flex">
       <div class="col-6 p-3" style="border-color: #af3248; border-style: solid; border-width: 0 2px 0 0;">
		<div class="d-flex justify-content-between" style="padding: 2% 5%;">
			<div style= "width: 150%">

				<div style="margin: 1% 0">
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color: #3e3e3e">T&iacutetulo</h5>
					</div>
					<p style="margin-left: 3%">${story.title}</p>
				</div>
				<div style="margin: 1% 0">
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color: #3e3e3e">G&eacutenero</h5>
					</div>
					<p style="margin-left: 3%">${story.genre}</p>
<!-- develop -->
				</div>
				<div>
					<h4>G&eacutenero</h4>
					<span>${story.genre}</span>
				</div>
				<div id="resumen">
					<h4>Resumen</h4>
					<span>${story.body}</span>
				</div>

				<div id="escritorWrap">
					<h4>Escritor/a</h4>
					<div class="escritor d-flex flex-wrap align-items-center"
						onClick="location.href='/writers/show/${myWriter.id}'">
						<img class="rounded-circle" src="${myWriter.photo}">
						<p style="margin-left: 1rem">${myWriter.name}</p>
					</div>
				</div>
<!--  HEAD -->


					<div class="acciones">
						<h4>Acciones</h4>
						
						<c:if test="${showButton == false}">
							<sec:authorize access="isAuthenticated()">
								<button class="boton btn rounded-pill"	onClick="location.href='/messages/create/${writerUsername}'">Contactar
									con el escritor</button>
								<button class="boton btn rounded-pill" id="levantaModal">Asociar
									proyecto</button>
							</sec:authorize>
						</c:if>
						
						<sec:authorize access="isAuthenticated()">
							<c:if test="${isAdmin}">
								<button class="boton btn rounded-pill"
									onClick="location.href='/messages/create/${writerUsername}'">Contactar
									con el escritor</button>
							</c:if>
						</sec:authorize>
						
						<c:if test="${showButton == true}">
							<button class="boton btn rounded-pill"
								onClick="location.href='/stories/update/${story.id}'">Editar</button>
							<button class="boton btn rounded-pill"
								onClick="location.href='/stories/delete/${story.id}'">Eliminar</button>
						</c:if>
<!-- ======= -->
				<div>
					<div class="d-flex flex-wrap">
						<h5 class="p-2 rounded-pill" style="background-color: #3e3e3e">Escritor</h5>
<!-- develop -->
					</div>

				<c:if
					test="${ showButton == true and !story.isSponsored and !isAdmin}">
					<div class="pago">
						<script>
								function post(path, params, method = 'post') {
									const form = document.createElement('form');
									form.method = method;
									form.action = path;
									for (const key in params) {
										if (params.hasOwnProperty(key)) {
											const hiddenField = document.createElement('input');
											hiddenField.type = 'hidden';
											hiddenField.name = key;
											hiddenField.value = params[key];
											form.appendChild(hiddenField);
										}
									}
									document.body.appendChild(form);
									form.submit();
								}
							</script>
						<script>
								paypal.Buttons({
									createOrder: function (data, actions) {
										return actions.order.create({
											purchase_units: [{
												amount: {
													currency: "EUR",
													value: "30"
												},
											}]
										});
									},
									onApprove: function (data, actions) {
										// This function captures the funds from the transaction.
										return actions.order.capture().then(function (details) {
											post("/pro/confirmedAdStory", { storyID: ${ story.id }, paymentDetails: details, ${ _csrf.parameterName }: "${_csrf.token}"})
									});
							    }
							  }).render('#paypal-button-ad-story');
						  </script>
						<h4>¡Publicita tu historia!</h4>
						<div class="d-flex justify-content-between">
							<p>Por tan solo 30&#8364 puedes hacer que tu historia pueda
								salir publicitada en el listado de historias y así conseguir más
								visibilidad.</p>
							<div id="paypal-button-ad-story"></div>
						</div>
<!--  HEAD -->

					</div>
				</c:if>
			</div>
		</div>


	</div>
<!-- ======= -->
						<p style="margin-left: 3%">${myWriter.user.username}</p>
					
					</div>
					</div>
				</div>
			</div>

			<div style="width: 50%; margin-left: 3%">
			<div style="display:flex">
			<div>
			<h2>Apoya la historia!!</h2>
			</div>
			<div>
			<video autoplay muted loop style="margin-left:10px;width:2vw;height:3vh;object-fit:cover" class= "rounded-circle"
			 src="https://github.com/ivan-desing-testing/CinemaParadisoGrupo-04/blob/feature/%23285-likestory-V2/src/main/webapp/WEB-INF/views/static/corazon%20latiendo.mp4?raw=true" 
			 type="video/mp4"></video>
			</div>
			</div>
			<br>
			<c:if test="${likes < 1}">
		    <h5>El primer amor no se olvida !!</h5>
		    </c:if>
		    <c:if test="${likes == 1}">
		    <h5>Ladrillo a ladrillo se construyó la Gran Muralla</h5>
		    </c:if>
		    <c:if test="${likes > 1}">
		    <h5>Usuarios que ya le han dado amor animate!!</h5>
		    </c:if>
		    <div style= "background-color: #af3248; margin-right: 50%">
			<h5 style="color:white; margin: 0% 0% 0% 50% ">${likes} </h5>
			</div>
			<br>
			<c:if test="${actualUserLiked}">
			<img  class= "rounded-circle" src="https://raw.githubusercontent.com/ivan-desing-testing/CinemaParadisoGrupo-04/feature/%23285-likesStory/src/main/webapp/WEB-INF/views/static/like.png" 
			onClick="location.href='/stories/notLike/${story.id}'"
								style="width: 10%; height: 10%; "> 
			</c:if>
			<c:if test="${!actualUserLiked}">
			<img  class= "rounded-circle" src="https://raw.githubusercontent.com/ivan-desing-testing/CinemaParadisoGrupo-04/feature/%23285-likestory-V2/src/main/webapp/WEB-INF/views/static/dislike.png" 
			onClick="location.href='/stories/like/${story.id}'"
								style="width: 8%; height: 8%; "> 
			</c:if>
		    </div>
<!-- develop -->

		</div>
	
			                 
					<div style="padding: 2% 0; width: 30%; margin-left: 5%">
						<h4 style="margin-bottom: 4%">Proyectos asociados a esta historia</h4>
						<c:forEach items="${myProjectsRel}" var="myProjects">
							<div class="d-flex align-items-center justify-content-evenly"
								style="height: 15vh; margin: 1% 0; cursor: pointer"
								onClick="location.href='/projects/show/${myProjects.id}'">
								<div style="width: 10vh; height: 10vh; overflow: hidden"
									class="rounded-circle">
									<img src="${myProjects.photo}"
										style="width: 100%; height: 100%; object-fit: cover">
								</div>
								<div style="margin-left: 12%">
									<h5>${myProjects.title}</h5>
									<p>${myProjects.genre}</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				</div>


	<div id="boton-up"
		onClick="location.href='/stories/show/${story.id}#top'">
		<span>^</span>
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>