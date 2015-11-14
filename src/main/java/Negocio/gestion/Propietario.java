package Negocio.gestion;

import java.util.ArrayList;

import Negocio.lugar.Consulta;
import Negocio.lugar.Coordenadas;
import Negocio.lugar.Lugar;
import datos.LugarRepository;

public class Propietario extends Persona {
	private String email;
	private String password;
	private String nombre;
	private int telefono;
	private String tipo="propietario";
	public Propietario(String email){
		this.email = email;
	}
	public Propietario(String email,String password,String nombre,int telefono) {
		// TODO Auto-generated constructor stub
		this.email=email;
		this.password=password;
		this.nombre=nombre;
		this.telefono=telefono;
	}
	@Override
	public ArrayList<Lugar> consultarLugar(String forma, String valor) throws Exception {
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		Consulta consulta = new Consulta(forma,valor);
		lugares=consulta.realizarBusqueda();
		return lugares;	
	}
	public void registrarLugar(Lugar lugar) throws Exception{
		LugarRepository lugaresRepository= new LugarRepository();
		lugaresRepository.registrarLugar(lugar);
	}
	public void actualizarLugar(Lugar lugar) throws Exception{
		LugarRepository lugaresRepository= new LugarRepository();
		lugaresRepository.ActualizarDatos(lugar);
	}
	public void eliminarLugar(Lugar lugar){
		LugarRepository lugaresRepository= new LugarRepository();
		System.out.println("ELIMINR LUGAR ID: "+lugar.getId());
		lugaresRepository.eliminarLugar(lugar);
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
