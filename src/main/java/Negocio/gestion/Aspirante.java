package Negocio.gestion;

import java.util.ArrayList;

import Negocio.lugar.Lugar;

public class Aspirante extends Persona {
	private String email;
	private String password;
	private String nombre;
	private String tipo;
	public Aspirante(String email,String password,String nombre,String tipo) {
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
	@Override
	public ArrayList<Lugar> consultarLugar(String forma, String Valor) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
