package Negocio.registro_y_actualizacion_de_datos;
	
	
public class Usuario {
	private String email;
	private String password;
	private String nombre;
	private String gps="no";
	private String coordenadas;
	public Usuario(String email, String password, String nombre) {
		// TODO Auto-generated constructor stub
		this.email=email;
		this.password=password;
		this.nombre=nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public String getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}
}
