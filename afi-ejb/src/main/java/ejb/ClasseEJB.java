package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Inscription;
import model.Mesclass;
import model.Programmation;
import model.Programme;

/**
 * Session Bean implementation class ClasseEJB
 */
@Stateless
@LocalBean
public class ClasseEJB implements ClasseEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Mesclass classe) throws Exception {
		List<Mesclass> classes = findAll();
		for(Mesclass c : classes){
			if(c.getCode().equals(classe.getCode())){
				throw new Exception("Doublon sur classe");
			}
		}
		em.persist(classe);
	}

	@Override
	public Mesclass findByCode(String code) throws Exception {
		Query q = em.createQuery("select c from Mesclass c where c.code = :codeClasse");
		q.setParameter("codeClasse", code);
		List<Mesclass> classes = q.getResultList();
		if(classes.isEmpty()){
			throw new Exception("Classe inexistante");
		}
		return (Mesclass) q.getResultList().get(0);
	}

	@Override
	public void update(Mesclass classe) {
		
		em.merge(classe);
	}

	@Override
	public void delete(Mesclass classe) throws Exception {
		List<Inscription> inscriptions = classe.getInscriptions();
		List<Programme> programmes = findAllByClasse(classe.getCode());
		if(inscriptions.size() != 0){
			throw new Exception("Cette classe contient des inscrits");
		}
		if(programmes.size() != 0){
			throw new Exception("Cette classe a un programme");
		}
		em.remove(em.contains(classe) ? classe : em.merge(classe));
		
		
	}

	@Override
	public List<Mesclass> findAll() {
		
		return em.createQuery("select c from Mesclass c where c.specialite.mention.domaine.anneeAcademique.actived = true").getResultList();
	}

	@Override
	public List<Mesclass> findAllBySpecialite(String codeSpecialite) {
		Query q = em.createQuery("select c from Mesclass c where c.specialite.code = :codeSpecialite");
		q.setParameter("codeSpecialite", codeSpecialite);
		return q.getResultList();
	}

	@Override
	public List<Mesclass> findAllByNiveauAndCategorie(int codeNiveau,
			int codeCat) throws Exception{
		Query q = em.createQuery("select c from Mesclass c where c.niveau.code = :codeNiveau and c.categorie.code = :codeCat and c.specialite.mention.domaine.anneeAcademique.actived = true");
		q.setParameter("codeNiveau", codeNiveau);
		q.setParameter("codeCat", codeCat);
		if(q.getResultList().isEmpty()){
			throw new Exception("cette classe n'existe pas");
		}
		return q.getResultList();
	}

	@Override
	public List<Mesclass> findAllByNiveauCategorieAndMention(int codeNiveau,
			int codeCat, String codeMention){
		Query q = em.createQuery("select c from Mesclass c where c.niveau.code = :codeNiveau and c.categorie.code = :codeCat and c.specialite.mention.code = :codeMention");
		q.setParameter("codeNiveau", codeNiveau);
		q.setParameter("codeCat", codeCat);
		q.setParameter("codeMention", codeMention);
		return q.getResultList();
	}

	@Override
	public List<Mesclass> findAllByNiveauCategorieAndSpecialite(int codeNiveau,
			int codeCat, String codeSpec) {
		Query q = em.createQuery("select c from Mesclass c where c.niveau.code = :codeNiveau and c.categorie.code = :codeCat and c.specialite.code = :codeSpec");
		q.setParameter("codeNiveau", codeNiveau);
		q.setParameter("codeCat", codeCat);
		q.setParameter("codeSpec", codeSpec);
		return q.getResultList();
	}

	@Override
	public List<Mesclass> findAllByAgent(String matriculeAgent) {
		Query q = em.createQuery("select c from Mesclass c where c.utilisateur.matricule = :matriculeAgent and c.specialite.mention.domaine.anneeAcademique.actived = true");
		q.setParameter("matriculeAgent", matriculeAgent);
		return q.getResultList();
	}

	@Override
	public List<Programme> findAllByClasse(String codeClasse) {
		Query q = em.createQuery("select p from Programme p where p.mesclass.code = :codeClasse");
		q.setParameter("codeClasse", codeClasse);
		
		return q.getResultList();
	}

	

}
