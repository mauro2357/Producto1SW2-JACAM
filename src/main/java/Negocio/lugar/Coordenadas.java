package Negocio.lugar;

public class Coordenadas {
	private String latitud;
	private String longitud;
	public Coordenadas(String latitud, String longitud) {
		// TODO Auto-generated constructor stub
		this.latitud=latitud;
		this.longitud=longitud;

	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud=latitud;
	}
	public String getLongitud() {
		return longitud;
	}public void setLongitud(String longitud) {
		this.longitud=latitud;
	}
}
