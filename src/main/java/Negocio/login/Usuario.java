package Negocio.login;

import java.util.ArrayList;

import Negocio.busquedadelugaresporelusuario.Lugar;
import presentacion.consultaLugaresFacade;

public class Usuario extends Persona {
	
	public String email;
	public String nombre;
	public String gps;
	public String coordenadas;
	public String tipo= "usuario";
	public Usuario(String email, String nombre, String gps, String coordenadas) {
		this.email = email;
		this.nombre = nombre;
		this.gps = gps;
		this.coordenadas = coordenadas;
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
