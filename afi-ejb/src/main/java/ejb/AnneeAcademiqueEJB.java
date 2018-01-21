package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.AnneeAcademique;

/**
 * Session Bean implementation class AnneeAcademiqueEJB
 */
@Stateless
@LocalBean
public class AnneeAcademiqueEJB implements AnneeAcademiqueEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(AnneeAcademique anneeAcademique) throws Exception {
		if(anneeAcademique.getDateDebut().after(anneeAcademique.getDateFin())){
			throw new Exception("La date de fin ne doit pas être anterieure à la date de debut");
		}
		em.persist(anneeAcademique);
	}

	@Override
	public void update(AnneeAcademique anneeAcademique) {
		em.merge(anneeAcademique);
	}

	@Override
	public AnneeAcademique findByCode(String code) {
		
		return em.find(AnneeAcademique.class, code);
	}

	@Override
	public List<AnneeAcademique> findAll() {
		
		return em.createQuery("select a from AnneeAcademique a").getResultList();
	}

	@Override
	public AnneeAcademique getCurrentAA() {
		
		return (AnneeAcademique) em.createQuery("select a from AnneeAcademique a where a.actived = true").getResultList().get(0);
	}

}
