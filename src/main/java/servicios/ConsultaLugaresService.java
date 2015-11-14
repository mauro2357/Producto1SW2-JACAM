package servicios;

import java.util.ArrayList;

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
import presentacion.LugaresFacade;
import presentacion.consultaLugaresFacade;

@Path("ConsultaLugares")
public class ConsultaLugaresService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("consultaLugarNombre/{email}/{nombre}")
	public String ConsultarLugaresNombre(@PathParam("email")String email,@PathParam("nombre")String nombre) throws Exception{
		ArrayList<Lugar> luga = new ArrayList<Lugar>();
		Persona usuario = new Usuario(email);
		LugaresFacade lugares = new LugaresFacade(usuario);
		luga=lugares.consultarLugares("nombre", nombre);
		if(!luga.isEmpty()){
			return luga.get(0).getCoordenadas().getLatitud()+","+luga.get(0).getCoordenadas().getLongitud()+","+luga.get(0).getDescripcion()+","+luga.get(0).getCatenom()+","+luga.get(0).getTelefono();
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
		if(!luga.isEmpty()){
			return luga.get(0).getNombre()+","+luga.get(0).getDescripcion();
		}else{
			return "[]";
		}
		
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("consultaLugarCategoria/{email}/{categoria}")
	public String ConsultarLugaresCategoria(@PathParam("email")String email,@PathParam("categoria")String categoria) throws Exception{
		ArrayList<Lugar> luga = new ArrayList<Lugar>();
		Persona usuario = new Usuario(email);
		LugaresFacade lugares = new LugaresFacade(usuario);
		luga=lugares.consultarLugares("categoria", categoria);
		String resultado  ="";
		if(!luga.isEmpty()){
			for(int i=0;i<luga.size();i++){
				resultado =  resultado + luga.get(i).getNombre()+","+luga.get(i).getDescripcion()+"/";
			}
			return resultado;
		}else{
			return "[]";
		}
		
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("consultaTodosLugares/{email}")
	public String ConsultarTodosLugares(@PathParam("email")String email) throws Exception{
		ArrayList<Lugar> luga = new ArrayList<Lugar>();
		Persona usuario = new Usuario(email);
		LugaresFacade lugares = new LugaresFacade(usuario);
		luga=lugares.consultarLugares("todos", email);		
		String resultado = "";
		if(!luga.isEmpty()){
		for(int i=0;i<luga.size();i++){
			resultado =  resultado + luga.get(i).getNombre()+","+luga.get(i).getCatenom()+","+luga.get(i).getCoordenadas().getLatitud()+","+luga.get(i).getCoordenadas().getLongitud()+"/";
		}
		return resultado;
		}else{
			return "[]";
		}	
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("consultaLugaresPropietario/{email}")
	public String ConsultaLugaresPropietario(@PathParam("email")String email) throws Exception{
		ArrayList<Lugar> luga = new ArrayList<Lugar>();
		Persona propietario = new Propietario(email);
		LugaresFacade lugares = new LugaresFacade(propietario);
		luga=lugares.consultarLugares("propietario",email);		
		String resultado = "";
		if(!luga.isEmpty()){
			for(int i=0;i<luga.size();i++){
				resultado =  resultado + luga.get(i).getNombre()+","+luga.get(i).getCatenom()+"/";
			}
			return resultado;
			}else{
				return "[]";
			}	
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("agregarFavorito/{email}/{latitud}/{longitud}")
	public int AgregarFavorito(@PathParam("email")String email,@PathParam("latitud")String latitud,@PathParam("longitud")String longitud) throws Exception{
		ArrayList<Lugar> luga = new ArrayList<Lugar>();
		Persona usuario = new Usuario(email);
		LugaresFacade lugares = new LugaresFacade(usuario);
		String coordenadas = latitud+" "+longitud;
		lugares.agregarFavorito(coordenadas);		
		return 1;
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("consultarFavoritos/{email}")
	public String consultaFavoritos(@PathParam("email")String email) throws Exception{
		ArrayList<Lugar> luga = new ArrayList<Lugar>();
		Persona usuario = new Usuario(email);
		LugaresFacade lugares = new LugaresFacade(usuario);
		luga = lugares.consultarLugares("favoritos", email);
		String resultado = "";
		if(!luga.isEmpty()){
			for(int i=0;i<luga.size();i++){
				resultado =  resultado + luga.get(i).getNombre()+","+luga.get(i).getCatenom()+","+luga.get(i).getCoordenadas().getLatitud()+","+luga.get(i).getCoordenadas().getLongitud()+"/";
			}
			return resultado;
		}else{
			return "[]";	
		}	
	}
}
