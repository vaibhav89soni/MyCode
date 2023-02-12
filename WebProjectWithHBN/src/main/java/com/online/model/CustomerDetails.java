package com.online.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "customer_details")
public class CustomerDetails {
	@Id
	@Column(name = "customer_no")
	private int customerNo;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_age")
	private int customerAge;
	
	@Column(name = "customer_address")
	private String customerAddress;

	
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	static {
		System.out.println("CustomerDetails.class is loading...");
	}

	public CustomerDetails() {
		System.out.println("Zero parameter consturctor is used by Hibernate");
	}
	
	
	
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(customerAddress, customerAge, customerName);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		CustomerDetails other = (CustomerDetails) obj;
//		return Objects.equals(customerAddress, other.customerAddress) && customerAge == other.customerAge
//				&& Objects.equals(customerName, other.customerName);
//	}
	@Override
	public String toString() {
		return "CustomerDetails [customerName=" + customerName + ", customerAge=" + customerAge + ", customerAddress="
				+ customerAddress + "]";
	}
	
	
	

}
