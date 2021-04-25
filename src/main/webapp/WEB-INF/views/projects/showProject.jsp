<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
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
</head>
<style>
		.background-image{
			z-index: -1;
		   background-image: url(https://www.indecsur.cl/wp-content/uploads/2020/03/272910-desk-laptop.jpg);
		   width: 110%;
		   position: absolute;
		   height: 100%;
		   filter: blur(5px);
		   background-size: cover;
		}
		
		.card-wrap{
			width: 80%;
			box-shadow: 0 0 10px black;
			border-radius: 20px;
			margin: auto;
		}
		
		.ficha-tecnica{
			position: relative;
			overflow: hidden;
			display: flex;
			justify-content: flex-end;	
		}
		
		.integrantes{
			margin: 1.5rem auto;
			padding: 1.5rem;
			background-color: var(--gris);
		}
		
		.card-wrap .element-wrapper:hover{
			background-color: var(--gris-claro);
		}
		
		.integrantes h4{
			text-align: center;
		}
		
		.ficha-tecnica > div{
			padding: 1.5rem;
			position: absolute;
			background: linear-gradient(90deg, var(--gris) 0%, var(--gris) 65%, transparent 100%);
			width: 100%;
			height: 100%;
			overflow-y:scroll;
		}
		
		.ficha-tecnica > div > div{
			margin-bottom: 1rem;
		}
		
		.ficha-tecnica img{
			object-fit: cover;
		}
		
		.lista{
			display: grid;
 			 grid-template-columns: repeat(5, 15rem);
		}
		
		.adminP:hover{
			background-color: var(--rojo) !important;
		}
		
		.pago{
			width:35%;
		}
		
		.pago h4{
			margin-bottom: 1rem;
		}
		
					
		@media(max-width: 1545px) {
			.lista{
			 	grid-template-columns: repeat(4, 13rem);

			}
	
		}
		
		
		@media(max-width: 1160px) {
			
			.background-image{
				width: 100%;
			}
			

			
		}
				
		
</style>
<script src="https://www.paypal.com/sdk/js?client-id=AXbp0NhXvchBXWtbvtRNBvVdch6cABb0d7084I04WtigxqKbiVA6WPNIJFwzLyXd-0el451LDtbOEwI2&currency=EUR"></script>			
<body>
	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>
	<div class="background-image"></div>
	<div class="padding-nav padding-footer">
		<div class="card-wrap ficha-tecnica">
			<div>
				<div>
					<h4>T&iacutetulo</h4>
					<span>${project.title}</span>
				</div>
				<div>
					<h4>G&eacutenero</h4>
					<span>${project.genre}</span>
				</div>
				<div style="width: 65%">
					<h4>Resumen</h4>
					<span>${project.description}</span>
				</div>
				
				<c:if test="${ story!= null}">
					<div>
						<h4>Historia asociada</h4>
						<div class="d-flex flex-wrap justify-content-between">
							<img src="https://www.psicoactiva.com/wp-content/uploads/puzzleclopedia/Libros-codificados-300x262.jpg">
							<p style="margin-left: 3%">${story.title}</p>
						</div>
					</div>
				</c:if>
				
				<div class="acciones">
					<c:if test="${ isAdminProject == true  || isAdmin}">
						<button class="boton btn rounded-pill" onclick="location.href='/projects/update/${project.id}'">Editar</button>
					</c:if>
					
					<c:if test="${pertenece}">
						<button class="boton btn rounded-pill"  onClick="location.href='/projects/delete/${project.id}'">Salir del proyecto</button>
					</c:if>
					
					<c:if test="${isAdmin || isAdminProject}">
						<button class="boton btn rounded-pill" onClick="location.href='/projects/deleteAll/${project.id}'">Eliminar</button>
					</c:if>
					
					<c:if test="${ !noPuedeP}">
						<c:if test="${ (!perteneceP) && (!requestexistP) }">
							<button class="boton btn rounded-pill" onclick="location.href='/projects/joinProducer/${project.id}'">Unirse</button>
						</c:if>
						<c:if test="${perteneceP}">
							<button class="boton btn rounded-pill"  onClick="location.href='/projects/delete/${project.id}'">Salir del proyecto</button>
						</c:if>
					</c:if>
					
					<c:if test="${ !noPuede || isAdmin}">
						<c:if test="${ (!pertenece) && (!requestexist) && !isAdmin }">
							<button class="boton btn rounded-pill" onclick="location.href='/projects/joinArtist/${project.id}'">Unirse</button>
						</c:if>
					</c:if>
				</div>
				
				<c:if test="${ isAdminProject == true }">
					<c:if test="${ !project.isSponsored and !isAdmin }">
						<div class="pago">
							<script>
							    function post(path, params, method='post') {
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
								    createOrder: function(data, actions) {
								    	return actions.order.create({
									        purchase_units: [{
									          amount: {
									        	currency: "EUR",
									            value: "30"
									          },
									        }]
									      });
								    },
								    onApprove: function(data, actions) {
								      return actions.order.capture().then(function(details) {
								    	  post("/pro/confirmedAd", {projectID:${project.id}, paymentDetails: details, ${_csrf.parameterName}:"${_csrf.token}"})
								      });
								    }
								  }).render('#paypal-button-ad');
							  </script>
								<h4>¡Publicita tu proyecto! (30&#8364)</h4>
								<p>TODO poner info y arreglar index paypal</p>
								<div id="paypal-button-ad" style="z-index:1"></div>
						</div>
					</c:if>
				</c:if>
				
			</div>
			<img src="${project.photo}">
		</div>
		
		
		<div class="card-wrap integrantes">
			<h4>Integrantes - Artistas</h4>
			<div class="lista">
				<c:forEach items="${members}" var="member">
					<div class="element-wrapper ${member.pro?'element-pro':''} ${isAdminProject?'adminP':''} d-flex flex-column align-items-center justify-content-evenly" 
					onClick="location.href='/artists/show/${ member.id }'">
						<img class="rounded-circle" src="${member.photo}">
		      			<h5>${member.name}</h5>
	  				    <p>${member.role}</p>  			
		      		</div>
  				</c:forEach>
			</div>
			<c:if test="${producers.size() != 0}">
				<h4>Integrantes - Productoras</h4>
				<div class="lista">
					<c:forEach items="${producers}" var="producer">
						<div class="element-wrapper d-flex flex-column align-items-center justify-content-evenly" onClick="location.href='/producers/show/${ producer.id }'">
							<img class="rounded-circle" src="${producer.photo}">
			      			<h5>${producer.name}</h5>
		  				    <p>Productor</p>  			
			      		</div>
	  				</c:forEach>
				</div>
			</c:if>
		</div>
	</div>
	
	
	
	
	
	
	<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
	
</body>
</html>
