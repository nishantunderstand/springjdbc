package com.spring.jdbcwithoutxmlSterotypeAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = { "com.spring.jdbc.dao" })
public class JdbcConfig{
/**
 * 
 * We are using this instead of XML
 * This is not a starting point of Program.
 */
	
	
	@Bean("ds")
	// All the mentioned Below are correct. 
	// You can use any one of them. 
	// But DataSource and DriverManagerDataSource are famous one.
	
	// You can also use below any of them :  
	// public DataSource getDataSource()
	// public AbstractDataSource getDataSource()
	// public AbstractDriverBasedDataSource getDataSource()
	// public DriverManagerDataSource getDataSource() 
	
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		System.out.println("Driver Manager is Working !!!");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://Localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

	
	// Approach 2 
	// Not Mentioning the Object Of Dao Class
	// Just told to Scan the Class

	}
	

