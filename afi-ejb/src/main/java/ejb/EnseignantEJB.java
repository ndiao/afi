package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Enseignant;

/**
 * Session Bean implementation class EnseignantEJB
 */
@Stateless
@LocalBean
public class EnseignantEJB implements EnseignantEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Enseignant enseignant) {
		em.persist(enseignant);
	}

	@Override
	public Enseignant findByEnseignement(String matricule) {
		
		return em.find(Enseignant.class, matricule);
	}

	@Override
	public void update(Enseignant enseignant) {
		em.merge(enseignant);
	}

	@Override
	public void delete(Enseignant enseignant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Enseignant> findAll() {
		
		return em.createQuery("select e from Enseignant e").getResultList();
	}

	@Override
	public List<Enseignant> findAllByPrenomAndNom(String prenom, String nom) {
		Query q = em.createQuery("select e from Enseignant e where e.prenom like :prenom and e.nom like :nom");
		q.setParameter("prenom", "%"+prenom+"%");
		q.setParameter("nom", "%"+nom+"%");
		return q.getResultList();
	}

	@Override
	public Enseignant findByMatriculeAndPwd(String matricule, String pwd) throws Exception {
		Query q = em.createQuery("select e from Enseignant e where e.codeEns = :matricule and e.pwd = :pwd");
		q.setParameter("matricule", matricule);
		q.setParameter("pwd", pwd);
		List<Enseignant> enseignants = q.getResultList();
		if(enseignants.isEmpty()){
			throw new Exception("Echec de connexion");
		}
		else{
			if(!enseignants.get(0).isActived()){
				throw new Exception("Compte bloqué");
			}
		}
		return enseignants.get(0);
	}
	
}
