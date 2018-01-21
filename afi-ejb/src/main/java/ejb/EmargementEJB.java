package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Emargement;

/**
 * Session Bean implementation class EmargementEJB
 */
@Stateless
@LocalBean
public class EmargementEJB implements EmargementEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Emargement emargement) throws Exception {
		em.persist(emargement);
	}

	@Override
	public Emargement findBycode(Long code) {
		
		return em.find(Emargement.class, code);
	}

	@Override
	public void update(Emargement emargement) {
		em.merge(emargement);
	}

	@Override
	public void delete(Emargement emargement) {
		
	}

	@Override
	public List<Emargement> findAll() {
		
		return em.createQuery("select e from Emargement e").getResultList();
	}

	@Override
	public List<Emargement> findAllByEnseignant(String matricule) {
		Query q = em.createQuery("select e from Emargement e where e.programmation.ec.enseignant.codeEns = :codeEns");
		q.setParameter("codeEns", matricule);
		return q.getResultList();
	}

	@Override
	public List<Emargement> findAllByEnseignantAndMois(String matricule,
			int mois) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emargement> findAllByProgrammation(int codeProg) throws Exception{
		Query q = em.createQuery("select e from Emargement e where e.programmation.codeProg = :codeProg");
		q.setParameter("codeProg", codeProg);
		if(q.getResultList().isEmpty())
			throw new Exception("Ce planning n'a pas encore été emargé");
		return q.getResultList();
	}

	@Override
	public List<Emargement> findAllByEc(String codeEc) {
		Query q = em.createQuery("select e from Emargement e where e.programmation.ec.code = :codeEc");
		q.setParameter("codeEc", codeEc);
		return q.getResultList();
	}

	@Override
	public List<Emargement> findAllByEcAndMois(String codeEc, int mois) {
		Query q = em.createQuery("select e from Emargement e where e.programmation.ec.code = :codeEc and month(e.dateEm) = :mois");
		q.setParameter("codeEc", codeEc);
		q.setParameter("mois", mois);
		return q.getResultList();
	}

	@Override
	public List<Integer> findAllMoisByEns(String codeEns) {
		Query q = em.createQuery("select distinct(month(e.dateEm)) from Emargement e where e.programmation.ec.enseignant.codeEns = :codeEns");
		q.setParameter("codeEns", codeEns);
		return q.getResultList();
	}
}
