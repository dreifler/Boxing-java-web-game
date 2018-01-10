package boxing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boxers")
public class BoxerController {
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		return "list-boxers";
	}
}
