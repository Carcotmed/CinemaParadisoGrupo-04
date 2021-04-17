<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<title>Story</title>
</head>
<body class="h-100" style="background-color: #272727; color: white">
	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>

	<!-- Header Historia -->
	<div class="d-flex justify-content-between p-3" style="height:15%">
			<div class="d-flex align-items-center" style="width:50%">
				<div  class="rounded-circle d-flex" style="overflow:hidden;height:100%;width:12vh">
					<img src="https://www.psicoactiva.com/wp-content/uploads/puzzleclopedia/Libros-codificados-300x262.jpg" style="width:100%;height:100%;object-fit:cover">			
				</div>
				<div class="py-3 mx-3" style="width:40%">
					<h2>${story.title}</h2>
				</div>
			</div>
			<c:choose>
				<c:when test="${showButton == false}">
					<button class="btn rounded-pill" onClick="location.href='/messages/create/${writerUsername}'" style="color:white;height: fit-content;background-color: #af3248">Contactar con el escritor</button>
				</c:when>
				<c:when test="${showButton == true}">
					<button class="btn rounded-pill" onClick="location.href='/stories/update/${story.id}'" style="color:white;height: fit-content;background-color: #af3248">Actualizar</button>
				
				<c:if test="${!story.isSponsored}">
				<!-- PAYPAL -->
				
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
						    	  post("/pro/confirmedAdStory", {storyID:${story.id}, paymentDetails: details, ${_csrf.parameterName}:"${_csrf.token}"})
						      });
						    }
						  }).render('#paypal-button-ad-story');
						  //This function displays Smart Payment Buttons on your web page.
					  </script>
					
					<div id="paypal-button-ad-story"></div>
				
				<!-- END PAYPAL -->
				</c:if>
				
				</c:when>
			</c:choose>
	</div>
	<!-- Info general Historia -->
	<div>
		<div class="container-fluid" style="background-color:#4c4c4c; padding:1%">
			<h3 style="margin:0">Ficha técnica</h3>
		</div>
		
		<div class="d-flex justify-content-between" style="padding: 2% 5%;">
			<!-- Datos -->
			<div style="width:150%">
				<div style="margin:1% 0">
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Título</h5>
					</div>
					<p style="margin-left: 3%">${story.title}</p>
				</div>
				<div style="margin:1% 0">
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Género</h5>
					</div>
					<p style="margin-left: 3%">${story.genre}</p>
				</div>
				<div>
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Descripción</h5>
					</div>
					<p style="margin-left: 3%">${story.body}</p>
				</div>
								<div>
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color:#3e3e3e">Writer</h5>
					</div>
					<p style="margin-left: 3%">${myWriter.user.username}</p>
					<div style="width:20vh;height:20vh;overflow:hidden" class="rounded-circle">
					<img src="${myWriter.photo}" onClick="location.href='/writers/show/${myWriter.id}'" style="width:100%;height:100%;object-fit:cover">
					</div>
				</div>
			</div>
			
		</div>
	</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
	
</body>
</html>