package com.sripiranavan.java.maven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sripiranavan.java.maven.model.Alien;

public class LevelOneCacheDemo {

	public static void main(String[] args) {
		Alien alien = null;

		Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);

		SessionFactory sf = conf.buildSessionFactory();

		Session session1 = sf.openSession();
		session1.beginTransaction();
// deprecated
//		Query<Alien> q1 = session1.createQuery("from Alien where aid=2");
//		q1.setCacheable(true);

		alien = (Alien) session1.createQuery("from Alien where aid=2").setCacheable(true)
				.uniqueResult();

//		Alien qAlien = (Alien) session1.createQuery("from Alien where aid=1").setCacheable(true).uniqueResult();
		System.out.println(alien);
//		alien = (Alien) session1.get(Alien.class, 2);
//		alien = (Alien) q1.uniqueResult();
//		alien = q1.uniqueResult();
//		System.out.println(alien);

		session1.getTransaction().commit();

		Session session2 = sf.openSession();
		session2.beginTransaction();
		alien = (Alien) session2.createQuery("from Alien where aid=2").setCacheable(true).uniqueResult();
		
		System.out.println(alien);
//		alien = (Alien) session2.get(Alien.class, 2);
//		Query<Alien> q2 = session2.createQuery("from Alien where aid=2");
//		q2.setCacheable(true);

//		alien = (Alien) session2.createQuery("from Alien where aid=2").setCacheable(true).uniqueResult();
//		alien = q2.uniqueResult();
//		System.out.println(alien);

		session2.getTransaction().commit();

	}

}
