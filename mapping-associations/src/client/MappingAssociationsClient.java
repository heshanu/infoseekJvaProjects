package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entity.Guide;
import entity.Student;

public class MappingAssociationsClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();
        	
        			Guide guide = new Guide("2000MO10789", "Mike Lawson", 1000);
        			Guide guide1 = new Guide("2000MO10788", "Mike Lawson1", 1001);
        			Student student = new Student("2014JT50123", "John Smith", guide);
        			Student student1 = new Student("2014JT50124", "John Smith1", guide1);

        			session.save(guide);
        			session.save(student);
        			session.save(guide1);
        			session.save(student1);
        			
        		
        			
        		
	        
	        		txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}











