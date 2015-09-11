package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Negocio.login.Persona;
import Negocio.login.Usuario;
import Negocio.registro_y_actualizacion_de_datos.Propietario;;

public class PropietarioRepository {
	
	public ArrayList<Propietario> consultarPropietario(Persona persona) throws Exception{
		ArrayList<Propietario> propietarios = new ArrayList<>();
		String email = persona.getEmail();
		String clave = persona.getClave();		
		System.out.println("propietarioRepository :"+email);
		System.out.println("propietarioRepository :"+clave);
		String query = "SELECT pro_nombre, pro_telefono FROM usuarios WHERE pro_email='"+email+"' AND pro_password='"+clave+"'";;		
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;
		    
		    
		    try {
		    	System.out.println("ver1");
		    	con = new ConexionMysql().ObtenerConexion();
		    	st = con.createStatement();
		    	rs = st.executeQuery(query);
			    while (rs.next())
			    {	
			      System.out.println("ver2");
			      String nombre = rs.getString("pro_nombre");
			      String telefono = rs.getString("pro_telefono");	      
			      Propietario propietario = new Propietario(email,nombre,telefono);
			      // print the results
			      propietarios.add(propietario);
			      
			    }
				}catch (Exception e) {
			    	e.printStackTrace();
			    }finally {
				      try {
					        if (rs != null) {
					          rs.close();
					        }
					        if (st != null) {
					          st.close();
					        }
					        if (con != null) {
					          con.close();
					        }
					      } catch (Exception mysqlEx) {
					    	  mysqlEx.printStackTrace();
					      }
			    }	    

		
		
		return propietarios;
	}

}
