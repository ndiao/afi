package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Paiement;

/**
 * Session Bean implementation class PaiementEJB
 */
@Stateless
@LocalBean
public class PaiementEJB implements PaiementEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;

	@Override
	public void add(Paiement paiement) {
		em.persist(paiement);
	}

	@Override
	public Paiement findByCode(int code) {
		
		return em.find(Paiement.class, code);
	}

	@Override
	public void update(Paiement paiement) {
		em.merge(paiement);
	}

	@Override
	public void delete(Paiement paiement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Paiement> findAllbyIns(int codeIns) {
		Query q = em.createQuery("select p from Paiement p where p.inscription.codeIns = :codeIns");
		q.setParameter("codeIns", codeIns);
		return q.getResultList();
	}

	@Override
	public Paiement findByInsAndMois(int codeIns, String mois) {
		Query q = em.createQuery("select p from Paiement p where p.inscription.codeIns = :codeIns and p.mois = :mois");
		q.setParameter("codeIns", codeIns);
		q.setParameter("mois", mois);
		return (Paiement) q.getResultList().get(0);
	}
	
}
