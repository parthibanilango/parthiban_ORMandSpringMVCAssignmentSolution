/**
 * 
 */
package com.gl.customer.management.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.customer.management.model.Customer;

/**
 * @author Parthiban Ilango
 *
 */

@Repository
public class CustomerServiceImpl implements CustomerService {
	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public CustomerServiceImpl(SessionFactory sessionFactory ) {
	    this.sessionFactory = sessionFactory;
		
		try {
			this.session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			this.session = this.sessionFactory.openSession();
		}
	}

	
	/* (non-Javadoc)
	 * @see com.gl.customer.management.service.CustomerService#findAll()
	 */
	@Transactional
	public List<Customer> findAll() {
		Transaction tx = session.beginTransaction();
		List<Customer> customers = session.createQuery( "from Customer", Customer.class ).list(); // find all the records from the database table
		tx.commit();
		return customers;
	}

	
	/* (non-Javadoc)
	 * @see com.gl.customer.management.service.CustomerService#findById(int)
	 */
	@Transactional
	public Customer findById(int theId) {
		Customer customer = new Customer();
		Transaction tx = session.beginTransaction();
		customer = session.get(Customer.class, theId);
		tx.commit();
		return customer;
	}

	
	/* (non-Javadoc)
	 * @see com.gl.customer.management.service.CustomerService#save(com.gl.customer.management.model.Customer)
	 */
	@Transactional
	public void save(Customer customer) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();
		
	}

	
	/* (non-Javadoc)
	 * @see com.gl.customer.management.service.CustomerService#deleteById(int)
	 */
	public void deleteById(int theId) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, theId);
		session.delete(customer);
		tx.commit();
		
	}

	
	
}
