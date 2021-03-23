<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<title>Artist List</title>
</head>
<body class="h-100">
	<div class="d-flex h-100">

		<!--  Filtros -->
		<div class="px-3 w-25" style="background-color: pink">
			<form>
				<div class="form-group"></div>
			</form>
			<h3>Filtros</h3>
			</br>
			<form>
				<div class="form-group">
					<label class="form-control-label" for="name">Nombre:</label> <input
						class="form-control" type="text" value="" placeholder="Nombre"
						id="name">
				</div>
				<div class="form-group">
					<label>Rol:</label> <select class="form-control" id="role">
						<option>pinga</option>
						<c:forEach items="${roles}" var="role">
							<option value="${role}">${role}</option>
						</c:forEach>
					</select>
				</div>

				<legend class="form-check-label">Experiencia:</legend>
				<div class="form-check form-check-inline">
					<label class="form-check-label">1</label> <input
						class="form-check-input" type="checkbox" value="1" id="exp1">
				</div>
				<div class="form-check form-check-inline">
					<label class="form-check-label">2</label> <input
						class="form-check-input" type="checkbox" value="2" id="exp2">
				</div>
				<div class="form-check form-check-inline">
					<label class="form-check-label">3</label> <input
						class="form-check-input" type="checkbox" value="3" id="exp3">
				</div>
				<div class="form-check form-check-inline">
					<label class="form-check-label">4</label> <input
						class="form-check-input" type="checkbox" value="4" id="exp4">
				</div>
				<div class="form-check form-check-inline">
					<label class="form-check-label">5</label> <input
						class="form-check-input" type="checkbox" value="5" id="exp5">
				</div>

				<div>
					<legend class="col-form-label"> Disponibilidad:</legend>
					<div class="d-flex flex-column">
						<div class="form-group">
							<label><input type="checkbox" value="morning"
								id="av-morning">Mañana</label>

						</div>
						<div class="form-group">
							<label><input type="checkbox" value="afternoon"
								id="av-afternoon">Tarde</label>
						</div>
					</div>
				</div>
			</form>
		</div>

		<!--  Listado  -->
		<div class="w-75 d-flex flex-wrap justify-content-center align-items-center" style="background-color: green">

			<div class="d-flex flex-column align-items-center justify-content-center" style="flex-basis: 15%">
				<img src="https://via.placeholder.com/150" onClick="location.href='www.google.com'" class="rounded-circle w-50" style="cursor:pointer">
				<h4 style="color: black; margin: 0">Pipo</h4>
				<p>Summary</p>
			</div>
			<div class=" d-flex flex-column align-items-center "
				style="flex-basis: 15%">
				<a href="show/1"><img src="https://via.placeholder.com/150"></a>
				<h4 style="color: black; margin: 0">Pipo</h4>
				<p>Summary</p>
			</div>
			<div class=" d-flex flex-column align-items-center"
				style="flex-basis: 15%">
				<a href="show/1"><img src="https://via.placeholder.com/150"></a>
				<h4 style="color: black; margin: 0">Pipo</h4>
				<p>Summary</p>
			</div>
			<div class=" d-flex flex-column align-items-center"
				style="flex-basis: 15%">
				<a href="show/1"><img src="https://via.placeholder.com/150"></a>
				<h4 style="color: black; margin: 0">Pipo</h4>
				<p>Summary</p>
			</div>
			<div class=" d-flex flex-column align-items-center "
				style="flex-basis: 15%">
				<a href="show/1"><img src="https://via.placeholder.com/150"></a>
				<h4 style="color: black; margin: 0">Pipo</h4>
				<p>Summary</p>
			</div>
			<div class=" d-flex flex-column align-items-center "
				style="flex-basis: 15%">
				<a href="show/1"><img src="https://via.placeholder.com/150"></a>
				<h4 style="color: black; margin: 0">Pipo</h4>
				<p>Summary</p>
			</div>
			<div class=" d-flex flex-column align-items-center "
				style="flex-basis: 15%">
				<a href="show/1"><img src="https://via.placeholder.com/150"></a>
				<h4 style="color: black; margin: 0">Pipo</h4>
				<p>Summary</p>
			</div>
			<div class=" d-flex flex-column align-items-center"
				style="flex-basis: 15%">
				<a href="show/1"><img src="https://via.placeholder.com/150"></a>
				<h4 style="color: black; margin: 0">Pipo</h4>
				<p>Summary</p>
			</div>
			<div class=" d-flex flex-column align-items-center "
				style="flex-basis: 15%">
				<a href="show/1"><img src="https://via.placeholder.com/150"></a>
				<h4 style="color: black; margin: 0">Pipo</h4>
				<p>Summary</p>
			</div>

			<div class=" d-flex flex-column align-items-center "
				style="flex-basis: 15%">
				<a href="show/1"><img src="https://via.placeholder.com/150"></a>
				<h4 style="color: black; margin: 0">Pipo</h4>
				<p>Summary</p>
			</div>
			<div class=" d-flex flex-column align-items-center "
				style="flex-basis: 15%">
				<a href="show/1"><img src="https://via.placeholder.com/150"></a>
				<h4 style="color: black; margin: 0">Pipo</h4>
				<p>Summary</p>
			</div>
			




		</div>

	</div>





	<!-- 
	
	
	<div class="container" style="background-color: red">
		<div class="row">
			<div class="col-3">
				<p>Filtros</p>
				</br>
				<form>
					<label>Nombre:</label> <input type="text" value=""
						placeholder="Nombre" id="name"> <label>Rol:</label> <select
						id="role">
						<c:forEach items="${roles}" var="role">
							<option value="${role}">${role}</option>
						</c:forEach>
					</select> <label>Experiencia:</label> <input type="checkbox" value="1"
						id="exp1"> <input type="checkbox" value="2" id="exp2">
					<input type="checkbox" value="3" id="exp3"> <input
						type="checkbox" value="4" id="exp4"> <input
						type="checkbox" value="5" id="exp5"> <label>Disponibilidad:</label>
					<div>
						<label><input type="checkbox" value="morning"
							id="availability">Mañana</label> <label><input
							type="checkbox" value="afternoon" id="availability">Tarde</label>
					</div>
				</form>
			</div>
			<div class="col-9 d-flex">
				<div class="col-sm-2 d-flex align-items-center flex-wrap">
					<a href="show/1"><img src="https://via.placeholder.com/150"></a>
					<h4 style="color: black; margin: 0">Pipo</h4>
					<p>Summary</p>
				</div>
				<div class="col-sm-2 d-flex align-items-center flex-wrap">
					<a href="show/1"><img src="https://via.placeholder.com/150"></a>
					<h4 style="color: black; margin: 0">Pipo</h4>
					<p>Summary</p>
				</div>
				<div class="col-sm-2 d-flex align-items-center flex-wrap">
					<a href="show/1"><img src="https://via.placeholder.com/150"></a>
					<h4 style="color: black; margin: 0">Pipo</h4>
					<p>Summary</p>
				</div>
				<div class="col-sm-2 d-flex align-items-center fl=ex-wrap">
					<a href="show/1"><img src="https://via.placeholder.com/150"></a>
					<h4 style="color: black; margin: 0">Pipo</h4>
					<p>Summary</p>
				</div>
				<div class="col-sm-2 d-flex align-items-center flex-wrap">
					<a href="show/1"><img src="https://via.placeholder.com/150"></a>
					<h4 style="color: black; margin: 0">Pipo</h4>
					<p>Summary</p>
				</div>
				<div class="col-sm-2 d-flex align-items-center flex-wrap">
					<a href="show/1"><img src="https://via.placeholder.com/150"></a>
					<h4 style="color: black; margin: 0">Pipo</h4>
					<p>Summary</p>
				</div>
				<div class="col-sm-2 d-flex align-items-center flex-wrap">
					<a href="show/1"><img src="https://via.placeholder.com/150"></a>
					<h4 style="color: black; margin: 0">Pipo</h4>
					<p>Summary</p>
				</div>
				<div class="col-sm-2 d-flex align-items-center flex-wrap">
					<a href="show/1"><img src="https://via.placeholder.com/150"></a>
					<h4 style="color: black; margin: 0">Pipo</h4>
					<p>Summary</p>
				</div>
				<div class="col-sm-2 d-flex align-items-center flex-wrap">
					<a href="show/1"><img src="https://via.placeholder.com/150"></a>
					<h4 style="color: black; margin: 0">Pipo</h4>
					<p>Summary</p>
				</div>
				<div class="col-sm-2 d-flex align-items-center flex-wrap">
					<a href="show/1"><img src="https://via.placeholder.com/150"></a>
					<h4 style="color: black; margin: 0">Pipo</h4>
					<p>Summary</p>
				</div>
			</div>
		</div>
	</div>


	</div>
	
	-->

</body>
</html>



<!-- 

<p>Filtros</p>
				</br>
				<form>
					<label>Nombre:</label> <input type="text" value=""
						placeholder="Nombre" id="name"> <label>Rol:</label> <select
						id="role">
						<c:forEach items="${roles}" var="role">
							<option value="${role}">${role}</option>
						</c:forEach>
					</select> <label>Experiencia:</label> <input type="checkbox" value="1"
						id="exp1"> <input type="checkbox" value="2" id="exp2">
					<input type="checkbox" value="3" id="exp3"> <input
						type="checkbox" value="4" id="exp4"> <input
						type="checkbox" value="5" id="exp5"> <label>Disponibilidad:</label>
					<div>
						<label><input type="checkbox" value="morning"
							id="availability">Mañana</label> <label><input
							type="checkbox" value="afternoon" id="availability">Tarde</label>
					</div>
				</form>


	<!-- Listado Artistas -->

<!-- 
	<div>
		<!-- Listado Artistas PRO -->
<!-- 
		<div>
      		<c:forEach items="${artistsPro}" var="artistPro">
      			<a href="artist/detailsArtist/${artistPro.id}"><img src="https://via.placeholder.com/150/FFFF00/000000"></a>
      			<span>${artistPro.name}</span>
      			<p>${artistPro.summary}</p>
      		</c:forEach>
      	</div>
		<hr>
		<!-- Listado Artistas -->
<!--  
      	<div class="container">
      		<c:forEach items="${artists}" var="artist">
      			<div class="col-sm-2 d-flex align-items-center flex-wrap" >
	      			<a href="show/${artist.id}"><img src="https://via.placeholder.com/150"></a>
	      			<h4 style="color:black;margin:0">${artist.name}</h4>
	      			<p>${artist.summary}</p>
      			</div>
      		</c:forEach>
      	</div>
      

	</div>

 -->
