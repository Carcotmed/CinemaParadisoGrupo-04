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
    <title>Nuevo Usuario</title>
</head>
<body>
    <form action = "/users/create"  modelAttribute="user" method = "post">
        <fieldset>
            <legend>Datos del usuario</legend>
            <table>
                <tr>
                    <td><label>Usuario: </label></td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td><label>Contrasena: </label></td>
                    <td><input type="text" name="password" /></td>
                </tr>
                    <td>
                        <button type="submit">Registrarse</button>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>