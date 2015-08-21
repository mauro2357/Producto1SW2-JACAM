package Negocio.busquedadelugaresporelusuario;

import java.util.ArrayList;

import Negocio.busquedadelugaresporelusuario.Lugar;

public class Usuario {
	
	Lugar lugares;
	public void consultarlugares() {
		// TODO Auto-generated method stub
		
	}

	public String getMensaje() {
		// TODO Auto-generated method stub
		return "No existe el lugar";
	}

	public ArrayList<Lugar> getLugares() {
		// TODO Auto-generated method stub
		
		ArrayList b = new ArrayList();
		lugares  = new Lugar("Toscana", "descripcion","coordenadas");
		b.add(lugares);
	
		return b;
	}
}
