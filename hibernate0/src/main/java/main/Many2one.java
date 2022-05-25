package main;

import org.hibernate.Session;

import domainMany2one.Car;
import domainMany2one.Driver;
import domainMany2one.Van;
import util.HibernateUtil;

public class Many2one {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Van van = new Van();
		van.setName("vesel");
		van.setContactNo("123333");
		
		Van van1 = new Van();
		van1.setName("prius");
		van1.setContactNo("11111");
		

		Driver d1 = new Driver();
		d1.setName("Hehs");
		d1.setContactNo("1111");
		d1.setVan(van);

		Driver d2 = new Driver();
		d2.setName("Hehs2");
		d2.setContactNo("11112");
		d2.setVan(van1);

		Driver d3 = new Driver();
		d3.setName("Hehs");
		d3.setContactNo("1111");
		d3.setVan(van);

		Driver d4 = new Driver();
		d4.setName("Hehs4");
		d4.setContactNo("11114");
		d4.setVan(van1);
		/*
		 * car.getDrivers().add(d1); car.getDrivers().add(d2); car.getDrivers().add(d3);
		 */

		van.getDrivers().add(d1);
		van.getDrivers().add(d2);
		van.getDrivers().add(d3);
		van.getDrivers().add(d4);

		session.save(van);
		session.save(van1);
		session.save(d1);
		session.save(d2);
		session.save(d3);
		session.save(d4);

		/* Car ca = (Car) session.get(Car.class, 1L); */
		Van v = (Van) session.get(Van.class, 1L);
		System.out.println(v.getDrivers().get(2));

		// Driver d4 = (Driver) session.get(Driver.class, 2L);
		// System.out.println(d4);

		// System.out.println("name is " + b.getManager().getName());
		System.out.println(d1.getName());
		session.getTransaction().commit();
		session.close();

	}
}
