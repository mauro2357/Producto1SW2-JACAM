package presentacion;

import Negocio.busquedadelugaresporelusuario.Lugar;
import datos.LugarRepository;

public class ActualizaDatosFacade {

	public ActualizaDatosFacade(String nombre,int telefono,String coordenadas,String propietario,int categoria,String descripcion) throws Exception{
		LugarRepository lugaresRepository= new LugarRepository();
		Lugar lugar = new Lugar(0,nombre,telefono,coordenadas,propietario,3,descripcion);
		lugaresRepository.ActualizarDatos(lugar);
	}
}
