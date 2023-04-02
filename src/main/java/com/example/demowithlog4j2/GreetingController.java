package com.example.demowithlog4j2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
public class GreetingController {

    private static final Logger logger = LogManager.getLogger("HelloWorld");

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);

		// Added by PVK to log the User Controlled log4j2 string
		logger.info("This is the greeting set by the user " + name);
		return "greeting";
	}

}
