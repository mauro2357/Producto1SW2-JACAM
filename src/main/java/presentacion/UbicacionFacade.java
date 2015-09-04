package presentacion;


import datos.UbicacionRepository;


public class UbicacionFacade {
	
	public static String main() throws Exception{
		UbicacionRepository ubicacionRepository= new UbicacionRepository();
		String x = ubicacionRepository.GPS(null);
		return x;
	}

}
