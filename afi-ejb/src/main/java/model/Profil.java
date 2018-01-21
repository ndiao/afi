package model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


@Entity
@Table(name="profil")
public class Profil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	private String nom;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="profil")
	@JsonIgnore
	private List<Employe> utilisateurs;
	
	public Profil() {
		// TODO Auto-generated constructor stub
	}

	public Profil(int code) {
		super();
		this.code = code;
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

	public List<Employe> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Employe> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	

}
