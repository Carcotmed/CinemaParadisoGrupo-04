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
    <title>Nuevo Mensaje</title>
</head>
<body>
    <form:form action = "/messages/create/${userName}"  modelAttribute="message" method = "post">
	<input type="hidden" name="username" value="${user}" />    
	   <fieldset>
            <legend>Datos del mensaje</legend>
            <table>
                <tr>
                    <td><form:label path="issue">Asunto: </form:label></td>
                    <td><form:input type="text" path="issue" /></td>
                </tr>
                <tr>
                    <td><form:label path="body">Cuerpo: </form:label></td>
                    <td><form:input type="text" path="body" /></td>
                </tr>
                    <td>
                        <button class="btn btn-default" type="submit">Crear</button>
                    </td>
                </tr>
            </table>
            
             <button class="btn btn-default" type="reset" onclick="location.href = '/messages/listReceived';">Cancelar</button>    		
            
        </fieldset>
    </form:form>
</body>
</html>