package boxing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boxing.dao.BoxerDAO;
import boxing.entity.Boxer;

@Service
public class BoxerServiceImpl implements BoxerService {

	// inject boxer DAO
	@Autowired
	private BoxerDAO boxerDAO;
	
	@Override
	@Transactional
	public List<Boxer> getBoxers() {
		
		return boxerDAO.getBoxers();
	}

	@Override
	@Transactional
	public void saveBoxer(Boxer theBoxer) {
		
		boxerDAO.saveBoxer(theBoxer);
	}

	@Override
	@Transactional
	public Boxer getBoxer(int theId) {
		
		return boxerDAO.getBoxer(theId);
	}

}
