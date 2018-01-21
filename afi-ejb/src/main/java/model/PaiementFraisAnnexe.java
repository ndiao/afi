package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="paiement_frais_annexe")
public class PaiementFraisAnnexe implements Serializable{
	
	@EmbeddedId
	private PaiementFraisAnnexePK id;
	
	@ManyToOne
	@JoinColumn(name="code_ins", insertable=false, updatable=false)
	private Inscription inscription;
	
	@ManyToOne
	@JoinColumn(name="code_frais_annexe", insertable=false, updatable=false)
	private FraisAnnexe fraisAnnexe;
	
	@Temporal(TemporalType.DATE)
	private Date datePaiement;
	
	private double montant;
	public PaiementFraisAnnexe() {
		// TODO Auto-generated constructor stub
	}

	public PaiementFraisAnnexePK getId() {
		return id;
	}

	public void setId(PaiementFraisAnnexePK id) {
		this.id = id;
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

	public FraisAnnexe getFraisAnnexe() {
		return fraisAnnexe;
	}

	public void setFraisAnnexe(FraisAnnexe fraisAnnexe) {
		this.fraisAnnexe = fraisAnnexe;
	}

	public Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	
}
