package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="mesclasses")
public class Mesclass implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	@Column(name = "frais_ins")
	private double fraisIns;

	private double mensualite;

	private boolean ouverte;

	@Column(name = "tarif_vac1")
	private int tarifVac1;

	@Column(name = "tarif_vac2")
	private int tarifVac2;

	// bi-directional many-to-one association to Inscription
	@OneToMany(mappedBy = "mesclass", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Inscription> inscriptions;
	// bi-directional many-to-one association to Specialite
	@ManyToOne
	@JoinColumn(name = "code_spec")
	private Specialite specialite;

	// bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name = "code_categorie")
	private Categorie categorie;

	// bi-directional many-to-one association to Niveau
	@ManyToOne
	@JoinColumn(name = "code_niveau")
	private Niveau niveau;

	// bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name = "code_user")
	private Employe utilisateur;

	// bi-directional many-to-one association to Programme
	@OneToMany(mappedBy = "mesclass")
	@JsonIgnore
	private List<Programme> programmes;
	@ManyToOne
	@JoinColumn(name = "code_echeance")
	private Echeance echeance;
	@Transient
	private int nbreInscrit;
	@Transient
	private int nbreImpaye;

	public Mesclass() {
		// TODO Auto-generated constructor stub
	}

	public Mesclass(String code, double fraisIns, double mensualite,
			boolean ouverte, Specialite specialite, Categorie categorie,
			Niveau niveau) {
		super();
		this.code = code;
		this.fraisIns = fraisIns;
		this.mensualite = mensualite;
		this.ouverte = ouverte;
		this.specialite = specialite;
		this.categorie = categorie;
		this.niveau = niveau;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getFraisIns() {
		return fraisIns;
	}

	public void setFraisIns(double fraisIns) {
		this.fraisIns = fraisIns;
	}

	public double getMensualite() {
		return mensualite;
	}

	public void setMensualite(double mensualite) {
		this.mensualite = mensualite;
	}

	public boolean isOuverte() {
		return ouverte;
	}

	public void setOuverte(boolean ouverte) {
		this.ouverte = ouverte;
	}

	public int getTarifVac1() {
		return tarifVac1;
	}

	public void setTarifVac1(int tarifVac1) {
		this.tarifVac1 = tarifVac1;
	}

	public int getTarifVac2() {
		return tarifVac2;
	}

	public void setTarifVac2(int tarifVac2) {
		this.tarifVac2 = tarifVac2;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Employe getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Employe utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Programme> getProgrammes() {
		return programmes;
	}

	public void setProgrammes(List<Programme> programmes) {
		this.programmes = programmes;
	}

	public Echeance getEcheance() {
		return echeance;
	}

	public void setEcheance(Echeance echeance) {
		this.echeance = echeance;
	}
	
	public int getNbreInscrit() {
		return nbreInscrit;
	}

	public void setNbreInscrit(int nbreInscrit) {
		this.nbreInscrit = nbreInscrit;
	}

	public int getNbreImpaye() {
		return nbreImpaye;
	}

	public void setNbreImpaye(int nbreImpaye) {
		this.nbreImpaye = nbreImpaye;
	}

	@Override
	public String toString() {
		return "Mesclass [code=" + code + ", fraisIns=" + fraisIns
				+ ", mensualite=" + mensualite + ", ouverte=" + ouverte
				+ ", specialite=" + specialite + ", categorie=" + categorie
				+ ", niveau=" + niveau + "]";
	}

}
