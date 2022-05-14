package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Student;

public class InsertDummyDataClient {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Student student1 = new Student("2003CH50897", "Kevin Smith");
		Student student2 = new Student("2008EE10999", "Sherry Morgan");
		Student student3 = new Student("1987CS10007", "Sara Shield");
		
		em.persist(student1);
		em.persist(student2);
		em.persist(student3);
		 
		em.getTransaction().commit();
		em.close(); 
		
	}
}
