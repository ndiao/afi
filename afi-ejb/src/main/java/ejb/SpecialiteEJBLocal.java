package ejb;

import java.util.List;

import javax.ejb.Local;

import model.LesOption;
import model.Specialite;

@Local
public interface SpecialiteEJBLocal {

	public void add(Specialite specialite) throws Exception;
	public Specialite findByCode(String code);
	public List<Specialite> findAll();
	public void update(Specialite specialite);
	public void delete(Specialite specialite);
	public List<Specialite> findAllByMention(String codeMention);
	public List<LesOption> findAllBySpecialite(String codeSpec);
	public void addOption(LesOption option);
	
}
