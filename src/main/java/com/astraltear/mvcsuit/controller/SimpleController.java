package com.astraltear.mvcsuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
	
	@RequestMapping("/simple")
	@ResponseBody
	public String simple() {
		return "Hello SImple!!!";
	}
	
	@RequestMapping(value="/simple/revisited", method=RequestMethod.GET, headers="Accept=text/plain")
	@ResponseBody
	public String simpleRevisited() {
		return "Hello Simple Revisited!!";
	}
}
