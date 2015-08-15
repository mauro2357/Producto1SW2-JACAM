package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Negocio.Localizacion.lugar;

public class lugaresRepository {
	// our SQL SELECT query. 
    // if you only need a few columns, specify them by name instead of using "*"
    
	public ArrayList<lugar> consultarLugaresporCoordenadas() throws Exception{
	Connection con = new conexionMysql().obtenerConexion();
	ArrayList<lugar> lugares = new ArrayList<lugar>();
	String query = "SELECT * FROM lugar";
	
    // create the java statement
    Statement st = con.createStatement();
     
    // execute the query, and get a java resultset
    ResultSet rs = st.executeQuery(query);
     
    // iterate through the java resultset
    while (rs.next())
    {
      
      String nombre = rs.getString("nombre");
      String coordenadas = rs.getString("coordenadas");
      String descripcion = rs.getString("descripcion");
      lugar lugar = new lugar(nombre, descripcion, coordenadas);
      // print the results
      lugares.add(lugar);
    }
    
    st.close();
    return lugares;
 }
}
