package com.sripiranavan.java.maven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sripiranavan.java.maven.model.Alien;

public class GetValueHibernate {

	public static void main(String[] args) {
		Alien a1 = null;

		Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);

		SessionFactory sf = conf.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		a1 = (Alien) session.get(Alien.class, 1);
		tx.commit();
		System.out.println(a1);
	}

}
