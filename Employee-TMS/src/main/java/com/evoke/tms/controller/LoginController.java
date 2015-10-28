package com.evoke.tms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController implements ILoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
        return model;
    }

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ADMIN only!");
		model.setViewName("admin");
		logger.info("Welcome admin {}",SecurityContextHolder.getContext().getAuthentication().getName());
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("Welcome {} ",auth.getName());
		if (error != null) {
			logger.info("Login Error {}",error);
			model.addObject("error", "Invalid username and password!");
			model.setViewName("login");
		}
		if (logout != null) {
			logger.info("{} Employe log out successfully",auth.getName());
			model.addObject("msg", "You've been logged out successfully.");
			model.setViewName("login");
		}
		return model;

	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView homepage() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    logger.info("Welcome {} ",auth.getName());
		model.addObject("loginname",auth.getName());
		model.addObject("message", "Welcome Home Page");
		model.setViewName("home");
		return model;
	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		ModelAndView model = new ModelAndView();
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("403");
		return model;

	}

}