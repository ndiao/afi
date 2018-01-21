package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="salle")
public class Salle implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;
	private String nom;
	private String type;
	private int capacite;
	@ManyToOne
	@JoinColumn(name="code_site")
	private Site site;
	@OneToMany(mappedBy="salle")
	private List<Programmation> programmations;
	
	public Salle() {
		// TODO Auto-generated constructor stub
	}
	
	public Salle(String nom, String type, int capacite, Site site) {
		super();
		this.nom = nom;
		this.type = type;
		this.capacite = capacite;
		this.site = site;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public List<Programmation> getProgrammations() {
		return programmations;
	}
	public void setProgrammations(List<Programmation> programmations) {
		this.programmations = programmations;
	}
	
	
}
