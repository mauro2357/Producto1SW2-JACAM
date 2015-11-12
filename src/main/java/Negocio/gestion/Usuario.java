package Negocio.gestion;

import java.util.ArrayList;

import Negocio.lugar.Consulta;
import Negocio.lugar.Lugar;
import datos.LugarRepository;
import presentacion.consultaLugaresFacade;

public class Usuario extends Persona {
	
	public String email;
	public String nombre;
	public String gps;
	public String coordenadas;
	public final String tipo= "usuario";
	
	public Usuario(String email, String nombre, String gps, String coordenadas) {
		this.email = email;
		this.nombre = nombre;
		this.gps = gps;
		this.coordenadas = coordenadas;
	}
	public ArrayList<Lugar> consultarLugar(String forma, String valor) throws Exception{
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		Consulta consulta = new Consulta(forma,valor);
		lugares=consulta.realizarBusqueda();
		System.out.println("Usuario.java: arraylugares "+lugares.size());
		return lugares;	
	}
	public void agregarFavorito(Lugar lugar){
		LugarRepository lugarRepository=new LugarRepository();
		lugarRepository.RegistroFavorito(this.email, lugar);
		
	}
	public void quitarFavorito(Lugar lugar){
		LugarRepository lugarRepository=new LugarRepository();
		lugarRepository.quitarFavorito(this.email, lugar);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	@Override
	public String getClave() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setClave(String clave) {
		// TODO Auto-generated method stub
	}
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}
	
}
