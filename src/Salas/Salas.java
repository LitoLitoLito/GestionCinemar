package Salas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Conexion.Conexion;
import Consultas.Consultas;

public class Salas {

	private int IdSala;
	private String Nombre;
	private int Filas;
	private int Butacasporfila;
	private int Estado;
	
	public Salas(int IdSala, String Nombre, int Filas, int Butacasporfila, int Estado) {
		this.IdSala = IdSala;
		this.Nombre = Nombre;
		this.Filas = Filas;
		this.Butacasporfila = Butacasporfila;
		this.Estado=Estado;
	}

	public Salas() {
		// TODO Auto-generated constructor stub
	}

	public int getIdSala() {
		return IdSala;
	}

	public void setIdSala(int idSala) {
		IdSala = idSala;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getFilas() {
		return Filas;
	}

	public void setFilas(int filas) {
		Filas = filas;
	}

	public int getButacasporfila() {
		return Butacasporfila;
	}

	public void setButacasporfila(int butacasporfila) {
		Butacasporfila = butacasporfila;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}
	
	
	public void CrearSalas() {
		int numSala=1;
		setIdSala(numSala);
	System.out.println("Crear Salas");
	System.out.print("Cuántas Salas quiere Crear??? ---> ");
	Scanner lectura = new Scanner (System.in);
	int cantidadSalas=lectura.nextInt();
		
	for(int i=-1; i<=cantidadSalas;i++) {
		System.out.print("Para Sala "+numSala+" Ingrese cantidad COLUMNAS ---> ");
		Scanner lectura1 = new Scanner (System.in);
		this.Butacasporfila=lectura1.nextInt();
		System.out.print("Para Sala "+numSala+" Ingrese cantidad FILAS ---> ");
		this.Filas=lectura1.nextInt();
		this.Estado=1;
		this.Nombre="Sala";
		
		CrearSala2();
		cantidadSalas--;
		numSala++;
		setIdSala(numSala);
		}
		System.out.println("Salas Creadas");
		}
	
	public void CrearSala2() {
		Connection conn = null;
		PreparedStatement stmt=null;
		try {
			conn = DriverManager.getConnection(Conexion.DB_URL,Conexion.USER,Conexion.PASS);
				String sql = "INSERT INTO Salas (IdSala, Nombre, Filas, Butacasporfila, Estado) values (?, ?, ?, ?, ?)";
				stmt = conn.prepareStatement(sql);
				stmt.setInt (1,getIdSala());
				stmt.setString (2,getNombre());
				stmt.setInt (3,getFilas());
				stmt.setInt (4,getButacasporfila());
				stmt.setInt (5,getEstado());
				stmt.executeUpdate();
				
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
		 
	 }
}

