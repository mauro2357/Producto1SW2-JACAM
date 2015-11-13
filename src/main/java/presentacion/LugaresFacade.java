package presentacion;

import java.util.ArrayList;

import Negocio.gestion.Persona;
import Negocio.gestion.Propietario;
import Negocio.gestion.Usuario;
import Negocio.lugar.Coordenadas;
import Negocio.lugar.Lugar;
import datos.LugarRepository;

public class LugaresFacade {
	Persona persona;
	ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	public LugaresFacade(Persona persona) {
		// TODO Auto-generated constructor stub
		this.persona=persona;
	}
	public ArrayList<Lugar> consultarLugares(String forma, String valor) throws Exception{
		System.out.println("forma: "+forma+" Valor: "+valor);
		this.lugares=persona.consultarLugar(forma, valor);
		return(lugares);
	}
	public void ActualizarDatos(String id,String nombre,int telefono,String latitud, String longitud,int categoria,String descripcion) throws Exception{
		Propietario propietario= (Propietario) this.persona;
		int ID = Integer.parseInt(id);
		Coordenadas coordenadas= new Coordenadas(latitud,longitud);
		Lugar lugar = new Lugar(ID,nombre,telefono,coordenadas,persona.getEmail(),categoria,descripcion);
		propietario.actualizarLugar(lugar);
	}
	public void EliminarLugar(String id) throws Exception{
		lugares.clear();
		Propietario propietario= (Propietario) this.persona;
		Lugar lugar = this.consultarLugares("id", id).get(0);
		propietario.eliminarLugar(lugar);
		
	}
	public int RegistrarLugar(String nombre,int telefono,String latitud, String longitud,int categoria,String descripcion) throws Exception{
		lugares.clear();
		lugares=this.consultarLugares("ubicacion", latitud+" "+longitud);
		if(lugares.isEmpty()){
			Propietario propietario= (Propietario) this.persona;
			Coordenadas coordenadas = new Coordenadas(latitud,longitud);
			Lugar lugar = new Lugar(0,nombre,telefono,coordenadas,propietario.getEmail(),categoria,descripcion);
			propietario.registrarLugar(lugar); 
			return 1;
		}
		else{
			return 0;
		}
		
	}
	public void agregarFavorito(String coordenadas) throws Exception{
		lugares.clear();
		Lugar lugar = this.consultarLugares("ubicacion", coordenadas).get(0);
		Usuario usuario = (Usuario) this.persona;
		usuario.agregarFavorito(lugar);
	}
	public void quitarFavorito(String coordenadas) throws Exception{
		lugares.clear();
		Lugar lugar = this.consultarLugares("ubicacion", coordenadas).get(0);
		Usuario usuario = (Usuario) this.persona;
		usuario.quitarFavorito(lugar);
	}

}
