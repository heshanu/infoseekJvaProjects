package main;

import java.util.Date;

import org.hibernate.Session;

import domain.one2Many.Bank;
import domain.one2Many.Branch;
import domain.one2Many.Cart;
import domain.one2Many.Items;
import util.HibernateUtil;

public class One2Many {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		/*
		 * Bank combank = new Bank(); combank.setCode("com");
		 * combank.setName("commercial bank"); combank.setStatus("A");
		 * 
		 * Branch branch1 = new Branch(); branch1.setCode("nug");
		 * branch1.setCity("nuggedoda"); branch1.setStatus("A");
		 * 
		 * Branch branch2 = new Branch(); branch2.setCode("hikka");
		 * branch2.setCity("hikkaduwa"); branch2.setStatus("A");
		 * 
		 * combank.getBranches().add(branch1); combank.getBranches().add(branch2);
		 */
		Cart cart = new Cart();
		cart.setName("Heshan's");
		cart.setPrice("100");

		Items items1 = new Items();
		items1.setItemName("pasta");

		Items items2 = new Items();
		items2.setItemName("rice");

		cart.getItems().add(items1);
		cart.getItems().add(items2);

		session.save(items1);
		session.save(items2);
		session.save(cart);

		// System.out.println("name is " + b.getManager().getName());
		session.getTransaction().commit();
		session.close();

	}
}
