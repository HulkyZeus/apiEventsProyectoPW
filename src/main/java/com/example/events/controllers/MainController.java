package com.example.events.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class MainController {
	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "/i18n")
	public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
		//return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());  
	}
}
	


	
	
		
		

