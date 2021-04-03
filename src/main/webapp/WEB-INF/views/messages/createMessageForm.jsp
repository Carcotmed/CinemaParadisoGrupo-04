<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nuevo Mensaje</title>
</head>
<body>
    <form action = "/messages/create/{user.id}"  modelAttribute="user" method = "post">
	<input type="hidden" name="id" value="${user.id}" />    
	   <fieldset>
            <legend>Datos del mensaje</legend>
            <table>
                <tr>
                    <td><label>Asunto: </label></td>
                    <td><input type="text" name="issue" /></td>
                </tr>
                <tr>
                    <td><label>Cuerpo: </label></td>
                    <td><input type="text" name="body" /></td>
                </tr>
                <tr>
                    <td><fmt:formatDate value="${message.date}" type="date" pattern="yyyy/MM/dd HH:mm" var="date"/>
           			 <input type="hidden" name="date" value="${date}"/></td>
                    <td><input type="date" name="date" /></td>
                </tr>
                    <td>
                        <button class="btn btn-default" type="submit">Crear</button>
                    </td>
                </tr>
            </table>
            
             <button class="btn btn-default" type="reset" onclick="location.href = '/messages/list';">Cancelar</button>    		
            
        </fieldset>
    </form>
</body>
</html>