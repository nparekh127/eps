package com.scp.eps.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.scp.eps.domain.User;
import com.scp.eps.util.JwtUtil;

import io.jsonwebtoken.JwtException;

@Order(1)
@Component
public class AuthFilter extends OncePerRequestFilter {

	@Value("${jwt.enabled}")
	private boolean isJwtEnabled;
	
	@Autowired
	JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		System.out.println("Auth Fitler Start...");
		
		if (isAuthorizedUser(request)) {
			System.out.println("Auuthorized user.");
			chain.doFilter(request, response);
		} else {
			System.out.println("Not authorized user to access resource.");
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized user");
		}
		chain.doFilter(request, response);
		System.out.println("Auth Filter End...");
	}

	private boolean isAuthorizedUser(HttpServletRequest request) {
		String token = request.getHeader("token");
		boolean isValidToken = false;
		
		if (token != null && !token.equals("") && token.startsWith("Bearer")) {

			String tokenValue = token.substring("Bearer ".length());

			try {
				String username = "";
				username = jwtUtil.getUsernameFromToken(tokenValue);
				User user = new User();
				user.setUserid(username);
				isValidToken = jwtUtil.validateToken(tokenValue, user);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (JwtException e) {
				System.out.println("JWT Token has expired");
			}
		}
		
		return isValidToken;
	}
	

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		
		return request.getRequestURI().contains("/v1/auth/token") || !isJwtEnabled;
	}
}
