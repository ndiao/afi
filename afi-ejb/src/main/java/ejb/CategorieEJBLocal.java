package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Categorie;

@Local
public interface CategorieEJBLocal {

	public void add(Categorie categorie);
	public Categorie findByCode(int code);
	public void update(Categorie categorie);
	public void delete(Categorie categorie);
	public List<Categorie> findAll();
}
