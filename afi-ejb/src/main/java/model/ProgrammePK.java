package model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The primary key class for the programme database table.
 * 
 */
@Embeddable
public class ProgrammePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="code_classe", insertable=false, updatable=false)
	private String codeClasse;

	@Column(name="code_ue", insertable=false, updatable=false)
	private String codeUe;

	public ProgrammePK() {
	}
	public String getCodeClasse() {
		return this.codeClasse;
	}
	public void setCodeClasse(String codeClasse) {
		this.codeClasse = codeClasse;
	}
	public String getCodeUe() {
		return this.codeUe;
	}
	public void setCodeUe(String codeUe) {
		this.codeUe = codeUe;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProgrammePK)) {
			return false;
		}
		ProgrammePK castOther = (ProgrammePK)other;
		return 
			this.codeClasse.equals(castOther.codeClasse)
			&& this.codeUe.equals(castOther.codeUe);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codeClasse.hashCode();
		hash = hash * prime + this.codeUe.hashCode();
		
		return hash;
	}
}
