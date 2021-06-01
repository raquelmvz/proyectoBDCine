package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the salajunior database table.
 * 
 */
@Entity
@NamedQuery(name="Salajunior.findAll", query="SELECT s FROM Salajunior s")
public class Salajunior implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsalajunior;

	@Column(name="limite_edad")
	private int limiteEdad;

	@Column(name="nombre_supervisor")
	private String nombreSupervisor;

	@Column(name="tiempo_juego_antes_peli")
	private int tiempoJuegoAntesPeli;

	@Column(name="tiempo_juego_descanso")
	private int tiempoJuegoDescanso;

	@Column(name="tiene_zona_juegos_bebes")
	private boolean tieneZonaJuegosBebes;

	//bi-directional many-to-one association to Sala
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idsala")
	private Sala sala;

	public Salajunior() {
	}

	public int getIdsalajunior() {
		return this.idsalajunior;
	}

	public void setIdsalajunior(int idsalajunior) {
		this.idsalajunior = idsalajunior;
	}

	public int getLimiteEdad() {
		return this.limiteEdad;
	}

	public void setLimiteEdad(int limiteEdad) {
		this.limiteEdad = limiteEdad;
	}

	public String getNombreSupervisor() {
		return this.nombreSupervisor;
	}

	public void setNombreSupervisor(String nombreSupervisor) {
		this.nombreSupervisor = nombreSupervisor;
	}

	public int getTiempoJuegoAntesPeli() {
		return this.tiempoJuegoAntesPeli;
	}

	public void setTiempoJuegoAntesPeli(int tiempoJuegoAntesPeli) {
		this.tiempoJuegoAntesPeli = tiempoJuegoAntesPeli;
	}

	public int getTiempoJuegoDescanso() {
		return this.tiempoJuegoDescanso;
	}

	public void setTiempoJuegoDescanso(int tiempoJuegoDescanso) {
		this.tiempoJuegoDescanso = tiempoJuegoDescanso;
	}

	public boolean getTieneZonaJuegosBebes() {
		return this.tieneZonaJuegosBebes;
	}

	public void setTieneZonaJuegosBebes(boolean tieneZonaJuegosBebes) {
		this.tieneZonaJuegosBebes = tieneZonaJuegosBebes;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}