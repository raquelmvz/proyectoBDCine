package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the reservas database table.
 * 
 */
@Entity
@Table(name="reservas")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idreserva;

	@Column(name="contacto_reserva")
	private String contactoReserva;

	private boolean pagado;

	//bi-directional many-to-one association to Asientosreservado
	@OneToMany(mappedBy="reserva")
	private List<Asientosreservado> asientosreservados;

	//bi-directional many-to-one association to Proyeccione
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idproyeccion")
	private Proyeccione proyeccione;

	public Reserva() {
	}

	public int getIdreserva() {
		return this.idreserva;
	}

	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}

	public String getContactoReserva() {
		return this.contactoReserva;
	}

	public void setContactoReserva(String contactoReserva) {
		this.contactoReserva = contactoReserva;
	}

	public boolean getPagado() {
		return this.pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public List<Asientosreservado> getAsientosreservados() {
		return this.asientosreservados;
	}

	public void setAsientosreservados(List<Asientosreservado> asientosreservados) {
		this.asientosreservados = asientosreservados;
	}

	public Asientosreservado addAsientosreservado(Asientosreservado asientosreservado) {
		getAsientosreservados().add(asientosreservado);
		asientosreservado.setReserva(this);

		return asientosreservado;
	}

	public Asientosreservado removeAsientosreservado(Asientosreservado asientosreservado) {
		getAsientosreservados().remove(asientosreservado);
		asientosreservado.setReserva(null);

		return asientosreservado;
	}

	public Proyeccione getProyeccione() {
		return this.proyeccione;
	}

	public void setProyeccione(Proyeccione proyeccione) {
		this.proyeccione = proyeccione;
	}

}