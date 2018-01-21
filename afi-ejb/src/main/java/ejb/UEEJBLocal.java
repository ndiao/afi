package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Ue;

@Local
public interface UEEJBLocal {

	public void add(Ue ue);
	public Ue findByCode(String codeUE);
	public void update(Ue ue);
	public List<Ue> findAll();
	public void delete(Ue ue);
}
