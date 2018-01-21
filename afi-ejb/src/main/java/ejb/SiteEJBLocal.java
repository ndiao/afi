package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Site;

@Local
public interface SiteEJBLocal {

	public void add(Site site);
	public Site findByCode(int code);
	public void update(Site site);
	public void delete(Site site);
	public List<Site> findAll();
}
