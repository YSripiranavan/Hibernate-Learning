package com.sripiranavan.java.maven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sripiranavan.java.maven.model.Alien;
import com.sripiranavan.java.maven.model.AlienName;

public class HibernateStates {

	public static void main(String[] args) {
		Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		Alien alien = new Alien();
		AlienName an = new AlienName();
		an.setFname("Yogarajah");
		an.setLname("Piranavan");
		an.setMname("Sri");
		alien.setAid(12);
		alien.setAname(an);
		alien.setColor("Red");
		
		session.save(alien);
		alien.setColor("Green");
		
		session.remove(alien);
		
		session.getTransaction().commit();
		
		session.detach(alien);
		alien.setColor("Blue");
	}

}
