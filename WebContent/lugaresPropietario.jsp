<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="Negocio.lugar.*" %>
<!DOCTYPE html>
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
	<%
	ArrayList<Lugar> lugares = new ArrayList<>(); 
	lugares=(ArrayList<Lugar>)request.getAttribute("lugares");
	
	%>
	<table style="whidth:100%;">
		<tr>
		<th>Nombre</th>
		<th>Telefono</th>
		<th>Latitud</th>
		<th>Longitud</th>
		<th>Decripcion</th>
		<th>Categoria</th>
		<th>Eliminar</th>
		<th>Actualizar</th>
		</tr>
	<%
	
	for (int i=0;i<lugares.size();i++){
		out.print("<tr>");%>
		<form method="post" action="PropietarioControl">
		<td><input type="text" name ="nombrelugar" maxlength="30" placeholder=<%= lugares.get(i).getNombre() %> ></td>
		<td><input type="text" name ="telefono"  pattern="[0-9]{4,11}" title="Solo numeros (4-11)" placeholder=<%= lugares.get(i).getTelefono() %> ></td>
		<td><input type="text" name ="latitud" pattern="[0-9.+-]+" title="numeros y puntos" placeholder=<%= lugares.get(i).getCoordenadas().getLatitud() %> ></td>
		<td><input type="text" name ="longitud" pattern="[0-9.+-]+" title="numeros y puntos" placeholder=<%= lugares.get(i).getCoordenadas().getLongitud() %> ></td>
		<td><input type="text" name ="descripcion" placeholder=<%= lugares.get(i).getDescripcion() %>></td>
		<td><%out.print(lugares.get(i).getCatenom());%>
		<select name="categoria">
  			<option value="1">Restaurante</option>
			<option value="2">Bares</option>
			<option value="3">Hoteles</option>
			<option value="4">Universidades</option>
			<option value="5">Centros Comerciales</option>
		</select>
		</td>
		<!--  <form method="post" action="PropietarioControl"> -->
		<input type="hidden" name="lug_id" value=<%= lugares.get(i).getId() %>>
		<td>
		<input type="submit" name="ok" value="eliminar" class="button">
		</td>
		<td>
		<input type="submit" name="ok" value="actualizar" class="button">
		</td>
		</form>
		<%
		out.print("</tr>");
	}
	
	
	%>
	</table>
	<div> <p>Para actualizar el lugar debes llenar todas las cajas de texto, la informacion original se encuentra en el fondo de esta</br>
	Puedes ubicar las coordenadas del lugar en el mapa.</br>
	Recuerda, usa todas las cajas de texto.</p></div>
<div id="map"></div>
<script type="text/javascript">


var map = null;
	var infoWindow = null;

	function openInfoWindow(marker) {
		var markerLatLng = marker.getPosition();
		infoWindow.setContent(
			"La posicion del marcador es: "+'</br>'+"Latitud: "+markerLatLng.lat()+" Longitud: "+markerLatLng.lng()+'</br>'+"Haz click en el marcador para actualizar"
			
		);
		infoWindow.open(map, marker);
	}

	function initialize() {
		var myLatlng = new google.maps.LatLng(6.148699, -75.356351);
		var myOptions = {
		  zoom: 13,
		  center: myLatlng,
		  mapTypeId: google.maps.MapTypeId.ROADMAP
		}

		map = new google.maps.Map(document.getElementById("map"), myOptions);

		infoWindow = new google.maps.InfoWindow();

		var marker = new google.maps.Marker({
		    position: myLatlng,
		    draggable: true,
		    map: map,
		    title:"Ejemplo marcador arrastrable"
		});

		google.maps.event.addListener(marker, 'click', function(){
			openInfoWindow(marker);
		});
	}
	       
    </script>
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBRHzn9G_iNQggnEwwM_m7QCZiAH0C7S8U&libraries=places&callback=initialize">
    </script>
</body>
</html>