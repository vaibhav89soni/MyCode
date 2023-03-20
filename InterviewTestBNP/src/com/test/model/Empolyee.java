package com.test.model;

public class Empolyee {
	private int empId;
	private String empName;
	private Long empSalary;

	public Empolyee(int empId, String empName, Long empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	} 
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Long getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(Long empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Empolyee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}
	

}
