<%if(session.getAttribute("email") == null){%>
<jsp:forward page="index.jsp"></jsp:forward>
<%} %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>East Sites</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
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
    document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","consulta.txt",true);
xmlhttp.send();
}
</script>
</head>
<body class = "cuerpo">
<form method="post" action="enlace">    
<input type="submit" name="ok" value="Salir" class="button salir">
</form>
<section id="ban">
<h1>East Sites </h1></br>
<div id="header1" style=" background:rgb(210, 210, 210)">
<ul class="nav">
				<li><a href="">Lugares</a>
					<ul>
					    <li><a href="">Restaurantes</a></li>
					    <li><a href="">Hoteles</a></li>
					    <li><a href="">Bares</a></li>
					    <li><a href="">Centros Comerciales</a></li>
					    <li><a href="">Universidades</a></li>   
                     </ul>
				</li>
				</li>
</ul>
</div>
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