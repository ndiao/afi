package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Salle;

/**
 * Session Bean implementation class SalleEJB
 */
@Stateless
@LocalBean
public class SalleEJB implements SalleEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Salle salle) {
		em.persist(salle);
	}

	@Override
	public Salle findByCode(int code) {
		
		return em.find(Salle.class, code);
	}

	@Override
	public void update(Salle salle) {
		em.persist(salle);
	}

	@Override
	public void delete(Salle salle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Salle> findAll() {
		
		return em.createQuery("select s from Salle s").getResultList();
	}

	@Override
	public List<Salle> findAllBySite(int codeSite) {
		Query q = em.createQuery("select s from Salle s where s.site.code = :codeSite");
		q.setParameter("codeSite", codeSite);
		return q.getResultList();
	}
	
}
