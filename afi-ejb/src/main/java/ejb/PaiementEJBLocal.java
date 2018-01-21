package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Paiement;

@Local
public interface PaiementEJBLocal {

	public void add(Paiement paiement);
	public Paiement findByCode(int code);
	public void update(Paiement paiement);
	public void delete(Paiement paiement);
	public List<Paiement> findAllbyIns(int codeIns);
	public Paiement findByInsAndMois(int codeIns, String mois);
}
