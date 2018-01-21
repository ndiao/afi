package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PaiementFraisAnnexePK implements Serializable{

	@Column(name="code_ins", insertable=false, updatable=false)
	private int codeIns;
	
	@Column(name="code_frais_annexe", insertable=false, updatable=false)
	private int codeFraisAnnexe;
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NotePK)) {
			return false;
		}
		PaiementFraisAnnexePK castOther = (PaiementFraisAnnexePK)other;
		return 
			(this.codeIns == castOther.codeIns)
			&& (this.codeFraisAnnexe == castOther.codeFraisAnnexe);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codeFraisAnnexe;
		hash = hash * prime + this.codeIns;
		
		return hash;
	}

	public int getCodeIns() {
		return codeIns;
	}

	public void setCodeIns(int codeIns) {
		this.codeIns = codeIns;
	}

	public int getCodeFraisAnnexe() {
		return codeFraisAnnexe;
	}

	public void setCodeFraisAnnexe(int codeFraisAnnexe) {
		this.codeFraisAnnexe = codeFraisAnnexe;
	}
	
	
}
