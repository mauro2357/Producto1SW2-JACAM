package presentacion;

import Negocio.login.Propietario;
import Negocio.registro_y_actualizacion_de_datos.Ppersona;
import datos.PropietarioRepository;
import datos.UsuarioRepository;

public class RegistroFacade {
	public RegistroFacade() {
		// TODO Auto-generated constructor stub
	}
	public int registrarUsuario(String email,String password,String nombre){
		int bien;
		LogInFacade verificar = new LogInFacade();
		int siPro=verificar.validarPro(email, password);
		int siUs=verificar.validarUs(email,password);
		if (siPro==1 && siUs==1){
			bien=0;
			return bien;
		}
		else{
			Ppersona persona = new Ppersona(email,password,nombre);
			UsuarioRepository usuariosRepo = new UsuarioRepository();
			bien=usuariosRepo.registrarUsuario(persona);
			return bien;
		}
	}
	public int registrarPropietario(String email,String password,String nombre){
		int bien;
		LogInFacade verificar = new LogInFacade();
		int siPro=verificar.validarPro(email, password);
		int siUs=verificar.validarUs(email,password);
		if (siPro==1 && siUs==1){
			bien=0;
			return bien;
		}
		else{
			Ppersona persona = new Ppersona(email,password,nombre);
			PropietarioRepository propietarioRepo = new PropietarioRepository();
			bien=propietarioRepo.registrarPropietario(persona);
			return bien;
		}
		
	}
}
