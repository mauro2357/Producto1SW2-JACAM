package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Negocio.login.Persona;
import Negocio.login.Propietario;
import Negocio.login.Usuario;

public class PropietariosRepository {
	public Propietario ConsultarPropietario(Persona persona){
		String correo=persona.getEmail();
		String password=persona.getClave();
		System.out.println("usuarioRepository :"+correo);
		System.out.println("usuarioRepository :"+password);
		//Connection con = new ConexionMysql().ObtenerConexion();
		String query = "SELECT * FROM propietario WHERE pro_email='"+correo+"' AND pro_password='"+password+"'";	
		//"SELECT usu_nombre, usu_gps, usu_coordenas FROM usuarios WHERE usu_email='"+us_email+"' AND usu_password='"++"'";
		// create the java statement
	    //Statement st = con.createStatement();	     
	    // execute the query, and get a java resultset
	    System.out.println(query);
	    //ResultSet rs = st.executeQuery(query);
	    Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	    Propietario propietario=null;
	    try {
	    	System.out.println("ver1");
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query);
		    while (rs.next())
		    {	
		      System.out.println("ver2");
		      String email = rs.getString("pro_email");
		      String pass=rs.getString("pro_password");
		      String nombre = rs.getString("pro_nombre");
		      int telefono = rs.getInt("pro_telefono");      
		      propietario = new Propietario(email,pass,nombre,telefono);
		      
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
		    return propietario;
		
	}
}
