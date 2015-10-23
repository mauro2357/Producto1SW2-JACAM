package servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Negocio.busquedadelugaresporelusuario.Lugar;
import presentacion.LogInFacade;
import presentacion.consultaLugaresFacade;
@Path("Login")
public class LogInService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("validarUsuario/{email},{clave]")
	public void validarUsuario(@PathParam("email")String email,@PathParam("clave")String clave) throws Exception{
		LogInFacade logInFacade=new LogInFacade();
		logInFacade.validarUs(email, clave);
	}
}
