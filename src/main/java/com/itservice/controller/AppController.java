package com.itservice.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itservice.constant.URI;


@Controller
@ComponentScan("com.itservice")
public class AppController {

	@RequestMapping(value = { URI.MAIN, URI.HOME }, method = RequestMethod.GET)
	public String homePage() {
		return "redirect:"+URI.PROJECT_LIST;
	}
	
}
