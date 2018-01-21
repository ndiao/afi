package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the occuper database table.
 * 
 */
@Embeddable
public class OccuperPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="employe_matricule", insertable=false, updatable=false)
	private String employeMatricule;

	@Column(name="poste_code", insertable=false, updatable=false)
	private int posteCode;

	public OccuperPK() {
	}
	public String getEmployeMatricule() {
		return this.employeMatricule;
	}
	public void setEmployeMatricule(String employeMatricule) {
		this.employeMatricule = employeMatricule;
	}
	public int getPosteCode() {
		return this.posteCode;
	}
	public void setPosteCode(int posteCode) {
		this.posteCode = posteCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OccuperPK)) {
			return false;
		}
		OccuperPK castOther = (OccuperPK)other;
		return 
			this.employeMatricule.equals(castOther.employeMatricule)
			&& (this.posteCode == castOther.posteCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.employeMatricule.hashCode();
		hash = hash * prime + this.posteCode;
		
		return hash;
	}
}