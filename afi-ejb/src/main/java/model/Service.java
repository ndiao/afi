package model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the service database table.
 * 
 */
@Entity
@Table(name="service")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	private String nom;

	//bi-directional many-to-one association to Employe
	@OneToMany(mappedBy="service")
	@JsonIgnore
	private List<Employe> employes;

	//bi-directional many-to-one association to Direction
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="code_direction")
	private Direction direction;

	
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Service(String nom, Direction direction) {
		super();
		this.nom = nom;
		this.direction = direction;
	}


	public Service(int code, String nom, Direction direction) {
		super();
		this.code = code;
		this.nom = nom;
		this.direction = direction;
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

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}


	@Override
	public String toString() {
		return "Service [code=" + code + ", nom=" + nom + ", direction="
				+ direction + "]";
	}
	
	
}