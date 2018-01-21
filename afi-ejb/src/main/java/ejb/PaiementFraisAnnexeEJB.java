package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.PaiementFraisAnnexe;

/**
 * Session Bean implementation class PaiementFraisAnnexeEJB
 */
@Stateless
@LocalBean
public class PaiementFraisAnnexeEJB implements PaiementFraisAnnexeEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public List<PaiementFraisAnnexe> findAllByIns(int codeIns) {
		Query q = em.createQuery("select pfa from PaiementFraisAnnexe pfa where pfa.inscription.codeIns = :codeIns");
		q.setParameter("codeIns", codeIns);
		return q.getResultList();
	}

	@Override
	public void add(PaiementFraisAnnexe pfa) {
		em.persist(pfa);
	}

	@Override
	public void update(PaiementFraisAnnexe pfa) {
		em.merge(pfa);
	}
	
		
}
