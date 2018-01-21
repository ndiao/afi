package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Employe;

@Local
public interface EmployeEJBLocal {

	public void add(Employe employe) throws Exception;
	public Employe getPresident();
	public Employe findByEmailAndPwd(String email, String pwd) throws Exception;
	public List<Employe> findAllAgentByDirecteur(String codeSup);
	public Employe findByCode(String code);
	public List<Employe> findAll();
}
