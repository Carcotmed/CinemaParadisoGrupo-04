<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
	<div style="padding:0.5%;background-color:#2b2b2b;z-index:99;top:0" class="position-sticky d-flex justify-content-between align-items-center w-100">
		<div class="d-flex align-items-center" style="cursor:pointer; width:20%" onClick="location.href='/'">
			<img src="https://image.flaticon.com/icons/png/512/96/96595.png" style="cursor:pointer;width:30%;margin-left:1%;filter:invert(1)">
			<h4 style="color:white; margin-left: 1rem">Cinema Paradiso</h4>
		</div>

		<!-- Botones -->
		<div class="d-flex justify-content-center align-items-center" style="width:100%">
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/stories/list'">Historias</button>
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/writers/list'">Escritores</button>
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/artists/list'">Artistas</button>
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/projects/list'">Proyectos</button>
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/producers/list'">Productoras</button>
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/messages/list'">Mensajes</button>
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/projects/userList'">Mis Proyectos</button>
			<button class="btn rounded-pill" style="color:white;background-color:#e8c71a;margin:0 1%;color:black" onClick="location.href='/pro'"><strong>PRO</strong></button>
		</div>
		<!-- User menu -->
		<div style="width: 13%;margin-right:1%" class="d-flex justify-content-end align-items-center">
			<!-- Imagen lleva a perfil del user, se necesita en el modelo? -->
			<img src="https://via.placeholder.com/150" onClick="location.href='/messages/list/${user.id}'" class="rounded-circle" style="cursor:pointer;width:10px">
			<h5 style="margin: 0 5%;color:white;">${user.name}Hardcoded</h5>
			<img src="https://via.placeholder.com/150" onClick="location.href='/users/show/${user.id}'" class="rounded-circle" style="cursor:pointer;width:50px;">
		</div>
	</div>
</html>