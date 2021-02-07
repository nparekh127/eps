package com.scp.eps.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.scp.eps.util.ApplicationConstant;

@Order(2)
@Component
public class UserFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("User Filter Start...");
		if (validateCorelationId(request, response)) {
			chain.doFilter(request, response);			
		} else {
			System.out.println("Invalid corelation_id");
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized0 Invalid corelation id");
		}

		System.out.println("User Filter End...");
	}
	
	
	/**
	 * method to validate the corelation_id passed in the header
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	private boolean validateCorelationId (ServletRequest request, ServletResponse response) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String corelationId = httpServletRequest.getHeader(ApplicationConstant.CORELATION_ID);
		
		if (null != corelationId && corelationId.equals("ABC123XYZ")) {
			return true;
		}
		
		return false;
	}

}
