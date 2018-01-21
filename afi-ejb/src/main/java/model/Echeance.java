package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="echeance")
public class Echeance implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code;
	private String debut;
	private String fin;
	@OneToMany(mappedBy="echeance")
	@JsonIgnore
	private List<Mesclass> classes;
	@OneToMany(mappedBy="echeance")
	@JsonIgnore
	private List<Mois> mois;
	public Echeance() {
		// TODO Auto-generated constructor stub
	}
	
	public Echeance(String debut, String fin) {
		super();
		this.debut = debut;
		this.fin = fin;
	}

	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getDebut() {
		return debut;
	}
	public void setDebut(String debut) {
		this.debut = debut;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public List<Mesclass> getClasses() {
		return classes;
	}
	public void setClasses(List<Mesclass> classes) {
		this.classes = classes;
	}

	public List<Mois> getMois() {
		return mois;
	}

	public void setMois(List<Mois> mois) {
		this.mois = mois;
	}
	
}
