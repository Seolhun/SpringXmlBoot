package com.shun.blog.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("viewController")
public class ViewController {

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home1(ModelMap model) {
		return "main";
	}

	@RequestMapping(value = { "/main" }, method = RequestMethod.GET)
	public String home2(ModelMap model) {
		return "main";
	}
	
	@RequestMapping(value = { "/board" }, method = RequestMethod.GET)
	public String boardInsert(ModelMap model) {
		return "board";
	}

	@RequestMapping(value = { "/portfolio" }, method = RequestMethod.GET)
	public String portfolio(ModelMap model) {
		return "portfolio/portfolio";
	}

	@RequestMapping(value = { "/contact/contact" }, method = RequestMethod.GET)
	public String contact(ModelMap model) {
		return "contact/contact";
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}