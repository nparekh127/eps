package com.scp.eps.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.scp.eps.domain.CreateCustomerRequestBean;
import com.scp.eps.util.DaoConstant;

@Repository
public class CustomerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * method to create customer in DB
	 * 
	 * @param cust
	 * @return
	 */
	public boolean create(CreateCustomerRequestBean cust) {
		try {

			jdbcTemplate.update(DaoConstant.CUSTOMER_CREATE,
					new Object[] { cust.getCustomer_id(), cust.getStore_id(), cust.getFirst_name(), cust.getLast_name(),
							cust.getEmail(), cust.getAddress_id(), cust.getActive(), cust.getCreate_date(),
							new Date() });
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
}
