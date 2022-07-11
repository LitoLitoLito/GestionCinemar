import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import Conexion.Conexion;
import Menues.Menues;

public class SistemaGestionCine {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		try {
			// Registrar JDBC driver
			Class.forName(Conexion.JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Bloque catch generado automáticamente.
			e.printStackTrace();
		}
		try {
			//Abrir una Conexión.
			conn = DriverManager.getConnection(Conexion.DB_URL,Conexion.USER,Conexion.PASS);
		} catch (SQLException e) {
			// TODO Bloque catch generado automï¿½ticamente
			e.printStackTrace();
		}
		try {
			// Ejecutar una consulta SQL
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
				
		
		try {
			Menues.MenuCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("EXITOSA");
	
			}
	
}
































