package Peliculas;

public class Peliculas {

	private int IdPelicula;
	private String Titulo;
	private String Director;
	private String Descripcion;
	private String Genero;
	private float Duracion;
	private int Estado;
	public Peliculas(int IdPelicula, String Titulo, String Director, String Descripcion, String Genero, float Duracion,
			int Estado) {
		
		this.IdPelicula = IdPelicula;
		this.Titulo = Titulo;
		this.Director = Director;
		this.Descripcion = Descripcion;
		this.Genero = Genero;
		this.Duracion = Duracion;
		this.Estado = Estado;
	}
	public int getIdPelicula() {
		return IdPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		IdPelicula = idPelicula;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero(String genero) {
		Genero = genero;
	}
	public float getDuracion() {
		return Duracion;
	}
	public void setDuracion(float duracion) {
		Duracion = duracion;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	
	public void Disponibles() {
		
	}
	
}
