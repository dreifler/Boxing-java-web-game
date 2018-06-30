package com.BoxingGame.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BoxingGame.springsecurity.dao.BoxerDAO;
import com.BoxingGame.springsecurity.entity.Boxer;

@Service
public class BoxerServiceImpl implements BoxerService {

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

	@Override
	@Transactional
	public void deleteBoxer(int theId) {
		
		boxerDAO.deleteBoxer(theId);
	}

}
