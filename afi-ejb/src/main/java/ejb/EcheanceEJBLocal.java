package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Echeance;
import model.Mois;

@Local
public interface EcheanceEJBLocal {

	public void add(Echeance echeance);
	public Echeance findByCode(Long code);
	public void update(Echeance echeance);
	public List<Echeance> findAll();
	public List<Mois> findAllMoisByEcheance(Long codeMois);
	
}
