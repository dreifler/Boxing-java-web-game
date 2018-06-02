package boxing.dao;

import java.util.List;

import boxing.entity.Boxer;

public interface BoxerDAO {
	
	public List<Boxer> getBoxers();

	public void saveBoxer(Boxer theBoxer);

	public Boxer getBoxer(int theId);

	public void deleteBoxer(int theId);
}
