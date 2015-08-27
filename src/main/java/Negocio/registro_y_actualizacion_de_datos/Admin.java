package Negocio.registro_y_actualizacion_de_datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import datos.conexionMysql;

public class Admin {
	public static String registrar(Cliente cliente) {
		// TODO Auto-generated method stub
		return "Cliente registrado";
	}
	public ResultSet validarLogin(int id,String contra) throws Exception{
		Connection con = new conexionMysql().obtenerConexion();
		String query = ("select * from propietario where pro_id='"+ id +"' and pro_contraseña='" + contra+"'");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
		
	}

}
