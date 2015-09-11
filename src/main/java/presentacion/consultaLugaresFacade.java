package presentacion;

import java.util.ArrayList;

import Negocio.busquedadelugaresporelusuario.Lugar;
import datos.LugaresRepository;

public class consultaLugaresFacade {
	public consultaLugaresFacade() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Lugar> consultarLugarPorNombre(String nombre) throws Exception{
		LugaresRepository lugRepository =  new LugaresRepository();
		ArrayList<Lugar> lugares = lugRepository.consultarLugaresporNombre(nombre);
		return lugares;
	}
	public ArrayList<Lugar> consultarLugarPorCategorias(String categoria) throws Exception{
		LugaresRepository lugRepository =  new LugaresRepository();
		ArrayList<Lugar> lugares = lugRepository.consultarLugaresporCategoria(categoria);
		for (int i=0;i<lugares.size();i++){
			System.out.println("nombre: "+lugares.get(i).getNombre());
			System.out.println("coordenadas: "+lugares.get(i).getCoordenadas());
			System.out.println("tel: "+lugares.get(i).getTelefono());
			System.out.println("descripcion: "+lugares.get(i).getDescripcion());
			System.out.println("catenomb: "+lugares.get(i).getCatenom());
		}
		return lugares;
		}
	public ArrayList<Lugar> consultarLugarPorCoordenadas(String coordenadas) throws Exception{
		LugaresRepository lugRepository =  new LugaresRepository();
		ArrayList<Lugar> lugares = lugRepository.consultarLugaresporCoordenadas(coordenadas);
		return lugares;
	}
	public ArrayList<Lugar> consultarTodosLugares() throws Exception{
		LugaresRepository lugRepository =  new LugaresRepository();
		ArrayList<Lugar> lugares = lugRepository.consultarTodosLosLugares();
		return lugares;
		}
	
}
