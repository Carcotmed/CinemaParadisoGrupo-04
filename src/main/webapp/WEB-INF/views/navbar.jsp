<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
	<div style="padding:0.5%;background-color:#2b2b2b;z-index:99;top:0" class="position-sticky d-flex justify-content-between align-items-center w-100">
		<div class="d-flex align-items-center" style="cursor:pointer; width:20%" onClick="location.href='/'">
			<img src="https://image.flaticon.com/icons/png/512/96/96595.png" style="cursor:pointer;width:30%;margin-left:1%;filter:invert(1)">
			<h4 style="color:white; margin-left: 1rem">Cinema Paradiso</h4>
		</div>

		<!-- Botones -->
		<div class="d-flex justify-content-center align-items-center" style="width:50%">
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/stories/list'">Historias</button>
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/writers/list'">Escritores</button>
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/artists/list'">Artistas</button>
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/projects/list'">Proyectos</button>
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/producers/list'">Productoras</button>

			<sec:authorize access="isAuthenticated()">
				<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/messages/listReceived'">Mensajes</button>
			</sec:authorize>
			<button class="btn rounded-pill" style="color:white;background-color:#e8c71a;margin:0 1%;color:black"><strong>PRO</strong></button>
		</div>
		<!-- User menu -->
		<div style="width: 15%;margin-right:1%" class="d-flex justify-content-between align-items-center">
			<sec:authorize access="!isAuthenticated()">
				<button onClick="location.href='/login'" style="color:white;background-color:#af3248" class="btn rounded-pill">Inicia sesi&oacuten</button>
				<button onClick="location.href='/users/select'" style="color:white;background-color:#af3248" class="btn rounded-pill">Registrate</button>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<button onClick="location.href='/users/miPerfil'" style="margin: 0 5%;color:white; background-color:#af3248" class="btn rounded-pill">Mi perfil</button>
				<button onClick="location.href='/logout'" style="margin: 0 5%;color:white; background-color:#af3248" class="btn rounded-pill">Cerrar sesi&oacuten</button>
			</sec:authorize>
			
		</div>
	</div>
</html>