<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<style>
	
		footer{
			background-color: var(--gris-oscuro);
			position: absolute;
			bottom: 0;
			height: 17rem;
			font-size: 0.9rem;
			padding: 1rem;
			overflow:hidden;
		}
		
		.footer-wrap{
			height: 17rem;
			display: flex;
		}
		
		.footer-wrap > div:not(.align-items-center){
			margin: 0 1rem;
    		width: 15rem;
		}
		
		#mobile-footer{
			display: none;
		}
		
		footer img{
			width:8rem;
			filter:invert(1);
		}
		
		footer > * > div{
			height: 100%;
		}
		
		.padding-footer{
			padding-bottom: 17rem;
		}
		
		@media(max-width: 1160px) {
			#mobile-footer{
				display: block;
			}
			
			.footer-wrap{
				display:none;
			}
			
			#mobile-footer > div:not(.align-items-center){
				text-align: center;
			}
			
			#mobile-footer > div:not(.align-items-center) > h5{
				margin: 1rem auto;
			}
			
			footer img{
				width:5rem;
			}
			
			#mobile-footer > * > h5{
				width: 5rem;
			    margin: 0;
			    margin-left: 1rem;
			}
			
			footer{
				height: 35rem;
			}
			
			.padding-footer{
				padding-bottom: 35rem;
			}
			
			footer > * > div{
				height: unset;
			}
		}
		
	</style>
	
	<footer class="w-100 d-flex justify-content-center align-items-start">

		<div class="footer-wrap justify-content-center align-items-start">
			<div class="d-flex flex-column justify-content-center align-items-center" style="width:15rem">
				<img src="https://image.flaticon.com/icons/png/512/96/96595.png">
				<h5>Cinema Paradiso</h5>
			</div>
			
			<div class="d-flex flex-column">
				<h5>Aviso</h5>
				<p>Cinema Paradiso es un proyecto creado por alumnos de la Universidad de Sevilla para la asignatura de ISPP.
				<br>
				<br>
				De la misma forma, no buscamos lucrarnos de ninguna manera haciendo uso del contenido ya que se trata de un proyecto educativo.</p>
			</div>
			
			<div class="d-flex flex-column">
				<h5>Legal</h5>
				<p>Cinema Paradiso no est&aacute afiliado de ninguna forma a Ariane Films, Miramax o cualquier otra empresa que disponga los derechos de la pel&iacutecula.</p>
				<a href="/terms" target="_blank">Términos y Condiciones de Uso</a>
			</div>
			
			<div class="d-flex flex-column">
				<h5>Contacto</h5>
				<p>Email: cinemaparadisoapp@gmail.com</p>
			</div>
		</div>
		
		<!-- Mobile -->
		
		<div id="mobile-footer">
		
			<div class="d-flex justify-content-center align-items-center">
				<img src="https://image.flaticon.com/icons/png/512/96/96595.png">
				<h5>Cinema Paradiso</h5>
			</div>
			
			<div>
				<h5>Aviso</h5>
				<p>Cinema Paradiso es un proyecto creado por alumnos de la Universidad de Sevilla para la asignatura de ISPP.
				<br>
				<br>
				De la misma forma, no buscamos lucrarnos de ninguna manera haciendo uso del contenido ya que se trata de un proyecto educativo.</p>
			</div>
			
			<div>
				<h5>Legal</h5>
				<p>Cinema Paradiso no est&aacute afiliado de ninguna forma a Ariane Films, Miramax o cualquier otra empresa que disponga los derechos de la pel&iacutecula.</p>
				<a href="/terms" target="_blank">Términos y Condiciones de Uso</a>
			</div>
			
			<div>
				<h5>Contacto</h5>
				<p>Email: cinemaparadisoapp@gmail.com</p>
			</div>
		</div>
	</footer>
</html>