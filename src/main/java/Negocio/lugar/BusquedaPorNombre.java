package Negocio.lugar;

import java.util.ArrayList;

import datos.LugarRepository;

public class BusquedaPorNombre extends BusquedaDeLugares {
	private String nombre;
	private ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	public BusquedaPorNombre(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre=nombre;
	}

	@Override
	public ArrayList<Lugar> buscar() throws Exception {
		// TODO Auto-generated method stub
		LugarRepository lugarRepository = new LugarRepository();
		this.lugares=lugarRepository.consultarLugaresporNombre(this.nombre);
		
		return this.lugares;
	}

}
