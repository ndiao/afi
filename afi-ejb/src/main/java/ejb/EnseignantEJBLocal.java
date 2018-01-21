package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Enseignant;

@Local
public interface EnseignantEJBLocal {

	public void add(Enseignant enseignant);
	public Enseignant findByEnseignement(String matricule);
	public void update(Enseignant enseignant);
	public void delete(Enseignant enseignant);
	public List<Enseignant> findAll();
	public List<Enseignant> findAllByPrenomAndNom(String prenom, String nom);
	public Enseignant findByMatriculeAndPwd(String matricule, String pwd) throws Exception;
}
