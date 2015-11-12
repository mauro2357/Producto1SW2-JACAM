package Negocio.lugar;

import Negocio.gestion.Propietario;

public class Lugar {
	private int id;
	private String nombre;
	private String descripcion;
	private Coordenadas coordenadas;
	private String propietario;
	private int telefono;
	private int categoria;
	private String catenom;
	
	
	public Lugar(int id) {
		// TODO Auto-generated constructor stub
		this.id=id;
	}
	public Lugar(int id,String nombre,int telefono,Coordenadas coordenadas,String email,int categoria,String descripcion) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.coordenadas = coordenadas;
		this.propietario = email;
		this.telefono = telefono;
		this.categoria = categoria;
	}
	public Lugar(int id,String nombre,Coordenadas coordenadas,int telefono,String descripcion,String catenom) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.coordenadas = coordenadas;
		this.telefono = telefono;
		this.catenom = catenom;
		this.id = id;
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
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
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
	public Coordenadas getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(Coordenadas coordenadas) {
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

