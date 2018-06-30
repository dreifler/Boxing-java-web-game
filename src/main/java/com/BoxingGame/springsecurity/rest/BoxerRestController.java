package com.BoxingGame.springsecurity.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.BoxingGame.springsecurity.entity.Boxer;
import com.BoxingGame.springsecurity.service.BoxerService;

@RestController
@RequestMapping("/api")
public class BoxerRestController {
		
	// autowire the BoxerService
	@Autowired
	private BoxerService boxerService;
	
	@GetMapping("/boxers")
	public List<Boxer> getBoxers() {
		
		return boxerService.getBoxers();
	}
	
	@GetMapping("/boxers/{boxerId}")
	public Boxer getBoxer(@PathVariable int boxerId) {
		
		Boxer theBoxer = boxerService.getBoxer(boxerId);
		
		if(theBoxer == null) {
			throw new BoxerNotFoundException("Boxer id not found - " + boxerId);
		}
		
		return theBoxer;
	}
	
	// add mapping for POST /boxers - add new boxer
	
	@PostMapping("/boxers")
	public Boxer addBoxer(@RequestBody Boxer theBoxer) {
		
		theBoxer.setID(0);
		
		boxerService.saveBoxer(theBoxer);
		
		return theBoxer;
	}
		
}
