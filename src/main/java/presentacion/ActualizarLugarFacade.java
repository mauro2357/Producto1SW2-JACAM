package presentacion;

import Negocio.busquedadelugaresporelusuario.Lugar;
import datos.LugaresRepository;

public class ActualizarLugarFacade {
	public ActualizarLugarFacade(int id,String nombre,int telefono,String coordenadas,String propietario,int categoria,String descripcion) throws Exception{
		LugaresRepository lugaresRepository= new LugaresRepository();
		Lugar lugar = new Lugar(id,nombre,telefono,coordenadas,propietario,3,descripcion);
		lugaresRepository.ActualizarDatos(lugar);
		
	}
	


}
