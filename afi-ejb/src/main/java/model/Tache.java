package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the tache database table.
 * 
 */
@Entity
@Table(name="tache")
public class Tache implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	@Temporal(TemporalType.DATE)
	@Column(name="date_debut")
	private Date dateDebut;

	@Temporal(TemporalType.DATE)
	@Column(name="date_fin")
	private Date dateFin;

	private String nom;

	private String type;

	//bi-directional many-to-one association to Activite
	@ManyToOne
	@JoinColumn(name="code_activite")
	private Activite activite;
	
	private String resultat;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_realisation")
	private Date dateRealisation;

	

}