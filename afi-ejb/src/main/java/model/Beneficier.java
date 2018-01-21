package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the beneficier database table.
 * 
 */
@Entity
@Table(name="beneficier")
public class Beneficier implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BeneficierPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_obtention")
	private Date dateObtention;

	//bi-directional many-to-one association to Employe
	@ManyToOne
	@JoinColumn(name="matricule_employe", insertable=false, updatable=false)
	private Employe employe;

	//bi-directional many-to-one association to Prime
	@ManyToOne
	@JoinColumn(name="code_prime", updatable=false, insertable=false)
	private Prime prime;

	
}