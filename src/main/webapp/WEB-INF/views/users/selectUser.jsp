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
    
    <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
    
    <title>Nuevo Usuario</title>
    <h1>Seleccione el tipo de usuario que quiere ser: </h1>
   <table>
   <tr>
   <td>
   <ul>
   <a href="/artists/create" class="btn" style="color:white;background-color: #af3248"> Artista</a>
   </ul>
   <ul>
   <a href="/producers/create" class="btn" style="color:white;background-color: #af3248"> Productor</a>
   </ul>
   <ul>
   <a href="/writers/create" class="btn" style="color:white;background-color: #af3248"> Escritor</a>
   </ul>
   </td>
   </tr>
   </table> 
   </head>
   