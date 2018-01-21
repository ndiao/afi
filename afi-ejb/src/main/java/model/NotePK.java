package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the notes database table.
 * 
 */
@Embeddable
public class NotePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="code_eval", insertable=false, updatable=false)
	private int codeEval;

	@Column(name="code_ins", insertable=false, updatable=false)
	private int codeIns;

	public NotePK() {
	}
	public int getCodeEval() {
		return this.codeEval;
	}
	public void setCodeEval(int codeEval) {
		this.codeEval = codeEval;
	}
	public int getCodeIns() {
		return this.codeIns;
	}
	public void setCodeIns(int codeIns) {
		this.codeIns = codeIns;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NotePK)) {
			return false;
		}
		NotePK castOther = (NotePK)other;
		return 
			(this.codeEval == castOther.codeEval)
			&& (this.codeIns == castOther.codeIns);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codeEval;
		hash = hash * prime + this.codeIns;
		
		return hash;
	}
}
