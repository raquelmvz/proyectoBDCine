package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the asientosreservados database table.
 * 
 */
@Entity
@Table(name="asientosreservados")
@NamedQuery(name="Asientosreservado.findAll", query="SELECT a FROM Asientosreservado a")
public class Asientosreservado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idasientoreservado;

	//bi-directional many-to-one association to Asiento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idasiento")
	private Asiento asiento;

	//bi-directional many-to-one association to Reserva
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idreserva")
	private Reserva reserva;

	public Asientosreservado() {
	}

	public int getIdasientoreservado() {
		return this.idasientoreservado;
	}

	public void setIdasientoreservado(int idasientoreservado) {
		this.idasientoreservado = idasientoreservado;
	}

	public Asiento getAsiento() {
		return this.asiento;
	}

	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}