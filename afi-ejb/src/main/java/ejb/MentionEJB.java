package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Mention;

/**
 * Session Bean implementation class MentionEJB
 */
@Stateless
@LocalBean
public class MentionEJB implements MentionEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void create(Mention mention) {
		em.persist(mention);
	}

	@Override
	public Mention findByCode(String code) {
		
		return em.find(Mention.class, code);
	}

	@Override
	public void update(Mention mention) {
		em.merge(mention);
		
	}

	@Override
	public void delete(Mention mention) {
		
		
	}

	@Override
	public List<Mention> findAll() {
		
		return em.createQuery("select m from Mention m").getResultList();
	}

	@Override
	public List<Mention> findAllByAA(String codeAA) {
		Query q = em.createQuery("select m from Mention m where m.domaine.anneeAcademique.code = :codeAA");
		q.setParameter("codeAA", codeAA);
		return q.getResultList();
	}

	@Override
	public List<Mention> findAllByDomaine(String codeDomaine) {
		Query q = em.createQuery("select m from Mention m where m.domaine.code = :codeDomaine");
		q.setParameter("codeDomaine", codeDomaine);
		return q.getResultList();
	}

}
