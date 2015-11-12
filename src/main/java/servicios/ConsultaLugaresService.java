package servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Negocio.lugar.Lugar;
import presentacion.consultaLugaresFacade;

@Path("ConsultaLugares")
public class ConsultaLugaresService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("consultaLugarNombre/{nombre}")
	public String ConsultarLugaresNombre(@PathParam("nombre")String nombre) throws Exception{
		ArrayList<Lugar> luga = new ArrayList<Lugar>();
		consultaLugaresFacade lugares = new consultaLugaresFacade();
		luga=lugares.consultarLugarPorNombre(nombre);
		if(!luga.isEmpty()){
			return luga.get(0).getCoordenadas().getLatitud()+","+luga.get(0).getCoordenadas().getLongitud();
		}
		else{
			return "[]";
		}		
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("consultaLugarCoordenadas/{latitud}/{longitud}")
	public String ConsultarLugaresCoordenadas(@PathParam("latitud")String latitud,@PathParam("longitud")String longitud) throws Exception{
		ArrayList<Lugar> luga = new ArrayList<Lugar>();
		consultaLugaresFacade lugares = new consultaLugaresFacade();
		luga=lugares.consultarLugarPorCoordenadas(latitud,longitud);
		return luga.toString();
		
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("consultaLugarCategoria/{categoria}")
	public String ConsultarLugaresCategoria(@PathParam("categoria")String categoria) throws Exception{
		ArrayList<Lugar> luga = new ArrayList<Lugar>();
		consultaLugaresFacade lugares = new consultaLugaresFacade();
		luga=lugares.consultarLugarPorCategorias(categoria);
		return luga.toString();
		
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("consultaTodosLugares")
	public String ConsultarTodosLugares() throws Exception{
		ArrayList<Lugar> luga = new ArrayList<Lugar>();
		consultaLugaresFacade lugares = new consultaLugaresFacade();
		luga=lugares.consultarTodosLugares();
		return luga.toString();
		
	}

}

