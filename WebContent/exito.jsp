<%@page import java.util.ArrayList; %>
<%if(session.getAttribute("email") == null){%>
<jsp:forward page="index.jsp"></jsp:forward>
<%} %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>East Sites</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
<script type="text/javascript" src="validacion.js" ></script>
<script>
function loadXMLDoc()
{
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("arsenal").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","rr.jsp",true);
xmlhttp.send();
}
</script>
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

</body>
</html>
=======
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="enlace">    
    <input type="submit" name="ok" value="Salir" class="button salir">
    </form>
</body>
</html>
>>>>>>> origin/master
