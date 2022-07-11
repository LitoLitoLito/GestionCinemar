package Clientes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Cls.Cls;
import Conexion.Conexion;
import Consultas.Consultas;

public class Clientes {

	private String IdUsuario;
	private String Nombre;
	private String Apellido;
	private String FechaNacimiento;
	private String Celular;
	private String Clave;
	private int Estado;
	
	public Clientes() {
		
	};
	
	public Clientes(String IdUsuario, String Clave, String Nombre, String Apellido, int Estado, String FechaNacimiento, String Celular) {
		this.IdUsuario = IdUsuario;
		this.Clave = Clave;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.FechaNacimiento= FechaNacimiento;
		this.Celular= Celular;
		
		this.Estado = Estado;
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

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getCelular() {
		return Celular;
	}

	public void setCelular(String celular) {
		Celular = celular;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	public void AgregarCliente() {
		Cls.BorrarPantalla2();
		System.out.println("*************************************************");
		System.out.println("Ingrese su correo electronico");
		System.out.println("Recuerde que será su USUARIO ---> ");
		Scanner lectura = new Scanner (System.in);
		System.out.println("*************************************************");
		System.out.print("---> ");
		this.IdUsuario = lectura.next();
			Consultas consultas = new Consultas();
		boolean existe = consultas.ValidacionCliente();
				
		while (existe==true) {
			Cls.BorrarPantalla2();
			System.out.println("*************************************************");
			System.out.println("Ya existe un usuario con ese correo");
			System.out.println("Ingrese otra direccion de e-mail");
			Scanner lectura5 = new Scanner (System.in);
			System.out.println("*************************************************");
			System.out.print("---> ");
			this.IdUsuario = lectura5.next();
				existe=false;
				existe = consultas.ValidacionCliente();
			}
			Cls.BorrarPantalla2();
			System.out.println("*************************************************");
			System.out.println("Ingrese una Clave (ej.= ' 125Aae*Q ' hasta ocho dígitos");
			System.out.println("Recuerde que esta será su CLAVE para RESERVAR --->");
			Scanner lectura5 = new Scanner (System.in);
			System.out.println("*************************************************");
			System.out.print("---> ");
			this.Clave = lectura5.next();
			
			Cls.BorrarPantalla2();
			System.out.println("*************************************************");
			System.out.println("Ingrese su Nombre ---> ");
			Scanner lectura1 = new Scanner (System.in);
			System.out.println("*************************************************");
			System.out.print("---> ");
			this.Nombre = lectura1.next();
		
			Cls.BorrarPantalla2();
			System.out.println("*************************************************");
			System.out.println("Ingrese su Apellido ---> ");
			Scanner lectura2 = new Scanner (System.in);
			System.out.println("*************************************************");
			System.out.print("---> ");
			this.Apellido = lectura2.next();
		
			Cls.BorrarPantalla2();
			System.out.println("*************************************************");
			System.out.println("Ingrese su Fecha Nacimiento (Ejm. 2022-12-30 ---> ");
			Scanner lectura3 = new Scanner (System.in);
			System.out.println("*************************************************");
			System.out.print("---> ");
			this.FechaNacimiento = lectura3.next();
		
			Cls.BorrarPantalla2();
			System.out.println("*************************************************");
			System.out.println("Ingrese su N° Celular ---> ");
			Scanner lectura4 = new Scanner (System.in);
			System.out.println("*************************************************");
			System.out.println("--> ");
			this.Celular = lectura4.next();
		
			Connection conn = null;
			PreparedStatement stmt;
			ResultSet rs;
			 try {
				conn = DriverManager.getConnection(Conexion.DB_URL,Conexion.USER,Conexion.PASS);
			 	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 	}
				String sql1 = "INSERT INTO usuarios (IdUsuario, Clave, Nombre, Apellido, Estado, FechaNacimiento, Celular) values (?, ?, ?, ?, ?, ?,?)";
						try {
							stmt = conn.prepareStatement(sql1);
							stmt.setString (1,getIdUsuario());
							System.out.println();
							stmt.setString (2,getClave());
							stmt.setString (3,getNombre());
							stmt.setString (4,getApellido());
							stmt.setInt (5,getEstado());
							stmt.setString (6,getFechaNacimiento());
							stmt.setString (7,getCelular());
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
						Cls.BorrarPantalla2();
						System.out.println("*************************************************");
						System.out.println("Registración Exitosa");
						System.out.println("*************************************************");
						System.out.println("");
						
						
						
		    }
	public boolean VerFunciones() {
		
		Scanner lectura = new Scanner (System.in);
		
		Cls.BorrarPantalla2();
		System.out.println("*************************************************");
		System.out.println("Ingrese su usuario (correo: xxxxxx@xxxx.com)");
		System.out.println("*************************************************");
		this.IdUsuario=lectura.next();

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
				stmt.setString(1, this.IdUsuario);
				rs=stmt.executeQuery();
				if(rs.next()); 
				String id = rs.getString("IdUsuario");
					//System.out.println(rs.getString(id));
					if (((String) id).equalsIgnoreCase(this.IdUsuario)) {
					return true;
					} 
	 			}	catch (Exception e) {
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
	

}
