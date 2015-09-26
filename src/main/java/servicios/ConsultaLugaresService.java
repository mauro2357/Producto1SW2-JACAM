package servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Negocio.busquedadelugaresporelusuario.Lugar;
import presentacion.consultaLugaresFacade;

@Path("ConcultaLugares")
public class ConsultaLugaresService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("consultaLugar/{coordenadas}")
	public String ConsultarLugares(@PathParam("coordenadas")String coordenadas) throws Exception{
		ArrayList<Lugar> luga = new ArrayList<Lugar>();
		consultaLugaresFacade lugares = new consultaLugaresFacade();
		luga=lugares.consultarLugarPorNombre(coordenadas);
		return luga.toString();
		
	}
	
	

}

