package presentacion;

import java.util.ArrayList;

import Negocio.busquedadelugaresporelusuario.Lugar;
import datos.LugaresRepository;

public class consultaLugaresFacade {
	public static void  main(String[] args) throws Exception{
		LugaresRepository lugaresRepository= new LugaresRepository();
		ArrayList<Lugar> x = lugaresRepository.consultarLugaresporCategoria("Restaurantes");
		if(x.isEmpty()){
			System.out.println("No se encontro el lugar");
		}else{
			for(int i=0;i<x.size();i++){
				System.out.println(x.get(i).getNombre());
			}	
		}
	}
}
