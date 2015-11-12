package presentacion;
import java.util.ArrayList;

import Negocio.gestion.Persona;
import Negocio.gestion.Propietario;
import Negocio.gestion.Usuario;
import Negocio.lugar.Lugar;
import datos.UsuarioRepository;
import datos.ValidarRepository;
import datos.LugarRepository;
import datos.PropietarioRepository;
public class LogInFacade {
	public Usuario usario;
	public Propietario propietario;
	
	public Persona validar(String email,String clave){
		System.out.println("Vamos en el facade");
		ValidarRepository validarRepository = new ValidarRepository();
		Persona persona=validarRepository.consultarPersona(email, clave);
		//System.out.println(persona.getTipo());
		return persona;
		
	}	
}

