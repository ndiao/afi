package model;

import java.io.Serializable;
import javax.persistence.*;


@Embeddable
public class AbsencePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="code_ins", insertable=false, updatable=false)
	private int codeIns;

	@Column(name="code_em", insertable=false, updatable=false)
	private Long codeEm;

	public AbsencePK() {
	}
	public int getCodeIns() {
		return this.codeIns;
	}
	public void setCodeIns(int codeIns) {
		this.codeIns = codeIns;
	}
	
	
	public Long getCodeEm() {
		return codeEm;
	}
	public void setCodeEm(Long codeEm) {
		this.codeEm = codeEm;
	}
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AbsencePK)) {
			return false;
		}
		AbsencePK castOther = (AbsencePK)other;
		return 
			(this.codeIns == castOther.codeIns)
			&& (this.codeEm == castOther.codeEm);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codeIns;
		hash = (int) (hash * prime + this.codeEm);
		
		return hash;
	}
	
}