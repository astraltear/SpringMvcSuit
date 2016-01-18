package com.astraltear.mvcsuit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.astraltear.mvcsuit.domain.ParamGroup;

@Controller
@RequestMapping("/data")
public class RequestDataController {
	
	private static final Logger log = LoggerFactory.getLogger(RequestDataController.class);


//	/data/param?foo=bar
	@RequestMapping(value="/param", method=RequestMethod.GET)
	@ResponseBody
	public String withParam(@RequestParam String foo) {
		return "Obtained 'foo' query parameter value '" + foo + "'";
	}
	
//	/data/group?param1=foo&amp;param2=bar&amp;param3=baz
	@RequestMapping(value="/group", method=RequestMethod.GET)
	@ResponseBody
	public String withParamGroup(ParamGroup paramGroup) {
		return "Obtained parameter group " + paramGroup;
	}
	
//	/data/path/foo
	@RequestMapping(value="/path/{var}", method=RequestMethod.GET)
	@ResponseBody
	public String withPathVariable(@PathVariable String var) {
		return "Obtained 'var' path variable value '" + var + "'";
	}
	
//	/data/matrixvars;foo=bar/simple
	@RequestMapping(value="{path}/simple", method=RequestMethod.GET)
	@ResponseBody
	public String withMatrixVariable(@PathVariable String path, @MatrixVariable String foo) {
		return "Obtained matrix variable 'foo=" + foo + "' from path segment '" + path + "'";
	}
	
//	/data/matrixvars;foo=bar1/multiple;foo=bar2
	@RequestMapping(value="{path1}/{path2}", method=RequestMethod.GET)
	@ResponseBody
	public String withMatrixVariablesMultiple(
			@PathVariable String path1, @MatrixVariable(value="foo", pathVar="path1") String foo1,
			@PathVariable String path2, @MatrixVariable(value="foo", pathVar="path2") String foo2) {

		return "Obtained matrix variable foo=" + foo1 + " from path segment '" + path1
				+ "' and variable 'foo=" + foo2 + " from path segment '" + path2 + "'";
	}
	
	
//	/data/header
	@RequestMapping(value="/header", method=RequestMethod.GET)
	@ResponseBody
	public String withHeader(@RequestHeader String accept) {
		return "Obtained 'Accept' header '" + accept + "'";
	}
	
//	/data/body ajax를 호출할 때  data: "foo" 세팅
	@RequestMapping(value="/body", method=RequestMethod.POST)
	@ResponseBody
	public String withBody(@RequestBody String body) {
		log.info("withBodywithBodywithBodywithBodywithBodywithBody: "+body);
		return "Posted request body '" + body + "'";
	}
	
//	/data/entity ajax를 호출할 때  data: "foo" 세팅
	@RequestMapping(value="/entity", method=RequestMethod.POST)
	@ResponseBody
	public String withEntity(HttpEntity<String> entity) {
		return "Posted request body '" + entity.getBody() + "'; headers = " + entity.getHeaders();	
	}
	
	
//	/data/cookie
	@RequestMapping(value="/cookie", method=RequestMethod.GET)
	@ResponseBody
	public String withCookie(@CookieValue String openidProvider) {
		return "Obtained 'openid_provider' cookie '" + openidProvider + "'";
	}
	
	
}
