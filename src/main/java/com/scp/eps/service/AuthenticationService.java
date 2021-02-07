package com.scp.eps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scp.eps.domain.User;
import com.scp.eps.util.JwtUtil;

@Component
public class AuthenticationService {

	@Autowired
	private JwtUtil jwtTokenUtil;
	
	public String token(User user) {
		
		String token = jwtTokenUtil.generateToken(user);
		
		return token;
	}
	
}
