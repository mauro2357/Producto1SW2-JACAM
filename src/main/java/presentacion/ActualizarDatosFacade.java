package presentacion;

import Negocio.busquedadelugaresporelusuario.Lugar;
import datos.LugaresRepository;

public class ActualizarDatosFacade {

	public ActualizarDatosFacade(String nombre,int telefono,String coordenadas,String propietario,int categoria,String descripcion) throws Exception{
		LugaresRepository lugaresRepository= new LugaresRepository();
		Lugar lugar = new Lugar(0,nombre,telefono,coordenadas,propietario,3,descripcion);
		lugaresRepository.ActualizarDatos(lugar);
	}
}
