package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type_activite database table.
 * 
 */
@Entity
@Table(name="type_activite")
public class TypeActivite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	private String type;

	//bi-directional many-to-one association to Activite
	@OneToMany(mappedBy="typeActivite")
	private List<Activite> activites;


	

}