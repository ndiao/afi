package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Salle;

@Local
public interface SalleEJBLocal {

	public void add(Salle salle);
	public Salle findByCode(int code);
	public void update(Salle salle);
	public void delete(Salle salle);
	public List<Salle> findAll();
	public List<Salle> findAllBySite(int codeSite);
}
