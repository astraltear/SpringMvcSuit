package com.astraltear.mvcsuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.astraltear.mvcsuit.domain.FormBean;
import com.astraltear.mvcsuit.util.AjaxUtils;

@Controller
@RequestMapping("/form")
@SessionAttributes("formBean")
public class FormController {
	

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	
	@ModelAttribute("formBean")
	public FormBean createFormBean() {
		return new FormBean();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void form() {}
}
