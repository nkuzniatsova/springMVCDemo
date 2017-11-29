package com.mvcsample.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyDemoController {

	private String[] quotes ={"To be or not to be",
							   "Spring in nature's way of saying ...",
							   "The time is always right to do what is right"};
	
	// http://localhost:8080/springMVCDemo/getQuote.html
	
	@RequestMapping(value = "/getQuote") //mapping a method to a particular HTTP request above
	public String getRandomQuete(Model model) {
		
		int rand = new Random().nextInt(quotes.length);
		String randomQuote = quotes[rand];
		
		model.addAttribute("randomQuote", randomQuote);
		
		//return a view name that can provide response to the user if used
		return "quote";
	}
	
	
}
