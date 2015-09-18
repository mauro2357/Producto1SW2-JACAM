package presentacion;

import Negocio.busquedadelugaresporelusuario.Lugar;
import datos.LugarRepository;

public class RegistroLugarFacade {
	/*public RegistrarLugarFacade(int id,String nombre,int telefono,String coordenadas,String propietario,int categoria,String descripcion) throws Exception{
		lugaresRepository lugaresRepository= new lugaresRepository();
		Lugar lugar = new Lugar(id,nombre,telefono,coordenadas,propietario,categoria,descripcion);
		lugaresRepository.registrarLugar(lugar);
	}*/
	public RegistroLugarFacade(int id,String nombre,int telefono,String coordenadas,String propietario,int categoria,String descripcion) throws Exception{
		LugarRepository lugaresRepository= new LugarRepository();
		Lugar lugar = new Lugar(id,nombre,telefono,coordenadas,propietario,categoria,descripcion);
		lugaresRepository.registrarLugar(lugar);
	}


}
