package presentacion;

import datos.lugaresRepository;

public class RegistrarLugarFacade {
	public static void main(String[]args) throws Exception{
		lugaresRepository lugaresRepository= new lugaresRepository();
		lugaresRepository.registrarLocal(1232, "view", 5333333, "555.336.687", 1040045483 , 1, "Pasa");;
	}
}
