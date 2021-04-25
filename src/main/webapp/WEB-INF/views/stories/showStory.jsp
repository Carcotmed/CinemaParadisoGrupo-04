<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html class="h-100">

<head>
<style > 
body{margin:0; padding:0; -webkit-font-smoothing: antialiased; font-family:arial;}

#main-content{display:flex; width:100vw; height:100vh; background:white; align-items:center; justify-content:center; text-align:center;}

h1{font-size:14px; font-weight:400; margin:10px 0 0 0; color:#888888;}

a{font-size:12px; font-weight:bold; margin-top:10px; display:inline-block; text-decoration:none; color:#008A68;}

svg{
  cursor:pointer; overflow:visible; width:60px;
  #heart{transform-origin:center; animation:animateHeartOut .3s linear forwards;}
  #main-circ{transform-origin:29.5px 29.5px;}
}

#checkbox{display:none;}

#checkbox:checked + label svg{
    #heart{transform:scale(.2); fill:#E2264D; animation:animateHeart .3s linear forwards .25s;}
    #main-circ{transition:all 2s; animation:animateCircle .3s linear forwards; opacity:1;}
    #grp1{
      opacity:1; transition:.1s all .3s;
      #oval1{
        transform:scale(0) translate(0, -30px);
        transform-origin:0 0 0;
        transition:.5s transform .3s;}
      #oval2{
        transform:scale(0) translate(10px, -50px);
        transform-origin:0 0 0;
        transition:1.5s transform .3s;}
    }
    #grp2{
      opacity:1; transition:.1s all .3s;
      #oval1{
        transform:scale(0) translate(30px, -15px); 
        transform-origin:0 0 0;
        transition:.5s transform .3s;}
      #oval2{
        transform:scale(0) translate(60px, -15px); 
        transform-origin:0 0 0;
        transition:1.5s transform .3s;}
    }
    #grp3{
      opacity:1; transition:.1s all .3s;
      #oval1{
        transform:scale(0) translate(30px, 0px);
        transform-origin:0 0 0;
        transition:.5s transform .3s;}
      #oval2{
        transform:scale(0) translate(60px, 10px);
        transform-origin:0 0 0;
        transition:1.5s transform .3s;}
    }
    #grp4{
      opacity:1; transition:.1s all .3s;
      #oval1{
        transform:scale(0) translate(30px, 15px);
        transform-origin:0 0 0;
        transition:.5s transform .3s;}
      #oval2{
        transform:scale(0) translate(40px, 50px);
        transform-origin:0 0 0;
        transition:1.5s transform .3s;}
    }
    #grp5{
      opacity:1; transition:.1s all .3s;
      #oval1{
        transform:scale(0) translate(-10px, 20px);
        transform-origin:0 0 0;
        transition:.5s transform .3s;}
      #oval2{
        transform:scale(0) translate(-60px, 30px);
        transform-origin:0 0 0;
        transition:1.5s transform .3s;}
    }
    #grp6{
      opacity:1; transition:.1s all .3s;
      #oval1{
        transform:scale(0) translate(-30px, 0px);
        transform-origin:0 0 0;
        transition:.5s transform .3s;}
      #oval2{
        transform:scale(0) translate(-60px, -5px);
        transform-origin:0 0 0;
        transition:1.5s transform .3s;}
    }
    #grp7{
      opacity:1; transition:.1s all .3s;
      #oval1{
        transform:scale(0) translate(-30px, -15px);
        transform-origin:0 0 0;
        transition:.5s transform .3s;}
      #oval2{
        transform:scale(0) translate(-55px, -30px);
        transform-origin:0 0 0;
        transition:1.5s transform .3s;}
    }
    #grp2{opacity:1; transition:.1s opacity .3s;}
    #grp3{opacity:1; transition:.1s opacity .3s;}
    #grp4{opacity:1; transition:.1s opacity .3s;}
    #grp5{opacity:1; transition:.1s opacity .3s;}
    #grp6{opacity:1; transition:.1s opacity .3s;}
    #grp7{opacity:1; transition:.1s opacity .3s;}
}

@keyframes animateCircle{
  40%{transform:scale(10); opacity:1; fill:#DD4688;}
  55%{transform:scale(11); opacity:1; fill:#D46ABF;}
  65%{transform:scale(12); opacity:1; fill:#CC8EF5;}
  75%{transform:scale(13); opacity:1; fill:transparent; stroke:#CC8EF5; stroke-width:.5;}
  85%{transform:scale(17); opacity:1; fill:transparent; stroke:#CC8EF5; stroke-width:.2;}
  95%{transform:scale(18); opacity:1; fill:transparent; stroke:#CC8EF5; stroke-width:.1;}
  100%{transform:scale(19); opacity:1; fill:transparent; stroke:#CC8EF5; stroke-width:0;}
}

@keyframes animateHeart{
  0%{transform:scale(.2);}
  40%{transform:scale(1.2);}
  100%{transform:scale(1);}
}

@keyframes animateHeartOut{
  0%{transform:scale(1.4);}
  100%{transform:scale(1);}
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
<script>
		$(document).ready(function () {
			$("#levantaModal").click(function () {
				$("#fondoModal").show();
				$("#modalProyectos").show();
			});
			$("#fondoModal").click(function () {
				$("#fondoModal").hide();
				$("#modalProyectos").hide();
			});
		});

		$(window).scroll(function () {
			$("#fondoModal").hide();
			$("#modalProyectos").hide();
		})

	</script>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<title>Story</title>
</head>

<body class="h-100" style="background-color: #272727; color: white">
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<div id="fondoModal"
		style="display: none; position: fixed; width: 100%; height: 100%; background-color: transparent;"></div>
	<div id="modalProyectos"
		style="color: white; border-radius: 20px; display: none; left: 24vw; top: 20vh; padding: 1%; position: fixed; width: 50vw; background-color: #3c3c3c">
		<div class="container-fluid"
			style="background-color: #af3248; border-radius: 20px; padding: 1%">
			<h2>Proyectos a asociar</h2>
		</div>
		<c:forEach items="${projects}" var="projects">
			<br>
			<div class="d-flex justify-content-between align-items-center">
				<h5>${ projects.title }</h5>
				<button class="btn rounded-pill"
					onClick="location.href='/stories/request/${story.id}/${projects.id}'"
					style="color: white; background-color: #af3248">Asociar</button>
			</div>
		</c:forEach>
	</div>

	<!-- Header Historia -->
	<div class="d-flex justify-content-between p-3" style="height: 15%">
		<div class="d-flex align-items-center" style="width: 50%">
			<div class="rounded-circle d-flex"
				style="overflow: hidden; height: 100%; width: 12vh">
				<img
					src="https://www.psicoactiva.com/wp-content/uploads/puzzleclopedia/Libros-codificados-300x262.jpg"
					style="width: 100%; height: 100%; object-fit: cover">
			</div>
			<div class="py-3 mx-3" style="width: 40%">
				<h2>${story.title}</h2>
			</div>
		</div>
		<c:if test="${showButton == false}">
			<sec:authorize access="isAuthenticated()">
				<button class="btn rounded-pill"
					onClick="location.href='/messages/create/${writerUsername}'"
					style="color: white; height: fit-content; background-color: #af3248">Contactar
					con el escritor</button>
				<button class="btn rounded-pill" id="levantaModal"
					style="color: white; height: fit-content; background-color: #af3248">Asociar
					proyecto</button>
			</sec:authorize>
		</c:if>
		<c:if test="${showButton == true and !story.isSponsored and !isAdmin}">
			<!-- PAYPAL -->

			<script
				src="https://www.paypal.com/sdk/js?client-id=AXbp0NhXvchBXWtbvtRNBvVdch6cABb0d7084I04WtigxqKbiVA6WPNIJFwzLyXd-0el451LDtbOEwI2&currency=EUR"> // Required. Replace YOUR_CLIENT_ID with your sandbox client ID.
							</script>

			<script>
							function post(path, params, method = 'post') {
								// The rest of this code assumes you are not using a library.
								// It can be made less verbose if you use one.
								const form = document.createElement('form');
								form.method = method;
								form.action = path;
								for (const key in params) {
									if (params.hasOwnProperty(key)) {
										const hiddenField = document.createElement('input');
										hiddenField.type = 'hidden';
										hiddenField.name = key;
										hiddenField.value = params[key];
										form.appendChild(hiddenField);
									}
								}
								document.body.appendChild(form);
								form.submit();
							}

						</script>

			<script>
							paypal.Buttons({
								createOrder: function (data, actions) {
									return actions.order.create({
										purchase_units: [{
											amount: {
												currency: "EUR",
												value: "30"
											},
										}]
									});
								},
								onApprove: function (data, actions) {
									// This function captures the funds from the transaction.
									return actions.order.capture().then(function (details) {
										post("/pro/confirmedAdStory", { storyID: ${ story.id }, paymentDetails: details, ${ _csrf.parameterName }: "${_csrf.token}"})
								});
						    }
						  }).render('#paypal-button-ad-story');
						  //This function displays Smart Payment Buttons on your web page.
						</script>

			<div>
				<p>¡Publicita tu historia! (30&#8364)</p>
			</div>
			<div id="paypal-button-ad-story" style="z-index: 1"></div>

			<!-- END PAYPAL -->
		</c:if>

		<sec:authorize access="isAuthenticated()">
			<c:if test="${isAdmin}">
				<button class="btn rounded-pill"
					onClick="location.href='/messages/create/${writerUsername}'"
					style="color: white; height: fit-content; background-color: #af3248">Contactar
					con el escritor</button>
			</c:if>
		</sec:authorize>
		<c:if test="${showButton == true}">
			<button class="btn rounded-pill"
				onClick="location.href='/stories/update/${story.id}'"
				style="color:white;height: fit-content;background-color: ${isAdmin?'#8a4380':'#af3248'}">Actualizar</button>
			<button class="btn rounded-pill"
				onClick="location.href='/stories/delete/${story.id}'"
				style="color:white;height: fit-content;background-color: ${isAdmin?'#8a4380':'#af3248'}">Eliminar</button>
		</c:if>
	</div>
	<!-- Info general Historia -->
	<div>
		<div class="container-fluid"
			style="background-color: #4c4c4c; padding: 1%">
			<h3 style="margin: 0">Ficha t&eacutecnica</h3>
		</div>

		<div class="d-flex justify-content-between" style="padding: 2% 5%; display:flex">
			<!-- Datos -->
			<div style="width: 150%">
				<div style="margin: 1% 0">
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color: #3e3e3e">T&iacutetulo</h5>
					</div>
					<p style="margin-left: 3%">${story.title}</p>
				</div>
				<div style="margin: 1% 0">
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color: #3e3e3e">G&eacutenero</h5>
					</div>
					<p style="margin-left: 3%">${story.genre}</p>
				</div>
				<div>
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color: #3e3e3e">Descripci&oacuten</h5>
					</div>
					<p style="margin-left: 3%">${story.body}</p>
				</div>
				<div>
					<div class="d-flex flex-wrap ">
						<h5 class="p-2 rounded-pill" style="background-color: #3e3e3e">Escritor</h5>
					</div>
					<div class="d-flex align-items-center" style="cursor: pointer"
						onClick="location.href='/writers/show/${myWriter.id}'">
						<div
							style="width: 20vh; height: 20vh; overflow: hidden; cursor: pointer"
							class="rounded-circle">
							<img src="${myWriter.photo}"
								style="width: 100%; height: 100%; object-fit: cover">
						</div>
						<p style="margin-left: 3%">${myWriter.user.username}</p>
					</div>

				</div>
			</div>
			<div style="width: 50%;">
			<h2>Apoya la historia!!</h2>
			<br>
		    
		    <h5>usuario(s) le(s) gusta(n) la historia</h5>
		    <div style= "background-color: #af3248; margin-right: 50%">
			<h5 style="color:white; margin: 0% 0% 0% 50% ">${likes} </h5>
			
			</div>
			
			
			<br>
			<c:if test="${actualUserLiked}">
			
			<img  class= "rounded-circle" src="https://raw.githubusercontent.com/ivan-desing-testing/CinemaParadisoGrupo-04/feature/%23285-likesStory/src/main/webapp/WEB-INF/views/static/like.png" 
			onClick="location.href='/stories/notLike/${story.id}'"
								style="width: 10%; height: 10%; "> 
								
		       
			</c:if>
			
			<c:if test="${!actualUserLiked}">
			
			<img  class= "rounded-circle" src="https://raw.githubusercontent.com/ivan-desing-testing/CinemaParadisoGrupo-04/feature/%23285-likesStory/src/main/webapp/WEB-INF/views/static/dislike.png" 
			onClick="location.href='/stories/like/${story.id}'"
								style="width: 8%; height: 8%; "> 
			 
			
			</c:if>
		    </div>

		</div>
	</div>


	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>

</html>