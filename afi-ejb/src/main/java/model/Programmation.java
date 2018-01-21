package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;



@Entity
@Table(name="programmation")
public class Programmation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="code_prog")
	private int codeProg;

	@Temporal(TemporalType.TIME)
	@Column(name="heure_debut")
	private Date heureDebut;

	@Temporal(TemporalType.TIME)
	@Column(name="heure_fin")
	private Date heureFin;

	private String jour;
	
	@ManyToOne
	@JoinColumn(name="code_salle")
	private Salle salle;

	//bi-directional many-to-one association to Emargement
	@OneToMany(mappedBy="programmation")
	private List<Emargement> emargements;

	//bi-directional many-to-one association to Ec
	@ManyToOne
	@JoinColumn(name="code_ec")
	private Ec ec;

	public Programmation() {
		// TODO Auto-generated constructor stub
	}
	
	public Programmation(Date heureDebut, Date heureFin, String jour,
			Salle salle, Ec ec) {
		super();
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.jour = jour;
		this.salle = salle;
		this.ec = ec;
	}

	public int getCodeProg() {
		return codeProg;
	}

	public void setCodeProg(int codeProg) {
		this.codeProg = codeProg;
	}

	public Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public List<Emargement> getEmargements() {
		return emargements;
	}

	public void setEmargements(List<Emargement> emargements) {
		this.emargements = emargements;
	}

	public Ec getEc() {
		return ec;
	}

	public void setEc(Ec ec) {
		this.ec = ec;
	}

}
