<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<title>Crear productor</title>
</head>
<body class="h-100" style="background-color: #272727; color: white">
	<div class="d-flex justify-content-center align-items-center"
		style="padding: 2%">

		<!-- Info general Proyecto -->

		<div class="d-flex justify-content-between" style="width: 40%;">

			<form:form method="POST" action="" modelAttribute="producer"
				style="width:100%">
				<!--  USUARIO -->
				<c:if test="${isNew}">
				<div class="d-flex justify-content-between align-items-center"
					style="margin: 1% 0">
					<div class="d-flex flex-wrap ">
						<form:label class="p-2 rounded-pill form-control-label"
							style="background-color:#828282" path="user.username">Usuario</form:label>
					</div>
					<form:input class="form-control" value="${producer.user.username}"
						placeholder="Usuario" style="margin-left: 3%;width:60%"
						type="text" path="user.username"></form:input>
				</div>
				<form:errors style="color:red" path="user.username" />


				<div class="d-flex justify-content-between align-items-center"
					style="margin: 1% 0">
					<div class="d-flex flex-wrap ">
						<form:label class="p-2 rounded-pill form-control-label"
							style="background-color:#828282" path="user.password">Clave</form:label>
					</div>
					<form:input class="form-control" value="${producer.user.password}"
						placeholder="Clave" style="margin-left: 3%;width:60%"
						type="password" path="user.password"></form:input>
				</div>
				<form:errors style="color:red" path="user.password" />
				</c:if>


				<div class="d-flex justify-content-between align-items-center"
					style="margin: 1% 0">
					<div class="d-flex flex-wrap ">
						<form:label class="p-2 rounded-pill form-control-label"
							style="background-color:#828282" path="user.email">Email</form:label>
					</div>
					<form:input class="form-control" value="${producer.user.email}"
						placeholder="example@example.com"
						style="margin-left: 3%;width:60%" type="text" path="user.email"></form:input>
				</div>
				<form:errors style="color:red" path="user.email" />



				<!-- Datos -->
				<div>
					<div class="d-flex justify-content-between align-items-center"
						style="margin: 1% 0">
						<div class="d-flex flex-wrap ">
							<form:label class="p-2 rounded-pill form-control-label"
								style="background-color:#828282" path="name">Nombre</form:label>
						</div>
						<form:input class="form-control" value="${producer.name}"
							placeholder="Nombre" style="margin-left: 3%;width:60%"
							type="text" path="name"></form:input>
					</div>
					<form:errors style="color:red" path="name" />
					<div class="d-flex justify-content-between align-items-center"
						style="margin: 1% 0">
						<div class="d-flex flex-wrap ">
							<form:label class="p-2 rounded-pill form-control-label"
								style="background-color:#828282" path="surName">Apellidos</form:label>
						</div>
						<form:input class="form-control" value="${producer.surName}"
							placeholder="Apellidos" style="margin-left: 3%;width:60%"
							type="text" path="surName"></form:input>
					</div>
					<form:errors style="color:red" path="surName" />
					<div class="d-flex justify-content-between align-items-center"
						style="margin: 1% 0">
						<div class="d-flex flex-wrap ">
							<form:label class="p-2 rounded-pill form-control-label"
								path="skills" style="background-color:#828282">Habilidad</form:label>
						</div>
						<form:select value="${producer.skills}" class="form-control"
							style="width:60%" path="skills">
							<form:option value="" selected="true">Selecciona una habilidad</form:option>
							<c:forEach items="${skill}" var="skills">
								<form:option value="${skills}">${skills}</form:option>
							</c:forEach>
						</form:select>
					</div>
					<form:errors style="color:red" path="skills" />
					<div class="d-flex justify-content-between align-items-center"
						style="margin: 1% 0">
						<div class="d-flex flex-wrap ">
							<form:label class="p-2 rounded-pill form-control-label"
								style="background-color:#828282" path="description">Resumen</form:label>
						</div>
						<form:textarea class="form-control" value="${producer.description}"
							placeholder="Descripción" style="margin-left: 3%;width:60%"
							type="text" path="description"></form:textarea>
					</div>
					<form:errors style="color:red" path="description" />
					<div class="d-flex justify-content-between align-items-center"
						style="margin: 1% 0">
						<div class="d-flex flex-wrap ">
							<form:label class="p-2 rounded-pill form-control-label"
								style="background-color:#828282" path="photo">Url imagen</form:label>
						</div>
						<form:input class="form-control" value="${producer.photo}"
							placeholder="url" style="margin-left: 3%;width:60%" type="text"
							path="photo"></form:input>
					</div>
					<form:errors style="color:red" path="photo" />
					<div>
					<div class="d-flex justify-content-between align-items-center"
						style="margin: 1% 0">
						<div class="d-flex flex-wrap ">
							<form:label class="p-2 rounded-pill form-control-label"
								style="background-color:#828282" path="nif">NIF</form:label>
						</div>
						<form:input class="form-control" value="${producer.nif}"
							placeholder="Nombre" style="margin-left: 3%;width:60%"
							type="text" path="nif"></form:input>
					</div>
					<form:errors style="color:red" path="nif" />
					<div
						class="form-group d-flex justify-content-center align-items-center my-4">
						<form:button class="btn"
							style="color:white;background-color: #af3248">Guardar</form:button>
					</div>
				</div>

			</form:form>
    		<a class="btn btn-danger" onclick="location.href = '/producers/list'">Cancelar</a>
		</div>

	</div>
</body>
</html>