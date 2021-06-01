package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the salas database table.
 * 
 */
@Entity
@Table(name="salas")
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsala;

	private String nombre;

	//bi-directional many-to-one association to Asiento
	@OneToMany(mappedBy="sala")
	private List<Asiento> asientos;

	//bi-directional many-to-one association to Proyeccione
	@OneToMany(mappedBy="sala")
	private List<Proyeccione> proyecciones;

	//bi-directional many-to-one association to Salajunior
	@OneToMany(mappedBy="sala")
	private List<Salajunior> salajuniors;

	//bi-directional many-to-one association to Salaluxury
	@OneToMany(mappedBy="sala")
	private List<Salaluxury> salaluxuries;

	//bi-directional many-to-one association to Salamacro
	@OneToMany(mappedBy="sala")
	private List<Salamacro> salamacros;

	public Sala() {
	}

	public int getIdsala() {
		return this.idsala;
	}

	public void setIdsala(int idsala) {
		this.idsala = idsala;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Asiento> getAsientos() {
		return this.asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}

	public Asiento addAsiento(Asiento asiento) {
		getAsientos().add(asiento);
		asiento.setSala(this);

		return asiento;
	}

	public Asiento removeAsiento(Asiento asiento) {
		getAsientos().remove(asiento);
		asiento.setSala(null);

		return asiento;
	}

	public List<Proyeccione> getProyecciones() {
		return this.proyecciones;
	}

	public void setProyecciones(List<Proyeccione> proyecciones) {
		this.proyecciones = proyecciones;
	}

	public Proyeccione addProyeccione(Proyeccione proyeccione) {
		getProyecciones().add(proyeccione);
		proyeccione.setSala(this);

		return proyeccione;
	}

	public Proyeccione removeProyeccione(Proyeccione proyeccione) {
		getProyecciones().remove(proyeccione);
		proyeccione.setSala(null);

		return proyeccione;
	}

	public List<Salajunior> getSalajuniors() {
		return this.salajuniors;
	}

	public void setSalajuniors(List<Salajunior> salajuniors) {
		this.salajuniors = salajuniors;
	}

	public Salajunior addSalajunior(Salajunior salajunior) {
		getSalajuniors().add(salajunior);
		salajunior.setSala(this);

		return salajunior;
	}

	public Salajunior removeSalajunior(Salajunior salajunior) {
		getSalajuniors().remove(salajunior);
		salajunior.setSala(null);

		return salajunior;
	}

	public List<Salaluxury> getSalaluxuries() {
		return this.salaluxuries;
	}

	public void setSalaluxuries(List<Salaluxury> salaluxuries) {
		this.salaluxuries = salaluxuries;
	}

	public Salaluxury addSalaluxury(Salaluxury salaluxury) {
		getSalaluxuries().add(salaluxury);
		salaluxury.setSala(this);

		return salaluxury;
	}

	public Salaluxury removeSalaluxury(Salaluxury salaluxury) {
		getSalaluxuries().remove(salaluxury);
		salaluxury.setSala(null);

		return salaluxury;
	}

	public List<Salamacro> getSalamacros() {
		return this.salamacros;
	}

	public void setSalamacros(List<Salamacro> salamacros) {
		this.salamacros = salamacros;
	}

	public Salamacro addSalamacro(Salamacro salamacro) {
		getSalamacros().add(salamacro);
		salamacro.setSala(this);

		return salamacro;
	}

	public Salamacro removeSalamacro(Salamacro salamacro) {
		getSalamacros().remove(salamacro);
		salamacro.setSala(null);

		return salamacro;
	}

}