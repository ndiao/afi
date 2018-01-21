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
@Table(name="domaine")
public class Domaine implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private String nom;

	//bi-directional many-to-one association to AnneeAcademique
	@ManyToOne
	@JoinColumn(name="code_aa")
	private AnneeAcademique anneeAcademique;

	//bi-directional many-to-one association to Mention
	@OneToMany(mappedBy="domaine")
	@JsonIgnore
	private List<Mention> mentions;

	public Domaine() {
		// TODO Auto-generated constructor stub
	}
	
	public Domaine(String code, String nom, AnneeAcademique anneeAcademique) {
		super();
		this.code = code;
		this.nom = nom;
		this.anneeAcademique = anneeAcademique;
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

	public AnneeAcademique getAnneeAcademique() {
		return anneeAcademique;
	}

	public void setAnneeAcademique(AnneeAcademique anneeAcademique) {
		this.anneeAcademique = anneeAcademique;
	}

	public List<Mention> getMentions() {
		return mentions;
	}

	public void setMentions(List<Mention> mentions) {
		this.mentions = mentions;
	}
}
