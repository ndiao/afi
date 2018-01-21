package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name="ec")
public class Ec implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private int cm;

	private int coef;

	private String nom;

	private int td;

	private int tp;

	private int tpe;

	private int vh;

	private int vht;
	
	//bi-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="code_ens")
	private Enseignant enseignant;

	//bi-directional many-to-one association to Ue
	@ManyToOne
	@JoinColumn(name="code_ue")
	private Ue ue;

	//bi-directional many-to-one association to Evaluation
	@OneToMany(mappedBy="ec", fetch=FetchType.EAGER)
	private List<Evaluation> evaluations;

	//bi-directional many-to-one association to Programmation
	@OneToMany(mappedBy="ec")
	private List<Programmation> programmations;
	
	@Transient
	private int budget;
	@Transient
	private long vhRestant;
	@Transient
	private double ratio;
	public Ec() {
		// TODO Auto-generated constructor stub
	}
	
	public Ec(String code, int cm, int coef, String nom, int td, int tp,
			int tpe, int vh, int vht, Ue ue) {
		super();
		this.code = code;
		this.cm = cm;
		this.coef = coef;
		this.nom = nom;
		this.td = td;
		this.tp = tp;
		this.tpe = tpe;
		this.vh = vh;
		this.vht = vht;
		this.ue = ue;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCm() {
		return cm;
	}

	public void setCm(int cm) {
		this.cm = cm;
	}

	public int getCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTd() {
		return td;
	}

	public void setTd(int td) {
		this.td = td;
	}

	public int getTp() {
		return tp;
	}

	public void setTp(int tp) {
		this.tp = tp;
	}

	public int getTpe() {
		return tpe;
	}

	public void setTpe(int tpe) {
		this.tpe = tpe;
	}

	public int getVh() {
		return vh;
	}

	public void setVh(int vh) {
		this.vh = vh;
	}

	public int getVht() {
		return vht;
	}

	public void setVht(int vht) {
		this.vht = vht;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Ue getUe() {
		return ue;
	}

	public void setUe(Ue ue) {
		this.ue = ue;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public List<Programmation> getProgrammations() {
		return programmations;
	}

	public void setProgrammations(List<Programmation> programmations) {
		this.programmations = programmations;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public long getVhRestant() {
		return vhRestant;
	}

	public void setVhRestant(long vhRestant) {
		this.vhRestant = vhRestant;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	
}
