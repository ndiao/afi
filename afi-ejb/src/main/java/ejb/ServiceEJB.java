package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Service;

/**
 * Session Bean implementation class ServiceEJB
 */
@Stateless
@LocalBean
public class ServiceEJB implements ServiceEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Service service) {
		em.persist(service);
	}

	@Override
	public void update(Service service) {
		em.merge(service);
	}

	@Override
	public void delete(Service service) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Service> findAll() {
		
		return em.createQuery("SELECT s FROM Service s").getResultList();
	}

	@Override
	public Service findByCode(int code) {
		
		return em.find(Service.class, code);
	}

	@Override
	public List<Service> findAllServiceByDirection(int codeDirection) {
		Query q = em.createQuery("SELECT s FROM Service s WHERE s.direction.code = :codeDirection");
		q.setParameter("codeDirection", codeDirection);
		return q.getResultList();
	}

    

}
