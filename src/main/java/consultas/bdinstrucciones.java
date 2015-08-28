package consultas;

import java.util.ArrayList;

import datos.conexionMysql;

public class bdinstrucciones {
	
	conexionMysql hacer = new conexionMysql();
	private ArrayList<String> datos = new ArrayList<String>();	
	public bdinstrucciones() {
		// TODO Auto-generated constructor stub
	}
	public int validarUs(String us_email, String us_password){
		if (datos.isEmpty()==false){
			datos.clear();
		}		
		String sql = "SELECT * FROM usuarios WHERE usu_email='"+us_email+"' AND usu_password='"+us_password+"'";
		System.out.println("validarUS "+us_email+" "+us_password+" "+sql);
		hacer.consultar(sql);
		datos=hacer.getColumnData();
		if(datos.isEmpty()==true){
			String sql2 = "SELECT * FROM propietario WHERE pro_email='"+us_email+"' AND pro_password='"+us_password+"'";
			System.out.println("entro al otro "+sql2);
			hacer.consultar(sql2);
			datos=hacer.getColumnData();
			if(datos.isEmpty()==true){
				return 0;
			}			
			else{
				System.out.println("COORRECTOOOO");				
				return 1;
			}
			
		}
		else
			//Mirar si es oportuno guardar los datos del array en variables
			System.out.println("COORRECTOOOO");
			
			return 1;
		
	}
	public int crearUs(String usu_email, String usu_password, String usu_nombre){
		if (datos.isEmpty()==false){
			datos.clear();
		}
		String gps = "no";
		String sql = "SELECT * FROM usuarios WHERE usu_email='"+usu_email+"'";
		hacer.consultar(sql);
		datos=hacer.getColumnData();
		if(datos.isEmpty()==true){
			System.out.println("bien");
			String sqll = "INSERT INTO `usuarios`(`usu_email`,`usu_nombre`,`usu_gps`,`usu_password`) VALUES ('"+usu_email+"','"+usu_nombre+"','"+gps+"','"+usu_password+"')";
			System.out.println(sqll);
			hacer.ingresar(sqll);
			return 1;
			
		}
		else
			//Mirar si es oportuno guardar los datos del array en variables
			System.out.println("El usuario "+usu_email+" ya se encuentra registrado");			
			return 0;		
	}
	public int crearPr(String pro_email, String pro_nombre, String pro_password){
		if (datos.isEmpty()==false){
			datos.clear();
		}
		String sql = "SELECT * FROM propietario WHERE pro_email='"+pro_email+"'";
		hacer.consultar(sql);
		datos=hacer.getColumnData();
		if(datos.isEmpty()==true){
			System.out.println("bien");
			String sqll = "INSERT INTO `propietario`(`pro_email`,`pro_nombre`,`pro_password`) VALUES ('"+pro_email+"','"+pro_nombre+"','"+pro_password+"')";
			hacer.ingresar(sqll);
			return 1;
			
		}
		else
			//Mirar si es oportuno guardar los datos del array en variables
			System.out.println("El usuario "+pro_email+" ya se encuentra registrado");			
			return 0;		
	}
	
	public ArrayList<String> recibir(String tipo){
		if (datos.isEmpty()==false){
			datos.clear();
		}		
		String sql = "SELECT lug_nombre as Lugares,lug_coordenadas as Coordenadas From lugar natural join categorias WHERE cat_nombre='"+tipo+"'";
		hacer.consultar(sql);
		datos=hacer.getColumnData();
		return datos;
	}
	
}
