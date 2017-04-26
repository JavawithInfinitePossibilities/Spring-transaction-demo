/**
 * 
 */
package com.spring.jdbc.transaction.repository.intf;

import java.util.List;

import com.spring.jdbc.transaction.bean.StudentMark;

/**
 * @author Siddhant sahu
 *
 */
public interface StudentMarkRepoIntf {
	public void create(StudentMark studentMark);

	public List<StudentMark> listStudents();
}
