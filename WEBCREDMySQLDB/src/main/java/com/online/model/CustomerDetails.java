package com.online.model;

import java.util.Objects;

public class CustomerDetails {
	private String customerName;
	private int customerAge;
	private String customerAddress;
	private int customerNo;
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
	public CustomerDetails() {
		super();
	}
	
	
	
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerAddress, customerAge, customerName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDetails other = (CustomerDetails) obj;
		return Objects.equals(customerAddress, other.customerAddress) && customerAge == other.customerAge
				&& Objects.equals(customerName, other.customerName);
	}
	@Override
	public String toString() {
		return "CustomerDetails [customerName=" + customerName + ", customerAge=" + customerAge + ", customerAddress="
				+ customerAddress + "]";
	}
	
	
	

}
