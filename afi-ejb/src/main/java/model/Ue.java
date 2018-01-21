package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ue database table.
 * 
 */
@Entity
@Table(name="ue")
public class Ue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private String niveau;

	private String nom;

	//bi-directional many-to-one association to Ec
	@OneToMany(mappedBy="ue", fetch=FetchType.EAGER)
	private List<Ec> ecs;

	//bi-directional many-to-one association to Programme
	@OneToMany(mappedBy="ue")
	private List<Programme> programmes;
	@Transient
	private int nbreCredit;
	
	public Ue() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Ue(String code, String niveau, String nom) {
		super();
		this.code = code;
		this.niveau = niveau;
		this.nom = nom;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Ec> getEcs() {
		return ecs;
	}

	public void setEcs(List<Ec> ecs) {
		this.ecs = ecs;
	}

	public List<Programme> getProgrammes() {
		return programmes;
	}

	public void setProgrammes(List<Programme> programmes) {
		this.programmes = programmes;
	}



	public int getNbreCredit() {
		
		return nbreCredit;
	}



	public void setNbreCredit(int nbreCredit) {
		this.nbreCredit = nbreCredit;
	}
	
}
