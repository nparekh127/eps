package com.scp.eps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.scp.eps.annotations.CustomAnnotation;
import com.scp.eps.dao.CustomerDAO;
import com.scp.eps.domain.CreateCustomerRequestBean;

@Service
@Component
public class ApplicationControllerService {

	@Autowired
	CustomerDAO customerDao;
	
	@CustomAnnotation(val=10)
	public boolean createCustomer(CreateCustomerRequestBean cust) {
		customerDao.create(cust);		
		
		return true;
	}
}
