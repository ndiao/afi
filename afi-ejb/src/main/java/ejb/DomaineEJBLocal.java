package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Domaine;

@Local
public interface DomaineEJBLocal {

	public void add(Domaine domaine);
	public Domaine findByCode(String code);
	public void update(Domaine domaine);
	public List<Domaine> findAll();
	public List<Domaine> findAllByAA(String codeAA);
}
