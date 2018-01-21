package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.LesOption;
import model.Specialite;

/**
 * Session Bean implementation class SpecialiteEJB
 */
@Stateless
@LocalBean
public class SpecialiteEJB implements SpecialiteEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Specialite specialite) throws Exception {
		List<Specialite> specialites = findAll();
		for(Specialite s : specialites){
			if(s.getSigle().equals(specialite.getSigle())){
				throw new Exception("Doublon sur spécialité");
			}
		}
		em.persist(specialite);
	}

	@Override
	public List<Specialite> findAll() {
		
		return em.createQuery("select s from Specialite s where s.mention.domaine.anneeAcademique.actived = true").getResultList();
	}

	@Override
	public void update(Specialite specialite) {
		em.merge(specialite);
	}

	@Override
	public void delete(Specialite specialite) {
		
	}

	@Override
	public Specialite findByCode(String code) {
		
		return em.find(Specialite.class, code);
	}

	@Override
	public List<Specialite> findAllByMention(String codeMention) {
		Query q = em.createQuery("select s from Specialite s where s.mention.code = :codeMention");
		q.setParameter("codeMention", codeMention);
		return q.getResultList();
	}

	@Override
	public List<LesOption> findAllBySpecialite(String codeSpec) {
		Query q = em.createQuery("select o from LesOption o where o.specialite.code = :codeSpec");
		q.setParameter("codeSpec", codeSpec);
		return q.getResultList();
	}

	@Override
	public void addOption(LesOption option) {
		em.persist(option);
	}

}
