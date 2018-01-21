package ejb;

import java.util.List;

import javax.ejb.Local;

import model.PaiementFraisAnnexe;

@Local
public interface PaiementFraisAnnexeEJBLocal {

	public List<PaiementFraisAnnexe> findAllByIns(int codeIns);
	public void add(PaiementFraisAnnexe pfa);
	public void update(PaiementFraisAnnexe pfa);
}
