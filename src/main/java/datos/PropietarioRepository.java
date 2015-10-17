package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Negocio.login.Persona;
import Negocio.login.Propietario;
import Negocio.login.Usuario;
import Negocio.registro_y_actualizacion_de_datos.Ppersona;

public class PropietarioRepository {
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
	public int registrarPropietario(Ppersona persona){
		String email = persona.getEmail();
		String pass = persona.getClave();
		String nombre=persona.getNombre();
		//Connection con = new ConexionMysql().ObtenerConexion();
		String query = "INSERT INTO propietario (`pro_email`, `pro_password`, `pro_nombre`) VALUES ('"+email+"', '"+pass+"', '"+nombre+"')";	
		System.out.println(query);
	    // create the java statement
	    // execute the query, and get a java resultset
	    //int rs = st.executeUpdate(query);
	    Statement stmt = null;
	    Connection con = null;
	    int rs=0;
	    //ArrayList<String> columnNames = new ArrayList<String>();
	    

	    try {
	      // Register JDBC driver
	      // Open a connection
	    	con = new ConexionMysql().ObtenerConexion();

	      // Execute SQL query
	      stmt = con.createStatement();
	      rs = stmt.executeUpdate(query);
	      System.out.println("rs: "+rs);
	     System.out.println("al crear: "+rs);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	    finally {
	      try {

	        if (stmt != null) {
	          stmt.close();
	        }
	        if (con != null) {
	          con.close();
	        }
	      } catch (Exception mysqlEx) {
	        mysqlEx.printStackTrace();
	      }
	    }
	    return rs;
	}
}
