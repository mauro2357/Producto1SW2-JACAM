package Negocio.login;
import presentacion.LogInFacade;
public abstract class Persona {
	public String email;
	public String clave;
	public String tipo;
	/*public Persona(String email,String clave){
		this.email = email;
		this.clave = clave;
<<<<<<< HEAD
	}*/
	public abstract String getEmail();
	public abstract String getNombre();
	public abstract void setNombre(String email);
	public abstract String getClave();
	public abstract void setClave(String clave);
	public abstract String getTipo();
=======
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
>>>>>>> origin/master
}
