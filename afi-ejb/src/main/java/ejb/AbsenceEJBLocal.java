package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Absence;

@Local
public interface AbsenceEJBLocal {

	public void add(Absence absence) throws Exception;
	public List<Absence> findAll();
	public List<Absence> findAllByIns(int codeIns);
	public List<Absence> findAllByInsAndEC(int codeIns, String codeEC);
	public void update(Absence absence);
}
