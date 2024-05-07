package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
/**
 * This class need Object of Jdbc Template for functioning.
 * So some body need to write new Object 	
 */
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	public int insert(Student student) 
	{
		//Insert
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r= this.jdbcTemplate.update(query,student.getId(), student.getName(), student.getCity());
		return r;
	}

	public int change(Student student) {
		// update
		String query = "update student set name=?,city=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(), student.getCity(), student.getId());
		return r;
	}

	public int delete(int studentID) {
		// delete
		String query = "delete from student where id=?";
				int r =this.jdbcTemplate.update(query,studentID);
		return r;
	}
	public Student getStudent(int studentId) {
		// Select Single Student Data
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		// public <T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args) 
		// Method Syntax
		Student student= this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
		return student;
	}

	public List<Student> getAllStudents() {
		// Selecting All Student Data
		String query = "select * from student";

		// public <T> List<T> query(String sql, RowMapper<T> rowMapper) 		
		// Approach 1 
		RowMapper<Student> rowMapperImpl = new RowMapperImpl();
		//List<Student> students = this.jdbcTemplate.query(query,rowMapperImpl);
		
		// Approach 2 , Anonymous Object is really better
		List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl()); 
		return students;
	}
	
	
	
	
	
	
}
