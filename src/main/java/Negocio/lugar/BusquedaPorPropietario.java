package Negocio.lugar;

import java.util.ArrayList;

import Negocio.gestion.Propietario;
import datos.LugarRepository;

public class BusquedaPorPropietario extends BusquedaDeLugares {
	private String email;
	private ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	
	public BusquedaPorPropietario(String email) {
		// TODO Auto-generated constructor stub
		this.email=email;
	}
	@Override
	public ArrayList<Lugar> buscar() throws Exception {
		// TODO Auto-generated method stub
		LugarRepository lugarRepository = new LugarRepository();
		this.lugares=lugarRepository.consultarLugaresPropietario(this.email);
		return this.lugares;
	}

}
