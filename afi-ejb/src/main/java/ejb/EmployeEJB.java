package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Employe;

/**
 * Session Bean implementation class EmployeEJB
 */
@Stateless
@LocalBean
public class EmployeEJB implements EmployeEJBLocal {

	@PersistenceContext(unitName="PU_UNIVERSITY")
	private EntityManager em;
	
	@Override
	public void add(Employe employe) throws Exception {
		em.persist(employe);
	}

	@Override
	public Employe getPresident() {
		
		return (Employe) em.createQuery("SELECT e FROM Employe e WHERE e.superieur IS NULL").getResultList().get(0);
	}

	@Override
	public Employe findByEmailAndPwd(String email, String pwd) throws Exception {
		Employe e = null;
		Query q = em.createQuery("SELECT e FROM Employe e WHERE e.email = :email AND e.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", pwd);
		List<Employe> employes = q.getResultList();
		if(employes.isEmpty()){
			throw new Exception("Echec de connexion");
		}
		else{
			e = employes.get(0);
			if(!e.isActived()){
				throw new Exception("Compte bloqué");
			}
		}
		return e;
	}

	@Override
	public List<Employe> findAllAgentByDirecteur(String codeSup) {
		Query q =  em.createQuery("SELECT e FROM Employe e WHERE e.superieur.matricule = :codeSup");
		q.setParameter("codeSup", codeSup);
		return q.getResultList();
	}

	@Override
	public Employe findByCode(String code) {
		
		return em.find(Employe.class, code);
	}

	@Override
	public List<Employe> findAll() {
		
		return em.createQuery("select e from Employe e").getResultList();
	}

}
