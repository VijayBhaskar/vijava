package com.evoke.tms.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface ILoginController {
   
	public ModelAndView defaultPage();
	public ModelAndView adminPage();
	public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout);
	public ModelAndView homepage();
	public ModelAndView accesssDenied();
}
