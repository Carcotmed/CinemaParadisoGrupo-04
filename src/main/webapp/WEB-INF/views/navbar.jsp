
<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<style>

	body{
		min-height: 100vh;
		background-color:#af3248;
		position: relative;
	}
	
	.menu-nav{
		display: none;
	}
	
	.boton{
		color:white;
		border: 3px solid #af3248;
		margin: 0 0.5rem;
	  	transform: scale(1);
	    transition: 0.3s ease;
	}
	
	.boton:hover{
		background-color:#af3248;
		color:white;
		text-weight: bold;
		transform: scale(1.1);
	}
	
	.pro{
		border-color:#e8c71a;
		color:white;
	}
	
	.pro:hover{
		background-color:#e8c71a;
		color:black;
	}
	
	li,p,h1,h2,h3,h4,h5,h6,span,button{
		color:white;
	}
	
	#nav{
		transition: 0.5s;
	}
	
	.fondo{
		background-color: #232323;
	}
	
	@media(max-width: 1160px) {
		.menu-list > ul{
			list-style-type: none;
		    padding: 0;
		    margin: 0;
		    position: absolute;
		    background-color: #232323;
		    width: 10rem;
		    text-align: center;
		    right: 0;
	        margin-top: 1.3rem;
		}
		
		.menu-list > * > li{
			padding: 1rem 0;
		}
		
		.pro{
			background-color:#e8c71a;
			color: black;
			font-weight: bold;
		}
		
		.menu-nav{
			display:block;
		}
		
		.menu-long{
			display:none !important;
		}
		
		.menu-list{
			display:none;
		}
		
		nav{
			background-color: #232323;
		}
		
		#logout{
			background-color: #af3248;
		}
		
		#menu-b{
			padding: 5%;
		    width: 3rem;
		    height: 3rem;
		    filter: invert(1);
		}
	
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"	type="text/javascript"></script>
<script>
	
	
	$(document).ready(function () {
		document.getElementById("menu-list").style.display = "none";
	});
	
	function toggleMobileMenu() {
		var menu = document.getElementById("menu-list");

		if(menu.style.display === "none"){
			menu.style.display = "block";
		}else{
			menu.style.display = "none"
		}
	}
	
	$(window).scroll(function () {
	    var nav = document.getElementById("nav");

	    if($(window).scrollTop()){
	    	nav.classList.add("fondo");
	    }else{
	    	nav.classList.remove("fondo");
	    }
		
	})
	
</script>
<nav id="nav" style="padding: 0.5rem 1rem; z-index: 99; top: 0"
	class="position-fixed d-flex justify-content-between align-items-center w-100">
	
	<div class="d-flex align-items-center"
		style="cursor: pointer; width: 20%" onClick="location.href='/'">
		<img src="https://image.flaticon.com/icons/png/512/96/96595.png"
			style="cursor: pointer; width: 5rem; filter: invert(1)">
		<h4 style="color: white; margin-left: 1rem">Cinema Paradiso</h4>
	</div>

	<!-- Menu movil -->
	<div class="menu-nav">
		<img src="https://image.flaticon.com/icons/png/512/96/96595.png" id="menu-b" onClick="toggleMobileMenu()" />
		
		<div id="menu-list">
			<ul class="nav-ul">
				<li onClick="location.href='/stories/list'">Historias</li>
				<li onClick="location.href='/writers/list'">Escritores</li>
				<li onClick="location.href='/artists/list'">Artistas</li>
				<li onClick="location.href='/projects/list'">Proyectos</li>
				<li onClick="location.href='/producers/list'">Productoras</li>
				<sec:authorize access="isAuthenticated()">
					<li onClick="location.href='/messages/list'">Mensajes</li>
				</sec:authorize>
				<li class="pro" onClick="location.href='/pro'">PRO</li>
				<sec:authorize access="!isAuthenticated()">
					<li onClick="location.href='/login'">Iniciar sesi&oacuten</li>
					<li onClick="location.href='/users/select'">Registrarse</li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li onClick="location.href='/users/miPerfil'">Perfil</li>
					<li id="logout" onClick="location.href='/logoutsecure'">Salir</li>
				</sec:authorize>
				
			</ul>
		</div>
	</div>
	
	<!-- Botones -->
	<div class="menu-long d-flex justify-content-center align-items-center"
		style="width: fit-content">
		<button class="boton btn rounded-pill"
			onClick="location.href='/stories/list'">Historias</button>
		<button class="boton btn rounded-pill"
			onClick="location.href='/writers/list'">Escritores</button>
		<button class="boton btn rounded-pill"
			onClick="location.href='/artists/list'">Artistas</button>
		<button class="boton btn rounded-pill"
			onClick="location.href='/projects/list'">Proyectos</button>
		<button class="boton btn rounded-pill"
			onClick="location.href='/producers/list'">Productoras</button>

		<sec:authorize access="isAuthenticated()">
			<button class="boton btn rounded-pill"
				onClick="location.href='/messages/listReceived'">Mensajes</button>
		</sec:authorize>
		<button class="boton pro btn rounded-pill"
			onClick="location.href='/pro'">
			<strong>PRO</strong>
		</button>
	</div>
	
	<!-- User menu -->
	<div style="width: fit-content;"
		class="menu-long d-flex justify-content-between align-items-center">
		<sec:authorize access="!isAuthenticated()">
			<button onClick="location.href='/login'"
				class="boton btn rounded-pill">Inicia sesi&oacuten</button>
			<button onClick="location.href='/users/select'"
				class="boton btn rounded-pill">Registrate</button>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<button onClick="location.href='/users/miPerfil'"
				class="boton btn rounded-pill">Perfil</button>
			<button onClick="location.href='/logoutsecure'"
				class="boton btn rounded-pill">Salir</button>
		</sec:authorize>

	</div>
</nav>
</html>