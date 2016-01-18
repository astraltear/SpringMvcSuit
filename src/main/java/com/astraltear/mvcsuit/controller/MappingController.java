package com.astraltear.mvcsuit.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.astraltear.mvcsuit.domain.JavaBean;

@Controller
@RequestMapping("/mapping/*")
public class MappingController {
	
	private static final Logger log = LoggerFactory.getLogger(MappingController.class);

//	/mapping/path
	@RequestMapping("/path")
	@ResponseBody
	public String byPath() {
		return "Mapped by path!";
	}
	
//	/mapping/path/anywhere
	@RequestMapping(value="/path/*", method=RequestMethod.GET)
	@ResponseBody
	public String byPathPattern(HttpServletRequest request) {
		return "Mapped by path pattern('"+request.getRequestURI()+"')";
	}
	
//	/mapping/parameter?foo=bar
	@RequestMapping(value="/parameter", method=RequestMethod.GET, params="foo")
	@ResponseBody
	public String byParameter() {
		return "Mapped by path + method + presence of query parameters!";
	}
	
//	/mapping/parameter
	@RequestMapping(value="/parameter", method=RequestMethod.GET, params="!foo")
	@ResponseBody
	public String byParamterNegation() {
		return "Mapped by path + method + not presence of parameters!";
	}
	
//	/mapping/header
//	req.setRequestHeader("FooHeader", "foo");
	@RequestMapping(value="/header", method=RequestMethod.GET, headers="FooHeader=foo")
	@ResponseBody
	public String byHeader() {
		return "Mapped by path + method + presence of header!";
	}
	
//	/mapping/header
	@RequestMapping(value="/header", method=RequestMethod.GET, headers="!FooHeader")
	@ResponseBody
	public String byHeaderNegation() {
		return "Mapped by path + method + absence of header!";
	}
	
//	form post
//	/mapping/consumes
	@RequestMapping(value="/consumes", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public String byConsumes(@RequestBody JavaBean javaBean) {
		return "Mapped by path + method + consumable media type (javaBean '" + javaBean + "')";
	}
	
//	mapping/produces
//  req.setRequestHeader("Accept", "application/json")
	@RequestMapping(value="/produces", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JavaBean byProducesJson() {
		log.info("byProducesJson byProducesJson byProducesJson byProducesJson byProducesJson");
		return new JavaBean();
	}

//	/mapping/produces
//	req.setRequestHeader("Accept", "application/xml");
	@RequestMapping(value="/produces", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody 
	public JavaBean byProducesXml() {
		log.info("byProducesXml byProducesXml byProducesXml byProducesXml");
		return new JavaBean();
	}
	
	
}
