package com.astraltear.mvcsuit.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.astraltear.mvcsuit.domain.ValidJavaBean;

@Controller
public class ValidationController {

	@RequestMapping("/validate")
	public @ResponseBody String validate(@Valid ValidJavaBean bean, BindingResult result) {
		
		if (result.hasErrors()) {
			return "Object has validation errors";
		} else {
			return "No errors";
		}
	}
}
