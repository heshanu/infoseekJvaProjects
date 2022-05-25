package main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.criteria.expression.ConcatExpression;

import domain.Bank;
import domain.Book;
import domain.Manager;
import domain.Student;

import net.sf.ehcache.config.Configuration;
import util.HibernateUtil;

public class mainstudent {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		/*
		Student s = new Student();
		s.setFirstName("h");
		s.setLastName("u");
		s.setContactNo("1111");
		s.setAddress("Hikka");
		s.setDob(new Date());

		Book b = new Book();
		b.setName("A");
		b.setIsbn("!@12");
		b.setAuthor("Heshan");
		b.setStudent(s);
*/
		Bank b=new Bank();
		b.setCode("1");
		b.setDescription("Aaa");
		b.setStatus("A");
		
		Manager m=new Manager();
		m.setName("hesh");
		m.setContactNo("2121");
		m.setDob(new Date());
		m.setBank(b);
		m.setBank(b);
		
		b.setManager(m);
		
		session.save(b);
		session.save(m);
		
		session.get(Bank.class, 2L);
		System.out.println(b.getCode());
		System.out.println("name is "+ b.getManager().getName());
		session.getTransaction().commit();
		session.close();

	}
}
