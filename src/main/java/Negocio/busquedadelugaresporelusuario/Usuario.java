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
	public Usuario(String email) {
		this.email = email;
		
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
	
}