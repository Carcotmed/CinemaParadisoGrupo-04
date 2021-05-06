<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shorcut icon" type="image/ico" href="https://github.com/Carcotmed/CinemaParadisoGrupo-04/blob/feature/fix-general/src/main/webapp/WEB-INF/views/static/favicon.ico?raw=true" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>
<style>

		.background-image{
			z-index: -1;
		   background-image: url(https://hardfun.cl/inicio/wp-content/uploads/2018/02/Lets-Film.jpg);
		   width: 100vw;
		   position: absolute;
		   height: 100vh;
		   filter: blur(5px);
		   background-size: cover;
		   transition: 0.5s;
		}
		
		.wrapper{
			box-shadow: 0 0 10px black;
			border-radius: 20px;
			position: relative;
			overflow: hidden;
			display: flex;
			justify-content: flex-end;
			transition: 0.3s;
			width: 20rem;
			height: 25rem;
			margin: 2rem;
		}
		
		.wrapper img{
			width: 20rem;
			height: 20rem;
		}
		
		.wrapper:hover .content{
			background-color: var(--rojo);
		}
		
		.wrapper:hover h4{
			font-size: 3rem;
			padding-bottom: 50%;
		}
		
		.content{
			padding: 1.5rem;
			position: absolute;
			background: linear-gradient(0deg, var(--gris) 0%, var(--gris) 50%,	transparent 100%);
			width: 100%;
			height: 100%;
			display: flex;
			justify-content: center;
			transition: 0.3s;
		}
		
		h4{
			height: fit-content;
	    	align-self: flex-end;
	    	transition: 0.3s;
		}
		
		.padding-nav{
			display: flex;
			align-items:center;
			justify-content: center;
		}

		@media(max-width: 1160px) {
			.background-image{
				width: 100%;
				height: 100%;
			}
			
			.padding-nav{
				display: block !important;
				padding-top: 6rem;
			}
			
			.wrapper{
				width: unset;
				height: 10rem;
			}
			
			.wrapper:hover h4{
				padding-bottom:10%;
			}
		}

</style>
<body>

	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>
	<script>
		$(document).ready(function () {
		    var fondo = document.getElementById("global");
		    var artist = document.getElementById("artista");
		    var writer = document.getElementById("escritor");
		    var producer = document.getElementById("productora");
		    
		    artist.addEventListener("mouseenter", function() {
		    	fondo.style.backgroundImage = "url(https://cdn.hipwallpaper.com/i/33/55/hreiP4.jpg)";
		    });
		   
		    writer.addEventListener("mouseenter", function() {
		    	fondo.style.backgroundImage = "url(https://www.teahub.io/photos/full/55-553913_photo-wallpaper-background-wallpaper-blur-book-book-background.jpg)";
		    });
		    
		   
		    producer.addEventListener("mouseenter", function() {
		    	fondo.style.backgroundImage = "url(https://images.wallpaperscraft.com/image/sound_recording_studio_music_166147_3840x2160.jpg)";
		    });
		    
		    
		  
		})

	</script>
	<div id="global" class="background-image"></div>

	<div class="padding-nav padding-footer">
		<div id="artista" class="wrapper" onClick="location.href='/artists/create'">
			<img src="https://cdn.hipwallpaper.com/i/33/55/hreiP4.jpg">
			<div class="content">
				<h4>Artista</h4>
			</div>
		</div>	
		
		<div id="escritor" class="wrapper" onClick="location.href='/writers/create'">
			<img src="https://www.teahub.io/photos/full/55-553913_photo-wallpaper-background-wallpaper-blur-book-book-background.jpg">
			<div class="content">
				<h4>Escritor</h4>
			</div>
		</div>	
		
		<div id="productora" class="wrapper" onClick="location.href='/producers/create'">
		<img src="https://images.wallpaperscraft.com/image/sound_recording_studio_music_166147_3840x2160.jpg">
			<div class="content">
				<h4>Productora</h4>
			</div>
		</div>		
	</div>
		
	<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
	
</body>
</html>
    