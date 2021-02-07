package com.scp.eps.util;

public class DaoConstant {

	public static String CUSTOMER_CREATE = "INSERT INTO SAKILA.CUSTOMER (customer_id,store_id,first_name,last_name,email,address_id,active,create_date,last_update) "
			+ "values(?,?,?,?,?,?,?,?,?)";
	
	public static String CUSTOMER_SELECT = "SEELCT * FROM SAKILA.CUSTOMER";
}
