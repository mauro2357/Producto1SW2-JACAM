<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="enlace" onsubmit="return comprobarClave()">
Direccion de correo electronico: </br>
<input type="email" name="correo" class="textbox" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" maxlength="50" autofocus required></br>
Password:</br>
<input type="password" name="clave1" id="clave1" class="textbox" placeholder="Password" pattern=".{4,}" title="Cuatro o mas Caracteres" maxlength="30" required></br>
Confirmar Password:</br>
<input type="password" name="clave2" id="clave2" class="textbox" placeholder="Confirm Password" maxlength="30" required></br>
<div id="errorClave"  style="color:#FF0000;"></div>
Nombre(s) y Apellidos:</br>
<input type="text" name="nombre" class="textbox" pattern="[A-Za-z]{3,40}" title="Solo letras (3-40)" placeholder="Nombre" required></br>
Tipo:</br>
<select name="tipo">
<option value="usuario">Usuario</option>
<option value="propietario">Propietario</option>
</select></br>
<div class="bsub">
<input type="submit" name="ok" value="Crear" class="button login sub">
</div>
</form>	


<script type="text/javascript">
/*function comprobarClave(){ 
	
   	clave1 = document.getElementById("clave1").value;
   	clave2 = document.getElementById("clave2").value;
   	alert(clave1);
   	alert(clave2);
	var correcto;
   	if (clave1 == clave2){
       correcto= true;
   	}
   	else{ 
	      alert("Las contraseñas no coinciden");
	      document.getElementById("errorClave").innerHTML="Las contraseñas no coinciden";
	      correcto=false;
      	}
    return correcto;
    }*/

</script>
</body>
</html>