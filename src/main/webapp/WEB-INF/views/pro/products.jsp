<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" class="h-100">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<title>Products</title>
<script
		src="https://www.paypal.com/sdk/js?client-id=AXbp0NhXvchBXWtbvtRNBvVdch6cABb0d7084I04WtigxqKbiVA6WPNIJFwzLyXd-0el451LDtbOEwI2&currency=EUR"> // Required. Replace YOUR_CLIENT_ID with your sandbox client ID.
</script>
</head>
<body class="position-relative">

	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>

<div class="p-4 d-flex flex-column justify-content-start align-items-center" style="width:100%;background-color: #3e3e3e">

<br>
<br>

	

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
		
	<!-- COSAS DE ARTIST -->
	<sec:authorize access="hasAuthority('artist')">
		<div class="d-flex justify-content-center align-items-center"> 
			<div style="width:46%;margin:2%" class="d-flex flex-column align-items-center">
				<h3 style="margin: 0.7vw; color:white" >Un solo Proyecto (3&#8364)</h3>
				<p style="color:white;text-align:center;font-size:1.2rem">A&ntildeade un proyecto extra al n&uacutemero de proyectos que puedes crear</p>
				<div  id="paypal-button-project"></div>
			</div>
			
			<div style="width:46%;margin:2%" class="d-flex flex-column align-items-center">
				<h3 style="margin: 0.7vw; color:white">PRO (15&#8364)</h3>
				<p style="color:white;text-align:center;font-size:1.2rem">°A&ntildeade tres proyectos extra al n&uacutemero de proyectos que puedes crear y adem&aacutes convi&eacutertete en usuario PRO!
				°Aparecer&aacutes arriba en el listado y aumentar&aacutes tu probabilidad de que te encuentren!</p>
				<div id="paypal-button-pro"></div>
			</div>
			<!-- TODO
			<div>
				<button class="btn rounded-pill" onClick="location.href='/patata'" style="color:white;height: fit-content;background-color: #af3248">
				Anunciar proyecto
				</button>
			</div>
			 -->
			 	
			 
		</div>
		<p style="color:white;text-align:center;font-size:1.2rem">
			 		Para anunciar uno de tus proyectos, utiliza el bot&oacuten "Anunciar" en los detalles de tu proyecto.
			 	</p>
	</sec:authorize>
	
	<!-- COSAS DE WRITER -->
	<sec:authorize access="hasAuthority('writer')">
		<!-- TODO
		<div> 
			<button class="btn rounded-pill" onClick="location.href='/patata'" style="color:white;height: fit-content;background-color: #af3248">
			Anunciar historia
			</button>
		</div>
		 -->
		 
		 <div>
		 	<p style="color:white">
		 		Para anunciar una de tus historias, utiliza el bot√≥n "Anunciar" en los detalles de tu historia.
		 	</p>
		 </div>
		 
	</sec:authorize>
	
	<script>
	paypal.Buttons({
	    createOrder: function(data, actions) {
	      // This function sets up the details of the transaction, including the amount and line item details.
	      return actions.order.create({
	        purchase_units: [{
	          amount: {
		        currency: 'EUR',
	            value: '3.00'
	          }
	        }]
	      });
	    },
	    onApprove: function(data, actions) {
	      // This function captures the funds from the transaction.
	      return actions.order.capture().then(function(details) {
	    	  post("/pro/confirmedProyect", {paymentDetails: details, ${_csrf.parameterName}:"${_csrf.token}"})
	      });
	    }
	  }).render('#paypal-button-project');
	  //This function displays Smart Payment Buttons on your web page.
  </script>
  
  <script>
	paypal.Buttons({
	    createOrder: function(data, actions) {
	      // This function sets up the details of the transaction, including the amount and line item details.
	      return actions.order.create({
	        purchase_units: [{
	          amount: {
	        	currency: 'EUR',
	            value: '15.00'
	          }
	        }]
	      });
	    },
	    onApprove: function(data, actions) {
	      // This function captures the funds from the transaction.
	      return actions.order.capture().then(function(details) {
	    	  post("/pro/confirmedPro", {paymentDetails: details, ${_csrf.parameterName}:"${_csrf.token}"})
	      });
	    }
	  }).render('#paypal-button-pro');
	  //This function displays Smart Payment Buttons on your web page.
  </script>

<br>
<br>
<br>

</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>

</body>
</html>