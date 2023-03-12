package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SaveOperationApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null) 
				transaction = session.beginTransaction();
				
			if (transaction != null) {
				InsurancePolicy policy = new InsurancePolicy();
				policy.setCompany("Max Bupa");
				policy.setPolicyName("Max Life");
				policy.setPolicyType("yearly");
				policy.setTenure(30);
				session.save(policy);
				flag = true;
				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag == true)
				transaction.commit();
			else
				transaction.rollback();

			HibernateUtil.closeSession(session);
		}

	}

}
