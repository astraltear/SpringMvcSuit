package com.astraltear.mvcsuit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.astraltear.mvcsuit.controller.SimpleController;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class SimpleControllerTest {

	@Test
	public void simple() throws Exception {
		standaloneSetup(new SimpleController()).build()
		.perform(get("/simple"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello SImple!!!"));
		
	}

}
