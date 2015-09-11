package Negocio.login;

public class Propietario {
	private String email;
	private String password;
	private String nombre;
	private int telefono;
	
	public Propietario(String email,String password,String nombre,int telefono) {
		// TODO Auto-generated constructor stub
		this.email=email;
		this.password=password;
		this.nombre=nombre;
		this.telefono=telefono;
	}
	public String getEmail() {
		return email;
	}public String getPassword() {
		return password;
	}public String getNombre() {
		return nombre;
	}public int getTelefono() {
		return telefono;
	}public void setEmail(String email) {
		this.email = email;
	}public void setNombre(String nombre) {
		this.nombre = nombre;
	}public void setPassword(String password) {
		this.password = password;
	}public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}
