/**
 * 
 */
package com.spring.jdbc.transaction.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.jdbc.transaction.bean.Address;
import com.spring.jdbc.transaction.repository.intf.AddressRepoIntf;

/**
 * @author Siddhant sahu
 *
 */
@Repository
public class AddressRepository implements AddressRepoIntf {

	@Autowired
	private JdbcTemplate template;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spring.jdbc.transaction.repository.intf.AddressRepoIntf#createAddress
	 * (com.spring.jdbc.transaction.bean.Address)
	 */
	public void createAddress(Address address) {
		String sql = "insert into Address (id, address,country) values (?,?,?)";
		template.update(sql, address.getId(), address.getAddress(), address.getCountry());
	}

}
