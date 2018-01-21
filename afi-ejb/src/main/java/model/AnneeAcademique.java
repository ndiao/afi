package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="anneeacademique")
public class AnneeAcademique implements Serializable{

	@Id
	private String code;

	private boolean actived;

	@Temporal(TemporalType.DATE)
	@Column(name="date_debut")
	private Date dateDebut;

	@Temporal(TemporalType.DATE)
	@Column(name="date_fin")
	private Date dateFin;

	//bi-directional many-to-one association to Domaine
	@OneToMany(mappedBy="anneeAcademique")
	@JsonIgnore
	private List<Domaine> domaines;

	public AnneeAcademique() {
		// TODO Auto-generated constructor stub
	}
	
	public AnneeAcademique(String code, boolean actived, Date dateDebut,
			Date dateFin) {
		super();
		this.code = code;
		this.actived = actived;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public List<Domaine> getDomaines() {
		return domaines;
	}

	public void setDomaines(List<Domaine> domaines) {
		this.domaines = domaines;
	}

	@Override
	public String toString() {
		return "AnneeAcademique [code=" + code + ", actived=" + actived
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
	
	
}
