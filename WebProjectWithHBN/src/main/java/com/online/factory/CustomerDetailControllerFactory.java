package com.online.factory;

import com.online.controller.CustomerDetailControllerImpl;
import com.online.controller.IsCustomerDetailController;

public class CustomerDetailControllerFactory {

	private static IsCustomerDetailController customerDetailController = null;
	
	private CustomerDetailControllerFactory() {
		
	}
	
	public static IsCustomerDetailController getCustomerDetailController() {
		if(customerDetailController == null) {
			customerDetailController = new CustomerDetailControllerImpl();
		}
		return customerDetailController;
	}
	
}
