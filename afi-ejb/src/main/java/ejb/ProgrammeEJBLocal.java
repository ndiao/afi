package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Ec;
import model.Programme;

@Local
public interface ProgrammeEJBLocal {

	public void add(Programme programme);
	public List<Programme> findAllByClasse(String codeClasse);
	public void addEc(Ec ec);
	public void updateEc(Ec ec);
	public List<Programme> findAllByClasseAndSemestre(String codeClasse, String semestre);
	public Programme findByUE(String codeUE);
	public void delete(Programme programme) throws Exception;
	public List<Programme> findAllByUE(String codeUE);

	
}
