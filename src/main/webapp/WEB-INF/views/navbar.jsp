
<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<style>

	:root{
		--rojo: #af3248;
		--gris-oscuro: #232323;
		--gris: #2b2b2b;
		--gris-claro: #3e3e3e;
		--amarillo: #e8c71a;
	}

	body{
		min-height: 100vh;
		background-color: var(--gris-oscuro);
		position: relative;
		overflow-x: hidden;
	}
	
	.menu-nav{
		display: none;
	}
	
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
	
	.pro{
		border-color:var(--amarillo);
		color:white;
	}
	
	.pro:hover{
		background-color:var(--amarillo);
		color:black;
	}
	
	li,p,h1,h2,h3,h4,h5,h6,span,button,label{
		color:white;
	}
	
	#nav{
		transition: 0.5s;
	}
	
	.fondo{
		background-color: var(--gris-oscuro);
	}
	
	.padding-nav{
		padding-top: 7rem;
	}
	
	.linea-hor{
		border-width: 3px;
		border-style: solid;
		border-radius: 20px;
	}
	
	.element-wrapper{
		border-radius: 20px;
		transition: 0.3s;
		cursor:pointer;
		margin: 1rem;
		padding: 1rem;
	}
	
	.element-wrapper:hover{
		background-color: var(--gris);
		transform: scale(1.1);
		box-shadow: 0 0 10px black;
	}
	
	.element-wrapper img{
		height:7rem;
		width:7rem;
	}
	
	::-webkit-scrollbar {
	  width: 12px;
	  transition: 0.3s;
	}
	
	::-webkit-scrollbar-thumb {
	  background: var(--rojo);
	  border-radius: 20px;
	  transition: 0.3s;
	}

	::-webkit-scrollbar-thumb:hover {
	  background-color: #8a2f3f;
	}
	
	#boton-up{
		display:none;
	}
	
	@media(max-width: 1160px) {
		#menu-list > ul{
			list-style-type: none;
		    padding: 0;
		    margin: 0;
		    position: absolute;
		    background-color: var(--gris-oscuro);
		    width: 10rem;
		    text-align: center;
		    right: 0;
	        margin-top: 1.3rem;
		}
		
		#menu-list > * > li{
			padding: 1rem 0;
		}
		
		.pro{
			background-color:var(--amarillo);
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
			background-color: var(--gris-oscuro);
		}
		
		#logout{
			background-color: var(--rojo);
		}
		
		#menu-b{
			padding: 5%;
		    width: 3rem;
		    height: 3rem;
		    filter: invert(1);
		}
		
		nav h4 {
			display:none;
		}
		
		.padding-nav{
			padding-top: 8rem;
		}
		
		.element-wrapper{
			margin: 0;
			padding: 1rem;
		}
		
		#boton-up{
		    border-radius: 100%;
		    background-color: var(--gris);
		    justify-content: center;
		    align-items: center;
		    position: sticky;
		    bottom: 1rem;
		    left: 80%;
		    width: 4rem;
		    height: 4rem;
		    font-size: 2.5rem;
		    z-index: 99;
	        box-shadow: 0 0 10px rgb(0,0,0,40%);
		}
		
		.button-up-show{
			display: flex !important;
		}
		
		.hide{
			display: none;
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
	    var botonUp = document.getElementById("boton-up");

	    if($(window).scrollTop()){
	    	nav.classList.add("fondo");

	    }else{
	    	nav.classList.remove("fondo");
	    }
	    
	    if($(window).scrollTop() > 400 && $(window).width() <= 1160){
	    	botonUp.style.display = "flex";

	    }else{
	    	botonUp.style.display = "none";

	    }

		
	})
	
</script>
<head>
<title>Cinema Paradiso</title>
</head>
<nav id="nav" style="padding: 0.5rem 1rem; z-index: 99; top: 0"
	class="position-fixed d-flex justify-content-between align-items-center w-100">
	
	<div class="d-flex align-items-center"
		style="cursor: pointer; width: 20%" onClick="location.href='/'">
		<img src="https://image.flaticon.com/icons/png/512/96/96595.png"
			style="cursor: pointer; width: 5rem; filter: invert(1)">
		<h4 style="margin:0;margin-left: 1rem">Cinema Paradiso</h4>
	</div>

	<!-- Menu movil -->
	<div class="menu-nav">
		<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Hamburger_icon.svg/1200px-Hamburger_icon.svg.png" id="menu-b" onClick="toggleMobileMenu()" />
		
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