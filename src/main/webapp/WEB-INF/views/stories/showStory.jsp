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
		</div>

		<div id="infoCard" class="card-wrap ficha-tecnica">
			<img
				src="https://www.psicoactiva.com/wp-content/uploads/puzzleclopedia/Libros-codificados-300x262.jpg">

			<div>
				<div>
					<h4>T&iacutetulo</h4>
					<span>${story.title}</span>
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
					</div>
				</c:if>
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