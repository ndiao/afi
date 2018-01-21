package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Niveau;
import model.Semestre;

@Local
public interface NiveauEJBLocal {

	public void add(Niveau niveau);
	public Niveau findByCode(int code);
	public void update(Niveau niveau);
	public void delete(Niveau niveau);
	public List<Niveau> findAll();
	public List<Semestre> findAllSemestreByNiveau(int codeNiveau);
	public void addSemestre(Semestre semestre);
}
