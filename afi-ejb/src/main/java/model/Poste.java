package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the poste database table.
 * 
 */
@Entity
@Table(name="poste")
public class Poste implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	private String nom;

	//bi-directional many-to-one association to Activite
	@OneToMany(mappedBy="poste")
	private List<Activite> activites;

	//bi-directional many-to-one association to Occuper
	@OneToMany(mappedBy="poste")
	private List<Occuper> occupers;

	
}