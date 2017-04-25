/**
 * 
 */
package com.spring.jdbc.transaction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jdbc.transaction.bean.Address;
import com.spring.jdbc.transaction.bean.Customer;
import com.spring.jdbc.transaction.repository.intf.AddressRepoIntf;
import com.spring.jdbc.transaction.repository.intf.CustomerRepoIntf;
import com.spring.jdbc.transaction.services.intf.CustomerDetailsIntf;

/**
 * @author Siddhant sahu
 *
 */
@Service
class CustomerDetailsServices implements CustomerDetailsIntf {

	@Autowired
	private CustomerRepoIntf customerRepo;

	@Transactional
	public void createCustomerDetails(Customer customer) {
		customerRepo.createCustomer(customer);
	}

}
