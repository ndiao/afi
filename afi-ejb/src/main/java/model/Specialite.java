package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="specialite")
public class Specialite implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private String nom;

	private String sigle;

	//bi-directional many-to-one association to Mesclass
	@OneToMany(mappedBy="specialite")
	@JsonIgnore
	private List<Mesclass> mesclasses;
	
	@OneToMany(mappedBy="specialite")
	@JsonIgnore
	private List<LesOption> options;

	//bi-directional many-to-one association to Mention
	@ManyToOne
	@JoinColumn(name="code_mention")
	private Mention mention;

	public Specialite() {
		// TODO Auto-generated constructor stub
	}
	
	public Specialite(String code, String nom, String sigle, Mention mention) {
		super();
		this.code = code;
		this.nom = nom;
		this.sigle = sigle;
		this.mention = mention;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSigle() {
		return sigle;
	}

	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	public List<Mesclass> getMesclasses() {
		return mesclasses;
	}

	public void setMesclasses(List<Mesclass> mesclasses) {
		this.mesclasses = mesclasses;
	}

	public List<LesOption> getOptions() {
		return options;
	}

	public void setOptions(List<LesOption> options) {
		this.options = options;
	}

	public Mention getMention() {
		return mention;
	}

	public void setMention(Mention mention) {
		this.mention = mention;
	}

	@Override
	public String toString() {
		return "Specialite [code=" + code + ", nom=" + nom + ", sigle=" + sigle
				+ "]";
	}
	
}
