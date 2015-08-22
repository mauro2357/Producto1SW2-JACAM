package Negocio.Localizacion;

public class ubicacion {
	private String coordenadas;
	private String estado;
	
	public ubicacion(){
		
	}
	public void datos(String estado, String coordenadas){
		
		this.estado=estado;
		this.coordenadas=coordenadas;
		System.out.println(estado);
		System.out.println(coordenadas);
		
	}
	public Boolean gps(){
		if(this.estado== "si"){
			return(true);
		}
		else{
			return(false);
		}
		
	}
	public String estado(){
		boolean esta=this.gps();
		System.out.println(esta);
		if(esta==true){
			return(this.getCoordenadas());
			
		}
		else{
			return(this.getMensaje());
		}
	}

	public String getCoordenadas() {
		// TODO Auto-generated method stub
		return coordenadas;
	}

	public String getMensaje() {
		// TODO Auto-generated method stub
		return "Active el GPS";
	}

}
