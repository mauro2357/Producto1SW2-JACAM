package Negocio.login;

public class Propietario extends Persona {
	private String email;
	private String clave;
	private String nombre;
	private int telefono;
	private String tipo="propietario";
	
	public Propietario(String email,String clave,String nombre,int telefono) {
		// TODO Auto-generated constructor stub
		super(email, clave);
		this.nombre=nombre;
		this.telefono=telefono;
	}
	public String getEmail() {
		return email;
	}public String getClave() {
		return clave;
	}public String getNombre() {
		return nombre;
	}public int getTelefono() {
		return telefono;
	}public void setEmail(String email) {
		this.email = email;
	}public void setNombre(String nombre) {
		this.nombre = nombre;
	}public void setClave(String clave) {
		this.clave = clave;
	}public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	@Override
<<<<<<< HEAD
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
=======
	public void login() {
		// TODO Auto-generated method stub
		
	}
>>>>>>> origin/master
}
