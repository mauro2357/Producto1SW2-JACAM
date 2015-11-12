package Negocio.lugar;

import java.util.ArrayList;

import datos.LugarRepository;

public class BusquedaPorFavoritos extends BusquedaDeLugares {
	private String email;
	private ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	public BusquedaPorFavoritos(String email) {
		this.email=email;
	}

	@Override
	public ArrayList<Lugar> buscar() throws Exception {
		LugarRepository lugarRepository = new LugarRepository();
		this.lugares=lugarRepository.consultarLugaresFavoritos(this.email);
		System.out.println("BusquedaPorFavoritos.java: arraylugares "+lugares.size());
		return (this.lugares);
	}

}
