package com.online.controller;

import com.online.model.CustomerDetails;

public interface IsCustomerDetailController {
	String save(CustomerDetails customerDetails);// Creating a record
	
	CustomerDetails findById(int id);//Reading a record
	
	String updateById(CustomerDetails customerDetails);// Update a record
	
	String deleteById(Integer sid);// Deleting a record
}
