package presentacion;

import Negocio.busquedadelugaresporelusuario.Lugar;
import datos.LugarRepository;

public class ActualizaDatosFacade {

	public ActualizaDatosFacade(int id,String nombre,int telefono,String coordenadas,String propietario,int categoria,String descripcion) throws Exception{
		LugarRepository lugaresRepository= new LugarRepository();
		Lugar lugar = new Lugar(id,nombre,telefono,coordenadas,propietario,3,descripcion);
		lugaresRepository.ActualizarDatos(lugar);
	}
}
