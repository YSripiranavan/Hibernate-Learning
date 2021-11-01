package com.sripiranavan.java.maven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sripiranavan.java.maven.model.Alien;
import com.sripiranavan.java.maven.model.AlienName;

public class HibernateDemo {

	public static void main(String[] args) {
		AlienName an = new AlienName();
		an.setFname("Yogarajah");
		an.setLname("Piranavan");
		an.setMname("Sri");

		Alien a1 = new Alien();
		a1.setAid(2);
		a1.setAname(an);
		a1.setColor("Blue");

		AlienName an1 = new AlienName();
		an1.setFname("Kathiresu");
		an1.setLname("Indirani");
		an1.setMname("Yogarajah");

		Alien a2 = new Alien();
		a2.setAid(1);
		a2.setAname(an1);
		a2.setColor("Yellow");

		Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);

		SessionFactory sf = conf.buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(a1);
		session.save(a2);
		tx.commit();
	}

}
