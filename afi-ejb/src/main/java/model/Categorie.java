package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="categorie")
public class Categorie implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	private String nom;

	//bi-directional many-to-one association to Mesclass
	@OneToMany(mappedBy="categorie")
	@JsonIgnore
	private List<Mesclass> mesclasses;
	
	@OneToMany(mappedBy="categorie")
	@JsonIgnore
	private List<TarificationScolarite> tarificationScolarites;

	public Categorie() {
		// TODO Auto-generated constructor stub
	}
	
	public Categorie(String nom) {
		super();
		this.nom = nom;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Mesclass> getMesclasses() {
		return mesclasses;
	}

	public void setMesclasses(List<Mesclass> mesclasses) {
		this.mesclasses = mesclasses;
	}

	public List<TarificationScolarite> getTarificationScolarites() {
		return tarificationScolarites;
	}

	public void setTarificationScolarites(
			List<TarificationScolarite> tarificationScolarites) {
		this.tarificationScolarites = tarificationScolarites;
	}
}
