package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.FraisAnnexe;
import model.PaiementFraisAnnexe;

/**
 * Session Bean implementation class FraisAnnexeEJB
 */
@Stateless
@LocalBean
public class FraisAnnexeEJB implements FraisAnnexeEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;

	@Override
	public void add(FraisAnnexe fraisAnnexe) {
		em.persist(fraisAnnexe);
	}

	@Override
	public FraisAnnexe findByCode(int code) {
		
		return em.find(FraisAnnexe.class, code);
	}

	@Override
	public void update(FraisAnnexe fraisAnnexe) {
		em.merge(fraisAnnexe);
	}

	@Override
	public void delete(FraisAnnexe fraisAnnexe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FraisAnnexe> findAll() {
		
		return em.createQuery("select fa from FraisAnnexe fa").getResultList();
	}

	@Override
	public void payerFraisAnnexe(PaiementFraisAnnexe pfa) throws Exception{
		
		em.persist(pfa);
	}

	@Override
	public List<PaiementFraisAnnexe> findAllByInscription(int codeIns) {
		Query q = em.createQuery("select pfa from PaiementFraisAnnexe pfa where pfa.inscription.codeIns = :codeIns");
		q.setParameter("codeIns", codeIns);
		return q.getResultList();
	}
	
}
