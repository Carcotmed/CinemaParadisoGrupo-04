<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

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
<script
		src="https://www.paypal.com/sdk/js?client-id=AXbp0NhXvchBXWtbvtRNBvVdch6cABb0d7084I04WtigxqKbiVA6WPNIJFwzLyXd-0el451LDtbOEwI2&currency=EUR"> // Required. Replace YOUR_CLIENT_ID with your sandbox client ID.
</script>
</head>
<style>
	.background-image{
		z-index: -1;
	   background-image: url(https://hardfun.cl/inicio/wp-content/uploads/2018/02/Lets-Film.jpg);
	   width: 100%;
	   position: absolute;
	   height: 100%;
	   filter: blur(5px);
	}
	
	.wrapper{
		width: 80%;
		border-radius: 20px;
		box-shadow: 0 0 10px black;
		background-color: var(--gris);
		margin: 2rem 0;
		padding: 1rem;
	}
	
	.wrapper p {
		text-align: center;
		margin: 1rem 0;
	}
	
	.padding-nav{
	    display: flex;
	    justify-content: center;
	    align-items: center;
	}
	
	.pagos{
		display: flex;
		width: 100%;
		height: 100%;
	}
	
	.pagos > div{
		height: 100%;
		width: 50%;
		padding:2rem;
		display: flex;
		flex-direction: column;
		justify-content: space-between;
	}
	
	.pagos h3, .pagos p{
		text-align: center;
	}
	
	#paypal-button-project,  #paypal-button-pro{
		padding: 0 4rem;
	}
	
	#paypal-button-project{
		margin-top: 3rem;
	}
	
	.linea-hor{
		display: none;
	}
	
	@media(max-width: 1160px) {
		
		.padding-nav{
			padding-top: 6rem !important;
			height: unset;
		}
		
		.pagos, .pagos > div{
			display: block;
			width: unset;
			padding: 0.5rem;
		}
		
		#paypal-button-project,  #paypal-button-pro{
			padding:unset;
		}
		
		.linea-hor{
			background-color: var(--rojo);
			border-color: var(--rojo);
			display: block;
		}
		
		#paypal-button-project{
			margin-top: unset;
		}
	}
	
</style>
<body>

	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>
	<div class="background-image"></div>
	

	<div class="padding-nav padding-footer">

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
		
		<div class="wrapper">
		
			<!-- COSAS DE ARTIST -->
			<sec:authorize access="hasAuthority('artist')">
			
				<div class="pagos"> 
					<div>
						<div>
							<h3>Un solo Proyecto (3&#8364)</h3>
							<p>A&ntildeade un proyecto extra al n&uacutemero de proyectos que puedes crear</p>
						</div>
						<div  id="paypal-button-project"></div>
					</div>
					
					<hr class="linea-hor">
					
					<div>
						<div>
							<h3>PRO (15&#8364)</h3>
							<p>A&ntildeade tres proyectos extra al n&uacutemero de proyectos que puedes crear y adem&aacutes convi&eacutertete en usuario PRO!
							Aparecer&aacutes arriba en el listado y aumentar&aacutes tu probabilidad de que te encuentren!</p>
						</div>
						<div id="paypal-button-pro"></div>
					</div>
					
					<hr class="linea-hor">
					
					 
				</div>
				<p>
			 		Si lo que buscas es anunciar uno de tus proyectos, utiliza el bot&oacuten "Anunciar" que encontrar&aacutes en los detalles de tu proyecto.
			 	</p>
			</sec:authorize>
	
			<!-- COSAS DE WRITER -->
			<sec:authorize access="hasAuthority('writer')">
				 	<p>
				 		Para anunciar una de tus historias, utiliza el bot&oacuten "Anunciar" que encontrar&aacutes en los detalles de tu historia.
				 	</p>
			</sec:authorize>
	
			<script>
			paypal.Buttons({
			    createOrder: function(data, actions) {
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
			      return actions.order.capture().then(function(details) {
			    	  post("/pro/confirmedProyect", {paymentDetails: details, ${_csrf.parameterName}:"${_csrf.token}"})
			      });
			    }
			  }).render('#paypal-button-project');
		  </script>
  
		  <script>
			paypal.Buttons({
			    createOrder: function(data, actions) {
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
			      return actions.order.capture().then(function(details) {
			    	  post("/pro/confirmedPro", {paymentDetails: details, ${_csrf.parameterName}:"${_csrf.token}"})
			      });
			    }
			  }).render('#paypal-button-pro');
		  </script>
		  
			<sec:authorize access="hasAuthority('producer')">
				 	<p>
				 		Lo sentimos, pero actualmente no disponemos de planes PRO para productoras.
				 	</p>
			</sec:authorize>		  

		</div>

	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>

</body>
</html>