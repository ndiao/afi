package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Inscription;
import model.Paiement;

/**
 * Session Bean implementation class InscriptionEJB
 */
@Stateless
@LocalBean
public class InscriptionEJB implements InscriptionEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Inscription inscription) throws Exception {
		if(!inscription.getMesclass().getCategorie().getNom().equals("BE")){
			if(inscription.getMesclass().getEcheance() == null){
				throw new Exception("L'écheance de cette classe n'a pas été défini");
			}
		}
		em.persist(inscription);
	}

	@Override
	public Inscription findByCode(int codeIns) {
		
		return em.find(Inscription.class, codeIns);
	}

	@Override
	public void update(Inscription inscription) {
		em.merge(inscription);
	}

	@Override
	public void delete(Inscription inscription) throws Exception{
		/*if(findAllPaiementByIns(inscription.getCodeIns()) != null){
			throw new Exception("Suppression impossible");
		}*/
		em.remove(em.contains(inscription) ? inscription : em.merge(inscription));
	}

	@Override
	public List<Inscription> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select i from Inscription i").getResultList();
	}

	@Override
	public List<Inscription> findAllByEtudiant(String matricule) {
		Query q = em.createQuery("select i from Inscription i where i.etudiant.matricule = :matricule");
		q.setParameter("matricule", matricule);
		return q.getResultList();
	}

	@Override
	public List<Inscription> findAllByClasse(String codeClasse) {
		Query q = em.createQuery("select i from Inscription i where i.mesclass.code = :codeClasse");
		q.setParameter("codeClasse", codeClasse);
		return q.getResultList();
	}

	@Override
	public Inscription findInscriptionByetudiant(String matricule)
			throws Exception {
		Query q = em.createQuery("select i from Inscription i where i.etudiant.matricule = :matricule and i.mesclass.specialite.mention.domaine.anneeAcademique.actived = true");
		q.setParameter("matricule", matricule);
		if(q.getResultList().isEmpty()){
			throw new Exception("Cet étudiant n'est pas encore inscrit à cette année academique");
		}
		return (Inscription) q.getResultList().get(0);
	}

	@Override
	public List<Paiement> findAllPaiementByIns(int codeIns) {
		Query q = em.createQuery("select p from Paiement p where p.inscription.codeIns = :codeIns");
		q.setParameter("codeIns", codeIns);
		return q.getResultList();
	}

    

}
