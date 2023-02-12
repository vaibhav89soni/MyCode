package com.online.factory;

import com.online.service.CustomerServiceImpl;
import com.online.service.IsCustomerService;

public class CustomerDetailServiceFactory {
	private static IsCustomerService customerService=null;
	private CustomerDetailServiceFactory() {
		
	}
	
	public static IsCustomerService getCustomerService() {
		if(customerService == null) {
			customerService=new CustomerServiceImpl();
		}
		return customerService;
	}
}
