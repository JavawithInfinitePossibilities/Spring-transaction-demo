/**
 * 
 */
package com.spring.jdbc.transaction.repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.jdbc.transaction.bean.Customer;
import com.spring.jdbc.transaction.repository.intf.CustomerRepoIntf;

/**
 * @author Siddhant sahu
 *
 */
@Repository
public class CustomerRepository implements CustomerRepoIntf {
	private final static Logger LOGGER = Logger.getLogger(CustomerRepository.class);

	@Autowired
	private JdbcTemplate template;

	public void createCustomer(Customer customer) {
		String sql = "insert into Customer (name) values (?)";
		template.update(sql, customer.getName());
		LOGGER.info("Inserted into Customer Table Successfully");
		sql = "select max(id) from Customer";
		int id = template.queryForObject(sql, Integer.class);
		customer.setId(id);
		sql = "insert into Address (id, address,country) values (?,?,?)";
		/*
		 * create an error to check the transaction rollback. Like
		 * customer.getId()-1
		 */
		template.update(sql, customer.getId(), customer.getAddress().getAddress(), customer.getAddress().getCountry());
		LOGGER.info("Inserted into Address Table Successfully");
	}
}
