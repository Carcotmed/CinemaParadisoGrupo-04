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
    <h1>Seleccione el tipo de usuario que quiere ser: </h1>
   <table>
   <tr>
   <td>
   <ul>
   <a href="/artists/create" class= "btn btn-danger"> Artista</a>
   </ul>
   <ul>
   <a href="/producers/create" class= "btn btn-danger"> Productor</a>
   </ul>
   <ul>
   <a href="/writers/create" class= "btn btn-danger"> Escritor</a>
   </ul>
   </td>
   </tr>
   </table> 
   </head>
   