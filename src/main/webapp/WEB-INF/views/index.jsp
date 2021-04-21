<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	<link rel="shorcut icon" type="image/ico" href="https://github.com/Carcotmed/CinemaParadisoGrupo-04/blob/feature/fix-general/src/main/webapp/WEB-INF/views/static/favicon.ico?raw=true" />
    <title>Cinema Paradiso</title>
</head>
<style>

	.video-wrapper{
	    height: 50vh;
	    align-items: center;
	    display: flex;
	    justify-content: center;
	}
	
	.div-inicio{
		height: 20rem;
	}
	
	#last-element{
		height:37rem;
	}
	
	.info-element{
		width:30%;
		margin: 0 1rem;
	}
	
	.div-inicio > div{
	    margin: 2rem 0;
	}
	
	@media(max-width: 1160px) {
	
		#last-element{
			height:52rem;
		}
		
		.info-element{
			width:50%;
			margin: 0 1rem;
		}
		
		.video-wrapper{
			padding-top: 7rem;
			height: 43vh;
		}
	}
	

</style>
<body>
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

	<div class="video-wrapper">
		<video autoplay muted loop class="w-100 position-absolute"
			src="https://github.com/Carcotmed/CinemaParadisoGrupo-04/blob/develop/src/main/webapp/WEB-INF/views/static/index-video.mp4?raw=true"
			type="video/mp4"></video>
		<div class="d-flex justify-content-center align-items-center">
			<div
				class="d-flex flex-column justify-content-center align-items-center"
				style="z-index: 2;padding:0 1rem">
				<h1 class="text-center" style="margin-bottom: 2rem;">Cinema Paradiso</h1>
				<h5 class="text-center">El material con el
					que se hacen los sueños</h5>
			</div>
		</div>
	</div>

	<div
		class="div-inicio d-flex justify-content-center align-items-center position-relative w-100"
		style="background-color: var(--rojo)">
		<div class="d-flex justify-content-center align-items-center">
			<div class="info-element">
				<h3 class="text-center" style="color: white">¿Qu&eacute es
					Cinema Paradiso?</h3>
			</div>
			<div class="info-element">
				<p class="text-center">Tu mejor opción para
					formar un equipo para realizar tus proyectos cinematogr&aacuteficos
					personales</p>
			</div>
		</div>
	</div>

	<div
		class="div-inicio d-flex justify-content-center align-items-center position-relative w-100"
		style="background-color: var(--gris)">
		<div class="d-flex justify-content-center align-items-center">
			<div class="info-element">
				<p class="text-center" >Encuentra a gente a
					tu alrededor para formar tu equipo sin necesidad de irte a la otra
					punta del mundo</p>
			</div>
			<div class="info-element">
				<h3 class="text-center">La cercan&iacutea
					es importante</h3>
			</div>
		</div>
	</div>

	<div
		class="padding-footer div-inicio d-flex justify-content-center align-items-center position-relative w-100"
		style="background-color: var(--rojo)" id="last-element">
		<div class="d-flex justify-content-center align-items-center">
			<div class="info-element">
				<h3 class="text-center">¿Eres mas de
					libros?</h3>
			</div>
			<div class="info-element">
				<p class="text-center">Aquí puedes
					encontrar a personas que hagan realidad tus historias para que
					dejen de ser solo historias</p>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>