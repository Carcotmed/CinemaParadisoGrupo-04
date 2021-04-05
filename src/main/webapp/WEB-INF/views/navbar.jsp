<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
	<div style="height:7vh;background-color:#2b2b2b;z-index:99" class="position-fixed d-flex justify-content-between align-items-center w-100">
		<img src="https://via.placeholder.com/150" onClick="location.href='/'" class="rounded-circle" style="cursor:pointer;width:50px;margin-left:1%">
		<!-- Botones -->
		<div class="d-flex justify-content-center align-items-center" style="width:50%">
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/histories/list'">Historias</button>
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/artists/list'">Artistas</button>
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/projects/list'">Proyectos</button>
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/producers/list'">Productoras</button>
			<button class="btn rounded-pill" style="color:white;background-color:#af3248;margin:0 1%" onClick="location.href='/artists/myProjects'">Mis Proyectos</button>
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