package boxing.service;

import java.util.List;

import boxing.entity.Boxer;

public interface BoxerService {

	public List<Boxer> getBoxers();

	public void saveBoxer(Boxer theBoxer);
	
}
