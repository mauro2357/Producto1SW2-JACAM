package Negocio.lugar;

import java.util.ArrayList;

import datos.LugarRepository;

public class BusquedaTodos extends BusquedaDeLugares {
	private ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	
	public BusquedaTodos() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public ArrayList<Lugar> buscar() throws Exception {
		// TODO Auto-generated method stub
		LugarRepository lugarRepository = new LugarRepository();
		this.lugares=lugarRepository.consultarTodosLosLugares();
		return this.lugares;
	}

}
