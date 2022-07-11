package Consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Clientes.Clientes;
import Conexion.Conexion;
import Salas.Salas;

public class Consultas {



	

	public Consultas() {
		
	}
	
	 public void MostrarPeliculas(Statement stmt) throws SQLException {
		String sql;
		sql="SELECT * FROM cinecine.peliculas;";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
			int IdPelicula=rs.getInt("IdPelicula");
			String Titulo=rs.getString("Titulo");
			String Director=rs.getString("Director");
			String Genero=rs.getString("Genero");
			float Duracion=rs.getFloat("Duracion");
			String Descripcion=rs.getString("Descripcion");
			int Estado=rs.getInt("Estado");
						
			System.out.println(IdPelicula+" ) "+Titulo);
			System.out.println("Director:--> "+Director);
			System.out.println("Género:--> "+Genero);
			System.out.println("Duración:--> "+Duracion);
			System.out.println(Descripcion);
			if(Estado == 1) {
				System.out.println("--> HABILITADA");
			}else {
				System.out.println("--> DESHABILITADA");
			}
			System.out.println();
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automï¿½ticamente
			e.printStackTrace();
		}
		
		rs.close();
			
	}
	
	 public void MostrarClientes(Statement stmt) {
		try {
			String sql="SELECT * FROM cinecine.usuarios;";
			ResultSet rs = null;
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String Nombre=rs.getString("Nombre");
				System.out.println("Nombre: "+ Nombre);
				String Apellido=rs.getString("Apellido");
				System.out.println("Apellido: "+Apellido);
				String FechaNacimiento=rs.getString("FechaNacimiento");
				System.out.println("Fecha de Nacimiento: "+FechaNacimiento);
				String Celular=rs.getString("Celular");
				System.out.println("Celular: "+Celular);
				String IdUsuario=rs.getString("IdUsuario");
				System.out.println("Correo ---> "+IdUsuario);
				String Clave=rs.getString("Clave");
				System.out.println("Clave de Ingreso ---> "+ Clave);
				System.out.println("");
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	 }
	
	 public boolean ValidacionCliente() {
		Clientes cliente=new Clientes();
		String nuevoCliente = cliente.getIdUsuario();	
		Connection conn = null;
		PreparedStatement stmt;
		ResultSet rs;
		 try {
			conn = DriverManager.getConnection(Conexion.DB_URL,Conexion.USER,Conexion.PASS);
		 	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 	}
		
			try {
				stmt= conn.prepareStatement("SELECT * FROM usuarios WHERE IdUsuario=?");
				stmt.setString(1, nuevoCliente);
				rs=stmt.executeQuery();
				if(rs.next()); 
				String id = rs.getString("IdUsuario");
					//System.out.println(rs.getString(id));
					if (((String) id).equalsIgnoreCase(nuevoCliente)) {
					return true;
					} 
	 			}	catch (Exception e) {
	 				System.out.println("Cliente Nuevo Aceptado");
	 				System.err.println(e);
	 			 	}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
	 		
	 }
	
	 
		
		public String Titulo(int id1) {
			Connection conn = null;
			Statement stmt=null;
			String sql="SELECT * FROM cinecine.peliculas;";
			ResultSet rs = null;
			
			try {
				conn = DriverManager.getConnection(Conexion.DB_URL,Conexion.USER,Conexion.PASS);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt=conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
				try {
					while(rs.next()) {
						int IdFuncion=rs.getInt("IdPelicula");
						
						if(IdFuncion==id1) {
							String tituloPeli=rs.getString("Titulo");
							return tituloPeli;
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
				
					
			
 
			}
		
		
}

