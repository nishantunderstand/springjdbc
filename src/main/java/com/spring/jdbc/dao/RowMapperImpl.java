package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

/**
 * 1. Row Mapper is an interface. 
 * 	You need to implement it
 * 2. Row Mapper Convert resultset to Class Object
 * 	You need to define which Class Object
 * 	Otherwise it will create generic object
 * 3. Whether it is Student Type or Object
 * 	You will still get result.
 */
public class RowMapperImpl implements RowMapper<Student>{
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException  {		
		Student student = new Student();
		student.setId(rs.getInt(1)); // Here 1,2,3 is representing the Index, No need to get Confused.
		student.setName(rs.getString(2)); // Depending Upon Datatype, you can use int,String Follow CamelCase Notation.
		student.setCity(rs.getString(3));
		return student;
	}

}
