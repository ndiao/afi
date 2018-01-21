package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name="absence")
public class Absence implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AbsencePK id;

	//bi-directional many-to-one association to Programmation
	@ManyToOne
	@JoinColumn(name="code_em", insertable=false, updatable=false)
	private Emargement emargement;

	//bi-directional many-to-one association to Inscription
	@ManyToOne
	@JoinColumn(name="code_ins", insertable=false, updatable=false)
	private Inscription inscription;

	public AbsencePK getId() {
		return id;
	}

	public void setId(AbsencePK id) {
		this.id = id;
	}

	public Emargement getEmargement() {
		return emargement;
	}

	public void setEmargement(Emargement emargement) {
		this.emargement = emargement;
	}
	
	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}
}
