package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Etudiant;

/**
 * Session Bean implementation class EtudiantEJB
 */
@Stateless
@LocalBean
public class EtudiantEJB implements EtudiantEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Etudiant etudiant) throws Exception {
		em.persist(etudiant);
	}

	@Override
	public Etudiant findByMatricule(String matricule) {
		
		return em.find(Etudiant.class, matricule);
	}

	@Override
	public void update(Etudiant etudiant) {
		em.merge(etudiant);
	}

	@Override
	public void delete(Etudiant etudiant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Etudiant> findAll() {
		
		return em.createQuery("select e from Etudiant e").getResultList();
	}

	@Override
	public List<Etudiant> findAllByPrenomAndNom(String prenom, String nom) {
		Query q = em.createQuery("select e from Etudiant e where e.prenom like :prenom and e.nom like :nom");
		q.setParameter("prenom", "%"+prenom+"%");
		q.setParameter("nom", "%"+nom+"%");
		return q.getResultList();
	}

}
