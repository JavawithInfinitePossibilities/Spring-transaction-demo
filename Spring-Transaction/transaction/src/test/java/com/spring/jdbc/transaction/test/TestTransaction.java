/**
 * 
 */
package com.spring.jdbc.transaction.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.transaction.bean.Address;
import com.spring.jdbc.transaction.bean.Customer;
import com.spring.jdbc.transaction.services.intf.CustomerDetailsIntf;

/**
 * @author Siddhant sahu
 *
 */
public class TestTransaction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
		CustomerDetailsIntf services = applicationContext.getBean("customerDetailsServices", CustomerDetailsIntf.class);
		Address address = new Address("Bangalore", "India");
		Customer customer = new Customer(2, "Siddhant", address);
		services.createCustomerDetails(customer);
	}

}
