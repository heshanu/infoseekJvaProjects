package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Student;

public class ForceDirtyCheckSynchronizationClient {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Student student = em.find(Student.class, 1L);
		student.setName("Kevin Smith");
		em.flush(); 
		
		em.getTransaction().commit();
		em.close(); 
		
	}
}
