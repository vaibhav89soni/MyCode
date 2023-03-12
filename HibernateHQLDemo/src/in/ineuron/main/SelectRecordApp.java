package in.ineuron.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		/*
		 * using getResultList() to retrive the records try { Query<Employee> query =
		 * session.
		 * createQuery("FROM in.ineuron.Model.Employee WHERE eno>=:id1 AND eno<=:id2");
		 * query.setParameter("id1", 7); query.setParameter("id2", 10);
		 * 
		 * List<Employee> empRecords = query.getResultList();
		 * empRecords.forEach(System.out::println);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } finally {
		 * HibernateUtil.closeSession(session); HibernateUtil.closeSessionFactory(); }
		 */

		/*
		 * using list() to retrive the records try {
		 * 
		 * Query<Employee> query =
		 * session.createQuery("FROM in.ineuron.Model.Employee"); List<Employee>
		 * employees = query.list(); employees.forEach(employee ->
		 * System.out.println(employee));
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } finally {
		 * HibernateUtil.closeSession(session); HibernateUtil.closeSessionFactory(); }
		 */

		/* using iterate() to retrive the records */

		try {
			Query<Employee> query = session.createQuery("FROM in.ineuron.Model.Employee");
//			Iterator<Employee> itr = query.iterate();
//			while (itr.hasNext()) {
//				itr.getClass()
//			}/
			List<Employee> employees = query.list();
			System.out.println("SelectRecordApp.main()");
			System.out.println("*****Employee Details *******");
			employees.forEach(employee -> System.out.println(employee));
			System.out.println("*****************************");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			HibernateUtil.closeSession(session);
//			HibernateUtil.closeSessionFactory();
		}
	}

}
