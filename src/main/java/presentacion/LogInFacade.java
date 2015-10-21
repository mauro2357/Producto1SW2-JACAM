package presentacion;
import java.util.ArrayList;

import Negocio.busquedadelugaresporelusuario.Lugar;
import Negocio.login.Persona;
import Negocio.login.Propietario;
import Negocio.login.Usuario;
import datos.ValidarRepository;
import datos.LugarRepository;
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

