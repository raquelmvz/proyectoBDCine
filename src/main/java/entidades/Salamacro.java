package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the salamacro database table.
 * 
 */
@Entity
@NamedQuery(name="Salamacro.findAll", query="SELECT s FROM Salamacro s")
public class Salamacro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsalamacro;

	private int m2pantalla;

	@Column(name="potencia_sonido")
	private int potenciaSonido;

	@Column(name="resolucion_pantalla")
	private String resolucionPantalla;

	@Column(name="tipo_tecnologia")
	private String tipoTecnologia;

	//bi-directional many-to-one association to Sala
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idsala")
	private Sala sala;

	public Salamacro() {
	}

	public int getIdsalamacro() {
		return this.idsalamacro;
	}

	public void setIdsalamacro(int idsalamacro) {
		this.idsalamacro = idsalamacro;
	}

	public int getM2pantalla() {
		return this.m2pantalla;
	}

	public void setM2pantalla(int m2pantalla) {
		this.m2pantalla = m2pantalla;
	}

	public int getPotenciaSonido() {
		return this.potenciaSonido;
	}

	public void setPotenciaSonido(int potenciaSonido) {
		this.potenciaSonido = potenciaSonido;
	}

	public String getResolucionPantalla() {
		return this.resolucionPantalla;
	}

	public void setResolucionPantalla(String resolucionPantalla) {
		this.resolucionPantalla = resolucionPantalla;
	}

	public String getTipoTecnologia() {
		return this.tipoTecnologia;
	}

	public void setTipoTecnologia(String tipoTecnologia) {
		this.tipoTecnologia = tipoTecnologia;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}