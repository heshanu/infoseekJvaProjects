package main;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import domainMany2Many.Jeep;
import domainMany2Many.Owner;
import util.HibernateUtil;

public class many2many {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		/*
		 * Bok b1 = new Bok(); b1.setIsbn("ss"); b1.setName("Java");
		 * 
		 * Bok b2 = new Bok(); b2.setIsbn("ss2"); b2.setName("Java2");
		 * 
		 * Author a1 = new Author(); a1.setName("ge"); a1.setContactNo("12121");
		 * 
		 * Author a2 = new Author(); a2.setName("fgffg"); a2.setContactNo("fd");
		 * 
		 * a1.getBook().add(b1); a1.getBook().add(b2); // a1.getBook().add(b3);
		 * 
		 * b1.getAuthors().add(a2); // b3.getAuthors().add(a2);
		 */

		Owner o1 = new Owner();
		o1.setName("hesha");
		o1.setContactNo("12111");

		Owner o2 = new Owner();
		o2.setName("hesha2");
		o2.setContactNo("12111");
	

		Jeep j1 = new Jeep();
		j1.setModel("jeep1");
		j1.setDate(new Date());
		j1.getOwner().add(o1);
		o1.getJeep().add(j1);
		j1.getOwner().add(o2);

		Jeep j2 = new Jeep();
		j2.setModel("jeep2");
		j2.setDate(new Date());
		j2.getOwner().add(o1);
		o2.getJeep().add(j1);
		j2.getOwner().add(o2);

		Jeep j3 = new Jeep();
		j3.setModel("jeep1");
		j3.setDate(new Date());
		j3.getOwner().add(o1);
		j3.getOwner().add(o2);

		session.save(j1);
		session.save(j2);
		session.save(j3);
		// session.save(2);
		// session.save(b3);

		session.save(o1);
		session.save(o2);

		// System.out.println("name is " + b.getManager().getName());
		// System.out.println(d1.getName());
		session.getTransaction().commit();
		session.close();
	}
}
