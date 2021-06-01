package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the asientos database table.
 * 
 */
@Entity
@Table(name="asientos")
@NamedQuery(name="Asiento.findAll", query="SELECT a FROM Asiento a")
public class Asiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idasiento;

	private int fila;

	private int numero;
	
	//bi-directional many-to-one association to Sala
	/* Relacion bidireccional entre Asientos y Salas
	 * Una sala contiene muchos asientos
	 * El atributo representa la sala a la que pertenece este asiento
	 * La tabla Asiento es la propietaria de esta relación porque tiene la clave ajena
	 * Esto se indica con el @JoinColumn y el atributo de la tabla con la que obtener los
	 * datos de la tabla Sala */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idsala")
	private Sala sala;
	
	//bi-directional many-to-one association to Asientosreservado
	/* Relacion bidireccional uno a muchos con Asientos Reservados
	 * Un asiento puede ser reservado muchas veces
	 * Con esta anotacion y este atributo se pueden recuperar 
	 * las reservas que se han hecho para ese asiento
	 * mappedBy indica el atributo asociado en la clase Asiento */
	@OneToMany(mappedBy="asiento")
	private List<Asientosreservado> asientosreservados;

	public Asiento() {
	}

	public int getIdasiento() {
		return this.idasiento;
	}

	public void setIdasiento(int idasiento) {
		this.idasiento = idasiento;
	}

	public int getFila() {
		return this.fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Asientosreservado> getAsientosreservados() {
		return this.asientosreservados;
	}

	public void setAsientosreservados(List<Asientosreservado> asientosreservados) {
		this.asientosreservados = asientosreservados;
	}

	public Asientosreservado addAsientosreservado(Asientosreservado asientosreservado) {
		getAsientosreservados().add(asientosreservado);
		asientosreservado.setAsiento(this);

		return asientosreservado;
	}

	public Asientosreservado removeAsientosreservado(Asientosreservado asientosreservado) {
		getAsientosreservados().remove(asientosreservado);
		asientosreservado.setAsiento(null);

		return asientosreservado;
	}

}