package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the prime database table.
 * 
 */
@Entity
@Table(name="prime")
public class Prime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	private double montant;

	private String nom;

	//bi-directional many-to-one association to Beneficier
	@OneToMany(mappedBy="prime")
	private List<Beneficier> beneficiers;

	

}