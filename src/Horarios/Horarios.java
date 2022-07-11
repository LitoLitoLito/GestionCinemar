package Horarios;

public class Horarios {

	private String Horario;
	private double Precio;
	private int Estado;
	
	
	
	public Horarios(String Horario, double Precio, int Estado) {
		this.Horario = Horario;
		this.Precio = Precio;
		this.Estado = Estado;
	}
	public String getHorario() {
		return Horario;
	}
	public void setHorario(String horario) {
		Horario = horario;
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
	
	
}
