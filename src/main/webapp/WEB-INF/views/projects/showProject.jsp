<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html class="h-100">
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shorcut icon" type="image/ico" href="https://github.com/Carcotmed/CinemaParadisoGrupo-04/blob/feature/fix-general/src/main/webapp/WEB-INF/views/static/favicon.ico?raw=true" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<title>Project</title>
</head>
<body class="h-100" style="background-color: #272727; color: white">
	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>

	<!-- Header Proyecto -->
	<div class="d-flex justify-content-between p-3" style="height:15%">
			<div class="d-flex align-items-center" style="width:50%">
				<div  class="rounded-circle d-flex" style="overflow:hidden;height:100%;width:12vh">
					<img src="${project.photo}" style="width:100%;height:100%;object-fit:cover">			
				</div>
				<div class="py-3 mx-3" style="width:40%">
					<h2>${project.title}</h2>
				</div>
			</div>
			<c:if test="${ !noPuede || isAdmin}">
				<c:if test="${ (!pertenece) && (!requestexist) && !isAdmin }">
					<button class="btn rounded-pill" onclick="location.href='/projects/joinArtist/${project.id}'" style="color:white;height: fit-content;background-color: #af3248">Unirse al equipo</button>
				</c:if>
			</c:if>
			<c:if test="${ isAdminProject == true }">
				
				<c:if test="${ !project.isSponsored and !isAdmin }">
				
					<!-- BOTON PAYPAL ANUNCIAR -->
					
					<script
					src="https://www.paypal.com/sdk/js?client-id=AXbp0NhXvchBXWtbvtRNBvVdch6cABb0d7084I04WtigxqKbiVA6WPNIJFwzLyXd-0el451LDtbOEwI2&currency=EUR"> // Required. Replace YOUR_CLIENT_ID with your sandbox client ID.
					</script>
					
					<script>
				    function post(path, params, method='post') {
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
						      // This function captures the funds from the transaction.
						      return actions.order.capture().then(function(details) {
						    	  post("/pro/confirmedAd", {projectID:${project.id}, paymentDetails: details, ${_csrf.parameterName}:"${_csrf.token}"})
						      });
						    }
						  }).render('#paypal-button-ad');
						  //This function displays Smart Payment Buttons on your web page.
					  </script>
					<div>
						<p>¡Publicita tu proyecto! (30&#8364)</p>
					</div>
					<div id="paypal-button-ad" style="z-index:1"></div>
					
					<!-- Fin paypal -->
				
				</c:if>
			</c:if>
			
			<c:if test="${ isAdminProject == true  || isAdmin}">
				<button class="btn rounded-pill" onclick="location.href='/projects/update/${project.id}'" style="color:white;height: fit-content;background-color: ${isAdmin?'#8a4380':'#af3248'}">Actualizar</button>
			</c:if>
			<c:if test="${pertenece}">
				<button style="color:white;height: fit-content;background-color:#af3248" class="btn rounded-pill"  onClick="location.href='/projects/delete/${project.id}'">Salir del proyecto</button>
			</c:if>
			<c:if test="${isAdmin || isAdminProject}">
				<button style="color:white;height: fit-content;background-color:${isAdmin?'#8a4380':'#af3248'}" class="btn rounded-pill"  onClick="location.href='/projects/deleteAll/${project.id}'">Eliminar proyecto</button>
			</c:if>
			
			<c:if test="${ !noPuedeP}">
			<c:if test="${ (!perteneceP) && (!requestexistP) }">
				<button class="btn rounded-pill" onclick="location.href='/projects/joinProducer/${project.id}'" style="color:white;height: fit-content;background-color: #af3248">Unirse al equipo</button>
			</c:if>
			<c:if test="${perteneceP}">
				<button style="color:white;height: fit-content;background-color:#af3248" class="btn rounded-pill"  onClick="location.href='/projects/delete/${project.id}'">Salir del proyecto</button>
			</c:if>
			</c:if>
			
	</div>
	<!-- Info general Proyecto -->
	<div>
		<div class="container-fluid" style="background-color:#4c4c4c; padding:1%">
			<h3 style="margin:0">Ficha tecnica</h3>
		</div>
		
		<div class="d-flex justify-content-between" style="padding: 2% 5%;">
			<!-- Datos -->
			<div style="width:150%">
				<div style="margin:1% 0">
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Titulo</h5>
					</div>
					<p style="margin-left: 3%">${project.title}</p>
				</div>
				<div style="margin:1% 0">
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Genero</h5>
					</div>
					<p style="margin-left: 3%">${project.genre}</p>
				</div style="margin:1% 0">
				<div>
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Resumen</h5>
					</div>
					<p style="margin-left: 3%">${project.description}</p>
				</div>
				<c:if test="${ story!= null}">
					<div>
						<div class="d-flex flex-wrap ">
							<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Historia asociada</h5>
						</div>
						<p style="margin-left: 3%">${story.title}</p>
				    </div>
				</c:if>
			</div>
			
			<!-- Imagen - Video -->
			<div class="d-flex justify-content-center align-items-center" style="width:100vh">
				<img src="${project.photo}" style="max-height:100%; max-width:100%">
			</div>
		</div>
		
		<div class="container-fluid" style="background-color:#4c4c4c; padding:1%">
			<h3 style="margin:0">Integrantes</h3>
			<c:if test="${pertenece || perteneceP}"> 
			<h3 style="margin:0; max-height:100%;max-right:100%; margin:0 1% ;">Anuncios</h3>
			</c:if>
		</div>
			
		<div style="padding: 2% 0;width:30%;margin:auto">
			<c:forEach items="${members}" var="member">
				<div onclick="location.href='/artists/show/${ member.id }'"  class="d-flex align-items-center justify-content-evenly" style="cursor:pointer;height:15vh; margin: 1% 0">
					<div style="width:10vh;height:10vh;overflow:hidden" class="rounded-circle">
						<img src="${member.photo}" style="width:100%;height:100%;object-fit:cover"><!-- {member.img} -->
					</div>
					<div style="margin-left: 12%">
						<h5>${member.name}</h5>
						<p>${member.role}</p>
					</div>
				</div>
				<hr style="border-width: 3px;border-style: solid;border-radius: 20px;border-color:#e8c71a; width:60%; margin:1% auto">
			</c:forEach>
			<c:forEach items="${producers}" var="producer">
				<div onclick="location.href='/producers/show/${ producer.id }'" class="d-flex align-items-center justify-content-evenly" style="cursor:pointer;height:15vh; margin: 1% 0">
					<div style="width:10vh;height:10vh;overflow:hidden" class="rounded-circle">
						<img src="${producer.photo}" style="width:100%;height:100%;object-fit:cover"><!-- {member.img} -->
					</div>
					<div style="margin-left: 12%">
						<h5>${producer.name}</h5>
						<p>PRODUCTOR</p>
					</div>
				</div>
				<hr style="border-width: 3px;border-style: solid;border-radius: 20px;border-color:#e8c71a; width:60%; margin:1% auto">
			</c:forEach>
			<c:if test="${pertenece || perteneceP }">
			<div style="padding: 0% 2;width:30%;margin:auto">
			       <h5>ANUNCIOS</h5>
			<c:forEach items="${posts}" var="post">
			            <h5>${post.title}</h5>
						<p>${post.body}</p>
						<p>${post.date}</p>
			</c:forEach>
			<button  onclick="location.href='/posts/create/${project.id}'" class="btn rounded-pill" id="levantaModal"
					style="color: white; height: fit-content; background-color: #af3248">Crear anuncio</button>
			</div>
			</c:if>
		</div>

	</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
	
</body>
</html>
