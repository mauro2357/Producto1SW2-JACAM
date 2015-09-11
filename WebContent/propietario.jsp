<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%if(session.getAttribute("email") == null){%>
<jsp:forward page="index.jsp"></jsp:forward>
<%} %>
<!--  <%if(session.getAttribute("email")!=null && (request.getAttribute("propietario")!="propietario")){%>
	<script>window.onload=goBack();</script>

	<%} %>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<button class="button login" id="enter" onclick="limpiar();eliLugar()">Eliminar Lugar</button>

<button class="button login" id="enter" onclick="limpiar();actLugar()">Actualizar Datos de un Lugar</button>

<button class="button login" id="enter" onclick="limpiar();consLugar()">Consultar Mis Lugares</button></br>

<div id="fo" ></div>

<%String login= (String) (request.getAttribute("loginvalido"));

String reginv= (String) (request.getAttribute("reginvalido"));

if(login==null){

System.out.println(login);

}

if(reginv!=null){

System.out.println(reginv);

}

%>

</section>

<!-- Main -->

<section id="main" class="container">

<section class="box special">

<header class="major">

<h2>Be Happy.

<br />

Descubre nuevos sitios.</h2>

<p>Encuentra tus lugares de interes desde el movil.</p>

</header>

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