package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Negocio.busquedadelugaresporelusuario.Lugar;
import Negocio.login.Persona;
import Negocio.login.Usuario;

public class UsuariosRepository {
	public Usuario consultarUsuario(Persona persona){
		
		String email = persona.getEmail();
		String clave = persona.getClave();		
		System.out.println("usuarioRepository :"+email);
		System.out.println("usuarioRepository :"+clave);
		//Connection con = new ConexionMysql().ObtenerConexion();
		String query = "SELECT usu_nombre, usu_gps, usu_coordenas FROM usuarios WHERE usu_email='"+email+"' AND usu_password='"+clave+"'";;		
		//"SELECT usu_nombre, usu_gps, usu_coordenas FROM usuarios WHERE usu_email='"+us_email+"' AND usu_password='"++"'";
		// create the java statement
	    //Statement st = con.createStatement();	     
	    // execute the query, and get a java resultset
	    System.out.println(query);
	    //ResultSet rs = st.executeQuery(query);
	    Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	    Usuario usuario=null;
	    
	    
	    try {
	    	System.out.println("ver1");
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query);
		    while (rs.next())
		    {	
		      System.out.println("ver2");
		      String nombre = rs.getString("usu_nombre");
		      String gps = rs.getString("usu_gps");
		      String coordenadas = rs.getString("usu_coordenas");	      
		      usuario = new Usuario(email,nombre,gps,coordenadas);
		      // print the results
		      
		      
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
		    return usuario;
	}
	public void registrarUsuario(Lugar lugar) throws Exception{
		int id = lugar.getId();
		String nombre = lugar.getNombre();
		int telefono = lugar.getTelefono();
		String coordenadas = lugar.getCoordenadas();
		String email = lugar.getEmail();
		int categoria = lugar.getCategoria();
		String descripcion = lugar.getDescripcion();
		//Connection con = new ConexionMysql().ObtenerConexion();
		String query = "INSERT INTO lugar (`lug_id`, `lug_nombre`, `lug_telefono`, `lug_coordenadas`, `pro_email`, `cat_id`, `lug_descripcion`) VALUES ('"+id+"', '"+nombre+"', '"+telefono+"', '"+coordenadas+"', '"+email+"', '"+categoria+"', '"+descripcion+"')";	
		System.out.println(query);
	    // create the java statement
	    // execute the query, and get a java resultset
	    //int rs = st.executeUpdate(query);
	    Statement stmt = null;
	    Connection con = null;
	    int rs;
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
				
	}
}