package com.spring.jdbcwithoutxmlSterotypeAnnotation;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App3WithoutXml {
	public static void main(String[] args) {
		System.out.println("My Program Started.......");
		
		// spring jdbc => JDBC Template

		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(JdbcConfig.class);
		//new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		/**
		 * Why are we creating Object of Student? Reason In Insert Scripts, I am getting
		 * Data from Student. Somewhere in the program, You need to insert the data
		 * Otherwise it will not work.
		 */
		Student student = new Student();
		
		// INSERT	CREATE C
		student.setId(3);
		student.setName("Raj Kumar Ranjan");
		student.setCity("India New Delhi West ");
		int result0 = studentDao.insert(student);
		System.out.println("Student Added Insert is working Fine " + result0);
	
		// READ R
		// Get One 1 Student
		student.setId(2);
		//Student student1 = studentDao.getStudent(1);
		Student student1 = studentDao.getStudent(student.getId());
		System.out.println(student1);
	
		// Get All Student
		List<Student> students = studentDao.getAllStudents();
		for (Student s : students) {
			System.out.println(s);
		}
		System.out.println("Student Get All Student ");
		
		// UPDATE U 
		student.setId(1);
		student.setName("Aman Deeep");
		student.setCity("Kolkata");
		int result1 = studentDao.change(student);
		System.out.println("Student Update Update is working Fine" + result1);

		// DELETE D
		student.setId(1);
		int result2 = studentDao.delete(student.getId());
		//int result2 = studentDao.delete(2);
		System.out.println("Student Deleted Delete is working Fine" + result2);
		
		context.close();
	}
}
