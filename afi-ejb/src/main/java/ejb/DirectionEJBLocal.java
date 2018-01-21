package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Direction;
import model.Service;

@Local
public interface DirectionEJBLocal {

	public void add(Direction direction);
	public List<Direction> findAll();
	public void update(Direction direction);
	public Direction findByCode(int code);
	public List<Service> findAllServiceByDirection(int codeDirection);
	public void delete(Direction direction) throws Exception;
}
