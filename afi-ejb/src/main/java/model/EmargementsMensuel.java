package model;

import java.io.Serializable;
import java.util.List;

public class EmargementsMensuel implements Serializable{

	private String mois;
	private List<Emargement> emargements;
	private int duree;
	
	public EmargementsMensuel() {
		// TODO Auto-generated constructor stub
	}
	
	

	public EmargementsMensuel(String mois, List<Emargement> emargements, int duree) {
		super();
		this.mois = mois;
		this.emargements = emargements;
		this.duree = duree;
	}



	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	public List<Emargement> getEmargements() {
		return emargements;
	}
	public void setEmargements(List<Emargement> emargements) {
		this.emargements = emargements;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}
	
}
