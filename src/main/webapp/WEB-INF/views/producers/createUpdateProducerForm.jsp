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
    <title>Nuevo Productor</title>
</head>
<body>
    <form:form action = ""  modelAttribute="producer" method = "post">
        <fieldset>
            <legend>Datos del productor</legend>
            <table>
                <tr>
                    <td><form:label path="name">NAME: </form:label></td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td><form:label path="surName">SURNAME: </form:label></td>
                    <td><form:input path="surName" /></td>
                </tr>
                <tr>
                    <td>
                 <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${isNew}">
                            <input class="btn btn-danger" type="submit" value="Crear"/>
                        </c:when>
                        <c:otherwise>
                            <input class="btn btn-danger" type="submit" value="Actualizar"/>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
                    </td>
                </tr>
            </table>
            <button class="btn btn-danger" onclick="location.href = '/producers/list';">Cancelar</button>
        </fieldset>
    </form:form>
</body>
</html>