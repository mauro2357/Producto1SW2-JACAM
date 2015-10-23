package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Negocio.login.Persona;
import Negocio.login.Propietario;
import Negocio.login.Usuario;

public class LogInRepository {
	public Persona logIn(Persona persona){
		String email = persona.getEmail();
		String clave = persona.getClave();
		String query_propietario = "SELECT * FROM propietario WHERE pro_email='"+email+"' AND pro_password='"+clave+"'";
		String query_usuarios = "SELECT usu_nombre, usu_gps, usu_coordenas FROM usuarios WHERE usu_email='"+email+"' AND usu_password='"+clave+"'";;
	    Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	    Persona personar = null;
	    try {
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query_propietario);
	    	if(rs!=null){
	    		while (rs.next())
	    			{	
	    				String correo = rs.getString("pro_email");
	    				String pass=rs.getString("pro_password");
	    				String nombre = rs.getString("pro_nombre");
	    				int telefono = rs.getInt("pro_telefono");      
	    				personar = new Propietario(email,pass,nombre,telefono);
		      
		    }
	    	}
	    	else{
	    		rs = st.executeQuery(query_usuarios);
	    		while (rs.next())
    			{	
	    		  String nombre = rs.getString("usu_nombre");
	    		  String pass = rs.getString("usu_password");
	   		      String gps = rs.getString("usu_gps");
	   		      String coordenadas = rs.getString("usu_coordenas");	      
	   		      personar = new Usuario(email,pass,nombre,gps,coordenadas);
	      
    			}
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
	    return personar;
	}
}