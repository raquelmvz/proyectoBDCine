package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the peliculas database table.
 * 
 */
@Entity
@Table(name="peliculas")
@NamedQuery(name="Pelicula.findAll", query="SELECT p FROM Pelicula p")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpelicula;

	@Column(name="calificacion_edad")
	private String calificacionEdad;

	@Lob
	private String descripcion;

	private String director;

	@Column(name="duracion_min")
	private int duracionMin;

	private String genero;

	private String titulo;

	//bi-directional many-to-one association to Proyeccione
	@OneToMany(mappedBy="pelicula")
	private List<Proyeccione> proyecciones;

	public Pelicula() {
	}

	public int getIdpelicula() {
		return this.idpelicula;
	}

	public void setIdpelicula(int idpelicula) {
		this.idpelicula = idpelicula;
	}

	public String getCalificacionEdad() {
		return this.calificacionEdad;
	}

	public void setCalificacionEdad(String calificacionEdad) {
		this.calificacionEdad = calificacionEdad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuracionMin() {
		return this.duracionMin;
	}

	public void setDuracionMin(int duracionMin) {
		this.duracionMin = duracionMin;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Proyeccione> getProyecciones() {
		return this.proyecciones;
	}

	public void setProyecciones(List<Proyeccione> proyecciones) {
		this.proyecciones = proyecciones;
	}

	public Proyeccione addProyeccione(Proyeccione proyeccione) {
		getProyecciones().add(proyeccione);
		proyeccione.setPelicula(this);

		return proyeccione;
	}

	public Proyeccione removeProyeccione(Proyeccione proyeccione) {
		getProyecciones().remove(proyeccione);
		proyeccione.setPelicula(null);

		return proyeccione;
	}

}