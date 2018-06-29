package com.BoxingGame.springsecurity.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BoxingGame.springsecurity.entity.Boxer;

@RestController
@RequestMapping("/api")
public class BoxerRestController {
		
		// define endpoint for "/boxers" - return list of students
		
		@GetMapping("/boxers")
		public List<Boxer> getStudents() {
				
			List<Boxer> theBoxers = new ArrayList<>();
			
			theBoxers.add(new Boxer("Yri", "Patel"));
			theBoxers.add(new Boxer("Mario", "Rossi"));
			theBoxers.add(new Boxer("Mary", "Smith"));
			
			return theBoxers;
		}
}
