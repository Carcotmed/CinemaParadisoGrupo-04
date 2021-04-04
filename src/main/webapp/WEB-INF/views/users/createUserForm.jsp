<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nuevo Usuario</title>
</head>
<body>
    <form:form action = "/users/create"  modelAttribute="user" method = "post">
        <fieldset>
            <legend>Datos del usuario</legend>
            <table>
                <tr>
                    <td><form:label path="username">Usuario: </form:label></td>
                    <td><form:input type="text" path="username" /></td>
                </tr>
                <tr>
                    <td><form:label path="password">Clave: </form:label></td>
                    <td><form:input type="text" path="password" /></td>
                </tr>
                <tr>
                    <td><form:label path="email">Email: </form:label></td>
                    <td><form:input type="text" path="email" /></td>
                </tr>
                <td><form:label>Tipo de usuario: </form:label></td>
                <button onClick="<c:set var='tipoUser' value='artist'  /> "> Artista<br>
                <button onClick="<c:set var='tipoUser' value='producer'  /> "> Productor<br>
                <button onClick="<c:set var='tipoUser' value='writer'  /> "> Escritor<br>
                <tr>
                <c:choose>
					<c:when test="${tipoUser == artist}">
						<form:form action = "/artist/create"  modelAttribute="artist" method = "post">
						    <form:label path="name">Nombre: </form:label>
                            <form:input value="${artist.name}" placeholder="Nombre"  type="text" path="username" /><br>
						    <form:label path="username">Apellidos: </form:label>
                            <form:input value="${artist.surname}" type="text" placeholder="Apellidos" path="username" /><br>
						
						<form:select value="${artist.skills}" class="form-control" style="width:60%" path="skills">
								<form:option value="" selected="true">Selecciona una habilidad</form:option>
								<c:forEach items="${skills}" var="skills">
									<form:option value="${skills}">${skills}</form:option>
								</c:forEach>
							</form:select>
							<form:label path="description">Descripción: </form:label>
                            <form:input value="${artist.description}" type="text" placeholder="Cuenta algo de ti..." path="description" /><br>
                         <div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" style="background-color:#828282" path="photo">Url imagen</form:label>
							</div>
							<form:input class="form-control" value="${project.photo}" placeholder="url" style="margin-left: 3%;width:60%" type="text" path="photo"></form:input>
						</div>
						<form:select value="${artist.role}" class="form-control" style="width:60%" path="roles">
								<form:option value="" selected="true">Selecciona un rol</form:option>
								<c:forEach items="${role}" var="skills">
									<form:option value="${role}">${role}</form:option>
								</c:forEach>
							</form:select>
					<form:select value="${artist.roles}" class="form-control" style="width:60%" path="roles">
								<form:option value="" selected="true">Selecciona una habilidad</form:option>
								<c:forEach items="${skills}" var="skills">
									<form:option value="${skills}">${skills}</form:option>
								</c:forEach>
							</form:select>
							<form:label path="summary">Resumen: </form:label>
                            <form:input value="${artist.summary}" type="text" placeholder="Cuenta tu experiencia..." path="summary" /><br>
							</form:form>
					</c:when>
					<c:when test="${tipoUser == producer}">
					<form:form action = "/producer/create"  modelAttribute="producer" method = "post">
						<form:label path="name">Nombre: </form:label>
                            <form:input value="${producer.name}" placeholder="Nombre"  type="text" path="username" /><br>
						    <form:label path="username">Apellidos: </form:label>
                            <form:input value="${producer.surname}" type="text" placeholder="Apellidos" path="username" /><br>
						
						<form:select value="${producer.skills}" class="form-control" style="width:60%" path="skills">
								<form:option value="" selected="true">Selecciona una habilidad</form:option>
								<c:forEach items="${skills}" var="skills">
									<form:option value="${skills}">${skills}</form:option>
								</c:forEach>
							</form:select>
							<form:label path="description">Descripción: </form:label>
                            <form:input value="${producer.description}" type="text" placeholder="Cuenta algo de ti..." path="description" /><br>
                            <div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" style="background-color:#828282" path="photo">Url imagen</form:label>
							</div>
							<form:input class="form-control" value="${producer.photo}" placeholder="url" style="margin-left: 3%;width:60%" type="text" path="photo"></form:input>
						</div>
                            <form:label path="nif">NIF: </form:label>
                            <form:input value="${producer.nif}" placeholder="NIF"  type="text" path="nif" /><br>
                            </form:form>
					</c:when>
					<c:otherwise>
						<form:form action = "/writer/create"  modelAttribute="writer" method = "post">
						<form:label path="name">Nombre: </form:label>
                            <form:input value="${writer.name}" placeholder="Nombre"  type="text" path="username" /><br>
						    <form:label path="username">Apellidos: </form:label>
                            <form:input value="${writer.surname}" type="text" placeholder="Apellidos" path="username" /><br>
						
						<form:select value="${writer.skills}" class="form-control" style="width:60%" path="skills">
								<form:option value="" selected="true">Selecciona una habilidad</form:option>
								<c:forEach items="${skills}" var="skills">
									<form:option value="${skills}">${skills}</form:option>
								</c:forEach>
							</form:select>
							<form:label path="description">Descripción: </form:label>
                            <form:input value="${writer.description}" type="text" placeholder="Cuenta algo de ti..." path="description" /><br>
                            <div class="d-flex justify-content-between align-items-center" style="margin:1% 0">
							<div class="d-flex flex-wrap ">
								<form:label class="p-2 rounded-pill form-control-label" style="background-color:#828282" path="photo">Url imagen</form:label>
							</div>
							</div>
							<form:input class="form-control" value="${writer.photo}" placeholder="url" style="margin-left: 3%;width:60%" type="text" path="photo"></form:input>
							</form:form>
					</c:otherwise>
				</c:choose>
              </tr> 
              <tr>
                    <td>
                        <input type="submit" value="Registrarse"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form:form>
    
</body>
</html>