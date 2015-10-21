<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="Negocio.busquedadelugaresporelusuario.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<th>telefono</th>
<th>Coordenadas</th>
<th>decripcion</th>
<th>categoria</th>
<<<<<<< HEAD
<th>Agregar</th>
=======
<th>Agregar a Favoritos</th>
>>>>>>> origin/master
</tr>
<%

for (int i=0;i<lugares.size();i++){
	out.print("<tr>");
	out.print("<td>"+lugares.get(i).getNombre()+"</td>");
	out.print("<td>"+lugares.get(i).getTelefono()+"</td>");
	out.print("<td>"+lugares.get(i).getCoordenadas()+"</td>");
	out.print("<td>"+lugares.get(i).getDescripcion()+"</td>");
	out.print("<td>"+lugares.get(i).getCatenom()+"</td>");
	out.print("<td>"+"<button>   F     	</button>"+"</td>");
	out.print("</tr>");
}


%>
</table>
</body>
</html>