package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Domaine;

/**
 * Session Bean implementation class DomaineEJB
 */
@Stateless
@LocalBean
public class DomaineEJB implements DomaineEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Domaine domaine) {
		em.persist(domaine);
	}

	@Override
	public Domaine findByCode(String code) {
		
		return em.find(Domaine.class, code);
	}

	@Override
	public void update(Domaine domaine) {
		em.merge(domaine);
		
	}

	@Override
	public List<Domaine> findAll() {
		em.createQuery("select d from Domaine d").getResultList();
		return null;
	}

	@Override
	public List<Domaine> findAllByAA(String codeAA) {
		Query q = em.createQuery("select d from Domaine d where d.anneeAcademique.code = :codeAA");
		q.setParameter("codeAA", codeAA);
		return q.getResultList();
	}

}
