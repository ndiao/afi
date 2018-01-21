package model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the direction database table.
 * 
 */
@Entity
@Table(name="direction")
public class Direction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	private String nom;

	//bi-directional many-to-one association to Service
	@OneToMany(mappedBy="direction")
	@JsonIgnore
	private List<Service> services;
	
	public Direction() {
		// TODO Auto-generated constructor stub
	}

	public Direction(String nom) {
		super();
		this.nom = nom;
	}

	public Direction(int code, String nom) {
		super();
		this.code = code;
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

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
	

}