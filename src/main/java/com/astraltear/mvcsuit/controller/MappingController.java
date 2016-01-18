package com.astraltear.mvcsuit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value="/parameter", method=RequestMethod.GET, params="foo")
	@ResponseBody
	public String byParameter() {
		return "Mapped by path + method + presence of query parameters!";
	}
	
	@RequestMapping(value="/parameter", method=RequestMethod.GET, params="!foo")
	@ResponseBody
	public String byParameerNegation() {
		return "Mapped by path + method + not presence of parameters!";
	}
	
	@RequestMapping(value="/header", method=RequestMethod.GET, headers="FooHeader=foo")
	@ResponseBody
	public String byHeader() {
		return "Mapped by path + method + presence of header!";
	}
	
	@RequestMapping(value="/header", method=RequestMethod.GET, headers="!FooHeader")
	@ResponseBody
	public String byHeaderNegation() {
		return "Mapped by path + method + absence of header!";
	}
	
	
	@RequestMapping(value="/consumes", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public String byConsumes(@RequestBody JavaBean javaBean) {
		return "Mapped by path + method + consumable media type (javaBean '" + javaBean + "')";
	}
	
	@RequestMapping(value="/produces", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JavaBean byProducesJson() {
		return new JavaBean();
	}
	
	
}
