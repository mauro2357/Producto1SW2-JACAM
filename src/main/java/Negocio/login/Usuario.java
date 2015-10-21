package Negocio.login;

import java.util.ArrayList;

import Negocio.busquedadelugaresporelusuario.Lugar;
import presentacion.consultaLugaresFacade;

<<<<<<< HEAD
public class Usuario extends Persona {
=======
public class Usuario extends Persona{
>>>>>>> origin/master
	
	public String email;
	public String nombre;
	public String gps;
	public String coordenadas;
<<<<<<< HEAD
	public String tipo= "usuario";
	public Usuario(String email, String nombre, String gps, String coordenadas) {
		this.email = email;
=======
	public String clave;
	
	public Usuario(String email, String clave,String nombre, String gps, String coordenadas) {
		super(email,clave);
>>>>>>> origin/master
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
<<<<<<< HEAD
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
=======
	public void login() {
		// TODO Auto-generated method stub
		
	}
>>>>>>> origin/master
}
