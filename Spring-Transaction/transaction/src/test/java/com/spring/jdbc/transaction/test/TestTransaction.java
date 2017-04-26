/**
 * 
 */
package com.spring.jdbc.transaction.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.jdbc.transaction.bean.Address;
import com.spring.jdbc.transaction.bean.Customer;
import com.spring.jdbc.transaction.bean.StudentMark;
import com.spring.jdbc.transaction.services.StudentMarkServices;
import com.spring.jdbc.transaction.services.intf.CustomerDetailsIntf;

/**
 * @author Siddhant sahu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class TestTransaction {
	@Autowired
	public ApplicationContext applicationContext;

	@Ignore
	public void testTransaction() {
		CustomerDetailsIntf services = applicationContext.getBean("customerDetailsServices", CustomerDetailsIntf.class);
		Address address = new Address("Bangalore", "India");
		Customer customer = new Customer("Siddhant", address);
		services.createCustomerDetails(customer);
	}

	@Test
	public void testProgrammeticTransaction() {
		StudentMarkServices studentMarkServices = applicationContext.getBean("studentMarkServices",
				StudentMarkServices.class);
		StudentMark studentMark = new StudentMark(29, "siddhant", 100, 2009);
		studentMarkServices.createStudent(studentMark);
	}
}
