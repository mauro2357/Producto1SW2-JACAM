package servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Negocio.gestion.Persona;
import Negocio.gestion.Propietario;
import Negocio.gestion.Usuario;
import Negocio.lugar.Lugar;
import presentacion.LogInFacade;
import presentacion.RegistroFacade;
import presentacion.consultaLugaresFacade;
@Path("GestionPersona")
public class GestionPersonasService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("logIn/{email}/{clave}")
	public int LogIn(@PathParam("email")String email,@PathParam("clave")String clave) throws Exception{
		Persona persona = new Usuario();
		LogInFacade login = new LogInFacade();		
		persona = login.validar(email, clave);		
		int r = 0;
		if(persona != null){
			String tipo = persona.getTipo();
			if(tipo.equalsIgnoreCase("propietario")){
				r = 1;
			}if(tipo.equalsIgnoreCase("usuario")){
				r = 2;
			}
		}else if (persona == null){
			r = 0;
		}
		return r;
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("registrar/{email}/{clave}/{nombre}/{tipo}")
	public int Registrar(@PathParam("email")String email,@PathParam("clave")String clave,@PathParam("nombre")String nombre,@PathParam("tipo")String tipo) throws Exception{
		RegistroFacade registro = new RegistroFacade();
		Persona reg = registro.registrar(email, clave, nombre, tipo);
		System.out.println(reg);
		int r =0;
		if(reg != null){
			if(reg.getTipo().equalsIgnoreCase("propietario")){				
				r =2;				
			}if(reg.getTipo().equalsIgnoreCase("usuario")){
				r = 1;
			}
		}
		System.out.println(r);
		return r;
		
	}
}
