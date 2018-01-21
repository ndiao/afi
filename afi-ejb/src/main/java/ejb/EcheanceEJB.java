package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Echeance;
import model.Mois;

/**
 * Session Bean implementation class EcheanceEJB
 */
@Stateless
@LocalBean
public class EcheanceEJB implements EcheanceEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Echeance echeance) {
		em.persist(echeance);
	}

	@Override
	public Echeance findByCode(Long code) {
		
		return em.find(Echeance.class, code);
	}

	@Override
	public void update(Echeance echeance) {
		em.merge(echeance);
	}

	@Override
	public List<Echeance> findAll() {
		
		return em.createQuery("select e from Echeance e").getResultList();
	}

	@Override
	public List<Mois> findAllMoisByEcheance(Long codeMois) {
		Query q = em.createQuery("select m from Mois m where m.echeance.code = :codeMois");
		q.setParameter("codeMois", codeMois);
		return q.getResultList();
	}

	

}
