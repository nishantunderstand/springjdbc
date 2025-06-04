package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * 1. CRUD Operation
 */
public class App2ByDao {
	public static void main(String[] args) {
		System.out.println("My Program Started.......");
		// spring jdbc => JDBC Template

		ApplicationContext context = 
				new ClassPathXmlApplicationContext("config_ByAppByDao.xml");
	
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		
		/**
		 * Why are we creating Object of Student? Reason 
		 * In Insert Scripts, I am getting
		 * Data from Student. 
		 * Somewhere in the program, You need to insert the data Otherwise it will not work.
		 */
		
		Student student = new Student();

		// INSERT Create C
		// student.setId(2); // Auto Increment to 
		student.setName("Raj Kumar Ranjan");
		student.setCity("India New Delhi West ");
		int result0 = studentDao.insert(student);
		System.out.println("Student Added " + result0);
		System.out.println("Create");

		/*
		 * // READ R // Get One 1 Student student.setId(2); // Student student1 =
		 * studentDao.getStudent(1); Student student1 =
		 * studentDao.getStudent(student.getId()); System.out.println(student1);
		 * System.out.println("Read 1");
		 * 
		 * // Get All Student List<Student> students = studentDao.getAllStudents(); for
		 * (Student s : students) { System.out.println(s); }
		 * System.out.println("Read All");
		 * 
		 * // UPDATE U student.setId(1); student.setName("Aman Deeep");
		 * student.setCity("Kolkata"); int result1 = studentDao.change(student);
		 * System.out.println("Student Update " + result1);
		 * System.out.println("Update");
		 * 
		 * // DELETE D student.setId(1); int result2 =
		 * studentDao.delete(student.getId()); // int result2 = studentDao.delete(2);
		 * System.out.println("Student Deleted" + result2);
		 * System.out.println("Delete");
		 */
	}
}

/** Archived Code


		// READ R
		// Get One 1 Student
		student.setId(2);
		// Student student1 = studentDao.getStudent(1);
		Student student1 = studentDao.getStudent(student.getId());
		System.out.println(student1);
		System.out.println("Read 1");
		
		// Get All Student
		List<Student> students = studentDao.getAllStudents();
		for (Student s : students) {
			System.out.println(s);
		}
		System.out.println("Read All");

		// UPDATE U 
		student.setId(1);
		student.setName("Aman Deeep");
		student.setCity("Kolkata");
		int result1 = studentDao.change(student);
		System.out.println("Student Update " + result1);
		System.out.println("Update");
		
		// DELETE D
		student.setId(1);
		int result2 = studentDao.delete(student.getId());
		// int result2 = studentDao.delete(2);
		System.out.println("Student Deleted" + result2);
		System.out.println("Delete");




*/
