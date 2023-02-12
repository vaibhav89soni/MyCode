package com.online.service;

import com.online.dao.IsCustomerDetailsDao;
import com.online.factory.CustomerDetailDaoFactory;
import com.online.model.CustomerDetails;

public class CustomerServiceImpl implements IsCustomerService {
	IsCustomerDetailsDao  CustomerDetailsDao=null;
	@Override
	public String save(CustomerDetails customerDetails) {
		CustomerDetailsDao=CustomerDetailDaoFactory.getCustomerDetailsDao();
		return CustomerDetailsDao.save(customerDetails);
	}

	@Override
	public CustomerDetails findById(Integer sid) {
		CustomerDetailsDao=CustomerDetailDaoFactory.getCustomerDetailsDao();
		return CustomerDetailsDao.search(sid);
	}

	@Override
	public String updateById(CustomerDetails customerDetails) {
		CustomerDetailsDao=CustomerDetailDaoFactory.getCustomerDetailsDao();
		return CustomerDetailsDao.update(customerDetails);
	}

	@Override
	public String deleteById(Integer sid) {
		CustomerDetailsDao=CustomerDetailDaoFactory.getCustomerDetailsDao();
		return CustomerDetailsDao.delete(sid);
	}

}
