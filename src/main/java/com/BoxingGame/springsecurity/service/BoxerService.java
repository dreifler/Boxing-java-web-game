package com.BoxingGame.springsecurity.service;

import java.util.List;

import com.BoxingGame.springsecurity.entity.Boxer;

public interface BoxerService {

	public List<Boxer> getBoxers();
	
	public void saveBoxer(Boxer theBoxer);
	
	public Boxer getBoxer(int theId);
	
	public void deleteBoxer(int theId);
	
}

