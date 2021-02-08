package me.inners.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

	@RequestMapping(value="/accessError", method = RequestMethod.GET)
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied: " + auth) ;
		model.addAttribute("msg", "Access Denied");
	}

	@RequestMapping(value="/customLogin", method = RequestMethod.GET)
	public void loginInput(String error, String logout, Model model) {
		log.info("error: " + error);
		log.info("logout: " + logout);
		
		if (error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		
		if (error != null) {
			model.addAttribute("logout", "Logout!!");
		}
	}
	
	@RequestMapping(value = "/customLogout", method = RequestMethod.GET)
	public void logoutGET() {
		log.info("custom logout");
	}
	
	@RequestMapping(value = "/customLogout", method = RequestMethod.POST)
	public void logoutPost() {
		log.info("post custom logout");
	}
	
}
