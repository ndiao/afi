package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name="pointage")
public class Pointage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	@Temporal(TemporalType.DATE)
	@Column(name="date_pointage")
	private Date datePointage;

	@Temporal(TemporalType.TIME)
	private Date arriver;
	@Temporal(TemporalType.TIME)
	private Date depart;

	//bi-directional many-to-one association to Employe
	@ManyToOne
	@JoinColumn(name="matricule_employe")
	private Employe employe;

	
}