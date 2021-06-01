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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idsala")
	private Sala sala;

	//bi-directional many-to-one association to Asientosreservado
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