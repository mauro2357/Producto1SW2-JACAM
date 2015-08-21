package Negocio.busquedadelugaresporelusuario;

public class Lugar {
	private String nombre;
	private String descripcion;
	private String coordenadas;
	String a;
	
	public Lugar(String nombre,String descripcion, String coordenadas){
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.coordenadas=coordenadas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre;
	}
	public String getInformacion() {
		// TODO Auto-generated method stub
		a = "descripcion";
		return a;

 }
}
