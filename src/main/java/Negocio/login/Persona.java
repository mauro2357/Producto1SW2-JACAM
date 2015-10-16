package Negocio.login;
import presentacion.LogInFacade;
public abstract class Persona {
	public String email;
	public String clave;
	public Persona(String email,String clave){
		this.email = email;
		this.clave = clave;
	}
	public String getEmail() {
		return email;
	}
	public void setNombre(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public  void login(){
		
	}
}
