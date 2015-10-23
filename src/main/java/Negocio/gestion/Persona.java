package Negocio.gestion;
import java.util.ArrayList;

import Negocio.lugar.Lugar;
import presentacion.LogInFacade;
public abstract class Persona {
	public String email;
	public String clave;
	public String tipo;
	/*public Persona(String email,String clave){
		this.email = email;
		this.clave = clave;
	}*/
	public abstract ArrayList<Lugar> consultarLugar(String forma, String Valor) throws Exception;
	public abstract String getEmail();
	public abstract String getNombre();
	public abstract void setNombre(String email);
	public abstract String getClave();
	public abstract void setClave(String clave);
	public abstract String getTipo();
}
