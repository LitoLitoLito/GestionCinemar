package Butacas;

public class Butacas {

	private int IdButaca;
	private int IdFuncion;
	private int Fila;
	private int Columna;
	private int Estado;
	
	public Butacas(int IdButaca, int IdFuncion, int Fila, int Columna, int Estado) {
		this.IdButaca = IdButaca;
		this.IdFuncion = IdFuncion;
		this.Fila = Fila;
		this.Columna = Columna;
		this.Estado = Estado;
	}

	public int getIdButaca() {
		return IdButaca;
	}

	public void setIdButaca(int idButaca) {
		IdButaca = idButaca;
	}

	public int getIdFuncion() {
		return IdFuncion;
	}

	public void setIdFuncion(int idFuncion) {
		IdFuncion = idFuncion;
	}

	public int getFila() {
		return Fila;
	}

	public void setFila(int fila) {
		Fila = fila;
	}

	public int getColumna() {
		return Columna;
	}

	public void setColumna(int columna) {
		Columna = columna;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}
		
	
}
