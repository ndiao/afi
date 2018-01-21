package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Direction;
import model.Service;

/**
 * Session Bean implementation class DirectionEJB
 */
@Stateless
@LocalBean
public class DirectionEJB implements DirectionEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	@Override
	public void add(Direction direction) {
		em.persist(direction);
	}
	@Override
	public List<Direction> findAll() {
		
		return em.createQuery("SELECT d FROM Direction d").getResultList();
	}
	@Override
	public void update(Direction direction) {
		em.merge(direction);
		
	}
	@Override
	public Direction findByCode(int code) {
		return em.find(Direction.class, code);
	}
	@Override
	public void delete(Direction direction) throws Exception {
		if(!findAllServiceByDirection(direction.getCode()).isEmpty()){
			throw new Exception("Cette direction n'est pas vide");
		}
		em.remove(em.contains(direction) ? direction : em.merge(direction));
		
	}
	@Override
	public List<Service> findAllServiceByDirection(int codeDirection) {
		Query q = em.createQuery("SELECT s FROM Service s WHERE s.direction.code = :codeDirection");
		q.setParameter("codeDirection", codeDirection);
		return q.getResultList();
	}

}
