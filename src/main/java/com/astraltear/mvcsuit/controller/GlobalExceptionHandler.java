package com.astraltear.mvcsuit.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler
	@ResponseBody
	public String handleBusinessException(BusinessException bex) {
		return "Handled BusinessException";
	}
}
