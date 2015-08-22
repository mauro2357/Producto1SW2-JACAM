package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Negocio.busquedadelugaresporelusuario.Lugar;

public class lugaresRepository {
	// our SQL SELECT query. 
    // if you only need a few columns, specify them by name instead of using "*"
    
	public ArrayList<Lugar> consultarLugaresporCoordenadas() throws Exception{
	Connection con = new conexionMysql().obtenerConexion();
	ArrayList<Lugar> lugares = new ArrayList<Lugar>();
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
      Lugar lugar = new Lugar(nombre, descripcion, coordenadas);
      // print the results
      lugares.add(lugar);
    }
    
    st.close();
    return lugares;
 }
	public void registrarLocal(int id,String nombre,int telefono,String coordenadas,int  propietario,int categoria,String descripcion) throws Exception{
		Connection con = new conexionMysql().obtenerConexion();
		String query = "INSERT INTO lugar (lug_id, lug_nombre, lug_telefono, lug_coordenadas, pro_id,cat_id,lug_descripcion) VALUES ('"+id+"','"+nombre+"','"+telefono+"','"+coordenadas+"','"+propietario+"','"+categoria+"','"+descripcion+"')";
		Statement st = con.createStatement();
		int result = st.executeUpdate(query);
		if(result == 1){
    		System.out.println("Se ingreso el lugar Correctamente");
    	}else{
    		System.out.println("NO se ingresó el lugar");
    	}
		st.close();
	}
}
