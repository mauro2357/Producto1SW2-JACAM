package presentacion;

import java.util.ArrayList;

import Negocio.gestion.Persona;
import Negocio.gestion.Usuario;
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
		this.lugares=persona.consultarLugar(forma, valor);
		System.out.println("Lugar Propietario: "+lugares.get(0).getCoordenadas());
		return(lugares);
	}
	public void ActualizarDatos(String nombre,int telefono,String coordenadas,String propietario,int categoria,String descripcion) throws Exception{
		LugarRepository lugaresRepository= new LugarRepository();
		Lugar lugar = new Lugar(nombre,telefono,coordenadas,propietario,3,descripcion);
		lugaresRepository.ActualizarDatos(lugar);
	}
	public void EliminarLugar(String coordenadas) throws Exception{
		LugarRepository lugaresRepository= new LugarRepository();
		lugares.clear();
		
		Lugar lugar = this.consultarLugares("ubicacion", coordenadas).get(0);
		System.out.println("ELIMINR LUGAR COORDE: "+lugar.getCoordenadas());
		lugaresRepository.eliminarLugar(lugar);
	}
	public void RegistrarLugar(int id,String nombre,int telefono,String coordenadas,String propietario,int categoria,String descripcion) throws Exception{
		LugarRepository lugaresRepository= new LugarRepository();
		Lugar lugar = new Lugar(nombre,telefono,coordenadas,propietario,categoria,descripcion);
		lugaresRepository.registrarLugar(lugar);
	}
	public void agregarFavorito(String coordenadas) throws Exception{
		LugarRepository lugaresRepository= new LugarRepository();
		lugares.clear();
		Lugar lugar = this.consultarLugares("ubicacion", coordenadas).get(0);
		Usuario usuario = (Usuario) this.persona;
		usuario.agregarFavorito(lugar);
	}

}
