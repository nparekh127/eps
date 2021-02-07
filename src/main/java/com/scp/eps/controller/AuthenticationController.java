package com.scp.eps.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scp.eps.domain.User;
import com.scp.eps.service.AuthenticationService;

@RequestMapping({"/v1/auth"})
@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService; 
	
	
	@RequestMapping({"/token"})
	public String authenticate(HttpServletRequest httpServletRequest) throws Exception {
		
		if (httpServletRequest.getHeader("username") == null 
				|| httpServletRequest.getHeader("username").equals("")
				|| httpServletRequest.getHeader("password") == null
				|| httpServletRequest.getHeader("password").equals("")) {
			
			throw new DisabledException("USER_NOT_ALLOWED");
		}
		
		User user = new User();
		user.setUserid(httpServletRequest.getHeader("username"));
		user.setPassword(httpServletRequest.getHeader("password"));
		
		return authenticationService.token(user);
	}
}
