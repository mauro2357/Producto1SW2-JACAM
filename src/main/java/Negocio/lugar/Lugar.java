package Negocio.lugar;

import Negocio.gestion.Propietario;

public class Lugar {
	private String nombre;
	private String descripcion;
	private String coordenadas;
	private Propietario propietario;
	private int telefono;
	private int categoria;
	private String catenom;
	private int id;
	private String email;
	public String getEmail() {
		return email;
	}
	public Lugar(int id) {
		// TODO Auto-generated constructor stub
		this.id=id;
	}
	public Lugar(String nombre,int telefono,String coordenadas,String email,int categoria,String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.coordenadas = coordenadas;
		this.propietario = propietario;
		this.email = email;
		this.telefono = telefono;
		this.categoria = categoria;
		this.id = id;
	}
	public Lugar(int id,String nombre,String coordenadas,int telefono,String descripcion,String catenom) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.coordenadas = coordenadas;
		this.propietario = propietario;
		this.email = email;
		this.telefono = telefono;
		this.categoria = categoria;
		this.id = id;
	}
	public Lugar(String nombre,String coordenadas,int telefono,String descripcion,String catenom ){
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.coordenadas=coordenadas;
		this.telefono=telefono;
		this.catenom=catenom;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	public String getCatenom() {
		return catenom;
	}
	public void setCatenom(String catenom) {
		this.catenom = catenom;
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
		String a = "descripcion";
		return a;
	}

 }

