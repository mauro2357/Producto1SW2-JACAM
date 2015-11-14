package servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Negocio.gestion.Persona;
import Negocio.gestion.Propietario;
import Negocio.gestion.Usuario;
import Negocio.lugar.Coordenadas;
import Negocio.lugar.Lugar;
import presentacion.LogInFacade;
import presentacion.LugaresFacade;

@Path("GestionLugares")
public class GestionLugaresService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("registrarLugar/{nombre}/{telefono}/{latitud}/{longitud}/{propietario}/{categoria}/{descripcion}")
	public int RegistrarLugar(@PathParam("nombre")String nombre,@PathParam("telefono")String telefono,@PathParam("latitud")String latitud,@PathParam("longitud")String longitud,@PathParam("propietario")String propietario,@PathParam("categoria")String categoria,@PathParam("descripcion")String descripcion) throws Exception{
    	Persona persona= new Propietario(propietario);
		LugaresFacade registrar_lugar = new LugaresFacade(persona);		
		int r = registrar_lugar.RegistrarLugar(nombre, Integer.parseInt(telefono), latitud,longitud, Integer.parseInt(categoria), descripcion);
		return r;
			
	}
}
