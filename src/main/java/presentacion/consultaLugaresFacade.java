package presentacion;

import java.util.ArrayList;

import Negocio.busquedadelugaresporelusuario.Lugar;
import datos.LugaresRepository;

public class consultaLugaresFacade {
	public ArrayList<Lugar> main() throws Exception{
		LugaresRepository lugaresRepository= new LugaresRepository();
		ArrayList<Lugar> x = lugaresRepository.consultarLugaresporCoordenadas ();
		return x;
	}
}
