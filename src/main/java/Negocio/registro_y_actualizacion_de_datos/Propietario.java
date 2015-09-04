package Negocio.registro_y_actualizacion_de_datos;

import java.util.ArrayList;

import Negocio.busquedadelugaresporelusuario.Lugar;
import presentacion.*;

public class Propietario {
	
	public String email;
	public String nombre;
	public String telefono;
	public ArrayList<Lugar> x;
	
	public Propietario(String email, String nombre, String telefono) {
		this.email = email;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public Propietario() {
		// TODO Auto-generated constructor stub
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public String getNombre() {
		return nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	
	public void crearPerfil() {
		// TODO Auto-generated method stub
		
	}
}
