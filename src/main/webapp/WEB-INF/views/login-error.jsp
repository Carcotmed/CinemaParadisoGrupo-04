<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="shorcut icon" type="image/ico"
	href="https://github.com/Carcotmed/CinemaParadisoGrupo-04/blob/feature/fix-general/src/main/webapp/WEB-INF/views/static/favicon.ico?raw=true" />
<title>Inicia sesi&oacuten</title>
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
	
	.login-wrap{
		width: 25%;
	}
	
	.login-form{
		width:80%;
	}
	
	.login-form > div{
		margin-top: 1rem;
	}
	
	h2,label{
		text-shadow: 0 0 4px black;
	}
	
	.error{
		background-color: var(--rojo);
		border-radius: 10px;
		padding: 1rem;
	}
	
	.error p{
		margin:0;
	}
	
	@media(max-width: 1160px) {
	
		.login-wrap{
			width: 80%;
		}
	
	}
	
</style>
<body class="padding-footer d-flex justify-content-center align-items-center">

	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	
	<div class="background-image"></div>
	
	<div class="padding-nav login-wrap d-flex flex-column justify-content-center align-items-center">

		<h2>Iniciar sesi&oacuten</h2>
		
		<div class="error">
			<p>Usuario o contrase&ntildea incorrectos</p>
		</div>
		
		<form:form class="login-form" action="/login" method="POST" modelAttribute="user">
			<div>
				<form:label class="form-control-label" path="username">Nombre de usuario</form:label>
				<form:input class="form-control" type="text" path="username"
					name="username" placeholder="Nombre usuario" />
			</div>

			<div>
				<form:label class="form-control-label" path="password">Contrase&ntildea</form:label>
				<form:input class="form-control" type="password" path="password"
					name="password" placeholder="Contraseña" />
			</div>

			<div class="d-flex justify-content-center">
				<form:button class="boton btn rounded-pill">Listo</form:button>
			</div>
		</form:form>
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>