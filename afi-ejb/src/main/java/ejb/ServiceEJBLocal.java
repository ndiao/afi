package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Service;

@Local
public interface ServiceEJBLocal {

	public void add(Service service);
	public void update(Service service);
	public void delete(Service service);
	public List<Service> findAll();
	public Service findByCode(int code);
	public List<Service> findAllServiceByDirection(int codeDirection);
}
