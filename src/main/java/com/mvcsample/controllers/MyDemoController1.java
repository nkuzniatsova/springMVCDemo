package com.mvcsample.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.demo.model.Account;

@Controller
@SessionAttributes("aNewAccount")  //store attribute to the session 
public class MyDemoController1 {
	
	@ModelAttribute
	public void addAccountToModel(Model model) {
		System.out.println("Making sure account object is on model");
		if(!model.containsAttribute("aNewAccount")) {
			Account a = new Account();
			model.addAttribute("aNewAccount", a); 
		}
	}
	
	@RequestMapping(value="/createAccount")
	public String createAccount(@Valid @ModelAttribute ("aNewAccount") Account account, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("Form has errors");
			return "/createAccount";
		}
		
		System.out.println("Form validated");
		System.out.println(account.getFirstName() + " " + account.getLastName() + " " + account.getAddress()  + " " + account.getEmail());
		
		return "createAccount";
		//return "redirect:accountCreated";
	}
	
	@RequestMapping(value="/accountCreated", method=RequestMethod.POST)
	public String performCreate(Account account) {
		
		System.out.println(account.getFirstName() + " " + account.getLastName() + " " + account.getAddress()  + " " + account.getEmail());
		
		return "accountCreated";
	}
	
	/**
	@RequestMapping(value="/accountConfirm")
	public String accountConfirmation(@ModelAttribute ("aNewAccount") Account account) {
		
		System.out.println("Account confirmed: Welkome " + account.getFirstName() + " " + account.getLastName());
		return "accountConfirmed";
	} */
	

}
