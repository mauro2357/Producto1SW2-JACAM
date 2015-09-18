package presentacion;

import Negocio.busquedadelugaresporelusuario.Lugar;
import datos.LugarRepository;

public class EliminaLugarFacade {

	public EliminaLugarFacade(String coordenadas, int ide) throws Exception{
		LugarRepository lugaresRepository= new LugarRepository();
		Lugar lugar = new Lugar(ide, coordenadas, ide, coordenadas, coordenadas, ide, coordenadas);
		lugaresRepository.eliminarLugar(lugar);
	}
}
