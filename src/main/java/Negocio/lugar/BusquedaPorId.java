package Negocio.lugar;

import java.util.ArrayList;

import datos.LugarRepository;

public class BusquedaPorId extends BusquedaDeLugares {
	private String id;
	private ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	public BusquedaPorId(String id) {
		// TODO Auto-generated constructor stub
		this.id=id;
	}
	@Override
	public ArrayList<Lugar> buscar() throws Exception {
		// TODO Auto-generated method stub
		LugarRepository lugarRepository = new LugarRepository();
		this.lugares=lugarRepository.consultarLugaresporId(this.id);
		return this.lugares;
	}
	
}
