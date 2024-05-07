package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *com.spring.jdbc.App2ByDao
 */
public class App3WithoutXml {
	public static void main(String[] args) {
		System.out.println("My Program Started.......");
		
		// spring jdbc => JDBC Template

		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		//new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		/**
		 * Why are we creating Object of Student? Reason In Insert Scripts, I am getting
		 * Data from Student. Somewhere in the program, You need to insert the data
		 * Otherwise it will not work.
		 */

		Student student = new Student();
		/**
		// INSERT
		
		student.setId(3);
		student.setName("Raj Kumar Ranjan");
		student.setCity("India New Delhi West ");
		int result0 = studentDao.insert(student);
		System.out.println("Student Added " + result0);
		 */
		
		/**
		// UPDATE
		student.setId(1);
		student.setName("Aman Deeep");
		student.setCity("Kolkata");
		int result1 = studentDao.change(student);
		System.out.println("Student Update " + result1);
			
		
		// DELETE
		
		student.setId(1);
		int result2 = studentDao.delete(student.getId());
		//int result2 = studentDao.delete(2);
		System.out.println("Student Deleted" + result2);
	
	
	
		
	
		
		// Get One 1 Student
		student.setId(2);
		//Student student1 = studentDao.getStudent(1);
		Student student1 = studentDao.getStudent(student.getId());
		System.out.println(student1);
		*/
		
		
		// Get All Student
		List<Student> students = studentDao.getAllStudents();
		for (Student s : students) {
			System.out.println(s);

		}
		
		
		
		

	}
}
