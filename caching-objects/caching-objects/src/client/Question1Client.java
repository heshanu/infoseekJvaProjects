package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Message;

public class Question1Client {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Message m = em.find(Message.class, 1L); //1
		m = em.merge(m); //2
		em.detach(m); //3
		em.remove(m); //4
		m = em.merge(m); //5
		System.out.println(em.contains(m)); //6		
	
		em.getTransaction().commit(); //7
		em.close();         
	}
}



