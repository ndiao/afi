package ejb;

import java.util.List;

import javax.ejb.Local;

import model.FraisAnnexe;
import model.PaiementFraisAnnexe;

@Local
public interface FraisAnnexeEJBLocal {

	public void add(FraisAnnexe fraisAnnexe);
	public FraisAnnexe findByCode(int code);
	public void update(FraisAnnexe fraisAnnexe);
	public void delete(FraisAnnexe fraisAnnexe);
	public List<FraisAnnexe> findAll();
	public void payerFraisAnnexe(PaiementFraisAnnexe pfa) throws Exception;
	public List<PaiementFraisAnnexe> findAllByInscription(int codeIns);
}
