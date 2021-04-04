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
                    <td><form:label path="password">Contrasena: </form:label></td>
                    <td><form:input type="text" path="password" /></td>
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