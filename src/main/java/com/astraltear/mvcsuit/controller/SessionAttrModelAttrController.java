package com.astraltear.mvcsuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.astraltear.mvcsuit.domain.SessModelBean;

@Controller
@SessionAttributes("user")
@RequestMapping("/sessmodelAttr")
public class SessionAttrModelAttrController {
	
	@RequestMapping("/view")
	public String view(Model model) {
		SessModelBean bean = new SessModelBean();
		bean.setId("astral");
		bean.setPw("password");
		
		model.addAttribute("user", bean);
		return "SessModelView";
	}
	
    @RequestMapping(value = "/result")
    public String submit(@ModelAttribute("user") SessModelBean aUser) {   
        System.out.println("id : " + aUser.getId());
        System.out.println("pw : " + aUser.getPw());
        System.out.println("Name : " + aUser.getName());
         
        return "SessModelViewResult";
    }
    
    @RequestMapping("sessClear")
    public String clearSess(@ModelAttribute("user") SessModelBean aUser, SessionStatus status) {
    	status.setComplete();
    	
    	return "SessModelViewClear";
    }
}
