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
</head>
<body>
<form method="post" action="enlace">    
    <input type="submit" name="ok" value="Salir" class="button salir">
</form>
</body>
</html>