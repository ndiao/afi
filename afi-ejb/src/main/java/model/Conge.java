package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="conge")
public class Conge implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code;
	@Temporal(TemporalType.DATE)
	@Column(name="date_debut")
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	@Column(name="date_fin")
	private Date dateFin;
	@ManyToOne
	@JoinColumn(name="code_type")
	private TypeConge type;
	@ManyToOne
	@JoinColumn(name="code_employe")
	private Employe employe;
}
