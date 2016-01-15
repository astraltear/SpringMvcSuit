package com.astraltear.mvcsuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/csrf")
public class CsrfController {
	
	@RequestMapping("/main")
	public String csrfMain() {
		return "/csrf/main";
	}
	
	
	@RequestMapping("/recv")
	public String csrfRecv() {
		return "/csrf/recv";
	}
}
