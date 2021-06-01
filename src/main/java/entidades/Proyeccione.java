package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the proyecciones database table.
 * 
 */
@Entity
@Table(name="proyecciones")
@NamedQuery(name="Proyeccione.findAll", query="SELECT p FROM Proyeccione p")
public class Proyeccione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproyeccion;

	@Column(name="comienzo_proyeccion")
	private Timestamp comienzoProyeccion;

	@Column(name="idioma_proyeccion")
	private String idiomaProyeccion;

	//bi-directional many-to-one association to Pelicula
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idpelicula")
	private Pelicula pelicula;

	//bi-directional many-to-one association to Sala
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idsala")
	private Sala sala;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="proyeccione")
	private List<Reserva> reservas;

	public Proyeccione() {
	}

	public int getIdproyeccion() {
		return this.idproyeccion;
	}

	public void setIdproyeccion(int idproyeccion) {
		this.idproyeccion = idproyeccion;
	}

	public Timestamp getComienzoProyeccion() {
		return this.comienzoProyeccion;
	}

	public void setComienzoProyeccion(Timestamp comienzoProyeccion) {
		this.comienzoProyeccion = comienzoProyeccion;
	}

	public String getIdiomaProyeccion() {
		return this.idiomaProyeccion;
	}

	public void setIdiomaProyeccion(String idiomaProyeccion) {
		this.idiomaProyeccion = idiomaProyeccion;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setProyeccione(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setProyeccione(null);

		return reserva;
	}

}