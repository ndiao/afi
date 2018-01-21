package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the notes database table.
 * 
 */
@Entity
@Table(name="notes")
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NotePK id;

	private double note;

	//bi-directional many-to-one association to Inscription
	@ManyToOne
	@JoinColumn(name="code_ins", insertable=false, updatable=false)
	private Inscription inscription;

	//bi-directional many-to-one association to Evaluation
	@ManyToOne
	@JoinColumn(name="code_eval", insertable=false, updatable=false)
	private Evaluation evaluation;

	public Note() {
		
	}
	public NotePK getId() {
		return id;
	}

	public void setId(NotePK id) {
		this.id = id;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

}
