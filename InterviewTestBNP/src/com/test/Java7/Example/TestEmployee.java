package com.test.Java7.Example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.test.model.Empolyee;

public class TestEmployee {

	public static void main(String[] args) {

		Empolyee emp1 = new Empolyee(1,"Rocky",100000L);
		Empolyee emp2 = new Empolyee(2,"Vicky",500000L);
		Empolyee emp3 = new Empolyee(3,"Joney",400000L);
		Empolyee emp4 = new Empolyee(4,"Ravi",300000L);
		
		List<Empolyee> listOfEmployee=new ArrayList<Empolyee>(Arrays.asList(emp1,emp2,emp3,emp4));//Add many list in 
	
		//compare basis on salary in Descending order
		Comparator<Empolyee> compareDesc= new Comparator<Empolyee>() {
			@Override
			public int compare(Empolyee o1, Empolyee o2) {
				if(o1.getEmpSalary() < o2.getEmpSalary()) {
					return 1;
				}else if(o1.getEmpSalary() > o2.getEmpSalary()){
					return -1;
				}else {
				return 0;
				}
			}
		};
		Collections.sort(listOfEmployee, compareDesc);
		System.out.println("*** compare basis on salary in Descending order ***");
		for(Empolyee emp : listOfEmployee) {
			System.out.println(emp.toString());
		}
		
		System.out.println("");
		//compare basis on salary in Ascending order
		Comparator<Empolyee> compareAsc= new Comparator<Empolyee>() {
			@Override
			public int compare(Empolyee o1, Empolyee o2) {
				if(o1.getEmpSalary() < o2.getEmpSalary()) {
					return -1;
				}else if(o1.getEmpSalary() > o2.getEmpSalary()){
					return 1;
				}else {
				return 0;
				}
			}
		};
		Collections.sort(listOfEmployee, compareAsc);
		System.out.println("*** compare basis on salary in Ascending order ***");
		for(Empolyee emp : listOfEmployee) {
			System.out.println(emp.toString());
		}
	}

}
