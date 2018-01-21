package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the beneficier database table.
 * 
 */
@Embeddable
public class BeneficierPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="matricule_employe", insertable=false, updatable=false)
	private String matriculeEmploye;

	@Column(name="code_prime", insertable=false, updatable=false)
	private int codePrime;

	

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BeneficierPK)) {
			return false;
		}
		BeneficierPK castOther = (BeneficierPK)other;
		return 
			this.matriculeEmploye.equals(castOther.matriculeEmploye)
			&& (this.codePrime == castOther.codePrime);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.matriculeEmploye.hashCode();
		hash = hash * prime + this.codePrime;
		
		return hash;
	}
}