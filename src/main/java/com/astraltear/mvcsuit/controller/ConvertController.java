package com.astraltear.mvcsuit.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.astraltear.mvcsuit.domain.ConvertBean;

@Controller
@RequestMapping("/convert")
public class ConvertController {

	@RequestMapping("primitive")
	@ResponseBody
	public String primitive(@RequestParam Integer value) {
		return "Converted primitive " + value;
	}
	
	@RequestMapping("collection")
	@ResponseBody
	public String date(@RequestParam Collection<Integer> values) {
		return "Converted collection " + values;
	}

	@RequestMapping("value")
	@ResponseBody 
	public String valueObject(@RequestParam SocialSecurityNumber value) {
		return "Converted value object " + value;
	}
	

	@RequestMapping("custom")
	@ResponseBody
	public  String customConverter(@RequestParam @MaskFormat("###-##-####") String value) {
		return "Converted '" + value + "' with a custom converter";
	}
	

	@RequestMapping("bean")
	public @ResponseBody String bean(ConvertBean convertBean) {
		return "Converted " + convertBean;
	}
}
