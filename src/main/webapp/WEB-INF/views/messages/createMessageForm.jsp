<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html style="height:100%">
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
    <title>Nuevo Mensaje</title>
</head>
<body class="position-relative" style="color:white;height:100%;background-color: #272727; color: white">
   	<jsp:include page="/WEB-INF/views/navbar.jsp" ></jsp:include>
   
    <form:form action = "/messages/create/${userName}" style="min-height:70%"  modelAttribute="message" method = "post" class="d-flex justify-content-center align-items-center">
	<input type="hidden" name="username" value="${user}" />    
	   <fieldset class="d-flex justify-content-center align-items-center flex-column">
            <legend style="width:fit-content">Datos del mensaje</legend>
            <table>
                <tr>
                    <td><form:label path="issue">Asunto: </form:label></td>
                    <td><form:input type="text" path="issue" /></td>
                </tr>
                <tr>
                    <td><form:label path="body">Cuerpo: </form:label></td>
                    <td><form:textarea path="body" /></td>
            </table>
            
            <div class="d-flex justify-content-evenly" style="width:100%">
            	<button class="btn btn-default" style="color:white;background-color:#af3248" class="btn btn-default" type="submit">Crear</button>
            	<button class="btn btn-default" style="color:white;background-color: #af3248" type="reset" onclick="location.href = '/messages/listReceived';">Cancelar</button>    		
            </div>
               
        </fieldset>
    </form:form>
    		<jsp:include page="/WEB-INF/views/footer.jsp" ></jsp:include>
    
</body>
</html>