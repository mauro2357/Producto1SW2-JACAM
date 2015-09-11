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
</head>
<body class="cuerpo">
<form method="post" action="enlace">    
    <input type="submit" name="ok" value="Salir" class="button salir">
</form>
<section id="ban">
<h1>Busqueda de Lugares</h1></br>
<form method="post" action ="enlace">
Tipo:</br>
<select name="tipo">
<option value="restaurantes">Restaurante</option>
<option value="hoteles">Hoteles</option>
<option value="bares">Bares</option>
<option value="centros comerciales">Centros Comerciales</option>
<option value="universidades">Universidades</option>
<input type="submit" name="ok" value="tipos" class="button">
</select></br>
</form>
</section>
<script>
function goBack() {
    window.history.back();
}
</script>
</body>
</html>