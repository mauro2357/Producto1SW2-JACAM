package Negocio.registro_y_actualizacion_de_datos;

import java.util.ArrayList;


public class Admin {
	
	ArrayList<Propietario> listaclientes = new ArrayList<Propietario>();
	//Lista de clientes.
	
	public String registrar_clientes() { //se valida el cliente y se registra
		Propietario propietario = new Propietario();
		listaclientes.add(propietario);
		return "Cliente registrado";

	}
	
	public boolean consulta_cliente(){
		return true; //if(objeto cliente existe en el array) return true
	}

}
