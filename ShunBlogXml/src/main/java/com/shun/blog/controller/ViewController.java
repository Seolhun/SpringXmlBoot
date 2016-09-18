package com.shun.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("viewController")
public class ViewController {

	@RequestMapping(value = { "/main" })
	public String home1(ModelMap model) {
		return "main";
	}

	@RequestMapping(value = { "/portfolio" })
	public String portfolio(ModelMap model) {
		return "portfolio/portfolio";
	}

	@RequestMapping(value = { "/contact/contact" })
	public String contact(ModelMap model) {
		return "contact/contact";
	}
}