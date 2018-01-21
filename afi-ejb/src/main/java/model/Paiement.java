package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name="paiement")
public class Paiement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	@Temporal(TemporalType.DATE)
	@Column(name="date_p")
	private Date dateP;

	private double du;

	private String mois;

	private double percu;

	private double reliquat;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="code_agent_pay")
	private Employe caissier;

	//bi-directional many-to-one association to Inscription
	@ManyToOne
	@JoinColumn(name="code_ins")
	private Inscription inscription;
	
	public Paiement() {
		// TODO Auto-generated constructor stub
	}

	public Paiement(double du, String mois,
			Inscription inscription) {
		super();
		this.du = du;
		this.mois = mois;
		this.inscription = inscription;
	}

	public Paiement(double du, double reliquat, String mois,
			Inscription inscription) {
		super();
		this.du = du;
		this.reliquat = reliquat;
		this.mois = mois;
		this.inscription = inscription;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getDateP() {
		return dateP;
	}

	public void setDateP(Date dateP) {
		this.dateP = dateP;
	}

	public double getDu() {
		return du;
	}

	public void setDu(double du) {
		this.du = du;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public double getPercu() {
		return percu;
	}

	public void setPercu(double percu) {
		this.percu = percu;
	}

	public double getReliquat() {
		return reliquat;
	}

	public void setReliquat(double reliquat) {
		this.reliquat = reliquat;
	}

	public Employe getCaissier() {
		return caissier;
	}

	public void setCaissier(Employe caissier) {
		this.caissier = caissier;
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

}
