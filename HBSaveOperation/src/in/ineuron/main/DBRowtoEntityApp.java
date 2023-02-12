package in.ineuron.main;

import org.hibernate.Session;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class DBRowtoEntityApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Employee employee = null;

		try {
			
			employee = session.get(Employee.class, 12);
			if (employee != null) {
				System.out.println("Before any modification :: " + employee);

				System.in.read();//pause the execution(mean while make some change by going to databasee)
				
				session.refresh(employee);
				System.out.println("After modification in the dbTable :: " + employee);

			} else {
				System.out.println("Record not avaialble...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

