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
@Table(name="niveau")
public class Niveau implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	private String nom;

	//bi-directional many-to-one association to Mesclass
	@OneToMany(mappedBy="niveau")
	@JsonIgnore
	private List<Mesclass> mesclasses;

	//bi-directional many-to-one association to Semestre
	@OneToMany(mappedBy="niveau", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Semestre> semestres;
	
	@OneToMany(mappedBy="niveau")
	@JsonIgnore
	private List<TarificationScolarite> tarificationScolarites;
	
	public Niveau() {
		// TODO Auto-generated constructor stub
	}

	public Niveau(String nom) {
		super();
		this.nom = nom;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Mesclass> getMesclasses() {
		return mesclasses;
	}

	public void setMesclasses(List<Mesclass> mesclasses) {
		this.mesclasses = mesclasses;
	}

	public List<Semestre> getSemestres() {
		return semestres;
	}

	public void setSemestres(List<Semestre> semestres) {
		this.semestres = semestres;
	}

	public List<TarificationScolarite> getTarificationScolarites() {
		return tarificationScolarites;
	}

	public void setTarificationScolarites(
			List<TarificationScolarite> tarificationScolarites) {
		this.tarificationScolarites = tarificationScolarites;
	}
}
