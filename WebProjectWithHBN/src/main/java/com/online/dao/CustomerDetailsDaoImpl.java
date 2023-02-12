package com.online.dao;

import java.sql.Connection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.online.model.CustomerDetails;
import com.online.util.HibernateUtil;


public class CustomerDetailsDaoImpl implements IsCustomerDetailsDao {
	Connection connection = null;

	@Override
	public String save(CustomerDetails custDetails) {
		Session session = null;
		Transaction transaction = null;
		String status = null;
//		System.out.println("CustomerDetails "+custDetails.toString());
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				
				transaction = session.beginTransaction();
				System.out.println("After session.beginTransaction");
			}

			if (transaction != null) {
				System.out.println("transaction is not null");
				
				session.save(custDetails);
				status = "success";
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if( status!= null &&   status.equalsIgnoreCase("success")) {
				transaction.commit();
			}
			else {
				transaction.rollback();
			status="Failed";
			}
			
			HibernateUtil.closeSession(session);
		}
		return status;
	}

	@Override
	public String update(CustomerDetails custDetails) {
		Session session = null;
		Transaction transaction = null;
		String status = "";

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				
				session.saveOrUpdate(custDetails);
				status = "success";
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			status = "Failed";
		} finally {
			if ( status!=null  && status .equalsIgnoreCase("success")) {
				transaction.commit();
				System.out.println("Record updated succesfully...");
			}

			else {
				status = "Failed";
				transaction.rollback();
				System.out.println("Record updation failed...");
			}

			HibernateUtil.closeSession(session);
		}
		return status;
	}

	@Override
	public String delete(int id) {
		Session session = null;
		Transaction transaction = null;
//		boolean flag = false;
		String status = null;
		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				CustomerDetails customerDetails = session.get(CustomerDetails.class, id);
				if (customerDetails != null) {
					session.delete(customerDetails);
					status = "success";
				} else {
					System.out.println("Record not available for deletion :: " + id);
					status="Failed";
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			status="Failed";
		} finally {
			if (status.equalsIgnoreCase("success")) {
				transaction.commit();
				System.out.println("Object deleted succesfuly...");
			} else {
				transaction.rollback();
				System.out.println("Object failed to delete...");
				status="Failed";
			}

			HibernateUtil.closeSession(session);
		}
		return status;
	}

	@Override
	public CustomerDetails search(int id) {

		Session session = HibernateUtil.getSession();
		CustomerDetails customer = new CustomerDetails();


		try {
			if (session != null)
//				customer = session.load(CustomerDetails.class, id);
				customer = session.get(CustomerDetails.class, id);
			System.out.println(customer);
		} catch (HibernateException e) {
//			System.out.println(customer.toString());
			System.out.println("Employee record not found for the given id :: " + id);
		}finally {
				HibernateUtil.closeSession(session);
		}
	
		return customer;
	}

}
