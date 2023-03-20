package com.test.Java8.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.test.model.Empolyee;

public class EmployeeJava {
	public static void main(String[] args) {
		Empolyee emp1 = new Empolyee(1, "Rocky", 100000L);
		Empolyee emp2 = new Empolyee(2, "Vicky", 500000L);
		Empolyee emp3 = new Empolyee(3, "Joney", 400000L);
		Empolyee emp4 = new Empolyee(4, "Ravi", 300000L);

		// ascending order
		System.out.println("ascending order :: ");
		List<Empolyee> employees = new ArrayList<Empolyee>(Arrays.asList(emp1, emp2, emp3, emp4));// Add many list in

		Comparator<Empolyee> employeeNameComparator = Comparator.comparing(Empolyee::getEmpSalary);

		Collections.sort(employees, employeeNameComparator);
		for (Empolyee emp : employees) {
			System.out.println(emp.toString());
		}

		System.out.println("descnding order :: ");
		Comparator<Empolyee> employeeNameComparatorDesc = Comparator.comparing(Empolyee::getEmpSalary,(s1,s2)->{
			return s2.compareTo(s1);
		});

		Collections.sort(employees, employeeNameComparatorDesc);
		for (Empolyee emp : employees) {
			System.out.println(emp.toString());
		}
	}	

}
