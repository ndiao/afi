package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Ue;

/**
 * Session Bean implementation class UEEJB
 */
@Stateless
@LocalBean
public class UEEJB implements UEEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Ue ue) {
		em.persist(ue);
	}

	@Override
	public Ue findByCode(String codeUE) {
		return em.find(Ue.class, codeUE);
	}

	@Override
	public void update(Ue ue) {
		em.merge(ue);
	}

	@Override
	public List<Ue> findAll() {
		
		return em.createQuery("select ue from Ue ue").getResultList();
	}

	@Override
	public void delete(Ue ue) {
		em.remove(em.contains(ue) ? ue : em.merge(ue));
	}

}
