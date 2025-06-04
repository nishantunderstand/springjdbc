package com.spring.jdbc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Jun 3, 2025,11:07:47 PM
 * Make Table AutoCrement Key
 * 
 * Can springjdbtemplate create 
 * table ? Yes
 * Database ? NO
 * They work on existing database / schema
 */
public class MainAppAutoIncrement {
	public static void main(String[] args) {
		System.out.println("=== Following Correct Structure 2025-06-03 === ");
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("config.xml");
		
		JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		// Create table 
		String createtable = 
				"CREATE TABLE IF NOT EXISTS student("+
				"id INT PRIMARY KEY AUTO_INCREMENT,"+
				"name VARCHAR(100),"+                 
				"city VARCHAR(100)"+
				")";
		template.execute(createtable);
		
		// Insert into Table 
		String newQuery = "insert into student(name,city) values (?,?)";
		
		int result = template.update(newQuery,"Aman","New Delhi");
		System.out.println("No of record Inserted :"+result);
		context.close();
		
	}
}
