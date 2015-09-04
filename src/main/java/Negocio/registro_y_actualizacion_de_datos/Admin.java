package Negocio.registro_y_actualizacion_de_datos;

import java.util.ArrayList;
import Negocio.registro_y_actualizacion_de_datos.Propietario;
public class Admin {
	
	ArrayList<Propietario> listaclientes = new ArrayList<Propietario>();
	//Lista de clientes.
	
	public String registrar_clientes(Propietario propietario) { //se valida el cliente y se registra
		Propietario x = new Propietario();
		listaclientes.add(x);
		return "Cliente registrado";

	}
	
	public boolean consulta_cliente(){
		return true; //if(objeto cliente existe en el array) return true
	}

}
