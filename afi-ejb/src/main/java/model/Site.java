package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="site")
public class Site implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;
	private String nom;
	@OneToMany(mappedBy="site")
	private List<Salle> salles;
	
	public Site() {
		// TODO Auto-generated constructor stub
	}
	
	public Site(String nom) {
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
	public List<Salle> getSalles() {
		return salles;
	}
	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}

}
