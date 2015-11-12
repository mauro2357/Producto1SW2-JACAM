package presentacion;

import Negocio.gestion.Aspirante;
import Negocio.gestion.Persona;
import Negocio.gestion.Propietario;
import datos.PropietarioRepository;
import datos.UsuarioRepository;
import datos.ValidarRepository;

public class RegistroFacade {
	
	ValidarRepository gestion;
	
	public RegistroFacade() {
		gestion= new ValidarRepository();
	}

	public String verificar(String email){
		String correo=gestion.consultarEmail(email);
		return correo;
	}
	public Persona registrar(String email,String password,String nombre,String tipo){
		String correo=this.verificar(email);
		int existe=0;
		Persona persona=null;
		if (correo!=null){
			existe=0;
			System.out.println("existe correo para registo: "+existe);
		}
		else{
			persona = new Aspirante(email,password,nombre,tipo);
			existe=gestion.registrar(persona);
			System.out.println("no existe correo para registo: "+existe);
		}
		return(persona);
		
	}
}
