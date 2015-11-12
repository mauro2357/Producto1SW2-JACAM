<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="Negocio.lugar.*" %>
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
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Lista de Lugares</title>
</head>
<body class="cuerpo">
<form method="post" action="enlace">    
    <input type="submit" name="ok" value="Salir" class="button salir">
</form>
<section id="ban">
<h1><%=request.getAttribute("busqueda") %></h1></br>
<section >
<%
	String valor= (String)request.getAttribute("quitar");
	if (valor==null){
		valor="agregar";
	}
	String nombre;
	int telefono;
	String latitud;
	String longitud;
	String descripcion;
	String categoria;
	ArrayList<Lugar> lugares = new ArrayList<>();
	lugares=(ArrayList<Lugar>)request.getAttribute("lugares");
	for (int i=0;i<lugares.size();i++){
		nombre=lugares.get(i).getNombre();
		telefono=lugares.get(i).getTelefono();
		latitud=lugares.get(i).getCoordenadas().getLatitud();
		longitud=lugares.get(i).getCoordenadas().getLongitud();
		descripcion=lugares.get(i).getDescripcion();
		categoria=lugares.get(i).getCatenom();
 %>
 <button class="button enter" id="enter" onclick="lugdatos(<%=latitud%>,<%=longitud%>,<%=telefono%>);">
 	<%=nombre%>
 </button>
 <%} %>
<table style="whidth:100%;">
<tr>
<th>Nombre</th>
<th>telefono</th>
<th>Latitud</th>
<th>Longitud</th>
<th>decripcion</th>
<th>categoria</th>
<th>Agregar</th>
</tr>
<%

for (int i=0;i<lugares.size();i++){
	out.print("<tr>");
	out.print("<td>"+lugares.get(i).getNombre()+"</td>");
	out.print("<td>"+lugares.get(i).getTelefono()+"</td>");
	out.print("<td>"+lugares.get(i).getCoordenadas().getLatitud()+"</td>");
	out.print("<td>"+lugares.get(i).getCoordenadas().getLongitud()+"</td>");
	out.print("<td>"+lugares.get(i).getDescripcion()+"</td>");
	out.print("<td>"+lugares.get(i).getCatenom()+"</td>");
	
	%>
	<td>
	<form method="post" action="control">
	<input type="hidden" name="latitud" value=<%= lugares.get(i).getCoordenadas().getLatitud() %>>
	<input type="hidden" name="longitud" value=<%= lugares.get(i).getCoordenadas().getLongitud() %>>
	<input type="submit" name="clugar" value=<%= valor %> class="button" id="fav">
	</form>
	</td>
	<%
	out.print("</tr>");
}


%>
</table>
</section>
</section>

<!-- Main -->

<section id="main" class="container">

<section class="box special">
<div id="map"> </div>


</section>

</section>
<script type="text/javascript">
var map;
function lugdatos(latitud,longitud,telefono,categoria){
	//var nombre=document.getElementById("enter").value;
	var coorde = latitud+","+longitud;
	var pos= new google.maps.LatLng(coorde);
	
	alert(coorde+" "+telefono);
	createMarker(pos);
}
function initMap() {
	var mapOptions = {
	          center: new google.maps.LatLng(6.148699, -75.356351),
	          zoom: 10,
	          mapTypeId: google.maps.MapTypeId.ROADMAP
	        };
	        var map = new google.maps.Map(document.getElementById("map"),
	            mapOptions);
  
}

function createMarker(pos) {
	var marker = new google.maps.Marker({
	      position: pos,
	      map: map,
	      title:"Esto es un marcador",
	      animation: google.maps.Animation.DROP
	  });

	 /* google.maps.event.addListener(marker, 'click', function() {
	    infowindow.setContent(place.name);
	    infowindow.open(map, this);
	  });*/
	}

    </script>
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBjaBtBYyGYRQ1_x-MYLZjSpLbGWcFQrMk&libraries=places&callback=initMap">
    </script>
</body>
</html>