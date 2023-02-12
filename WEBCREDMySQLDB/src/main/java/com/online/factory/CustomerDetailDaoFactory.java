package com.online.factory;

import com.online.dao.CustomerDetailsDaoImpl;
import com.online.dao.IsCustomerDetailsDao;


public class CustomerDetailDaoFactory {
	private static IsCustomerDetailsDao customerDetailsDao=null;
	
	private CustomerDetailDaoFactory() {
		
	}
	public static IsCustomerDetailsDao getCustomerDetailsDao() {
		if(customerDetailsDao == null) {
			customerDetailsDao= new CustomerDetailsDaoImpl();
		}
		return customerDetailsDao;
	}

}
