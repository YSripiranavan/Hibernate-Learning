package com.sripiranavan.java.maven;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sripiranavan.java.maven.model.Laptop;
import com.sripiranavan.java.maven.model.Student;

public class HQLDemo {

	public static void main(String[] args) {
		Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);

		SessionFactory sf = conf.buildSessionFactory();

		Session session = sf.openSession();

		session.beginTransaction();

//		Random rand = new Random();
//		
//		for(int i=1;i<=50;i++) {
//			Laptop lap = new Laptop();
//			lap.setLid(i);
//			lap.setLname("LapName "+i);
//			
//			Student student = new Student();
//			student.setRollno(i+1);
//			student.setName("StudentName "+i);
//			student.setMarks(rand.nextInt(100));
//			student.getLaptop().add(lap);
//			
//			lap.getStudents().add(student);
//
//			session.save(student);
//			session.save(lap);
//		}

//		Query q = session.createQuery("from Student");
//		List<Student> students = q.list();
//		int markLimit = 60;
//		@SuppressWarnings("unchecked")
//		List<Student> students = session.createQuery("from Student where marks > :marks").setParameter("marks", markLimit)
//				.list();
//		for (Student student : students) {
//			System.out.println(student);
//		}

//		Query<?> q = session.createQuery("select rollno,name from Student where rollno=8");
//		Object[] student = (Object[]) q.uniqueResult();
//		System.out.println(student[0]);

//		SQLQuery<?> query = session.createSQLQuery("select * from student where marks>90");
//		query.addEntity(Student.class);
//		List<Student> students =(List<Student>) query.list();
//		
//		for(Student s : students) {
//			System.out.println(s);
//		}

		SQLQuery<?> query = session.createSQLQuery("select rollno,name from student where marks>90");
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List students = query.list();

		for (Object s : students) {
			Map<String, Long> m = (Map) s;
			System.out.println(m.get("name") + " : " + m.get("rollno"));
		}

		session.getTransaction().commit();
	}

}
