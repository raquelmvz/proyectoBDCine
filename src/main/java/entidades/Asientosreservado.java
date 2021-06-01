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
	/* Relacion bidireccional muchos a uno entre Asientos reservados y Asientos
	 * Un asiento puede estar reservado muchas veces
	 * El atributo representa el asiento que forma parte de la reserva de asiento
	 * La tabla Asientos Reservados es la propietaria de esta relacion
	 * porque tiene la clave ajena
	 * Esto se indica con el @JoinColumn y el atributo de la tabla con la que
	 * obtener los datos de la tabla Asiento */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idasiento")
	private Asiento asiento;

	//bi-directional many-to-one association to Reserva
	/* Relacion bidireccional muchos a uno entre Asientos Reservados y Reservas
	 * Una reserva puede contener muchos asientos reservados
	 * El atributo representa la reserva implicada
	 * La tabla Asientos Reservados es la propietaria de la relacion
	 * porque tiene la clave ajena
	 * Esto se indica con el @JoinColumn y el atributo de la tabla con la que obtener los datos
	 * de la tabla Reserva */
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