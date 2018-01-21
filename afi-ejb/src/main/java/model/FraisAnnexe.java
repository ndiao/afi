package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="frais_annexe")
public class FraisAnnexe implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;
	private String nom;
	private double montant;
	@OneToMany(mappedBy="fraisAnnexe")
	private List<PaiementFraisAnnexe> paiementFraisAnnexes;
	
	public FraisAnnexe() {
		// TODO Auto-generated constructor stub
	}
	
	public FraisAnnexe(String nom, double montant) {
		super();
		this.nom = nom;
		this.montant = montant;
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
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public List<PaiementFraisAnnexe> getPaiementFraisAnnexes() {
		return paiementFraisAnnexes;
	}
	public void setPaiementFraisAnnexes(
			List<PaiementFraisAnnexe> paiementFraisAnnexes) {
		this.paiementFraisAnnexes = paiementFraisAnnexes;
	}
}
