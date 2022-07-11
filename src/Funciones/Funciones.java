package Funciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Cls.Cls;
import Conexion.Conexion;
import Consultas.Consultas;

public class Funciones {

	private int IdFuncion;
	private int IdSala;
	private int IdPelicula;
	private String Horario;
	private String Fecha;
	private int Estado;
	
	public Funciones() {
		
	}
	
	public Funciones(int IdFuncion, int IdSala, int IdPelicula, String Horario, String Fecha, int Estado) {
		super();
		this.IdFuncion = IdFuncion;
		this.IdSala = IdSala;
		this.IdPelicula = IdPelicula;
		this.Horario = Horario;
		this.Fecha = Fecha;
		this.Estado = Estado;
	}
	public int getIdFuncion() {
		return IdFuncion;
	}
	public void setIdFuncion(int idFuncion) {
		IdFuncion = idFuncion;
	}
	public int getIdSala() {
		return IdSala;
	}
	public void setIdSalta(int idSalta) {
		IdSala = idSalta;
	}
	public int getIdPelicula() {
		return IdPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		IdPelicula = idPelicula;
	}
	public String getHorario() {
		return Horario;
	}
	public void setHorario(String horario) {
		Horario = horario;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	
	
	public void CrearFunciones() {
		
		Cls.BorrarPantalla2();
		System.out.println("*************************************************");
		System.out.println("Ingrese Número de Funcion ---> ");
		System.out.println("*************************************************");
		Scanner lectura = new Scanner (System.in);
		this.IdFuncion = lectura.nextInt();
		System.out.println("*************************************************");
		System.out.println("Ingrese (1) Sala 2d ó (2) Sala 3D ---> ");
		System.out.println("*************************************************");
		this.IdSala = lectura.nextInt();
		System.out.println("*************************************************");
		System.out.println("Ingrese Número de la Pelicula (1 a 13 ---> ");
		System.out.println("*************************************************");
		this.IdPelicula = lectura.nextInt();
		System.out.println("*************************************************");
		System.out.println("Ingrese Horario de la Función (HH:MM:SS) ---> ");
		System.out.println("*************************************************");
		this.Horario = lectura.next();
		System.out.println("*************************************************");
		System.out.println("Ingrese Fecha de la Función (AA-MM-DD) ---> ");
		System.out.println("*************************************************");
		this.Fecha = lectura.next();
		int Estado1=1;
		setEstado(Estado1);
		
		Connection conn = null;
		PreparedStatement stmt;
		ResultSet rs;
		 try {
			conn = DriverManager.getConnection(Conexion.DB_URL,Conexion.USER,Conexion.PASS);
		 	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 	}
		
		 String sql = "INSERT INTO funciones (IdFuncion, IdSala, IdPelicula, Horario, Fecha, Estado) values (?, ?, ?, ?, ?, ?)";
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt (1,getIdFuncion());
				stmt.setInt (2,getIdSala());
				stmt.setInt (3,getIdPelicula());
				stmt.setString (4,getHorario());
				stmt.setString (5,getFecha());
				stmt.setInt (6,getEstado());
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				}
	
	public void TodasLasFunciones() {
		Connection conn = null;
		Statement stmt=null;
		String sql="SELECT * FROM cinecine.funciones;";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(Conexion.DB_URL,Conexion.USER,Conexion.PASS);
			stmt=conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
			int IdFuncion=rs.getInt("IdFuncion");
			int IdSala=rs.getInt("IdSala");
			int IdPelicula=rs.getInt("IdPelicula");
			String Horario=rs.getString("Horario");
			String Fecha=rs.getString("Fecha");
			
			System.out.println("*************************************************");
			System.out.println("******* FUNCION ----> "+ IdFuncion);
			System.out.println("******* SALA ----> "+ IdSala);
			
			Consultas consulta=new Consultas();
			String tituloPeli = consulta.Titulo(IdPelicula); 
			System.out.println("******* PELICULA ---->"+tituloPeli);
			System.out.println("******* HORARIO ---->"+Horario);
			System.out.println("******* FECHA ---->"+Fecha);
			
			

			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automï¿½ticamente
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
