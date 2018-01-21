package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Ec;

/**
 * Session Bean implementation class ECEJB
 */
@Stateless
@LocalBean
public class ECEJB implements ECEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;

	@Override
	public void add(Ec ec) {
		em.persist(ec);
	}

	@Override
	public Ec findByCode(String code) {
		
		return em.find(Ec.class, code);
	}

	@Override
	public void update(Ec ec) {
		em.merge(ec);
	}

	@Override
	public void delete(Ec ec) throws Exception {
		if(!ec.getProgrammations().isEmpty() || !ec.getEvaluations().isEmpty()){
			throw new Exception("Cet element constitutif n'est pas vide");
		}
		em.remove(em.contains(ec) ? ec : em.merge(ec));
	}

	@Override
	public List<Ec> findAll() {
		
		return em.createQuery("select e from Enseignant e").getResultList();
	}

	@Override
	public List<Ec> findAllByEnseignant(String matricule) {
		Query q = em.createQuery("select e from Ec e where e.enseignant.codeEns = :codeEns");
		q.setParameter("codeEns", matricule);
		return q.getResultList();
	}
	
}
