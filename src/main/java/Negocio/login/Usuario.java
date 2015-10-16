package Negocio.login;

import java.util.ArrayList;

import Negocio.busquedadelugaresporelusuario.Lugar;
import presentacion.consultaLugaresFacade;

public class Usuario extends Persona{
	
	public String email;
	public String nombre;
	public String gps;
	public String coordenadas;
	public String clave;
	
	public Usuario(String email, String clave,String nombre, String gps, String coordenadas) {
		super(email,clave);
		this.nombre = nombre;
		this.gps = gps;
		this.coordenadas = coordenadas;
	}	
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
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
	public void login() {
		// TODO Auto-generated method stub
		
	}
}
