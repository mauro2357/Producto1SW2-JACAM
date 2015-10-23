package presentacion;

import Negocio.busquedadelugaresporelusuario.Lugar;
import Negocio.busquedadelugaresporelusuario.Usuario;
import datos.LugarRepository;

public class RegistroFavoritoFacade {
	public RegistroFavoritoFacade(int id, String email) throws Exception{
		LugarRepository lugaresRepository=new LugarRepository();
		Lugar lugar = new Lugar(id);
		//lugaresRepository.ActualizarDatos(lugar);
		Usuario usuario=new Usuario(email);
		lugaresRepository.RegistroFavorito(usuario, lugar);
		
	}

}
