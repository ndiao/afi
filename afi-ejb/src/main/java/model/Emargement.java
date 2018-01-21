package model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="emargement")
public class Emargement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code;

	@Lob
	private String commentaire;

	@Temporal(TemporalType.DATE)
	@Column(name="date_em")
	private Date dateEm;

	private String etat;

	@Column(name="heure_debut")
	@Temporal(TemporalType.TIME)
	private Date heureDebut;

	@Column(name="heure_fin")
	@Temporal(TemporalType.TIME)
	private Date heureFin;

	//bi-directional many-to-one association to Programmation
	@ManyToOne
	@JoinColumn(name="code_prog")
	private Programmation programmation;
	@Transient
	private Long duree;
	
	//bi-directional many-to-one association to Feuillepresence
	@OneToMany(mappedBy="emargement")
	private List<Absence> absences;
	public Emargement() {
		// TODO Auto-generated constructor stub
	}
	
	public Emargement(String commentaire, Date dateEm, String etat,
			Date heureDebut, Date heureFin, Programmation programmation) {
		super();
		this.commentaire = commentaire;
		this.dateEm = dateEm;
		this.etat = etat;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.programmation = programmation;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Date getDateEm() {
		return dateEm;
	}

	public void setDateEm(Date dateEm) {
		this.dateEm = dateEm;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
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

	public Programmation getProgrammation() {
		return programmation;
	}

	public void setProgrammation(Programmation programmation) {
		this.programmation = programmation;
	}

	public Long getDuree() {
		duree = (heureFin.getTime() - heureDebut.getTime()) / 3600000;
		return duree;
	}
	@Override
	public String toString() {
		return "Emargement [code=" + code + ", commentaire=" + commentaire
				+ ", dateEm=" + dateEm + ", etat=" + etat + ", heureDebut="
				+ heureDebut + ", heureFin=" + heureFin  + "]";
	}

	
}
