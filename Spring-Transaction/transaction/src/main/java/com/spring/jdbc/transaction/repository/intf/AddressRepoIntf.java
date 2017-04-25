/**
 * 
 */
package com.spring.jdbc.transaction.repository.intf;

import com.spring.jdbc.transaction.bean.Address;
import com.spring.jdbc.transaction.bean.Customer;

/**
 * @author Siddhant sahu
 *
 */
public interface AddressRepoIntf {
	void createAddress(Address address);
}
