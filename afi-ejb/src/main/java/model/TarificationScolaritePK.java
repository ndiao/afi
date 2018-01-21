package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TarificationScolaritePK implements Serializable{
	
	@Column(name="code_niveau", insertable=false, updatable=false)
	private int codeNiveau;
	
	@Column(name="code_categorie", insertable=false, updatable=false)
	private int codeCategorie;
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NotePK)) {
			return false;
		}
		TarificationScolaritePK castOther = (TarificationScolaritePK)other;
		return 
			(this.codeNiveau == castOther.codeNiveau)
			&& (this.codeCategorie == castOther.codeCategorie);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codeNiveau;
		hash = hash * prime + this.codeCategorie;
		
		return hash;
	}

	public int getCodeNiveau() {
		return codeNiveau;
	}

	public void setCodeNiveau(int codeNiveau) {
		this.codeNiveau = codeNiveau;
	}

	public int getCodeCategorie() {
		return codeCategorie;
	}

	public void setCodeCategorie(int codeCategorie) {
		this.codeCategorie = codeCategorie;
	}

}
