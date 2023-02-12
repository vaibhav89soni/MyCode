package in.ineuron.main;


import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class EntityToDbRowApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean flag = false;
		Employee employee = null;

		try {
			transaction = session.beginTransaction();
			employee = session.get(Employee.class, 12);
			if (employee != null) {
				System.out.println(employee);
				employee.setEmpSal(5555.5);
				flag = true;
			}else {
				System.out.println("Record not avaialble...");
				System.exit(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("object upated...");
			} else {
				transaction.rollback();
				System.out.println("object failed to update...");
			}
		}
	}

}

