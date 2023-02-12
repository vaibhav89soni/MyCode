package com.online.dao;

import com.online.model.CustomerDetails;

public interface IsCustomerDetailsDao {
	public String save(CustomerDetails custDetails);
	public String update(CustomerDetails custDetails);
	public String delete(int id);
	public CustomerDetails search(int id);
	
 
}
