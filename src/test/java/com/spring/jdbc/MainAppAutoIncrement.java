package com.spring.jdbc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Jun 3, 2025,11:07:47 PM
 * Make Table AutoCrement Key
 */
public class MainAppAutoIncrement {
	public static void main(String[] args) {
		System.out.println("=== Following Correct Structure 2025-06-03 === ");
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("config.xml");
		
		JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		
		String oldQuery = "insert into student(id,name,city) values (?,?,?)";
		String newQuery = "insert into student(name,city) values (?,?)";
		
		int result = template.update(newQuery,"Aman","New Delhi");
		System.out.println("No of record Inserted :"+result);
		context.close();
		
	}
}
