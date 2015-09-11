package presentacion;
import java.util.ArrayList;

import Negocio.busquedadelugaresporelusuario.Lugar;
import Negocio.login.Persona;
import Negocio.login.Propietario;
import Negocio.login.Usuario;
import datos.UsuariosRepository;
import datos.LugaresRepository;
import datos.PropietariosRepository;
public class LogInFacade {
	public Usuario usario;
	public Propietario propietario;
	/*public ArrayList validar(String email,String clave) throws Exception{
		ArrayList<Object> usuario=new ArrayList();
		usuario=null;
		Usuario usuarioo = this.validarUs(email,clave);
		if (usuarioo==null){
			Propietario propietario=null;
			propietario=this.validarPro(email, clave);
			if (propietario==null){
				return null;
			}
			else{
				usuario.add(propietario);
				return(usuario);
			}
		}
		else{
			usuario.add(usuarioo);
			return(usuario);
			}
	}*/
	public int validarUs(String email,String clave){
		// TODO Auto-generated method stub	
		UsuariosRepository usuariosRepository = new UsuariosRepository();
		Persona persona = new Persona(email,clave);
		Usuario usuario = usuariosRepository.consultarUsuario(persona);
		if (usuario==null){
			System.out.println("No se encontro el propietario");
			return 0;
		}else{
			System.out.println("usuario: "+usuario.getNombre()+" "+usuario.getEmail());
			return 1;
		}
	}
	public int validarPro(String email,String clave){
		PropietariosRepository propietariosRepository = new PropietariosRepository();
		Persona persona= new Persona(email,clave);
		Propietario propietario=propietariosRepository.ConsultarPropietario(persona);
		if (propietario==null){
			System.out.println("No se encontro el propietario");
			return 0;
		}else{
			System.out.println("Propietario: "+propietario.getNombre()+" "+propietario.getEmail());
			return 1;
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

