package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Site;

/**
 * Session Bean implementation class SiteEJB
 */
@Stateless
@LocalBean
public class SiteEJB implements SiteEJBLocal {
	
	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;

	@Override
	public void add(Site site) {
		em.persist(site);
	}

	@Override
	public Site findByCode(int code) {
		
		return em.find(Site.class, code);
	}

	@Override
	public void update(Site site) {
		em.merge(site);
	}

	@Override
	public void delete(Site site) {
		em.remove(em.contains(site) ? site : em.merge(site));
	}

	@Override
	public List<Site> findAll() {
		
		return em.createQuery("select s from Site s").getResultList();
	}
	
}
