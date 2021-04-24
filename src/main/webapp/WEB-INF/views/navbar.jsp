<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
	
<!DOCTYPE html>

<head>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
	<script>
	$(document).ready(function () {
		$.ajax({
		    type : "GET",
		    url : "/messages/check",
		    data : {
		    	"username": $("#usernameContainer").text()
		    },
		    success: function(data){
		    	if(data && data=="true"){
		    		$("#messagesButton").css("background-color", "#359106");
		    	}
		    }
		});
	});
	</script>
</head>

	<div style="padding:0.5%;background-color:#2b2b2b;z-index:99;top:0" class="position-sticky d-flex justify-content-between align-items-center w-100">
		<div class="d-flex align-items-center" style="cursor:pointer; width:20%" onClick="location.href='/'">
			<img src="https://image.flaticon.com/icons/png/512/96/96595.png" style="cursor:pointer;width:30%;margin-left:1%;filter:invert(1)">
			<h4 style="color:white; margin-left: 1rem">Cinema Paradiso</h4>
		</div>
		
		<style>
		
		.boton {
  color: #af3248 !important;
  font-size: 20px;
  font-weight: 500;
  padding: 0.5em 1.2em;
  background: #af3248;
  border: 2px solid;
  border-color: white;
  position: relative;
}
		.boton3 {
  color: white !important;
  font-size: 20px;
  font-weight: 500;
  padding: 0.5em 1.2em;
  background: #af3248;
  border: 2px solid;
  border-color: white;
  transition: all 1s ease;
  position: relative;
}
.boton3:hover {
  background: #2b2b2b;
  color: #af3248 !important;
}

.boton4 {
  color: #2b2b2b !important;
  font-size: 20px;
  font-weight: 500;
  padding: 0.5em 1.2em;
  background: #e8c71a;
  position: relative;
  border: 2px solid #318aac;
  outline: 1px solid;
  transition: all 1s cubic-bezier(0.19, 1, 0.22, 1);
}
.boton4:hover {
  box-shadow: inset 0 0 20px rgba(49, 138, 172, 0.5), 0 0 20px rgba(49, 138, 172, 0.4);
  outline-offset: 90px;
  outline-color: rgba(49, 138, 172, 0);
  text-shadow: 1px 1px 6px #fff;
  color: #af3248 !important;
  border-shadow: 
  
}

		</style>
		</head>
		<!-- Botones -->
		<div class="d-flex justify-content-center align-items-center" style="width:50%">
			<button class="btn rounded-pill boton boton3" style="margin:0 1%" onClick="location.href='/stories/list'">Historias</button>
			<button class="btn rounded-pill boton boton3" style="margin:0 1%" onClick="location.href='/writers/list'">Escritores</button>
			<button class="btn rounded-pill boton boton3" style="margin:0 1%" onClick="location.href='/artists/list'">Artistas</button>
			<button class="btn rounded-pill boton boton3" style="margin:0 1%" onClick="location.href='/projects/list'">Proyectos</button>
			<button class="btn rounded-pill boton boton3" style="margin:0 1%" onClick="location.href='/producers/list'">Productoras</button>
 			
			<sec:authorize access="isAuthenticated()">

				<button class="btn rounded-pill" id="messagesButton" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/messages/listReceived'">Mensajes</button>

			</sec:authorize>
			<button class="btn rounded-pill boton boton4" style="margin:0 1%" onClick="location.href='/pro'"><strong>PRO</strong></button>
		</div>
		<!-- User menu -->
		<p style="display: none;" id="usernameContainer"><sec:authentication property="name"/></p>
		<div style="width: 15%;margin-right:1%" class="d-flex justify-content-between align-items-center">
			<sec:authorize access="!isAuthenticated()">
				<button class="btn rounded-pill boton boton3" style="margin:0 1%" onClick="location.href='/login'" >Inicia sesi&oacuten</button>
				<button class="btn rounded-pill boton boton3" style="margin:0 1%" onClick="location.href='/users/select'" >Registrate</button>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<button onClick="location.href='/users/miPerfil'" style="margin: 0 6%" class="btn rounded-pill boton boton3">Mi perfil</button>
				<button onClick="location.href='/logoutsecure'" style="margin: 0 6%" class="btn rounded-pill boton boton3">Cerrar sesi&oacuten</button>
			</sec:authorize>
			
		</div>
	</div>
</html>