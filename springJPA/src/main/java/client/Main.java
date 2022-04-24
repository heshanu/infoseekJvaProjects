package client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Guide;
import entity.Student;
import util.HibernateUtil;

public class Main {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.getTransaction();
		try {
			Guide guide = new Guide("1111", "Heshan Umayanga", 1000);
			Student student = new Student("20144444", "Heshan", guide);
//			Address address = new Address("200 E Main St", "Seattle", "85123");
//			Person person = new Person("Ruby", address);

			/*
			 * session.save(person); session.save(guide); session.save(s);
			 */
			session.persist(student);
		
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		txn.begin();

		session.close();
		sessionFactory.close();

	}
}
