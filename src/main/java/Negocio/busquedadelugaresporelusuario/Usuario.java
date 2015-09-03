package Negocio.busquedadelugaresporelusuario;

import java.util.ArrayList;

import Negocio.busquedadelugaresporelusuario.Lugar;
import presentacion.consultaLugaresFacade;

public class Usuario {
	
	public String email;
	public String nombre;
	public String gps;
	public String coordenadas;
	
	public Usuario(String email, String nombre, String gps, String coordenadas) {
		this.email = email;
		this.nombre = nombre;
		this.gps = gps;
		this.coordenadas = coordenadas;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCoordenadas() {
		return coordenadas;
	}
	public String getEmail() {
		return email;
	}
	public String getGps() {
		return gps;
	}
	public String getNombre() {
		return nombre;
	}
	
	public String getMensaje() throws Exception {
		ArrayList<Lugar> x = consultarLugares();
		if(!(x.size()==0)) return "el lugar no existe";
		return "el lugar no existe";
	}
	
	public ArrayList<Lugar> consultarLugares() throws Exception {
		consultaLugaresFacade y = new consultaLugaresFacade();
		ArrayList<Lugar> x = new ArrayList<Lugar>();
		x = y.main();
		return x;
	}
}
