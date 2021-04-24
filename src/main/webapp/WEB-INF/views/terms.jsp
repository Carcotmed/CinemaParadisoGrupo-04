<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <title>Términos y Condiciones</title>
</head>

    <body class="h-100" style="background-color: #272727; color: white">

        <jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

            <div class="d-flex justify-content-center align-items-center" style="padding:2%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    TÉRMINOS Y CONDICIONES DE USO
                </div>    
            </div> 

            <div class="d-flex justify-content-center align-items-center" style="padding:1%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    DATOS REQUERIDOS Y FINALIDAD    
                </div>    
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    El cliente o usuario de la web posee los derechos sobre sus datos como controlador de datos, 
                    y la empresa, poseedora de la web Cinema Paradiso, actúa como procesador de datos en nombre 
                    del cliente. Todo el procesamiento por parte de la empresa de los datos personales y otros datos 
                    proporcionados por el cliente se realizará de acuerdo con las leyes aplicables. Por lo tanto, el 
                    procesamiento de datos personales por parte del cliente solo se realizará para proporcionar el 
                    producto (la aplicación Cinema Paradiso ) y estará sujeto a las instrucciones del cliente. 
                    En ningún caso se usarán los datos del cliente para otras funciones ajenas a las propias que 
                    conforman el producto Cinema Paradiso App.
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">       
                    Dado que la empresa es el procesador de datos y el cliente es el controlador de datos, las 
                    obligaciones de las partes con respecto al procesamiento de datos personales están reguladas 
                    en este mismo acuerdo de Términos y Condiciones, el cual es aceptado por el cliente en el momento 
                    que de registro de la cuenta de usuario y está disponible en todo momento en el footer o parte 
                    inferior de la web.
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;"> 
                    El cliente está obligado a mantener en secreto los inicios de sesión de los usuarios y las contraseñas 
                    de la aplicación frente a usuarios no autorizados o terceros.
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    El cliente está obligado a garantizar que los datos personales proporcionados por el este y utilizados
                    por la web sean procesados por el cliente de acuerdo con todas las leyes aplicables. El cliente está 
                    obligado a garantizar que sus datos proporcionados para el producto, incluidos los datos personales, 
                    no violen ningún derecho de propiedad intelectual de terceros y/o cualquier legislación aplicable. 
                    La empresa propietaria tiene derecho a eliminar cualquier dato que, a su exclusivo criterio, constituya 
                    un incumplimiento del compromiso antes mencionado por parte del cliente, y este último no tendrá derecho 
                    a ninguna compensación al respecto.
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    Para el correcto funcionamiento de la web Cinema Paradiso se pedirán los siguientes datos de carácter personal:  
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                        <ul>
                            <li>Nombre</li>
                            <li>Apellidos</li>
                            <li>Email</li>
                            <li>Foto (Mediante enlace web)</li>
                            <li>Resumen biográfico</li>
                        </ul>  
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    Estos datos se piden con la finalidad de ser usados en el contacto entre los usuarios que utilizarán la web. 
                    Por esta misma razón, es completamente necesario que el nombre y los apellidos puedan consultarse públicamente, 
                    de forma que permita el a los clientes conocer la persona con la que están contactando.
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    Los datos concretados en el resumen biográfico también serán de carácter público. A este respecto, el cliente será 
                    responsable de lo especificado en este campo.
                </div>
            </div>
            
            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    El email se almacenará de forma totalmente privada y se usará expresamente para contactar con el cliente en caso de 
                    ser necesario.
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:1%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    SOLICITUD Y GESTIÓN DE INCIDENCIAS    
                </div>    
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    En caso de encontrar algún fallo en la aplicación, el cliente dispone de la posibilidad de 
                    reportar los fallos a la empresa para poder corregirse con la mayor brevedad posible.
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    Para reportar fallos el cliente solo debe escribir un correo al email cinemaparadisoapp@gmail.es, dedicado al soporte. 
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    Desde la empresa propietaria, agradecemos la implicación del cliente con respecto a la corrección de fallos y 
                    el mantenimiento de la calidad de nuestro producto.
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:1%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    NOTIFICACION DE BRECHAS DE SEGURIDAD
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    Teniendo como premisa la imposibilidad de obtener un riesgo nulo de filtración 
                    de datos, las leyes pertinentes exigen la elaboración de un plan de gestión en 
                    caso de ocurrir una brecha de seguridad.
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    En caso de que una filtración de datos afecte al cliente, la empresa contactará 
                    con este y con la Agencia Española de Protección de Datos en un plazo máximo de 
                    72 horas.
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    Estas medidas pretenden reducir el posible perjuicio ocasionado al cliente con la 
                    filtración de sus datos personales.
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:1%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    DERECHO AL OLVIDO Y MOVILIDAD DE LOS DATOS 
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    Para cumplir con las leyes pertinentes de protección de datos, concretamente en 
                    lo especificado al Derecho de Supresión, el cliente tiene completo derecho a revocar 
                    el consentimiento prestado anteriormente en estos términos.
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    Este derecho implica la obligación de la empresa para garantizar la total eliminación 
                    de los datos privados del cliente que así lo solicita, así como su desvinculación del 
                    resto de datos almacenados en nuestro producto.
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    Para solicitar la aplicación de este derecho, únicamente será necesario ponerse en 
                    contacto con nuestro email de soporte cinemaparadisoapp@gmail.es. Una vez realizada 
                    dicha solicitud, esta se llevará a cabo en un plazo máximo de 6 días laborables. El 
                    cliente recibirá un correo de confirmación en cuanto el procedimiento haya sido concluido.
                </div>
            </div>

            <div class="d-flex justify-content-center align-items-center" style="padding:0.5%">
                <div class="d-flex justify-content-between" style="width:40%;">
                    Así mismo, también se puede solicitar los datos almacenados usando este mismo email 
                    de soporte. El cliente recibirá los datos pertinentes de forma adjunta al correo recibido.
                </div>
            </div>
            

        
        <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

    </body>

</html>