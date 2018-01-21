package model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="etudiant")
public class Etudiant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String matricule;

	private String adresse;

	@Column(name="adresse_tuteur")
	private String adresseTuteur;

	private String anneeEntree;

	private String codeAFI;

	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance")
	private Date dateNaissance;

	private String email;

	private String entrepriseTuteur;

	@Column(name="fonction_tuteur")
	private String fonctionTuteur;

	private String genre;

	@Column(name="lieu_naissance")
	private String lieuNaissance;

	private String nationalite;

	private String niveauEntree;

	private String nom;

	@Column(name="nom_tuteur")
	private String nomTuteur;

	@Lob
	private String photo;

	private String prenom;

	private String situation;

	private String tel;

	@Column(name="tel_tuteur")
	private String telTuteur;

	//bi-directional many-to-one association to Inscription
	@OneToMany(mappedBy="etudiant")
	@JsonIgnore
	private List<Inscription> inscriptions;

	public Etudiant() {
		// TODO Auto-generated constructor stub
	}
	
	public Etudiant(String matricule, String adresse, Date dateNaissance,
			String email, String entrepriseTuteur, String fonctionTuteur,
			String genre, String lieuNaissance, String nationalite,
			String niveauEntree, String nom, String nomTuteur, String prenom,
			String situation, String tel, String telTuteur, String anneeEntree) {
		super();
		this.matricule = matricule;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.entrepriseTuteur = entrepriseTuteur;
		this.fonctionTuteur = fonctionTuteur;
		this.genre = genre;
		this.lieuNaissance = lieuNaissance;
		this.nationalite = nationalite;
		this.niveauEntree = niveauEntree;
		this.nom = nom;
		this.nomTuteur = nomTuteur;
		this.prenom = prenom;
		this.situation = situation;
		this.tel = tel;
		this.telTuteur = telTuteur;
		this.anneeEntree = anneeEntree;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAdresseTuteur() {
		return adresseTuteur;
	}

	public void setAdresseTuteur(String adresseTuteur) {
		this.adresseTuteur = adresseTuteur;
	}

	public String getAnneeEntree() {
		return anneeEntree;
	}

	public void setAnneeEntree(String anneeEntree) {
		this.anneeEntree = anneeEntree;
	}

	public String getCodeAFI() {
		return codeAFI;
	}

	public void setCodeAFI(String codeAFI) {
		this.codeAFI = codeAFI;
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

	public String getEntrepriseTuteur() {
		return entrepriseTuteur;
	}

	public void setEntrepriseTuteur(String entrepriseTuteur) {
		this.entrepriseTuteur = entrepriseTuteur;
	}

	public String getFonctionTuteur() {
		return fonctionTuteur;
	}

	public void setFonctionTuteur(String fonctionTuteur) {
		this.fonctionTuteur = fonctionTuteur;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getNiveauEntree() {
		return niveauEntree;
	}

	public void setNiveauEntree(String niveauEntree) {
		this.niveauEntree = niveauEntree;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomTuteur() {
		return nomTuteur;
	}

	public void setNomTuteur(String nomTuteur) {
		this.nomTuteur = nomTuteur;
	}

	
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTelTuteur() {
		return telTuteur;
	}

	public void setTelTuteur(String telTuteur) {
		this.telTuteur = telTuteur;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	@Override
	public String toString() {
		return "Etudiant [matricule=" + matricule + ", adresse=" + adresse
				+ ", adresseTuteur=" + adresseTuteur + ", anneeEntree="
				+ anneeEntree + ", codeAFI=" + codeAFI + ", dateNaissance="
				+ dateNaissance + ", email=" + email + ", entrepriseTuteur="
				+ entrepriseTuteur + ", fonctionTuteur=" + fonctionTuteur
				+ ", genre=" + genre + ", lieuNaissance=" + lieuNaissance
				+ ", nationalite=" + nationalite + ", niveauEntree="
				+ niveauEntree + ", nom=" + nom + ", nomTuteur=" + nomTuteur
				+ ", photo=" + photo + ", prenom=" + prenom + ", situation="
				+ situation + ", tel=" + tel + ", telTuteur=" + telTuteur + "]";
	}

}
