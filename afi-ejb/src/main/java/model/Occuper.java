package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the occuper database table.
 * 
 */
@Entity
@Table(name="occuper")
public class Occuper implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OccuperPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_occupation")
	private Date dateOccupation;

	//bi-directional many-to-one association to Employe
	@ManyToOne
	@JoinColumn(name="code_employe", insertable=false, updatable=false)
	private Employe employe;

	//bi-directional many-to-one association to Poste
	@ManyToOne
	@JoinColumn(name="code_poste", insertable=false, updatable=false)
	private Poste poste;

	

}