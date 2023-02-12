package com.online.service;

import com.online.model.CustomerDetails;

public interface IsCustomerService {
	String save(CustomerDetails customerDetails);// Creating a record

	CustomerDetails findById(Integer sid);// Reading a record

	String updateById(CustomerDetails customerDetails);// Updating a record

	String deleteById(Integer sid);// Deleting a record
}
