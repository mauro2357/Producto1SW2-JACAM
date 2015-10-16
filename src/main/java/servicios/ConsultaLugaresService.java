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

@Path("ConsultaLugares")
public class ConsultaLugaresService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("validarUsuario/{email},{clave}")
	public int validarUsuario(@PathParam("email")String email,@PathParam("clave")String clave) throws Exception{
		LogInFacade logInFacade=new LogInFacade();
		return logInFacade.validarUs(email, clave);

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
	@Path("consultaLugarCoordenadas/{coordenadas}")
	public String ConsultarLugaresCoordenadas(@PathParam("coordenadas")String coordenadas) throws Exception{
		ArrayList<Lugar> luga = new ArrayList<Lugar>();
		consultaLugaresFacade lugares = new consultaLugaresFacade();
		luga=lugares.consultarLugarPorCoordenadas(coordenadas);
		return luga.toString();		
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("consultaLugarNombre/{nombre}")
	public String ConsultarLugaresNombre(@PathParam("nombre")String nombre) throws Exception{
		ArrayList<Lugar> luga = new ArrayList<Lugar>();
		consultaLugaresFacade lugares = new consultaLugaresFacade();
		luga=lugares.consultarLugarPorNombre(nombre);
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
