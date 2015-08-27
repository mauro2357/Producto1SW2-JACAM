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
	public int crearUs(String us_email, String us_password, String us_nombre, String us_apellido, String us_sexo){
		if (datos.isEmpty()==false){
			datos.clear();
		}
		String sql = "SELECT * FROM usuario WHERE us_email='"+us_email+"'";
		hacer.consultar(sql);
		datos=hacer.getColumnData();
		if(datos.isEmpty()==true){
			System.out.println("bien");
			String sqll = "INSERT INTO `usuario`(`us_email`,`us_password`,`us_nombre`,`us_apellido`,`us_sexo`) VALUES ('"+us_email+"','"+us_password+"','"+us_nombre+"','"+us_apellido+"','"+us_sexo+"')";
			hacer.ingresar(sqll);
			return 1;
			
		}
		else
			//Mirar si es oportuno guardar los datos del array en variables
			System.out.println("El usuario "+us_email+" ya se encuentra registrado");
			
			return 0;
		
	}
	
}
