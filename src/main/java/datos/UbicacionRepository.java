package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Negocio.Localizacion.ubicacion;

public class UbicacionRepository {
	
	// our SQL SELECT query. 
    // if you only need a few columns, specify them by name instead of using "*"
    private String estado;
	public String GPS(String usuario) throws Exception{
		
	Connection con = new ConexionMysql().ObtenerConexion();
	String query = "SELECT usu_gps, usu_coordenas FROM usuarios where usu_email='"+usuario+"'";
	
	
    // create the java statement
    Statement st = con.createStatement();
     
    // execute the query, and get a java resultset
    ResultSet rs = st.executeQuery(query);
     
    // iterate through the java resultset
    while (rs.next())
    {
      
      String gps = rs.getString("usu_gps");
      String coordenadas = rs.getString("usu_coordenas");
      ubicacion lugar = new ubicacion();
      lugar.datos(gps, coordenadas);
      
      // print the results
      estado=lugar.estado();
    }
    
    st.close();
    return this.estado;
 }

}
