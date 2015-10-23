package Negocio.registro_y_actualizacion_de_datos;

import Negocio.login.Persona;

public class Ppersona extends Persona {
	private String email;
	private String password;
	private String nombre;
	private String tipo;
	public Ppersona(String email,String password,String nombre,String tipo) {
		// TODO Auto-generated constructor stub
		this.email=email;
		this.password=password;
		this.nombre=nombre;
		this.tipo=tipo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave(){
		return password;
	}
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}public String getTipo() {
		return tipo;
	}public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public void setClave(String clave) {
		// TODO Auto-generated method stub
		
	}
	
}
