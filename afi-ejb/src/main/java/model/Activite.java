package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the activite database table.
 * 
 */
@Entity
@Table(name="activite")
public class Activite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	private String nom;

	//bi-directional many-to-one association to Poste
	@ManyToOne
	private Poste poste;

	//bi-directional many-to-one association to TypeActivite
	@ManyToOne
	@JoinColumn(name="code_type")
	private TypeActivite typeActivite;

	//bi-directional many-to-one association to Tache
	@OneToMany(mappedBy="activite")
	private List<Tache> taches;

	

}