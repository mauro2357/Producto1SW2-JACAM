<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="Negocio.lugar.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Lista de Lugares</title>
</head>
<body>
<%
String valor= (String)request.getAttribute("quitar");
if (valor==null){
	valor="agregar";
}
ArrayList<Lugar> lugares = new ArrayList<>(); 
lugares=(ArrayList<Lugar>)request.getAttribute("lugares");

%>
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
	<script type="text/javascript">
function onoff() {
	var x = document.getElementById("fav");
	if(quitar!=null){
		
	}
	
}
</script>
</body>
</html>