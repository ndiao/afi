package ejb;

import java.util.List;

import javax.ejb.Local;

import model.AnneeAcademique;

@Local
public interface AnneeAcademiqueEJBLocal {

	public void add(AnneeAcademique anneeAcademique) throws Exception;
	public void update(AnneeAcademique anneeAcademique);
	public AnneeAcademique findByCode(String code);
	public List<AnneeAcademique> findAll();
	public AnneeAcademique getCurrentAA();
}
