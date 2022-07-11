package Reservas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Clientes.Clientes;
import Conexion.Conexion;
import Consultas.Consultas;
import Funciones.Funciones;

public class Reservas {

	private int IdReserva;
	private String Horario;
	private int IdFuncion;
	private int IdSala;
	private int IdPelicula;
	private String IdUsuario;
	private String Nombre;
	private String Fecha;
	private double Precio;
	private int Estado;
	
	public Reservas() {
		
	}
	
	public Reservas(int IdReserva, String Horario, int IdFuncion, int IdSala, int IdPelicula, String IdUsuario,
			String Nombre, String Fecha, double Precio, int Estado) {
		this.IdReserva = IdReserva;
		this.Horario = Horario;
		this.IdFuncion = IdFuncion;
		this.IdSala = IdSala;
		this.IdPelicula = IdPelicula;
		this.IdUsuario = IdUsuario;
		this.Nombre = Nombre;
		this.Fecha = Fecha;
		this.Precio = Precio;
		this.Estado = Estado;
	}

	public int getIdReserva() {
		return IdReserva;
	}

	public void setIdReserva(int idReserva) {
		IdReserva = idReserva;
	}

	public String getHorario() {
		return Horario;
	}

	public void setHorario(String horario) {
		Horario = horario;
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

	public void setIdSala(int idSala) {
		IdSala = idSala;
	}

	public int getIdPelicula() {
		return IdPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		IdPelicula = idPelicula;
	}

	public String getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		IdUsuario = idUsuario;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}
	
	public void EsCliente() {
		System.out.println("Ingrese su Usuario (mail) ---> ");
		Scanner lectura=new Scanner(System.in);
		this.IdUsuario = lectura.next();
		
	Connection conn = null;
	PreparedStatement stmt;
	ResultSet rs;
	 
		
			try {
				conn = DriverManager.getConnection(Conexion.DB_URL,Conexion.USER,Conexion.PASS);
			 	stmt= conn.prepareStatement("SELECT * FROM usuarios WHERE IdUsuario=?");
				stmt.setString(1, getIdUsuario());
				rs=stmt.executeQuery();
				if(rs.next()); 
				String id;
				int Clave;
				id = rs.getString("IdUsuario");
				if (((String) id).equalsIgnoreCase(getIdUsuario())) {
					Clave=rs.getInt("clave");
					System.out.println("Ingrese su Clave (********) ---> ");
					int ClaveIngresada=lectura.nextInt();
					if (Clave==ClaveIngresada) {
					Funciones funciones=new Funciones();	
					funciones.TodasLasFunciones();
					System.out.print("Ingrese el Número de Función para Reservar ---> ");
					this.IdFuncion=lectura.nextInt();
					System.out.println("Elija Butaca");
					int c = IdFuncion;
					ElijaButaca(c);
						
					}else {
						
					}
					
				}else {
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				//System.out.println(rs.getString(id));
				 {
				
		
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
 		
 }
		
		
		
		
		
		
		
		
	}

	public void ElijaButaca(int c) {
		System.out.println("");
		System.out.println("*************************************************");
		System.out.println("Hasta Aquí llegué !!!! ");
		System.out.println("*************************************************");
		System.out.println("");
	}
}
