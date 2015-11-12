<%@page import="Negocio.gestion.*" %>
<%if(session.getAttribute("persona") == null){%>
<jsp:forward page="index.jsp"></jsp:forward>
<%} %>
<%
Persona persona= (Persona)session.getAttribute("persona");
String tipo=persona.getTipo();
if(session.getAttribute("persona")!=null && tipo.equalsIgnoreCase("propietario")){%>
	<jsp:forward page="propietario.jsp"></jsp:forward>
	<%} %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>East Sites</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
<script type="text/javascript" src="validacion.js" ></script>
</head>
<body class="cuerpo">
<form method="post" action="enlace">    
    <input type="submit" name="ok" value="Salir" class="button salir">
</form>
<section id="ban">
<h1>Busqueda de Lugares</h1></br>
<section >
<div class="lad"><button class="button enter" id="enter" onclick="limpiar();portipo()">Tipo</button></div>
<div class="lad"><form method="post" action="control"><input type="submit" name="clugar" value="todo" class="button login sub"></form></div>
<div class="lad"><button class="button enter" id="enter" onclick="limpiar();pornombre()">Nombres</button></div>
<div class="lad"><form method="post" action="control">
	<input type="submit" name="clugar" value="favoritos" class="button enter" onclick="limpiar();" >
</form></div>
</section>
<div id="fo" ></div>
<div id="listar" ></div>
</section>

</body>
</html>