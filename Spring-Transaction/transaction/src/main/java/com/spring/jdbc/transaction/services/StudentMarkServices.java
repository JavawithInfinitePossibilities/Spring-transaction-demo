/**
 * 
 */
package com.spring.jdbc.transaction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jdbc.transaction.bean.StudentMark;
import com.spring.jdbc.transaction.repository.intf.StudentMarkRepoIntf;
import com.spring.jdbc.transaction.services.intf.StudentMarkIntf;

/**
 * @author Siddhant sahu
 *
 */
@Service
public class StudentMarkServices implements StudentMarkIntf {
	@Autowired
	private StudentMarkRepoIntf studentMarkRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spring.jdbc.transaction.services.intf.StudentMarkIntf#createStudent(
	 * com.spring.jdbc.transaction.bean.StudentMark)
	 */
	public void createStudent(StudentMark studentMark) {
		studentMarkRepo.create(studentMark);
	}

}
