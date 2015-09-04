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
	public ArrayList<Usuario> consultarUsuario(Persona persona) throws Exception{
		ArrayList<Usuario> usuarios = new ArrayList<>();
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
		      Usuario usuario = new Usuario(email,nombre,gps,coordenadas);
		      // print the results
		      usuarios.add(usuario);
		      
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
		    return usuarios;
	}
}