package com.astraltear.mvcsuit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mapping/*")
public class MappingController {
	
	@RequestMapping("/path")
	@ResponseBody
	public String byPath() {
		return "Mapped by path!";
	}
	
	@RequestMapping(value="/path/*", method=RequestMethod.GET)
	@ResponseBody
	public String byPathPattern(HttpServletRequest request) {
		return "Mapped by path pattern('"+request.getRequestURI()+"')";
	}
}
