/**
 * 
 */
package com.gl.customer.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.customer.management.model.Customer;

/**
 * @author Parthiban Ilango
 *
 */
@Service
public interface CustomerService {
	public List<Customer> findAll();
	public Customer findById( int theId );
	public void save( Customer customer );
	public void deleteById( int theId );
	

}
