package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Programmation;

@Local
public interface ProgrammationEJBLocal {

	public void add(Programmation programmation) throws Exception;
	public Programmation findByCode(int code);
	public void update(Programmation programmation) throws Exception;
	public void delete(Programmation programmation);
	public List<Programmation> findAll();
	public List<Programmation> findAllByJourAndSalle(String jour, int codeSalle);
	public List<Programmation> findAllByEc(String codeEc);
}
