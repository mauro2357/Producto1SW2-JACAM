<!--  -->
<%if(session.getAttribute("email") != null){%>
<jsp:forward page="exito.jsp"></jsp:forward>
<%} %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>East Sites</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body class="cuerpo">
<section id="ban">
<h1>East Sites </h1></br>

<button class="button login" id="login" onclick="limpiar();log()">Entrar</button>

<button class="button enter" id="enter" onclick="limpiar();reg()">Registrarse</button></br>

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

<script>

function limpiar() {

var d = document.getElementById("fo");

while (d.hasChildNodes())

d.removeChild(d.firstChild);

}

var xmlhttp;

function loadXMLDoc(url,cfunc){

	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}

	else

	{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange=cfunc;
	xmlhttp.open("GET",url,true);
	xmlhttp.send();

	}

function log(){

	loadXMLDoc("log.txt",function()
{

	if (xmlhttp.readyState==4 && xmlhttp.status==200)
	{
		document.getElementById("fo").innerHTML=xmlhttp.responseText;
	}

});

}

function reg()
{
	loadXMLDoc("regi.txt",function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			document.getElementById("fo").innerHTML=xmlhttp.responseText;
			}
		});
}
</script>

</body>

</html>