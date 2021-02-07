package com.scp.eps.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scp.eps.domain.CreateCustomerRequestBean;
import com.scp.eps.service.ApplicationControllerService;

@RequestMapping({"/v1/customer"})
@RestController
public class CustomerController {

	@Autowired
	ApplicationControllerService appControllerService;
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String create(HttpServletRequest req, HttpServletResponse res, @RequestBody CreateCustomerRequestBean custBean) {
		
		appControllerService.createCustomer(custBean);
		return "Hello";
	}
}
