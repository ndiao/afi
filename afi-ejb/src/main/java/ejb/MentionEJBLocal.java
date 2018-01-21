package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Mention;

@Local
public interface MentionEJBLocal {

	public void create(Mention mention);
	public Mention findByCode(String code);
	public void update(Mention mention);
	public void delete(Mention mention);
	public List<Mention> findAll();
	public List<Mention> findAllByAA(String codeAA);
	public List<Mention> findAllByDomaine(String codeDomaine);
}
