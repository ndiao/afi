package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Ec;
import model.Programme;
import model.Ue;

/**
 * Session Bean implementation class ProgrammeEJB
 */
@Stateless
@LocalBean
public class ProgrammeEJB implements ProgrammeEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Programme programme) {
		em.persist(programme);
	}

	@Override
	public List<Programme> findAllByClasse(String codeClasse) {
		Query q = em.createQuery("select p from Programme p where p.mesclass.code = :codeClasse");
		q.setParameter("codeClasse", codeClasse);
		
		return q.getResultList();
	}

	@Override
	public void addEc(Ec ec) {
		em.persist(ec);
	}

	@Override
	public void updateEc(Ec ec) {
		em.merge(ec);
	}

	@Override
	public List<Programme> findAllByClasseAndSemestre(String codeClasse,
			String semestre) {
		Query q = em.createQuery("select p from Programme p where p.mesclass.code = :codeClasse and p.semestre = :semestre");
		q.setParameter("codeClasse", codeClasse);
		q.setParameter("semestre", semestre);
		return q.getResultList();
	}

	@Override
	public Programme findByUE(String codeUE) {
		Query q = em.createQuery("select p from Programme p where p.ue.code = :codeUE");
		q.setParameter("codeUE", codeUE);
		return (Programme) q.getResultList().get(0);
	}

	@Override
	public void delete(Programme programme) throws Exception {
		em.remove(em.contains(programme) ? programme : em.merge(programme));
	}

	@Override
	public List<Programme> findAllByUE(String codeUE) {
		Query q = em.createQuery("select p from Programme p where p.ue.code = :codeUE");
		q.setParameter("codeUE", codeUE);
		return q.getResultList();
	}

	
}
