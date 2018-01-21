package model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employe database table.
 * 
 */
@Entity
@Table(name="employe")
public class Employe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String matricule;

	@Temporal(TemporalType.DATE)
	@Column(name="date_embauche")
	private Date dateEmbauche;

	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance")
	private Date dateNaissance;

	private String email;

	private String nom;
	
	private String fonction;

	private String password;

	@Column(name="salaire_brute")
	private double salaireBrute;

	private String sexe;

	private String tel;
	
	private boolean actived;
	
	private String situation;

	//bi-directional many-to-one association to Beneficier
	@OneToMany(mappedBy="employe")
	@JsonIgnore
	private List<Beneficier> beneficiers;

	//bi-directional many-to-one association to Service
	@ManyToOne()
	@JoinColumn(name="code_service")
	private Service service;
	@ManyToOne()
	@JoinColumn(name="code_direction")
	private Direction direction;

	//bi-directional many-to-one association to Occuper
	@OneToMany(mappedBy="employe")
	@JsonIgnore
	private List<Occuper> occupers;

	//bi-directional many-to-one association to Pointage
	@OneToMany(mappedBy="employe")
	@JsonIgnore
	private List<Pointage> pointages;
	@OneToMany(mappedBy="employe")
	@JsonIgnore
	private List<Conge> conges;
	
	
	//bi-directional many-to-one association to Paiement
	@OneToMany(mappedBy="caissier")
	@JsonIgnore
	private List<Paiement> paiements;
	
	@ManyToOne()
	@JoinColumn(name="code_profil")
	private Profil profil;

	@ManyToOne()
	@JoinColumn(name="code_superieur")
	private Employe superieur;
	@OneToMany(mappedBy="superieur")
	@JsonIgnore
	private List<Employe> employes;
	@Transient
	private int nbreClasse;
	
	public Employe() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Employe(String matricule, Date dateEmbauche, Date dateNaissance,
			String email, String nom, String password, String fonction,
			Direction direction, String sexe, String tel, boolean actived,
			String situation, Profil profil, Employe superieur) {
		super();
		this.matricule = matricule;
		this.dateEmbauche = dateEmbauche;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.nom = nom;
		this.password = password;
		this.fonction = fonction;
		this.direction = direction;
		this.sexe = sexe;
		this.tel = tel;
		this.actived = actived;
		this.situation = situation;
		this.profil = profil;
		this.superieur = superieur;
	}


	public Employe(String matricule, Date dateEmbauche, Date dateNaissance,
			String email, String nom, String fonction, String password,
			String sexe, String tel, boolean actived, String situation,
			Service service, Profil profil, Employe superieur) {
		super();
		this.matricule = matricule;
		this.dateEmbauche = dateEmbauche;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.nom = nom;
		this.fonction = fonction;
		this.password = password;
		this.sexe = sexe;
		this.tel = tel;
		this.actived = actived;
		this.situation = situation;
		this.service = service;
		this.profil = profil;
		this.superieur = superieur;
	}


	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public double getSalaireBrute() {
		return salaireBrute;
	}
	public void setSalaireBrute(double salaireBrute) {
		this.salaireBrute = salaireBrute;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public List<Beneficier> getBeneficiers() {
		return beneficiers;
	}
	public void setBeneficiers(List<Beneficier> beneficiers) {
		this.beneficiers = beneficiers;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public List<Occuper> getOccupers() {
		return occupers;
	}
	public void setOccupers(List<Occuper> occupers) {
		this.occupers = occupers;
	}
	public List<Pointage> getPointages() {
		return pointages;
	}
	public void setPointages(List<Pointage> pointages) {
		this.pointages = pointages;
	}
	public List<Conge> getConges() {
		return conges;
	}
	public void setConges(List<Conge> conges) {
		this.conges = conges;
	}
	public List<Paiement> getPaiements() {
		return paiements;
	}
	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	public Employe getSuperieur() {
		return superieur;
	}
	public void setSuperieur(Employe superieur) {
		this.superieur = superieur;
	}
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}


	public String getFonction() {
		return fonction;
	}


	public void setFonction(String fonction) {
		this.fonction = fonction;
	}


	public Direction getDirection() {
		return direction;
	}


	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	

	public int getNbreClasse() {
		return nbreClasse;
	}


	public void setNbreClasse(int nbreClasse) {
		this.nbreClasse = nbreClasse;
	}


	@Override
	public String toString() {
		return "Employe [matricule=" + matricule + ", dateEmbauche="
				+ dateEmbauche + ", dateNaissance=" + dateNaissance
				+ ", email=" + email + ", nom=" + nom + ", fonction="
				+ fonction + ", password=" + password + ", salaireBrute="
				+ salaireBrute + ", sexe=" + sexe + ", tel=" + tel
				+ ", actived=" + actived + ", situation=" + situation
				+ ", service=" + service + ", direction=" + direction
				+ ", superieur=" + superieur + "]";
	}

	
	
}