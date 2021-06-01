package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the salaluxury database table.
 * 
 */
@Entity
@NamedQuery(name="Salaluxury.findAll", query="SELECT s FROM Salaluxury s")
public class Salaluxury implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsalaluxury;

	@Column(name="precio_menu")
	private int precioMenu;

	@Column(name="servicio_a_mesa")
	private boolean servicioAMesa;

	@Column(name="tiempo_espera_cena")
	private int tiempoEsperaCena;

	@Column(name="tiene_butacas_reclinables")
	private boolean tieneButacasReclinables;

	//bi-directional many-to-one association to Sala
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idsala")
	private Sala sala;

	public Salaluxury() {
	}

	public int getIdsalaluxury() {
		return this.idsalaluxury;
	}

	public void setIdsalaluxury(int idsalaluxury) {
		this.idsalaluxury = idsalaluxury;
	}

	public int getPrecioMenu() {
		return this.precioMenu;
	}

	public void setPrecioMenu(int precioMenu) {
		this.precioMenu = precioMenu;
	}

	public boolean getServicioAMesa() {
		return this.servicioAMesa;
	}

	public void setServicioAMesa(boolean servicioAMesa) {
		this.servicioAMesa = servicioAMesa;
	}

	public int getTiempoEsperaCena() {
		return this.tiempoEsperaCena;
	}

	public void setTiempoEsperaCena(int tiempoEsperaCena) {
		this.tiempoEsperaCena = tiempoEsperaCena;
	}

	public boolean getTieneButacasReclinables() {
		return this.tieneButacasReclinables;
	}

	public void setTieneButacasReclinables(boolean tieneButacasReclinables) {
		this.tieneButacasReclinables = tieneButacasReclinables;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}