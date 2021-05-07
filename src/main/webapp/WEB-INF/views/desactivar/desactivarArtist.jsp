<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>

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
	
	.login-wrap > div{
		margin: 2rem 0;
		width: 15rem;
	}
		
	h2,label{
		text-shadow: 0 0 4px black;
		text-align: center;
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
	
	<div class="login-wrap padding-nav d-flex flex-column justify-content-center align-items-center">

		<h2>¿Est&aacutes seguro de que quieres desactivar la cuenta?</h2>
		<div class="d-flex justify-content-between align-items-between">
		
			<button onClick="location.href='/artists/show/${artistId}'"
				class="boton btn rounded-pill">Volver</button>
			<button onClick="location.href='/artists/delete/${artistId}'"
				class="boton btn rounded-pill">Desactivar</button>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>