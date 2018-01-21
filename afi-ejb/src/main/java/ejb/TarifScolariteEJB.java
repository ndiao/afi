package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.TarificationScolarite;

/**
 * Session Bean implementation class TarifScolariteEJB
 */
@Stateless
@LocalBean
public class TarifScolariteEJB implements TarifScolariteEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(TarificationScolarite tarificationScolarite) throws Exception {
		if(findByNiveauAndCategorie(tarificationScolarite.getNiveau().getCode(), tarificationScolarite.getCategorie().getCode()) == null){
			em.persist(tarificationScolarite);
		}
		else{
			throw new Exception("Doublon");
		}
	}

	@Override
	public TarificationScolarite findByNiveauAndCategorie(int codeNiveau,
			int codeCat) throws Exception {
		TarificationScolarite ts = null;
		Query q = em.createQuery("select t from TarificationScolarite t where t.niveau.code = :codeNiveau and t.categorie.code = :codeCat");
		q.setParameter("codeNiveau", codeNiveau);
		q.setParameter("codeCat", codeCat);
		List<TarificationScolarite> lts = q.getResultList();
		if(!lts.isEmpty()){
			ts = (TarificationScolarite) q.getResultList().get(0);
		}
		return ts;
	}

	@Override
	public void update(TarificationScolarite tarificationScolarite) {
		em.merge(tarificationScolarite);
	}

	@Override
	public void delete(TarificationScolarite tarificationScolarite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TarificationScolarite> findAll() {
		
		return em.createQuery("select t from TarificationScolarite t").getResultList();
	}

	@Override
	public List<TarificationScolarite> findAllByNiveau(int codeNiveau) {
		Query q = em.createQuery("select t from TarificationScolarite t where t.niveau.code = :codeNiveau");
		q.setParameter("codeNiveau", codeNiveau);
		return q.getResultList();
	}

    

}
