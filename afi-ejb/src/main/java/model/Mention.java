package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="mention")
public class Mention implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private String nom;

	//bi-directional many-to-one association to Domaine
	@ManyToOne
	@JoinColumn(name="code_domaine")
	private Domaine domaine;

	//bi-directional many-to-one association to Specialite
	@OneToMany(mappedBy="mention")
	@JsonIgnore
	private List<Specialite> specialites;

	public Mention() {
		// TODO Auto-generated constructor stub
	}
	
	public Mention(String code, String nom, Domaine domaine) {
		super();
		this.code = code;
		this.nom = nom;
		this.domaine = domaine;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public List<Specialite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(List<Specialite> specialites) {
		this.specialites = specialites;
	}

}
