package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Mesclass;
import model.Programme;

@Local
public interface ClasseEJBLocal {

	public void add(Mesclass classe) throws Exception;
	public Mesclass findByCode(String code) throws Exception;
	public void update(Mesclass classe);
	public void delete(Mesclass classe) throws Exception;
	public List<Mesclass> findAll();
	public List<Mesclass> findAllBySpecialite(String codeSpecialite);
	public List<Mesclass> findAllByNiveauAndCategorie(int codeNiveau, int codeCat) throws Exception;
	public List<Mesclass> findAllByNiveauCategorieAndMention(int codeNiveau, int codeCat, String codeMention);
	public List<Mesclass> findAllByNiveauCategorieAndSpecialite(int codeNiveau, int codeCat, String codeSpec);
	public List<Mesclass> findAllByAgent(String matriculeAgent);
	public List<Programme> findAllByClasse(String codeClasse);
}
