package com.spring.jdbc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Jun 3, 2025,11:07:47 PM
 */
public class MainApp {
	public static void main(String[] args) {
		System.out.println("=== Following Correct Structure 2025-06-03 === ");
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("config.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		String query = "insert into student(id,name,city) values (?,?,?)";
		
		int result = template.update(query,101,"Aman","New Delhi");
		System.out.println("No of record Inserted :"+result);
		context.close();
		
	}
}
