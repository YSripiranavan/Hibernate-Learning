package com.sripiranavan.java.maven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sripiranavan.java.maven.model.Laptop;
import com.sripiranavan.java.maven.model.Student;

public class MappingDemo {

	public static void main(String[] args) {
		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setLname("Dell");

		Student student = new Student();
		student.setRollno(1);
		student.setName("Sripiranavan");
		student.setMarks(75);
		student.getLaptop().add(laptop);

		laptop.getStudents().add(student);

		Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);

		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		session.save(laptop);
		session.save(student);

		session.getTransaction().commit();

	}

}
