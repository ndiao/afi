package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Programmation;

/**
 * Session Bean implementation class ProgrammationEJB
 */
@Stateless
@LocalBean
public class ProgrammationEJB implements ProgrammationEJBLocal {
	
	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;

	@Override
	public void add(Programmation programmation) throws Exception {
		if(findAllByJourAndSalle(programmation.getJour(), programmation.getSalle().getCode()).isEmpty()){
			em.persist(programmation);
		}
		else{
			List<Programmation> lp = findAllByJourAndSalle(programmation.getJour(), programmation.getSalle().getCode());
			for(Programmation p : lp){
				if(p.getHeureDebut().equals(programmation.getHeureDebut()) || p.getHeureFin().equals(programmation.getHeureDebut())){
					throw new Exception("Cette salle n'est pas libre à cette heure");
				}
			}
			em.persist(programmation);
		}
		
	}

	@Override
	public Programmation findByCode(int code) {
		
		return em.find(Programmation.class, code);
	}

	@Override
	public void update(Programmation programmation) throws Exception {
		if(findAllByJourAndSalle(programmation.getJour(), programmation.getSalle().getCode()).isEmpty()){
			em.merge(programmation);
		}
		else{
			List<Programmation> lp = findAllByJourAndSalle(programmation.getJour(), programmation.getSalle().getCode());
			for(Programmation p : lp){
				if(p.getHeureDebut().equals(programmation.getHeureDebut()) || p.getHeureFin().equals(programmation.getHeureDebut())){
					throw new Exception("Cette salle n'est pas libre à cette heure");
				}
			}
			em.merge(programmation);
		}
	}

	@Override
	public void delete(Programmation programmation) {
		
	}

	@Override
	public List<Programmation> findAll() {
		
		return em.createQuery("select p from Programmation p").getResultList();
	}

	@Override
	public List<Programmation> findAllByJourAndSalle(String jour, int codeSalle) {
		Query q = em.createQuery("select p from Programmation p where p.jour = :jour and p.salle.code = :codeSalle");
		q.setParameter("jour", jour);
		q.setParameter("codeSalle", codeSalle);
		return q.getResultList();
	}

	@Override
	public List<Programmation> findAllByEc(String codeEc) {
		Query q = em.createQuery("select p from Programmation p where p.ec.code = :codeEc");
		q.setParameter("codeEc", codeEc);
		return q.getResultList();
	}
	
}
