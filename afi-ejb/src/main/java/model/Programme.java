package model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="programme")
public class Programme implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProgrammePK id;

	private String semestre;

	//bi-directional many-to-one association to Mesclass
	@ManyToOne
	@JoinColumn(name="code_classe", insertable=false, updatable=false)
	private Mesclass mesclass;

	//bi-directional many-to-one association to Ue
	@ManyToOne
	@JoinColumn(name="code_ue", insertable=false, updatable=false)
	private Ue ue;
	
	public Programme() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Programme(ProgrammePK id, String semestre, Mesclass mesclass, Ue ue) {
		super();
		this.id = id;
		this.semestre = semestre;
		this.mesclass = mesclass;
		this.ue = ue;
	}



	public ProgrammePK getId() {
		return id;
	}

	public void setId(ProgrammePK id) {
		this.id = id;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Mesclass getMesclass() {
		return mesclass;
	}

	public void setMesclass(Mesclass mesclass) {
		this.mesclass = mesclass;
	}

	public Ue getUe() {
		return ue;
	}

	public void setUe(Ue ue) {
		this.ue = ue;
	}
}
