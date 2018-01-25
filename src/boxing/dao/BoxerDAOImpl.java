package boxing.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import boxing.entity.Boxer;

@Repository
public class BoxerDAOImpl implements BoxerDAO {

	//inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Boxer> getBoxers() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Boxer> theQuery = currentSession.createQuery("from Boxer", Boxer.class);
		
		//execute query and get result list
		List<Boxer> boxers = theQuery.getResultList();
		
		//return the results	
		return boxers;
	}

}
