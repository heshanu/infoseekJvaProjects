package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Message;
import util.HibernateUtil;

public class HelloWorldClient {
//
//	public static void main(String[] args) {
//
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//
//		Message message = new Message("Hello World with Hibernate and JPA Annotations");
//
//		session.save(message);
//
//		session.getTransaction().commit();
//		session.close();
//
//	}

	// finding a value using id

//	public static void main(String[] args) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction txn = session.getTransaction();
//		Message msg = null;
//
//		try {
//			txn.begin();
//			msg = (Message) session.get(Message.class, 100L);
//			// msg.setText("HEllo Automatic Dirty Checking!");
//
//			Message ms = new Message("HEllo Automatic Dirty Checking!");
//			txn.commit();
//
//		} catch (Exception e) {
//			if (txn != null) {
//				txn.rollback();
//			}
//			e.printStackTrace();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//
//	}
	// find trans
//	public static void main(String[] args) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		Transaction tnx=session.getTransaction();
//		
//		Message msg=(Message)session.get(Message.class,1L);
//		System.out.println(msg);
//		tnx.commit();
//	}
	// updating records
//	public static void main(String[] args) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction txn = session.getTransaction();
//
//		try {
//			txn.begin();
//			Message msg = (Message) session.get(Message.class, 2L);
//			msg.setText("HEllow Fucccccccccker Automatic Dirty Checking");
//
//			txn.commit();
//
//		} catch (Exception e) {
//			if (txn != null) {
//				txn.rollback();
//			}
//			e.printStackTrace();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}

	// delete records!
//	public static void main(String[] args) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction txn = session.getTransaction();
//		Message msg = null;
//		try {
//			txn.begin();
//
//			msg = (Message) session.get(Message.class, 2L);
//			session.delete(msg);
//			msg.setText("Suceefully Deleted!");
//			txn.commit();
//
//		} catch (Exception e) {
//			if (txn != null) {
//				txn.rollback();
//			}
//			e.printStackTrace();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		Message msg = null;
		try {
			txn.begin();
			msg = (Message) session.get(Message.class, 1L);
			msg.setText("hiii");
			session.update(msg);
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
	}
}
