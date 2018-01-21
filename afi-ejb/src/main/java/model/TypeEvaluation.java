package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type_evaluation database table.
 * 
 */
@Entity
@Table(name="type_evaluation")
public class TypeEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="code_te")
	private int codeTe;

	private double poids;

	private String type;

	//bi-directional many-to-one association to Evaluation
	@OneToMany(mappedBy="typeEvaluation")
	private List<Evaluation> evaluations;

}
