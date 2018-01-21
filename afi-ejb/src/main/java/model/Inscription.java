package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="inscription")
public class Inscription implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="code_ins")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codeIns;

	@Temporal(TemporalType.DATE)
	@Column(name="date_ins")
	private Date dateIns;

	@Temporal(TemporalType.DATE)
	@Column(name="date_modif_ins")
	private Date dateModifIns;

	private double montant;

	private String opt;

	private boolean payer;

	@Column(name="taux_reduction")
	private float tauxReduction;

	
	//bi-directional many-to-one association to Feuillepresence
	@OneToMany(mappedBy="inscription")
	@JsonIgnore
	private List<Absence> absences;

	//bi-directional many-to-one association to Etudiant
	@ManyToOne
	@JoinColumn(name="matricule")
	private Etudiant etudiant;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="code_agent_pay")
	private Employe caissier;

	//bi-directional many-to-one association to Mesclass
	@ManyToOne
	@JoinColumn(name="code_classe")
	private Mesclass mesclass;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="code_agent_ins")
	private Employe agentCom;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="inscription")
	@JsonIgnore
	private List<Note> notes;

	//bi-directional many-to-one association to Paiement
	@OneToMany(mappedBy="inscription")
	@JsonIgnore
	private List<Paiement> paiements;
	
	@OneToMany(mappedBy="inscription")
	@JsonIgnore
	private List<PaiementFraisAnnexe> paiementFraisAnnexes;

	@Transient
	private int nbreAbsence;
	
	public Inscription() {
		// TODO Auto-generated constructor stub
	}
	
	public Inscription(Date dateIns, double montant, String opt, boolean payer,
			float tauxReduction, Etudiant etudiant, Mesclass mesclass,
			Employe agentCom) {
		super();
		this.dateIns = dateIns;
		this.montant = montant;
		this.opt = opt;
		this.payer = payer;
		this.tauxReduction = tauxReduction;
		this.etudiant = etudiant;
		this.mesclass = mesclass;
		this.agentCom = agentCom;
	}
	

	public int getCodeIns() {
		return codeIns;
	}

	public void setCodeIns(int codeIns) {
		this.codeIns = codeIns;
	}

	public Date getDateIns() {
		return dateIns;
	}

	public void setDateIns(Date dateIns) {
		this.dateIns = dateIns;
	}

	public Date getDateModifIns() {
		return dateModifIns;
	}

	public void setDateModifIns(Date dateModifIns) {
		this.dateModifIns = dateModifIns;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public boolean isPayer() {
		return payer;
	}

	public void setPayer(boolean payer) {
		this.payer = payer;
	}

	public float getTauxReduction() {
		return tauxReduction;
	}

	public void setTauxReduction(float tauxReduction) {
		this.tauxReduction = tauxReduction;
	}

	public List<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Employe getCaissier() {
		return caissier;
	}

	public void setCaissier(Employe caissier) {
		this.caissier = caissier;
	}

	public Mesclass getMesclass() {
		return mesclass;
	}

	public void setMesclass(Mesclass mesclass) {
		this.mesclass = mesclass;
	}

	public Employe getAgentCom() {
		return agentCom;
	}

	public void setAgentCom(Employe agentCom) {
		this.agentCom = agentCom;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<Paiement> getPaiements() {
		return paiements;
	}

	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}

	public List<PaiementFraisAnnexe> getPaiementFraisAnnexes() {
		return paiementFraisAnnexes;
	}

	public void setPaiementFraisAnnexes(
			List<PaiementFraisAnnexe> paiementFraisAnnexes) {
		this.paiementFraisAnnexes = paiementFraisAnnexes;
	}

	public int getNbreAbsence() {
		return nbreAbsence;
	}

	public void setNbreAbsence(int nbreAbsence) {
		this.nbreAbsence = nbreAbsence;
	}
}
