package presentacion;


import datos.UbicacionRepository;
import datos.lugaresRepository;


public class UbicacionFacade {
	
	public static void main(String[]args) throws Exception{
		UbicacionRepository ubicacionRepository= new UbicacionRepository();
		System.out.println(ubicacionRepository.GPS("pedro128@hotmail.com"));
	}

}
