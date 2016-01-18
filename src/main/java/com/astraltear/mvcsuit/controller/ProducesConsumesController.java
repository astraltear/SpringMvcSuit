package com.astraltear.mvcsuit.controller;

import org.slf4j.Logger;

/*
아직 consumes, produces 차이가 이해가 되지 않는다 .

 */
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProducesConsumesController {
	
	private static final Logger log = LoggerFactory.getLogger(ProducesConsumesController.class);

	
	@RequestMapping( value="/producesconsumesControl")
	public String index() {
		log.info("indexindexindexindexindexindexindex");
		return "/producesconsumes/index";
	}
	
	
	@RequestMapping( value="/producesconsumesControl", produces="application/json")
	@ResponseBody
	public String appJson() {
		log.info("application/json application/json application/json application/json application/json application/json");
		return "STRING";
	}
	
	
	@RequestMapping( value="/producesconsumesControl", produces="text/plain")
	@ResponseBody
	public String textPlain() {
		log.info("text/plain text/plain text/plain text/plain text/plain text/plain text/plain ");
		return "STRING";
	}

}
