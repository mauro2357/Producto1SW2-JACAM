<%if(session.getAttribute("email") == null){%>
<jsp:forward page="index.jsp"></jsp:forward>
<%} %>
<%if(session.getAttribute("email")!=null && (request.getAttribute("usuario")!="usuario")){%>
	<script>window.onload=goBack();</script>

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
<div class="lad"><button class="button enter" id="enter" onclick="limpiar();favoritos()">Añadir a Favoritos</button></div>
</section>
<div id="fo" ></div>
<div id="listar" ></div>
</section>
<script>
function goBack() {
    window.history.back();
}
</script>
</body>
</html>