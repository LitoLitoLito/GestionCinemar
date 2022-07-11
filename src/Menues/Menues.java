package Menues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import Clientes.Clientes;
import Cls.Cls;
import Conexion.Conexion;
import Consultas.Consultas;
import Funciones.Funciones;
import Reservas.Reservas;
import Salas.Salas;

public class Menues {
	
	public static void MenuCliente() {
	Scanner lectura=new Scanner(System.in);
	boolean salir=false;
	int opcion;
		
		while(!salir) {
			System.out.println("");
			System.out.println("************---> MENU PRINCIPAL <---*************");
			System.out.println("*************************************************");
			System.out.println("*	1 ---->  Ver Funciones");
			System.out.println("*	2 ---->  Registrarse");
			System.out.println("*	3 ---->  Elegir Pelicula y Reservarla");
			System.out.println("*	4 ---->  Administrador");
			System.out.println("*	5 ---->  SALIR");
			System.out.println("*************************************************");
			System.out.print("	Opción----> ");
			
		try {	
			opcion=lectura.nextInt();
			switch(opcion) {
			case 1:
				Cls.BorrarPantalla2();
				Funciones funciones=new Funciones();
				funciones.TodasLasFunciones();
				
				
				break;
			case 2:
				Cls.BorrarPantalla2();
				Clientes cliente = new Clientes();
				cliente.AgregarCliente();
				break;
			case 3:
				Cls.BorrarPantalla2();
				Reservas reserva= new Reservas();
				reserva.EsCliente();
				
				break;
			case 4:
				MenuAdministrador();
				break;
				
			case 5:
				Cls.BorrarPantalla2();
				break;
			default:
				System.out.println("Las opciones son entre 1 <--> 5");
			}
		}catch(InputMismatchException e) {
			System.out.println("Debes ingresar un Número entre 1 y 5");
			lectura.next();
		}
			
		}
		
		
		
	}
	
	public static void MenuAdministrador() {
		Cls.BorrarPantalla2();
		System.out.println("*************************************************");
		System.out.println("*	Ingrese Usuario   (--> Admin <-- )");
		Scanner lectura = new Scanner (System.in);
		System.out.println("*************************************************");
		System.out.print("---> ");
		String usuario=lectura.next();
		Cls.BorrarPantalla2();
		
		System.out.println("*************************************************");
		System.out.println("*	Ingrese Contraseña (--> 1234 <-- )");
		Scanner lectura1 = new Scanner (System.in);
		System.out.println("*************************************************");
		System.out.print("---> ");
		String clave=lectura1.next();
		if (usuario.equals("Admin") && clave.equals("1234")) {
			Cls.BorrarPantalla2();
			MenuAdministrador2();
		}
	}
	
	public static void MenuAdministrador2() {
		Scanner lectura11=new Scanner(System.in);
		boolean salir=false;
		int opcion;
			
			while(!salir) {
				System.out.println("");
				System.out.println("*************---> ADMINISTRADOR <---*************");
				System.out.println("*************************************************");
				System.out.println("*	1 ---->  Crear Salas");
				System.out.println("*	2 ---->  Crear Función");
				System.out.println("*	3 ---->  Ver todas las Películas disponibles");
				System.out.println("*	4 ---->  Ver Clientes Registrados");
				System.out.println("*	5 ---->  Salir");
				System.out.println("*************************************************");
				System.out.print("	Opción----> ");
				
			try {	
				opcion=lectura11.nextInt();
				switch(opcion) {
				case 1:
					Cls.BorrarPantalla2();
					Salas salas=new Salas();
					salas.CrearSalas();
					break;
				case 2:
					Cls.BorrarPantalla2();
					Funciones crear=new Funciones();
					crear.CrearFunciones();
					Cls.BorrarPantalla2();
					Scanner lectura = new Scanner (System.in);
					System.out.println("*************************************************");
					System.out.println("FUNCION CREADA ---> ");
					System.out.println("*************************************************");
					System.out.println("*************************************************");
					
					
					
					break;
				case 3:
					Cls.BorrarPantalla2();
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
						Consultas consultas=new Consultas();
						consultas.MostrarPeliculas(stmt);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					MenuAdministrador2();
					break;
				case 4:
					Cls.BorrarPantalla2();
					Connection conn1=null;
					Statement stmt1=null;
					try {
						// Registrar JDBC driver
						Class.forName(Conexion.JDBC_DRIVER);
					} catch (ClassNotFoundException e) {
						// TODO Bloque catch generado automáticamente.
						e.printStackTrace();
					}
					try {
						//Abrir una Conexión.
						conn1 = DriverManager.getConnection(Conexion.DB_URL,Conexion.USER,Conexion.PASS);
					} catch (SQLException e) {
						// TODO Bloque catch generado automï¿½ticamente
						e.printStackTrace();
					}
					try {
						// Ejecutar una consulta SQL
						stmt1=conn1.createStatement();
					} catch (SQLException e) {
						// TODO Bloque catch generado automáticamente
						e.printStackTrace();
					}
					Consultas consultas=new Consultas();
					consultas.MostrarClientes(stmt1);
					MenuAdministrador2();
					break;
				case 5:
					Cls.BorrarPantalla2();
					MenuCliente();
					break;
					
				default:
					System.out.println("Las opciones son entre 1 <--> 5");
				}
			}catch(InputMismatchException e) {
				System.out.println("Debes ingresar un Número entre 1 y 5");
				lectura11.next();
			}
			
			}
	}
		}

	

