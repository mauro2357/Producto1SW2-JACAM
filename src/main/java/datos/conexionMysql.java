package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;


public class conexionMysql {
	private String sql;
	private ArrayList<String> columnData = new ArrayList<String>();
	
	public conexionMysql(){
		
	}
	public Connection obtenerConexion() throws Exception{
	    String driver = "com.mysql.jdbc.Driver";
	    String connection = "jdbc:mysql://localhost:3306/bdsoftware2";
	    String user = "root";
	    String password = "root";
	    Class.forName(driver);
	    Connection con = DriverManager.getConnection(connection, user, password);
	    System.out.println(con);
	    return(con);
	  }
	public void consultar(String query){
		this.limpiarColumnData();
		this.sql=query;
	    // JDBC driver name and database URL
	    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	    String DB_URL = "jdbc:mysql://localhost/bdsoftware2";

	    // Database credentials
	    String USER = "root"; // Fake of course.
	    String PASS = "root"; // This too!

	    Statement stmt = null;
	    ResultSet rs = null;
	    Connection conn = null;
	    ArrayList<String> columnNames = new ArrayList<String>();
	    

	    try {
	      // Register JDBC driver
	      Class.forName(JDBC_DRIVER).newInstance();

	      // Open a connection
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      // Execute SQL query
	      stmt = conn.createStatement();
	      rs = stmt.executeQuery(sql);
	      if (rs != null) {
	        ResultSetMetaData columns = rs.getMetaData();
	        int i = 0;
	        while (i < columns.getColumnCount()) {
	          i++;
	          System.out.print(columns.getColumnName(i));
	          columnNames.add(columns.getColumnName(i));
	        }
	        System.out.print("\n");

	        while (rs.next()) {
	          for (i = 0; i < columnNames.size(); i++) {
	            System.out.print(rs.getString(columnNames.get(i))
	                + "\t");
	            columnData.add(rs.getString(columnNames.get(i)));

	          }
	          System.out.print("\n");
	        }

	      }
	    } catch (Exception e) {
	      System.out.println("Exception: " + e.toString());
	    }

	    finally {
	      try {
	        if (rs != null) {
	          rs.close();
	        }
	        if (stmt != null) {
	          stmt.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
	      } catch (Exception mysqlEx) {
	        System.out.println(mysqlEx.toString());
	      }

	    }
		
	}
	public void ingresar(String sql){
		this.sql=sql;
	    // JDBC driver name and database URL
	    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	    String DB_URL = "jdbc:mysql://localhost/bdsoftware2";

	    // Database credentials
	    String USER = "root"; // Fake of course.
	    String PASS = "root"; // This too!

	    Statement stmt = null;
	    int rs = 0;
	    Connection conn = null;
	    ArrayList<String> columnNames = new ArrayList<String>();
	    

	    try {
	      // Register JDBC driver
	      Class.forName(JDBC_DRIVER).newInstance();

	      // Open a connection
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      // Execute SQL query
	      stmt = conn.createStatement();
	      rs = stmt.executeUpdate(sql);
	     System.out.println("al crear: "+rs);
	    } catch (Exception e) {
	      System.out.println("Exception: " + e.toString());
	    }

	    finally {
	      try {

	        if (stmt != null) {
	          stmt.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
	      } catch (Exception mysqlEx) {
	        System.out.println(mysqlEx.toString());
	      }

	    }
	  
	}

	public ArrayList<String> getColumnData() {
		return columnData;
	}
	public void limpiarColumnData(){
		if (this.columnData.isEmpty()==false){
			this.columnData.clear();
		}
	}
	

}
