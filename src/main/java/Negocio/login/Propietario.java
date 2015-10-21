package Negocio.login;

public class Propietario extends Persona {
	private String email;
	private String password;
	private String nombre;
	private int telefono;
	private String tipo="propietario";
	
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
	@Override
	public String getClave() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public void setClave(String clave) {
		this.password=clave;
		
	}
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}
}
