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
<body>
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
		<td><input type="text" name ="nombrelugar" maxlength="30" placeholder=<%= lugares.get(i).getNombre() %> required></td>
		<td><input type="text" name ="telefono"  pattern="[0-9]{4,11}" title="Solo numeros (4-11)" placeholder=<%= lugares.get(i).getTelefono() %> required></td>
		<td><input type="text" name ="latitud" pattern="[0-9.+-]+" title="numeros y puntos" placeholder=<%= lugares.get(i).getCoordenadas().getLatitud() %> required></td>
		<td><input type="text" name ="longitud" pattern="[0-9.+-]+" title="numeros y puntos" placeholder=<%= lugares.get(i).getCoordenadas().getLongitud() %> required></td>
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

</body>
</html>