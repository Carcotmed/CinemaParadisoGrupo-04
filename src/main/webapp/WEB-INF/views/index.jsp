<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
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
	    height: 100%;
	    align-items: center;
	    display: flex;
	    justify-content: center;
	}

</style>
<body>
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	

	<div class="video-wrapper">
		<video autoplay muted loop class="w-100 position-absolute"
		 src="https://github.com/Carcotmed/CinemaParadisoGrupo-04/blob/develop/src/main/webapp/WEB-INF/views/static/index-video.mp4?raw=true" 
		 type="video/mp4"></video>
		<div class="d-flex justify-content-center align-items-center" style="margin:auto">			
			<div class="d-flex flex-column justify-content-center align-items-center" style="z-index:2">
				<h1 class="text-center" style="color:white">Cinema Paradiso</h1>
				<h3 class="text-center" style="color:white">El material con el que se hacen los sueños</h3>
			</div>
		</div>
	</div>
	
	<div class="d-flex justify-content-center align-items-center position-relative w-100" style="background-color:#af3248; height:60%">
		<div class="d-flex justify-content-center align-items-center" style="margin:auto">
			<div style="width:30%;margin-right:2%">
				<h3 class="text-center" style="color:white">¿Qu&eacute es Cinema Paradiso?</h3>
			</div>
			<div style="width:30%">
				<p class="text-center"  style="color:white">Tu mejor opción para formar un equipo para realizar tus proyectos cinematogr&aacuteficos personales</p>
			</div>
		</div>
	</div>
	
	<div class="d-flex justify-content-center align-items-center position-relative w-100" style="background-color:#2b2b2b; height:60%">
		<div class="d-flex justify-content-center align-items-center" style="margin:auto">
			<div style="width:30%;margin-right:2%">
				<p class="text-center"  style="color:white">Encuentra a gente a tu alrededor para formar tu equipo sin necesidad de irte a la otra punta del mundo</p>
			</div>
			<div style="width:30%">
				<h3 class="text-center"  style="color:white">La cercan&iacutea es importante</h3>
			</div>
		</div>
	</div>
	
	<div class="d-flex justify-content-center align-items-center position-relative w-100" style="background-color:#af3248; height:60%">
		<div class="d-flex justify-content-center align-items-center" style="margin:auto">
			<div style="width:30%;margin-right:2%">
				<h3 class="text-center"  style="color:white">¿Eres mas de libros?</h3>
			</div>
			<div style="width:30%">
				<p class="text-center"  style="color:white">Aquí puedes encontrar a personas que hagan realidad tus historias para que dejen de ser solo historias</p>
			</div>
		</div>
	</div>
	
		<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
</body>
</html>