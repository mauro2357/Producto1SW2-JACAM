package presentacion;

import Negocio.busquedadelugaresporelusuario.Lugar;
import datos.LugaresRepository;

public class EliminarLugarFacade {

	public EliminarLugarFacade(String coordenadas, int ide) throws Exception{
		LugaresRepository lugaresRepository= new LugaresRepository();
		Lugar lugar = new Lugar(ide, coordenadas, ide, coordenadas, coordenadas, ide, coordenadas);
		lugaresRepository.eliminarLugar(lugar);
	}
}
