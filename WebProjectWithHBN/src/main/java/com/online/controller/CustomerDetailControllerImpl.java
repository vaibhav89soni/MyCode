package com.online.controller;

import com.online.factory.CustomerDetailServiceFactory;
import com.online.model.CustomerDetails;
import com.online.service.IsCustomerService;

public class CustomerDetailControllerImpl implements IsCustomerDetailController {
	IsCustomerService customerService;
	@Override
	public String save(CustomerDetails customerDetails) {
		customerService=CustomerDetailServiceFactory.getCustomerService();
		return customerService.save(customerDetails);
	}

	@Override
	public CustomerDetails findById(int id) {
		customerService=CustomerDetailServiceFactory.getCustomerService();
		return customerService.findById(id);
	}

	@Override
	public String updateById(CustomerDetails customerDetails) {
		customerService=CustomerDetailServiceFactory.getCustomerService();
		return customerService.updateById(customerDetails);
	}

	@Override
	public String deleteById(Integer sid) {
		customerService=CustomerDetailServiceFactory.getCustomerService();
		return customerService.deleteById(sid);
	}

}
