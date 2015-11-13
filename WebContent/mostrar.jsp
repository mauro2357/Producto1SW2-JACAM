<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="java.util.Vector" %>
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
<div id="salir">
<form method="post" action="enlace">    
    <input type="submit" name="ok" value="Salir" class="button salir">
</form>
</div>
<section id="ban">
<h1><%=request.getAttribute("busqueda") %></h1></br>
<section >
<%
	String valor= (String)request.getAttribute("quitar");
	if (valor==null){
		valor="agregar";
	}
	String concat;
	String nombre;
	int telefono;
	String latitud;
	String longitud;
	String descripcion;
	String categoria;
	ArrayList<Lugar> lugares = new ArrayList<>();
	lugares=(ArrayList<Lugar>)request.getAttribute("lugares");

for (int i=0;i<lugares.size();i++){
	String num=Integer.toString(i);
	nombre=lugares.get(i).getNombre();
	telefono=lugares.get(i).getTelefono();
	latitud=lugares.get(i).getCoordenadas().getLatitud();
	longitud=lugares.get(i).getCoordenadas().getLongitud();
	descripcion=lugares.get(i).getDescripcion();
	categoria=lugares.get(i).getCatenom();

%>
<table style="whidht:100%";>
<tr>
<th>Lugar</th>
<th>Favoritos</th>
</tr>
<tr>
<th>
<button class="button enter" id="enter" onclick="inicializar_mapa(<%=latitud%>,<%=longitud%>,<%=telefono%>,<%=i%>);">
 	<%=nombre %>
 </button>
 </th>
 <th>
	<form method="post" action="control">
	<input type="hidden" id=<%="latitud"+num %> name="latitud" value=<%= latitud%>><%System.out.println("longitud mostrar: "+longitud); %>
	<input type="hidden" id=<%="longitud"+num%> name="longitud" value=<%= longitud %>>
	<input type="hidden" id=<%="nombre"+num%> name="nombre" value=<%= lugares.get(i).getNombre() %>>
	<input type="hidden" id=<%="descripcion"+num%> name="descripcion" value=<%= lugares.get(i).getDescripcion()%>>
	<input type="hidden" id=<%="categoria"+num%> name="categoria" value=<%= lugares.get(i).getCatenom() %>>
	<input type="submit" name="clugar" value=<%= valor %> class="button" id="fav">
	</form>
	</th>
	<%
	out.print("</tr>");
	%>
</table>
<%
}
%>



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

function inicializar_mapa(latitud,longitud,telefono,i) {
	var idnom="nombre"+i;
	var iddes="descripcion"+i;
	var idcat="categoria"+i;
	
	var nombre = document.getElementById(idnom).value;
	var descripcion = document.getElementById(iddes).value;
	var categoria = document.getElementById(idcat).value;
	
	var pos= new google.maps.LatLng(latitud, longitud)
	var mapOptions = {
    		
      center:pos,
      zoom: 14,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
	
    var map = new google.maps.Map(document.getElementById("map"),
        mapOptions);
    var coorde = latitud+", "+longitud;
    //alert(coorde+" "+telefono+" i:"+i+" "+categoria);
    
    var contentString = "Nombre: "+nombre+'</br>'+"Latitud: "+latitud+" Longitud: "+longitud+'</br>'+"Telefono: "+telefono+'</br>'+"Descripcion: "+descripcion+'</br>'+"Categoria: "+categoria;
    var infowindow = new google.maps.InfoWindow({
        content: contentString
      });
    
    marker = new google.maps.Marker({
        position: pos,
        map: map,
        title:"Esto es un marcador",
        animation: google.maps.Animation.BOUNCE
    }); 
    marker.addListener('click', function() {
        infowindow.open(map, marker);
      });
    marker.addListener('click', toggleBounce);
  }
function toggleBounce() {
	  if (marker.getAnimation() !== null) {
	    marker.setAnimation(null);
	  } else {
	    marker.setAnimation(google.maps.Animation.BOUNCE);
	  }
	}

function initMap() {
	var pos= new google.maps.LatLng(6.148699, -75.356351)
	var mapOptions = {
			
	          center: pos,
	          zoom: 10,
	          mapTypeId: google.maps.MapTypeId.ROADMAP
	        };
	        var map = new google.maps.Map(document.getElementById("map"),
	            mapOptions);
	        
}


    </script>
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBjaBtBYyGYRQ1_x-MYLZjSpLbGWcFQrMk&libraries=places&callback=initMap">
    </script>
</body>
</html>