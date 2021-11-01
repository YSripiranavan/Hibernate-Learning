package com.sripiranavan.java.maven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sripiranavan.java.maven.model.Alien;

public class GetAndLoadDemo {

	public static void main(String[] args) {
		Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

//		Alien alien = session.get(Alien.class, 2);
//		Null point exception
//		System.out.println(alien);

		Alien alien2 = session.load(Alien.class, 2); // proxy
//		Object not found exception
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(alien2);

		session.getTransaction().commit();
	}

}
