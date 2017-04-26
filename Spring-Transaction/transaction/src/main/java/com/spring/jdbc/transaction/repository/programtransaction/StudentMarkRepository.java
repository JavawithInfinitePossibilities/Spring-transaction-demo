/**
 * 
 */
package com.spring.jdbc.transaction.repository.programtransaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.spring.jdbc.transaction.bean.StudentMark;
import com.spring.jdbc.transaction.repository.intf.StudentMarkRepoIntf;
import com.spring.jdbc.transaction.repository.rowmapper.StudentRowmapper;

/**
 * @author Siddhant sahu
 *
 */
@Repository
public class StudentMarkRepository implements StudentMarkRepoIntf {
	@Autowired
	private JdbcTemplate template;
	@Autowired
	private PlatformTransactionManager transactionManager;

	public void create(StudentMark studentMark) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			String sql = "insert into Student (name, age) values (?, ?)";
			template.update(sql, studentMark.getName(), studentMark.getAge());
			System.out.println("Student record inserted...");
			sql = "select max(id) from student";
			int id = template.queryForObject(sql, Integer.class);
			sql = "insert into Marks(sid, marks, year) values (?, ?, ?)";
			template.update(sql, id - 1, studentMark.getMarks(), studentMark.getYear());
			System.out.println("Student mark record has been inserted...");
			transactionManager.commit(status);
		} catch (Exception ex) {
			System.out.println("There is an error while processing record:" + ex.getMessage());
			System.out.println("Rolling back...");
			transactionManager.rollback(status);
		}
	}

	public List<StudentMark> listStudents() {
		String sql = "select * from Student, Marks where Student.id=Marks.sid";
		List<StudentMark> studentMarks = template.query(sql, new StudentRowmapper());
		return studentMarks;
	}
}
