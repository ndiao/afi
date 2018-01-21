package ejb;

import java.util.List;

import javax.ejb.Local;

import model.TarificationScolarite;

@Local
public interface TarifScolariteEJBLocal {

	public void add(TarificationScolarite tarificationScolarite) throws Exception;
	public TarificationScolarite findByNiveauAndCategorie(int codeNiveau, int codeCat) throws Exception;
	public void update(TarificationScolarite tarificationScolarite);
	public void delete(TarificationScolarite tarificationScolarite);
	public List<TarificationScolarite> findAll();
	public List<TarificationScolarite> findAllByNiveau(int codeNiveau);
}
