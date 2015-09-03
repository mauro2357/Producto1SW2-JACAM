package presentacion;

import datos.LugaresRepository;

public class RegistrarLugarFacade {
	public static void main(String[]args) throws Exception{
		LugaresRepository lugaresRepository= new LugaresRepository();
		lugaresRepository.registrarLocal(1233, "Pizzetas", 566666, "566.2255.22", 1040045483 , 1, "Pizzas a la orden llevela");;
	}
}
