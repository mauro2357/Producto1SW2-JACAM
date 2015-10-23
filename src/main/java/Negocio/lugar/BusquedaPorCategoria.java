package Negocio.lugar;

import java.util.ArrayList;

import datos.LugarRepository;

public class BusquedaPorCategoria extends BusquedaDeLugares {
	private ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	private String categoria;
	public BusquedaPorCategoria(String categoria) {
		// TODO Auto-generated constructor stub
		this.categoria=categoria;
	}
	@Override
	public ArrayList<Lugar> buscar() throws Exception {
		// TODO Auto-generated method stub
		LugarRepository lugarRepository = new LugarRepository();
		this.lugares=lugarRepository.consultarLugaresporCategoria(this.categoria);
		
		return this.lugares;
	}

}
