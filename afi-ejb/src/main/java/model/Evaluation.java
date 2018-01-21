package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="evaluation")
public class Evaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="code_eval")
	private int codeEval;

	@Temporal(TemporalType.DATE)
	@Column(name="date_eval")
	private Date dateEval;

	private boolean diseabled;

	//bi-directional many-to-one association to TypeEvaluation
	@ManyToOne
	@JoinColumn(name="code_te")
	private TypeEvaluation typeEvaluation;

	//bi-directional many-to-one association to Ec
	@ManyToOne
	@JoinColumn(name="code_ec")
	private Ec ec;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="evaluation")
	private List<Note> notes;

	public Evaluation() {
		
	}
	public int getCodeEval() {
		return codeEval;
	}

	public void setCodeEval(int codeEval) {
		this.codeEval = codeEval;
	}

	public Date getDateEval() {
		return dateEval;
	}

	public void setDateEval(Date dateEval) {
		this.dateEval = dateEval;
	}

	public boolean isDiseabled() {
		return diseabled;
	}

	public void setDiseabled(boolean diseabled) {
		this.diseabled = diseabled;
	}

	public TypeEvaluation getTypeEvaluation() {
		return typeEvaluation;
	}

	public void setTypeEvaluation(TypeEvaluation typeEvaluation) {
		this.typeEvaluation = typeEvaluation;
	}

	public Ec getEc() {
		return ec;
	}

	public void setEc(Ec ec) {
		this.ec = ec;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

}
