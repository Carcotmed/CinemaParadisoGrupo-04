<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

<title>Products</title>
</head>
<body>

	<script
		src="https://www.paypal.com/sdk/js?client-id=AXbp0NhXvchBXWtbvtRNBvVdch6cABb0d7084I04WtigxqKbiVA6WPNIJFwzLyXd-0el451LDtbOEwI2"> // Required. Replace YOUR_CLIENT_ID with your sandbox client ID.
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

	<div>
		<h1>UN SOLO PROYECTO (3 napos)</h1>
		<div id="paypal-button-project"></div>
	</div>
	<div>
		<h1>PRO (15 napos)</h1>
		<div id="paypal-button-pro"></div>
	</div>

	<script>
	paypal.Buttons({
	    createOrder: function(data, actions) {
	      // This function sets up the details of the transaction, including the amount and line item details.
	      return actions.order.create({
	        purchase_units: [{
	          amount: {
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





</body>
</html>