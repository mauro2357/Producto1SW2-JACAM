package Negocio.lugar;

import java.util.ArrayList;

public class Consulta {
	private String forma;
	private String valor;
	BusquedaDeLugares buscar;
	ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	
	public Consulta(String forma,String valor){
		this.forma=forma;
		this.valor=valor;
	}
	public ArrayList<Lugar> realizarBusqueda() throws Exception{
		switch (this.forma){
			case "nombre":
				this.buscar = new BusquedaPorNombre(valor);
				this.lugares=this.buscar.buscar();
				break;
			case "categoria":
				this.buscar = new BusquedaPorCategoria(valor);
				this.lugares=this.buscar.buscar();
				break;
			case "ubicacion":
				this.buscar = new BusquedaPorUbicacion(valor);
				this.lugares=this.buscar.buscar();
				break;
			case "todos":
				this.buscar = new BusquedaTodos();
				this.lugares=this.buscar.buscar();
				break;
			case "propietario":
				this.buscar = new BusquedaPorPropietario(valor);
				this.lugares=this.buscar.buscar();
				
		}
		return (this.lugares);
	}
}
