package com.scp.eps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scp.eps.service.ApplicationControllerService;

@RequestMapping({"/v1/application"})
@RestController
public class ApplicationController {

	@Autowired
	ApplicationControllerService appControllerService;
	
	
	@RequestMapping({"/init"})
	public String init() {
		String username = System.getProperty("user.name");
		String email = System.getProperty("user.email");
		System.out.println("####### Printing JVM args");
		System.out.println(username+"--"+email);
		
		
		return "Hello";	
	}
	
}
