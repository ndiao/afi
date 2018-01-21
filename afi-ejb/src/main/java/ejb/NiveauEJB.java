package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Niveau;
import model.Semestre;

/**
 * Session Bean implementation class NiveauEJB
 */
@Stateless
@LocalBean
public class NiveauEJB implements NiveauEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Niveau niveau) {
		em.persist(niveau);
	}

	@Override
	public Niveau findByCode(int code) {
		
		return em.find(Niveau.class, code);
	}

	@Override
	public void update(Niveau niveau) {
		em.merge(niveau);
	}

	@Override
	public void delete(Niveau niveau) {
		
	}

	@Override
	public List<Niveau> findAll() {
		
		return em.createQuery("SELECT n FROM Niveau n").getResultList();
	}

	@Override
	public List<Semestre> findAllSemestreByNiveau(int codeNiveau) {
		Query q = em.createQuery("select s from Semestre s where s.niveau.code = :codeNiveau");
		q.setParameter("codeNiveau", codeNiveau);
		return q.getResultList();
	}

	@Override
	public void addSemestre(Semestre semestre) {
		em.persist(semestre);
	}

}
