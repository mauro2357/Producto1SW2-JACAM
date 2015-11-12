<%@page import="Negocio.gestion.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%if(session.getAttribute("persona") == null){%>
<jsp:forward page="index.jsp"></jsp:forward>
<%} %>
<%
Persona persona= (Persona)session.getAttribute("persona");
String tipo=persona.getTipo();
if(session.getAttribute("persona")!=null && tipo.equalsIgnoreCase("usuario")){ %>
	<jsp:forward page="usuario.jsp"></jsp:forward>
	

	<%} %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>East Sites</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
<script type="text/javascript" src="validacion.js" ></script>
</head>
<body class = "cuerpo">
<form method="post" action="enlace">    
    <input type="submit" name="ok" value="Salir" class="button salir">
</form>
<section id="ban">
<button class="button login" id="enter" onclick="limpiar();regLugar()">Registrar Lugar</button>

<button class="button login" id="enter" onclick="limpiar();actLugar()">Actualizar Datos de un Lugar</button>

<form method="post" action="PropietarioControl">
<input type="submit" name="ok" value="consultarlugares" class="button login sub">
</form>

<div id="fo" ></div>

<% 


%>

</section>

<!-- Main -->

<section id="main" class="container">

<section class="box special">



</section>

</section>



</section>
<script>
function goBack() {
    window.history.back();
}
</script>
</body>
</html>