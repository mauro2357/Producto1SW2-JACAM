package datos;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexionMysql {
	
	public Connection obtenerConexion() throws Exception{
	    String driver = "com.mysql.jdbc.Driver";
	    String connection = "jdbc:mysql://localhost:3306/BDSoftware2";
	    String user = "root";
	    String password = "root";
	    Class.forName(driver);
	    Connection con = DriverManager.getConnection(connection, user, password);
	    return(con);
	  }
	

}
