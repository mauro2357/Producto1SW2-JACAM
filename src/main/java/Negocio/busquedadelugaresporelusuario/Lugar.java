package Negocio.busquedadelugaresporelusuario;

public class Lugar {
	String Nombre;
	String descripcion;
	String coordenadas;
	String a;	
		public Lugar( String Nombre, String descripcion,String coordenadas) {
		// TODO Auto-generated constructor stub
		this.Nombre = Nombre;
		this.descripcion = descripcion;
		this.coordenadas=coordenadas;
	}
		public String getNombre() {
			// TODO Auto-generated method stub
			return this.Nombre;
		}

		public String getInformacion() {
			// TODO Auto-generated method stub
			a = "descripcion";
			return a;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return Nombre;
		}
		public String toDescripcion(){
			return descripcion;
		}
		public String toCoordenadas(){
			return coordenadas;
		}


}
