<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>


<html style="background-color: #3e3e3e">
<head>
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	<link rel="shorcut icon" type="image/ico" href="https://github.com/Carcotmed/CinemaParadisoGrupo-04/blob/feature/fix-general/src/main/webapp/WEB-INF/views/static/favicon.ico?raw=true" />
</head>
<style>
	
	.boton{
		color:white;
		border: 3px solid var(--rojo);
		margin: 0 0.5rem;
	  	transform: scale(1);
	    transition: 0.3s ease;
	    text-shadow: 0 0 4px black;
	}
	
	.boton:hover{
		background-color:var(--rojo);
		color:white;
		text-weight: bold;
		transform: scale(1.1);
		text-shadow: unset;
	}
	
	h1{
		text-align:center
	}
	
</style>
<body>
	<div class="d-flex flex-column justify-content-center align-items-center" style="background-color: #3e3e3e; height: 100vh">
		<h1 style="color:white">�Parece que no tienes los permisos necesarios!</h1>
		<button class="boton btn rounded-pill" onClick="location.href='/'" style="color:white;height: fit-content;background-color: #af3248">Volver al Inicio</button>
	</div>
</body>
</html>