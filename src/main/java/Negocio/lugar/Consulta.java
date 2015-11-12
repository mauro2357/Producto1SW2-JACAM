package Negocio.lugar;

import java.util.ArrayList;

public class Consulta {
	private String forma;
	private String valor;
	private Coordenadas coordenadas;
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
				String[] vec= valor.split(" ");
				System.out.println("CASE UBICACION: latitud: "+vec[0]+" longitud: "+vec[1]);
				coordenadas = new Coordenadas(vec[0],vec[1]);
				this.buscar = new BusquedaPorUbicacion(coordenadas);
				this.lugares=this.buscar.buscar();
				break;
			case "todos":
				this.buscar = new BusquedaTodos();
				this.lugares=this.buscar.buscar();
				break;
			case "propietario":
				this.buscar = new BusquedaPorPropietario(valor);
				this.lugares=this.buscar.buscar();
				break;
			case "favoritos":
				this.buscar= new BusquedaPorFavoritos(valor);
				this.lugares=this.buscar.buscar();
				break;
			case "id":
				this.buscar=new BusquedaPorId(valor);
				this.lugares=this.buscar.buscar();
				break;
				
		}
		System.out.println("Consulta.java: arraylugares "+lugares.size());
		return (this.lugares);
	}
}
