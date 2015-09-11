package servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ConcultaLugares")
public class ConsultaLugaresService {
	@GET
	@Produces(MediaType.TEXT_XML)
	public String ConsultarLugares(){
		return "";
		
	}
	
	

}

