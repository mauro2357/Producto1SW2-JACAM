package presentacion;

import Negocio.busquedadelugaresporelusuario.Lugar;
import datos.LugaresRepository;

public class RegistrarLugarFacade {
	/*public RegistrarLugarFacade(int id,String nombre,int telefono,String coordenadas,String propietario,int categoria,String descripcion) throws Exception{
		lugaresRepository lugaresRepository= new lugaresRepository();
		Lugar lugar = new Lugar(id,nombre,telefono,coordenadas,propietario,categoria,descripcion);
		lugaresRepository.registrarLugar(lugar);
	}*/
	public RegistrarLugarFacade(int id,String nombre,int telefono,String coordenadas,String propietario,int categoria,String descripcion) throws Exception{
		LugaresRepository lugaresRepository= new LugaresRepository();
		Lugar lugar = new Lugar(id,nombre,telefono,coordenadas,propietario,categoria,descripcion);
		lugaresRepository.registrarLugar(lugar);
	}


}
