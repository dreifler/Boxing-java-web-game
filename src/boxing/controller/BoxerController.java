package boxing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import boxing.dao.BoxerDAO;
import boxing.entity.Boxer;

@Controller
@RequestMapping("/boxers")
public class BoxerController {
	
	//need to inject the customer dao
	@Autowired
	private BoxerDAO boxerDAO;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get boxers from the dao
		List<Boxer> theBoxers = boxerDAO.getBoxers();
		
		//add the customers to the model
		theModel.addAttribute("Boxers", theBoxers);
		
		return "list-boxers";
	}
}
