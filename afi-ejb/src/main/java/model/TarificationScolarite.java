package model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tarification_scolarite")
public class TarificationScolarite implements Serializable{

	@EmbeddedId
	private TarificationScolaritePK id;
	
	private double fraisIns;
	private double mensualite;
	@ManyToOne
	@JoinColumn(name="code_niveau", insertable=false, updatable=false)
	private Niveau niveau;
	@ManyToOne
	@JoinColumn(name="code_categorie", insertable=false, updatable=false)
	private Categorie categorie;
	
	public TarificationScolarite() {
		// TODO Auto-generated constructor stub
	}
	
	public TarificationScolarite(double fraisIns, double mensualite,
			Niveau niveau, Categorie categorie) {
		super();
		this.fraisIns = fraisIns;
		this.mensualite = mensualite;
		this.niveau = niveau;
		this.categorie = categorie;
	}

	public TarificationScolaritePK getId() {
		return id;
	}
	public void setId(TarificationScolaritePK id) {
		this.id = id;
	}
	public double getFraisIns() {
		return fraisIns;
	}
	public void setFraisIns(double fraisIns) {
		this.fraisIns = fraisIns;
	}
	public double getMensualite() {
		return mensualite;
	}
	public void setMensualite(double mensualite) {
		this.mensualite = mensualite;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
