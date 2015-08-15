package presentacion;

import datos.lugaresRepository;

public class consultaLugaresFacade {
	
	public static void main(String[]args) throws Exception{
		lugaresRepository lugaresRepository= new lugaresRepository();
		System.out.println(lugaresRepository.consultarLugaresporCoordenadas());
	}
}
