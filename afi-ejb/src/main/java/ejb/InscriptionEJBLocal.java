package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Inscription;
import model.Paiement;

@Local
public interface InscriptionEJBLocal {

	public void add(Inscription inscription) throws Exception;
	public Inscription findByCode(int codeIns);
	public void update(Inscription inscription);
	public void delete(Inscription inscription) throws Exception;
	public List<Inscription> findAll();
	public List<Inscription> findAllByEtudiant(String matricule);
	public List<Inscription> findAllByClasse(String codeClasse);
	public Inscription findInscriptionByetudiant(String matricule) throws Exception;
	public List<Paiement> findAllPaiementByIns(int codeIns);
}
