/**
 * 
 */
package com.spring.jdbc.transaction.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.transaction.bean.StudentMark;

/**
 * @author Siddhant sahu
 *
 */
public class StudentRowmapper implements RowMapper<StudentMark> {

	public StudentMark mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentMark studentMarks = new StudentMark();
		studentMarks.setId(rs.getInt("id"));
		studentMarks.setName(rs.getString("name"));
		studentMarks.setAge(rs.getInt("age"));
		studentMarks.setSid(rs.getInt("sid"));
		studentMarks.setMarks(rs.getInt("marks"));
		studentMarks.setYear(rs.getInt("year"));

		return studentMarks;
	}

}
