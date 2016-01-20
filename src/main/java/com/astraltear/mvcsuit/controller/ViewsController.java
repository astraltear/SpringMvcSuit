package com.astraltear.mvcsuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/views/*")
public class ViewsController {
	
	@RequestMapping(value="html", method=RequestMethod.GET)
	public String prepare(Model model) {
		model.addAttribute("foo", "bigpie");
		model.addAttribute("fruit", "apple");
		return "views/html";
	}
	
	@RequestMapping(value="pathVariables/{foo}/{fruit}", method=RequestMethod.GET)
	public String pathVars(@PathVariable String foo, @PathVariable String fruit) {
		return "views/html";
	}
	
}
