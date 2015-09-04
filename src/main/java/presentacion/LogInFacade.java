package presentacion;
import java.util.ArrayList;

import Negocio.busquedadelugaresporelusuario.Lugar;
import Negocio.login.Persona;
import Negocio.login.Usuario;
import datos.UsuariosRepository;
import datos.LugaresRepository;
public class LogInFacade {
	public Usuario usario;
	public Usuario validar(String email,String clave) throws Exception {
		// TODO Auto-generated method stub	
		UsuariosRepository usuariosRepository = new UsuariosRepository();
		Persona persona = new Persona(email,clave);
		ArrayList<Usuario> usuario = usuariosRepository.consultarUsuario(persona);
		if(usuario.isEmpty()){
			System.out.println("No se encontro el usuarios");
			return null;
		}else{
			for(int i=0;i<usuario.size();i++){
				System.out.println("Size: "+usuario.size()+"Nombre22: "+usuario.get(i).getNombre());
			}
			return(usuario.get(0));
		}
	}
	/*public Usuario verificarPersona(String email,String clave) throws Exception{
		ArrayList<Usuario> usuario = new ArrayList<>();
		System.out.println("verificar: "+email+" "+clave);
		Persona persona = new Persona(email, clave);
		System.out.println("PERSONA: "+ persona.getEmail());
		System.out.println("PERSONA: "+ persona.getEmail());
		UsuariosRepository usuariosRepository = new UsuariosRepository();		
		usuario = usuariosRepository.consultarUsuario(persona);
		if(usuario.isEmpty()){
			return null;
		}else{
			System.out.println("biennnnn:"+usuario.get(0).getNombre());
			return (usuario.get(0));
		}
		}*/
	
		
}

