package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Ec;

@Local
public interface ECEJBLocal {

	public void add(Ec ec);
	public Ec findByCode(String code);
	public void update(Ec ec);
	public void delete(Ec ec) throws Exception;
	public List<Ec> findAll();
	public List<Ec> findAllByEnseignant(String matricule);
}
