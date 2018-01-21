package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Etudiant;

@Local
public interface EtudiantEJBLocal {

	public void add(Etudiant etudiant) throws Exception;
	public Etudiant findByMatricule(String matricule);
	public void update(Etudiant etudiant);
	public void delete(Etudiant etudiant);
	public List<Etudiant> findAll();
	public List<Etudiant> findAllByPrenomAndNom(String prenom, String nom);
}
