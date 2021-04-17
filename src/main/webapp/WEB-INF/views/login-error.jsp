<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	<link rel="shorcut icon" type="image/ico" href="https://github.com/Carcotmed/CinemaParadisoGrupo-04/blob/feature/fix-general/src/main/webapp/WEB-INF/views/static/favicon.ico?raw=true" />
    <title>Inicia sesi&oacuten</title>
</head>
<body style="margin-top:20vh;background-color:#2b2b2b" class="d-flex justify-content-center align-items-center">
	<div  class="d-flex flex-column justify-content-center align-items-center" style="width:20%">
		
		<h2 style="color:white">Iniciar sesi&oacuten</h2>
		
		<form:form style="width:80%;" action="/login" method="POST" modelAttribute="user">
			<div style="border-radios:20px;background-color:#af3248;opacity:0.7" class="d-flex justify-content align-items-center">
				<p style="color:white">Usuario o contrase&ntildea incorrectos</p>
			</div>
			<div  style="margin-top:5%">
				<form:label class="form-control-label" style="color:white" path="username">Nombre de usuario</form:label>
				<form:input class="form-control" type="text" path="username" name="username" placeholder="Nombre usuario" />
			</div>
			
			<div  style="margin-top:5%">
				<form:label class="form-control-label" style="color:white" path="password">Contrase&ntildea</form:label>
				<form:input class="form-control" type="password"  path="password" name="password" placeholder="Contraseña" />
			</div>
			
			<div class="d-flex justify-content-center" style="margin-top:5%">
				<form:button class="btn rounded-pill" style="color:white;background-color: #af3248">Listo</form:button>
			</div>
		</form:form>		
	</div>
	<button onClick="location.href='/'" style="color:white; background-color:#af3248" class="btn rounded-pill">Volver</button>
	
		
	
	
	
	
</body>
</html>