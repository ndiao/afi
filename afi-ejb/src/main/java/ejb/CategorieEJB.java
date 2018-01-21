package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Categorie;

/**
 * Session Bean implementation class CategorieEJB
 */
@Stateless
@LocalBean
public class CategorieEJB implements CategorieEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Categorie categorie) {
		em.persist(categorie);
	}

	@Override
	public Categorie findByCode(int code) {
		return em.find(Categorie.class, code);
	}

	@Override
	public void update(Categorie categorie) {
		em.merge(categorie);
	}

	@Override
	public void delete(Categorie categorie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Categorie> findAll() {
		return em.createQuery("select c from Categorie c").getResultList();
	}

}
