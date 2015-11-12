  package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Negocio.lugar.Coordenadas;
import Negocio.lugar.Lugar;
import Negocio.gestion.Usuario;

public class LugarRepository {
	// our SQL SELECT query. 
    // if you only need a few columns, specify them by name instead of using "*"
	public ArrayList<Lugar> consultarLugaresporId(String id) throws Exception{
		//Connection con = new ConexionMysql().ObtenerConexion();
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String query = "select lug_id,lug_nombre,lug_latitud,lug_longitud,lug_telefono,lug_descripcion,cat_nombre from lugar natural join categorias where lug_id = '"+id+"'";
		
	    // create the java statement
	    //Statement st = con.createStatement();
	     
	    // execute the query, and get a java resultset
	    //ResultSet rs = st.executeQuery(query);
		Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	     
	    // iterate through the java resultset
	    try {
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query);
		    while (rs.next())
		    {
		      int ide = rs.getInt("lug_id");
		      String nombre= rs.getString("lug_nombre");
		      String latitud = rs.getString("lug_latitud");
		      String longitud = rs.getString("lug_longitud");
		      int telefono = rs.getInt("lug_telefono");
		      String descripcion = rs.getString("lug_descripcion");
		      String categorias = rs.getString("cat_nombre");	
		      Coordenadas coordenadas = new Coordenadas(latitud,longitud);
		      Lugar lugar = new Lugar(ide,nombre, coordenadas,telefono,descripcion,categorias);
		      // print the results
		      lugares.add(lugar);
		      
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
		    return lugares;
	 }
	
	public ArrayList<Lugar> consultarLugaresporNombre(String nombre) throws Exception{
	//Connection con = new ConexionMysql().ObtenerConexion();
	ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	String query = "select lug_id,lug_nombre,lug_latitud,lug_longitud,lug_telefono,lug_descripcion,cat_nombre from lugar natural join categorias where lug_nombre = '"+nombre+"'";
	
    // create the java statement
    //Statement st = con.createStatement();
     
    // execute the query, and get a java resultset
    //ResultSet rs = st.executeQuery(query);
	Statement st = null;
    ResultSet rs = null;
    Connection con = null;
     
    // iterate through the java resultset
    try {
    	con = new ConexionMysql().ObtenerConexion();
    	st = con.createStatement();
    	rs = st.executeQuery(query);
	    while (rs.next())
	    {
	      int id = rs.getInt("lug_id");
	      String latitud = rs.getString("lug_latitud");
	      String longitud = rs.getString("lug_longitud");
	      int telefono = rs.getInt("lug_telefono");
	      String descripcion = rs.getString("lug_descripcion");
	      String categorias = rs.getString("cat_nombre");	
	      Coordenadas coordenadas = new Coordenadas(latitud,longitud);
	      Lugar lugar = new Lugar(id,nombre, coordenadas,telefono,descripcion,categorias);
	      // print the results
	      lugares.add(lugar);
	      
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
	    return lugares;
 }
	
	public ArrayList<Lugar> consultarLugaresporCoordenadas(Coordenadas coordenadas) throws Exception{
		//Connection con = new ConexionMysql().ObtenerConexion();
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String latitud=coordenadas.getLatitud();
		String longitud=coordenadas.getLongitud();
		String query = "select lug_id,lug_nombre,lug_longitud,lug_latitud,lug_telefono,lug_descripcion,cat_nombre from lugar natural join categorias where lug_latitud = '"+latitud+"' and lug_longitud='"+longitud+"'";
		
	    // create the java statement
		Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	     
	    // iterate through the java resultset
	    try {
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query);
		    while (rs.next())
		    {
		      int id=rs.getInt("lug_id");
		      String nombre = rs.getString("lug_nombre");
		      
		      int telefono = rs.getInt("lug_telefono");
		      String descripcion = rs.getString("lug_descripcion");
		      String categorias = rs.getString("cat_nombre");	      
		      Lugar lugar = new Lugar(id,nombre, coordenadas,telefono,descripcion,categorias);
		      // print the results
		      lugares.add(lugar);
		      
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
		    return lugares;
	 }
	public ArrayList<Lugar> consultarLugaresporCategoria(String categoria) throws Exception{
		//Connection con = new ConexionMysql().ObtenerConexion();
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String query = "select lug_id,lug_nombre,lug_latitud,lug_longitud,lug_telefono,lug_descripcion,cat_nombre from lugar natural join categorias where cat_nombre = '"+categoria+"'";
		
	    // create the java statement
		Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	     
	    // iterate through the java resultset
	    try {
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query);
		    while (rs.next())
		    {
		      int id = rs.getInt("lug_id");
		      String nombre = rs.getString("lug_nombre");
		      System.out.println("nombre: "+nombre);
		      String latitud = rs.getString("lug_latitud");
		      System.out.println("latitud: "+latitud);
		      String longitud = rs.getString("lug_longitud");
		      System.out.println("latitud: "+longitud);
		      int telefono = rs.getInt("lug_telefono");
		      System.out.println("telefono: "+telefono);
		      String descripcion = rs.getString("lug_descripcion");
		      System.out.println("descripcion: "+descripcion);
		      Coordenadas coordenadas = new Coordenadas(latitud,longitud);
		      Lugar lugar = new Lugar(id,nombre, coordenadas,telefono,descripcion,categoria);
		      // print the results
		      lugares.add(lugar);
		      
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
		    return lugares;
	 }
	public ArrayList<Lugar> consultarTodosLosLugares() throws Exception {
		
		//Connection con = new ConexionMysql().ObtenerConexion();
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String query = "select lug_id,lug_nombre,lug_latitud,lug_longitud,lug_telefono,lug_descripcion,cat_nombre from lugar natural join categorias";
		
	    // create the java statement
		Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	     
	    // iterate through the java resultset
	    try {
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query);
	    while (rs.next())
	    {
	      int id=rs.getInt("lug_id");
	      String nombre = rs.getString("lug_nombre");
	      String latitud = rs.getString("lug_latitud");
	      String longitud = rs.getString("lug_longitud");
	      int telefono = rs.getInt("lug_telefono");
	      String descripcion = rs.getString("lug_descripcion");
	      String categorias = rs.getString("cat_nombre");
	      Coordenadas coordenadas = new Coordenadas(latitud,longitud);
	      Lugar lugar = new Lugar(id,nombre, coordenadas,telefono,descripcion,categorias);
	      // print the results
	      lugares.add(lugar);
	      
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
	    return lugares;
	 }
	public ArrayList<Lugar> consultarLugaresPropietario(String email) throws Exception {
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String query = "select lug_id,lug_nombre,lug_latitud,lug_longitud,lug_telefono,lug_descripcion,cat_nombre from lugar natural join categorias where pro_email='"+email+"'";
		Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	    try {
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query);
	    while (rs.next())
	    {
	      int id=rs.getInt("lug_id");
	      String nombre = rs.getString("lug_nombre");
	      String latitud = rs.getString("lug_latitud");
	      String longitud = rs.getString("lug_longitud");
	      int telefono = rs.getInt("lug_telefono");
	      String descripcion = rs.getString("lug_descripcion");
	      String categorias = rs.getString("cat_nombre");
	      System.out.println("categoria :"+categorias);
	      Coordenadas coordenadas = new Coordenadas(latitud,longitud);
	      Lugar lugar = new Lugar(id,nombre, coordenadas,telefono,descripcion,categorias);
	      // print the results
	      lugares.add(lugar);
	      
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
	    return lugares;
	 }
	public ArrayList<Lugar> consultarLugaresFavoritos(String email) throws Exception {
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String query = "select lug_id,lug_nombre,lug_longitud,lug_latitud,lug_telefono,lug_descripcion,cat_nombre from lugar natural join favoritos natural join categorias where usu_email='"+email+"'";
		Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	    try {
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query);
	    while (rs.next())
	    {
	      int id= rs.getInt("lug_id");
	      String nombre = rs.getString("lug_nombre");
	      String latitud = rs.getString("lug_latitud");
	      String longitud = rs.getString("lug_longitud");
	      int telefono = rs.getInt("lug_telefono");
	      String descripcion = rs.getString("lug_descripcion");
	      String categorias = rs.getString("cat_nombre");	
	      Coordenadas coordenadas = new Coordenadas(latitud,longitud);
	      Lugar lugar = new Lugar(id,nombre, coordenadas,telefono,descripcion,categorias);
	      // print the results
	      lugares.add(lugar);
	      
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
	    return lugares;
	 }
	
	public void registrarLugar(Lugar lugar) throws Exception{
		String nombre = lugar.getNombre();
		int telefono = lugar.getTelefono();
		Coordenadas coordenadas = lugar.getCoordenadas();
		String latitud = coordenadas.getLatitud();
		String longitud = coordenadas.getLongitud();
		String email = lugar.getPropietario();
		int categoria = lugar.getCategoria();
		String descripcion = lugar.getDescripcion();
		//Connection con = new ConexionMysql().ObtenerConexion();
		String query = "INSERT INTO lugar (`lug_nombre`, `lug_telefono`, `lug_latitud`, `lug_longitud`, `pro_email`, `cat_id`, `lug_descripcion`) VALUES ('"+nombre+"', '"+telefono+"', '"+latitud+"','"+longitud+"', '"+email+"', '"+categoria+"', '"+descripcion+"')";	
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
	public void eliminarLugar(Lugar lugar){
		int id = lugar.getId();
		Coordenadas coordenadas = lugar.getCoordenadas();
		String latitud=coordenadas.getLatitud();
		String longitud=coordenadas.getLongitud();
		String query = "delete from lugar where lug_id='"+id+"'and lug_latitud='"+latitud+"'and lug_longitud='"+longitud+"'";
		System.out.println(query);
		Statement stmt = null;
	    Connection con = null;
	    int rs=1;	    

	    try {
	     	con = new ConexionMysql().ObtenerConexion();
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
	public void ActualizarDatos(Lugar lugar)throws Exception{
		int id = lugar.getId();
		String nombre = lugar.getNombre();
		int telefono = lugar.getTelefono();
		Coordenadas coordenadas = lugar.getCoordenadas();
		String latitud=coordenadas.getLatitud();
		String longitud=coordenadas.getLongitud();
		String email = lugar.getPropietario();
		int categoria = lugar.getCategoria();
		String descripcion = lugar.getDescripcion();
		String query = "update lugar set lug_nombre='"+nombre+"', lug_telefono='"+telefono+"',lug_latitud='"+latitud+"', lug_longitud='"+longitud+"',cat_id='"+categoria+"',lug_descripcion='"+descripcion+"', pro_email='"+email+"' where lug_id='"+id+"'";
		System.out.println(query);
		Statement stmt = null;
	    Connection con = null;
	    int rs;
	    try {
	      con = new ConexionMysql().ObtenerConexion();
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
	public void RegistroFavorito(String email, Lugar lugar){
		int id = lugar.getId();
		String query="INSERT INTO `bdsoftware2`.`favoritos` (`usu_email`, `lug_id`) VALUES ('"+email+"', '"+id+"')";
		System.out.println(query);
		Statement stmt = null;
	    Connection con = null;
	    int rs;
	    try {
	      con = new ConexionMysql().ObtenerConexion();
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
	public void quitarFavorito(String email, Lugar lugar){
		int id = lugar.getId();
		String query = "delete from favoritos where usu_email='"+email+"' and lug_id='"+id+"'";
		System.out.println(query);
		Statement stmt = null;
	    Connection con = null;
	    int rs=1;	    

	    try {
	     	con = new ConexionMysql().ObtenerConexion();
	    	stmt = con.createStatement();
	      rs = stmt.executeUpdate(query);
	      System.out.println("rs: "+rs);
	     System.out.println("al eliminar favorito: "+rs);
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
