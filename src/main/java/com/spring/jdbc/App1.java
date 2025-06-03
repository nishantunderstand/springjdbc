package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class App1 {
	public static void main(String[] args) {
		System.out.println("My Program Started.......");
		System.out.println("========== My Program Started ================");

		/**
		 * 	1. context --> ClassPath / Annotation, I don't care
		 *  2. spring jdbc => JDBC Template ,
		 *  	I need jdbc object for operation
		 *  3. SQL Query
		 *  	Add Data at place Holder
		 *  This is the concept.
		 *  You want to reuse the concept, Perform some action.
		 *  That why we are mapping the Java Program to database.
		 *  So that we can manipulate the data. 
		 */
		
		System.out.println("App1 is working :");
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		
		// Insert Query
		// ? is called placeHolder
		System.out.println("Inserting Data into Mysql : ");
		String query = "insert into student(id,name,city) values(?,?,?)";
		
		// Fire the Query
		int result = template.update(query, 1, "Aman1", "Delhi");
		System.out.println("Number of Record Inserted : " + result);
		System.out.println("Create is working Fine :");
		
		/**
		 * This is code,
		 * As this is not manageable, so we are following designing Pattern
		 * As this will make code more manageable.
		 * This is our goal.
		 */
				
		/**
		For Select One Or Select All , You need to use RowMapper, Whether you like it or not ?
		/Row Mapper is the solution Provided by Spring JDBC
		*/
	}
}
