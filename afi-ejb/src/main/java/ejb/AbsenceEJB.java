package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Absence;

/**
 * Session Bean implementation class AbsenceEJB
 */
@Stateless
@LocalBean
public class AbsenceEJB implements AbsenceEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;

	@Override
	public void add(Absence absence) throws Exception {
		List<Absence> la = findAll();
		for(Absence a : la){
			if(a.getId().equals(absence))
				throw new Exception("Emargement déja effectué");
		}
		em.persist(absence);
	}

	@Override
	public List<Absence> findAll() {
		
		return em.createQuery("select a from Absence a").getResultList();
	}

	@Override
	public List<Absence> findAllByIns(int codeIns) {
		Query q = em.createQuery("select a from Absence a where a.inscription.codeIns = :codeIns");
		q.setParameter("codeIns", codeIns);
		return q.getResultList();
	}

	@Override
	public List<Absence> findAllByInsAndEC(int codeIns, String codeEC) {
		Query q = em.createQuery("select a from Absence a where a.inscription.codeIns = :codeIns and a.emargement.programmation.ec.code = :codeEc");
		q.setParameter("codeIns", codeIns);
		q.setParameter("codeEc", codeEC);
		return q.getResultList();
	}

	@Override
	public void update(Absence absence) {
		// TODO Auto-generated method stub
		
	}
	
}
