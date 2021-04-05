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
	<link rel="shorcut icon" type="image/ico" href="https://github.com/Carcotmed/CinemaParadisoGrupo-04/blob/feature/fix-general/src/main/webapp/WEB-INF/views/static/favicon.ico?raw=true" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<title>Elige que tipo de usuario quieres ser</title>
</head>
<body class="h-100" style="background-color: #272727; color: white">
	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>

	<div  class="d-flex flex-column justify-content-center">
	
		<div class="d-flex justify-content-between" style="background-color:#4c4c4c; padding:1%">
			<h4>Elige que tipo de usuario quieres ser</h4>
		</div>
		
		
			<div class="d-flex justify-content-between align-items-evenly" style="padding:1% 2%;width:70%;height:12vh;margin:auto">
				<div class="d-flex align-items-center" style="width:100%">
					<div  class="rounded-circle d-flex" style="overflow:hidden;height:100%;width:10%">
						<img src="https://fscomps.fotosearch.com/compc/CSP/CSP588/mimo-artista-actuar-cuerpo-clipart__k30691595.jpg"  style="cursor:pointer;width:100%;height:100%;object-fit:cover">
					</div>
					<h5 style="margin:0 2%">Artista</h5>
				</div>
				
				<div class="d-flex justify-content-between align-items-center" style="width:30%">
					<button style="color:white;height: fit-content;background-color:#af3248" class="btn rounded-pill" onClick="location.href='/artists/create'">Crear</button>
				</div>
				
			</div>
			
			<hr style="border-width: 3px;border-style: solid;border-radius: 20px;border-color:#e81a1a; width:60%; margin:1% auto">
			
			<div class="d-flex justify-content-between align-items-evenly" style="padding:1% 2%;width:70%;height:12vh;margin:auto">
				<div class="d-flex align-items-center" style="width:100%">
					<div  class="rounded-circle d-flex" style="overflow:hidden;height:100%;width:10%">
						<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIFe2nWx71Hrd2NFlPvry-HXwdlHt8Rq-YwA&usqp=CAU"  style="cursor:pointer;width:100%;height:100%;object-fit:cover">
					</div>
					<h5 style="margin:0 2%">Productor</h5>
				</div>
				
				<div class="d-flex justify-content-between align-items-center" style="width:30%">
					<button style="color:white;height: fit-content;background-color:#af3248" class="btn rounded-pill" onClick="location.href='/producers/create'">Crear</button>
					<button style="color:white;height: fit-content;background-color:#af3248" class="btn rounded-pill"  onClick="location.href='/'">Volver</button>
				</div>
				
			</div>
			
			<hr style="border-width: 3px;border-style: solid;border-radius: 20px;border-color:#e81a1a; width:60%; margin:1% auto">
			
	<div class="d-flex justify-content-between align-items-evenly" style="padding:1% 2%;width:70%;height:12vh;margin:auto">
				<div class="d-flex align-items-center" style="width:100%">
					<div  class="rounded-circle d-flex" style="overflow:hidden;height:100%;width:10%">
						<img src="https://elcorreoweb.es/binrepository/675x507/0c54/675d400/none/10703/DYTH/escribir-tu-histroria-1024x769_20332201_20200104232241.jpg"  style="cursor:pointer;width:100%;height:100%;object-fit:cover">
					</div>
					<h5 style="margin:0 2%">Escritor</h5>
				</div>
				
				<div class="d-flex justify-content-between align-items-center" style="width:30%">
					<button style="color:white;height: fit-content;background-color:#af3248" class="btn rounded-pill" onClick="location.href='/writers/create'">Crear</button>
				</div>
				
			</div>
			
			<hr style="border-width: 3px;border-style: solid;border-radius: 20px;border-color:#e81a1a; width:60%; margin:1% auto">
			
	</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
	
</body>
</html>
    