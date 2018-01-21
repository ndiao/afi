package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Emargement;

@Local
public interface EmargementEJBLocal {

	public void add(Emargement emargement) throws Exception;
	public Emargement findBycode(Long code);
	public void update(Emargement emargement);
	public void delete(Emargement emargement);
	public List<Emargement> findAll();
	public List<Emargement> findAllByEnseignant(String matricule);
	public List<Emargement> findAllByEnseignantAndMois(String matricule, int mois);
	public List<Emargement> findAllByProgrammation(int codeProg) throws Exception;
	public List<Emargement> findAllByEc(String codeEc);
	public List<Emargement> findAllByEcAndMois(String codeEc, int mois);
	public List<Integer> findAllMoisByEns(String codeEns);
}
